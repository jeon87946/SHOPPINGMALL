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
     	  String item_Price = request.getParameter("itemprice");
		  String item_Name = request.getParameter("itemName");
		  int item_Cnt = Integer.parseInt(request.getParameter("num-product"));
		  String item_Code = request.getParameter("itemCode");
		  
		  CartVO cartVO = new CartVO();
		 
		  cartVO.setId(id);
		  cartVO.setItem_Cnt(item_Cnt);
		  cartVO.setItem_Price(item_Price);
		  cartVO.setItem_Name(item_Name);
		  cartVO.setItem_Code(item_Code);
		  
		  CartDAO dao = new CartDAO();
		  int cnt = dao.selectName(cartVO);
		  
		  //수량변경
		  if(cnt == 0) {
			/* System.out.println("cartcart"+ cartVO); */
		  dao.insert(cartVO);
		  session.setAttribute("cart", cartVO);
		  }else if(cnt <= 1) {
			  dao.update(cartVO);
			  session.setAttribute("cart", cartVO);
		  }
		  return "/cozastore-master/product/product.jsp";
	}

}
