package kr.ac.kopo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.OrderVO;

public class PaymentFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		
		MemberVO loginVO = (MemberVO)session.getAttribute("LOGIN_USER");
		if(loginVO == null) {
			return "redirect:/login.do";
		}
		
		  String[] itemPriceStr = request.getParameterValues("itemPrice");
		  int[] itemPrice = new int[itemPriceStr.length];
		  for (int i = 0; i < itemPriceStr.length; i++) {
			  itemPrice[i] = Integer.parseInt(itemPriceStr[i]);
		    }
		  
		  String[] itemCntStr = request.getParameterValues("itemCnt"); 
		  int[]	itemCnt = new int[itemCntStr.length];
		  for (int i = 0; i < itemCntStr.length; i++) {
			  itemCnt[i] = Integer.parseInt(itemCntStr[i]);
		    }
		  
		  String[] itemCode = request.getParameterValues("itemCode"); 
		  String[] itemName = request.getParameterValues("itemName");
		  
		  
		  List<OrderVO> orderList = new ArrayList<>();
		  for(int i=0;i<itemPriceStr.length;i++) {
			  OrderVO order = new OrderVO();
			  order.setItemPrice(String.valueOf(itemPrice[i]*itemCnt[i])); 
			  order.setItemCode(itemCode[i]);
			  order.setItemCnt(itemCnt[i]); 
			  order.setItemName(itemName[i]);
			  orderList.add(order);
		  }
		  request.setAttribute("orderList", orderList);
		 
		
		return "/cozastore-master/cart/payment.jsp";
	}

}
