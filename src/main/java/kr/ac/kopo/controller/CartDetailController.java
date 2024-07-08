package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.CartDAO;
import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.ItemInfoVO;
import kr.ac.kopo.vo.MemberVO;
//장바구니에서 출력하기
public class CartDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		MemberVO member = (MemberVO)session.getAttribute("LOGIN_USER");
//		System.out.println("cartdetailcontroller : "+ member);
		
		String id = member.getId();
		/* String itemName = request.getParameter("itemName"); */
		
		CartDAO cartDAO = new CartDAO();
		List <CartVO> cList = cartDAO.cartAll(id);
		
		
		//cartVo.setId(id);
		//System.out.println("cardDetailcontroller : "+ cartVo);
		
		/*
		 * ItemDAO itemDAO = new ItemDAO(); List<ItemInfoVO> itemList =
		 * itemDAO.selectName(itemName);
		 */
		
		
		request.setAttribute("cartList", cList);
		/* request.setAttribute("itemName", itemName); */
		
		return "/cozastore-master/cart/shopping-cart.jsp";
	}

}
