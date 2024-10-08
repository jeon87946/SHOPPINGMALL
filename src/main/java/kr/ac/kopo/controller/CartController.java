package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.CartDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.MemberVO;
//장바구니에 담기
public class CartController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		request.setCharacterEncoding("utf-8");

		MemberVO loginVO = (MemberVO)session.getAttribute("LOGIN_USER");
		if(loginVO == null) {
			return "redirect:/login.do";
		}
		
     	  String id = loginVO.getId();
     	  String itemPrice = request.getParameter("itemPrice");
		  String itemName = request.getParameter("itemName");
		  int itemCnt = Integer.parseInt(request.getParameter("num-product"));
		  String itemCode = request.getParameter("itemCode");
		  
		  CartVO cartVO = new CartVO();
		 
		  cartVO.setId(id);
		  cartVO.setItemCnt(itemCnt);
		  cartVO.setItemPrice(itemPrice);
		  cartVO.setItemName(itemName);
		  cartVO.setItemCode(itemCode);
		  
		  //상품 있는지 확인 후 수량변경
		  CartDAO dao = new CartDAO();
		  int cnt = dao.selectName(cartVO);
		  
		  //수량변경
		  if(cnt == 0) {
		  dao.insert(cartVO);
		  session.setAttribute("orderList", cartVO);
		  }else if(cnt >= 1) {
			  dao.update(cartVO);
			  session.setAttribute("orderList", cartVO);
			 
		  }
		  System.out.println(cartVO);
		  
		  
		  return "/shopping-cart.do";
	}

}
