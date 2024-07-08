package kr.ac.kopo.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.dao.PaymentDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.OrderVO;
import kr.ac.kopo.vo.PaymentVO;

public class PaymentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		MemberVO loginVO = (MemberVO)session.getAttribute("LOGIN_USER");
		if(loginVO == null) {
			return "redirect:/login.do";
		} else {
		//Random random = new Random(999999999); random.nextInt(999999999);
		
		String orderNum = Integer.toString((int) (Math.random() * 89999999) + 10000000); //배송정보와 상품정보에 모두 사용
		
		////////////////////////// 배송정보 //////////////////////////
		String receive = request.getParameter("receive");
		String number1 = request.getParameter("number1");
		String number2 = request.getParameter("number2");
		String number3 = request.getParameter("number3");
		String email = request.getParameter("email");
		String post = request.getParameter("post");
		String basicAddr = request.getParameter("basicAddr");
		String detailAddr = request.getParameter("detailAddr");
		String orderMsg = request.getParameter("orderMsg");
		
		
		PaymentVO payment = new PaymentVO();
		
		payment.setReceive(receive);
		payment.setUserNumber1(number1);
		payment.setUserNumber2(number2);
		payment.setUserNumber3(number3);
		payment.setUserEmail(email);
		payment.setPost(post);
		payment.setAddress(basicAddr);
		payment.setDetailAddress(detailAddr);
		payment.setOrderMsg(orderMsg);
		payment.setOrderNum(orderNum);
		
////////////////////////// 구매한 상품정보 //////////////////////////
		
		
		String id = request.getParameter("id");
		
		System.out.println(request.getParameter("itemPrice"));
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		int itemCnt = Integer.parseInt(request.getParameter("itemCnt"));
		String itemCode = request.getParameter("itemCode");
		String itemName = request.getParameter("itemName");
		
		
		OrderVO order = new OrderVO();
		
			 
		order.setItemPrice(itemPrice);
		order.setItemName(itemName);
		order.setItemCnt(itemCnt);
		order.setItemCode(itemCode);
		order.setOrderNum(orderNum);
		order.setId(id);
		
		PaymentDAO dao = new PaymentDAO();

		dao.insert(payment);
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insert(order);
		
		//jsp로 order 보냄
		request.setAttribute("orderList", order);
		session.setAttribute("orderList", order);
		
		request.setAttribute("paymentList", payment);
		session.setAttribute("paymentList", payment);
		
		/*
		 * int itemPrice = Integer.parseInt(request.getParameter("itemPrice")); int
		 * itemCnt = Integer.parseInt(request.getParameter("itemCnt")); String itemCode
		 * = request.getParameter("itemCode"); String itemName =
		 * request.getParameter("itemName");
		 * 
		 * OrderVO order = new OrderVO();
		 * 
		 * order.setItemPrice(itemPrice); order.setItemCode(itemCode);
		 * order.setItemCnt(itemCnt); order.setItemName(itemName);
		 */
		
		request.setAttribute("order", order);
		
		return "cozastore-master/cart/Complete.jsp";
		}
	}
}
