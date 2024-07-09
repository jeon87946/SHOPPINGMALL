package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.CartDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.MemberVO;
//장바구니에서 출력하기
public class CartDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		MemberVO member = (MemberVO)session.getAttribute("LOGIN_USER");
		
		String id = member.getId();
		
		CartDAO cartDAO = new CartDAO();
		List <CartVO> cList = cartDAO.cartAll(id);
		
		request.setAttribute("cartList", cList);
		
		return "/cozastore-master/cart/shopping-cart.jsp";
	}

}
