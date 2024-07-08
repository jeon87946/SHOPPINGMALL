package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.OrderVO;

public class PaymentFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
//		  String id = request.getParameter("id");
//		  int itemPrice = Integer.parseInt(request.getParameter("itemPrice")); 
//		  int itemCnt = Integer.parseInt(request.getParameter("num-product")); 
//		  String itemCode = request.getParameter("itemCode"); 
//		  String itemName = request.getParameter("itemName");
//		  
//		  OrderVO order = new OrderVO();
//		  
//		  order.setId(id);
//		  order.setItemPrice(itemPrice); 
//		  order.setItemCode(itemCode);
//		  order.setItemCnt(itemCnt); 
//		  order.setItemName(itemName);
//		  
//		  request.setAttribute("order", order);
		 
		
		return "/cozastore-master/cart/payment.jsp";
	}

}
