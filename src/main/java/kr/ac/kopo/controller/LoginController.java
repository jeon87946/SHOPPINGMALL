package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.CartDAO;
import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.OrderVO;

public class LoginController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{

		HttpSession httpSession = request.getSession();
		
		request.setCharacterEncoding("utf-8");

		String id = request.getParameter("id");
		String Password = request.getParameter("Password");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPassword(Password);
		
		MemberDAO dao = new MemberDAO();
		MemberVO membervo = dao.login(vo); 
		
		//////////////////////////장바구니 정보 저장//////////////////////////		
		//장바구니 정보 저장
		CartDAO cartDAO = new CartDAO();
		List<CartVO> cList = cartDAO.cartAll(id);
		
		/*
		 * String itemPrice = request.getParameter("itemPrice"); String itemName =
		 * request.getParameter("itemName"); String itemCnt =
		 * request.getParameter("itemCnt"); String itemCode =
		 * request.getParameter("itemCode");
		
		OrderVO order = new OrderVO();
		*/
		
		//세션에 아이디별 카트 정보 저장하기
		request.setAttribute("LoginCart", cList);
		httpSession.setAttribute("LoginCart", cList);
		
		
		String url = "";
		String msg = "";
		
		if(membervo == null) {
			url = "redirect:/login.do";
			msg = "로그인 실패 다시 입력하세요";
			request.setAttribute("msg", msg);
			return "redirect:/login.do";
		}else {
		
			url = "/ShoppingMall/home.do";
			msg = membervo.getName() + "님 환영합니다";
			
			//로그인 성공시 로그인 정보 저장하기
			request.setAttribute("msg", msg);
			httpSession.setAttribute("LOGIN_USER", membervo);
			System.out.println("오예스" + membervo);
			return "/cozastore-master/join/login/LoginDetail.jsp";
		}
		
	}
}
