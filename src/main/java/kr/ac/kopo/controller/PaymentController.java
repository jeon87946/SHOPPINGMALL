package kr.ac.kopo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.dao.PaymentDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.OrderVO;
import kr.ac.kopo.vo.PaymentVO;

public class PaymentController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("utf-8");
		
		/*
		 * MemberVO loginVO = (MemberVO)session.getAttribute("LOGIN_USER"); if(loginVO
		 * == null) { return "redirect:/login.do"; }
		 */
		//Random random = new Random(999999999); random.nextInt(999999999);
		
		String orderNum = Integer.toString((int) (Math.random() * 89999999) + 10000000); //배송정보와 상품정보에 모두 사용
		
		////////////////////////// 배송정보 //////////////////////////
		String receive = request.getParameter("receive");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String postcode = request.getParameter("postcode");
		String homeAddress = request.getParameter("basicAddr");
		String detailAddress = request.getParameter("detailAddr");
		String orderMsg = request.getParameter("orderMsg");
		
		
		PaymentVO payment = new PaymentVO();
		
		payment.setReceive(receive);
		payment.setPhone(phone);
		payment.setEmail(email);
		payment.setPostcode(postcode);
		payment.setHomeAddress(homeAddress);
		payment.setDetailAddress(detailAddress);
		payment.setOrderMsg(orderMsg);
		payment.setOrderNum(orderNum);
		
////////////////////////// 구매한 상품정보 //////////////////////////
		
		
		String id = request.getParameter("id");
		int itemPrice =  Integer.parseInt(request.getParameter("itemPrice"));
		int itemCnt = Integer.parseInt(request.getParameter("itemCnt"));
		String itemCode = request.getParameter("itemCode");
		String itemName = request.getParameter("itemName");
		
		OrderVO order = new OrderVO();
		
			 
		order.setItemPrice(String.valueOf(itemPrice));
		order.setItemName(itemName);
		order.setItemCnt(itemCnt);
		order.setItemCode(itemCode);
		order.setOrderNum(orderNum);
		order.setId(id);
		PaymentDAO dao = new PaymentDAO();

		dao.insert(payment);
		
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insert(order);
		
//		상품 주문 정보(item) 주문회원 정보(payment)
		request.setAttribute("orderList", order);
		session.setAttribute("orderList", order);
		
		request.setAttribute("paymentList", payment);
		session.setAttribute("paymentList", payment);
		
		
		request.setAttribute("order", order);
		
		return "cozastore-master/cart/Complete.jsp";
		
	}
}
