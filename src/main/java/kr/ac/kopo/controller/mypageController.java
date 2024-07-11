package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.ItemInfoVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.OrderVO;

public class mypageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();

		request.setCharacterEncoding("utf-8");

		MemberVO loginVO = (MemberVO)session.getAttribute("LOGIN_USER");
		if(loginVO == null) {
			return "redirect:/login.do";
		}
		
		String id = loginVO.getId();
		
		OrderDAO orderdao = new OrderDAO();
		List<OrderVO> orderList = orderdao.orderAll(id);
		
		request.setAttribute("orderList", orderList);
		System.out.println(orderList);
		
		return "/cozastore-master/cart/mypage.jsp";
	}

}
