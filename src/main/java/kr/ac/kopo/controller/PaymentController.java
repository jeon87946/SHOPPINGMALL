package kr.ac.kopo.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.CartDAO;
import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.dao.OrderDAO;
import kr.ac.kopo.dao.PaymentDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.ItemInfoVO;
import kr.ac.kopo.vo.MemberVO;
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
		String Email = request.getParameter("Email");
		String postcode = request.getParameter("postcode");
		String homeAddress = request.getParameter("homeAddress");
		String detailAddress = request.getParameter("detailAddress");
		String orderMsg = request.getParameter("orderMsg");
		
		
		PaymentVO payment = new PaymentVO();
		
		payment.setReceive(receive);
		payment.setPhone(phone);
		payment.setEmail(Email);
		payment.setPostcode(postcode);
		payment.setHomeAddress(homeAddress);
		payment.setDetailAddress(detailAddress);
		payment.setOrderMsg(orderMsg);
		payment.setOrderNum(orderNum);
		
////////////////////////// 구매한 상품정보 //////////////////////////
		
		MemberVO member = (MemberVO)session.getAttribute("LOGIN_USER");
		
		String id = member.getId();

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
			  
			  order.setOrderNum(orderNum);
			  order.setId(id);
			  orderList.add(order);
		  }
		 ///////////////////결제 완료되면 쇼핑카트에서 해당 상품 삭제하기///////////////////
		  List<CartVO> cartList = new ArrayList<>();
		  for(int i=0; i<itemPriceStr.length; i++) {
			  CartVO cart = new CartVO();
			  cart.setId(id);
			  cart.setItemCode(itemCode[i]);
			  
			  cartList.add(cart);
		  }
		  
//////////////////////////////////////결제 완료되면 재고 수량 하나 삭제//////////////////////////////////////  
		
		
		
			 List<ItemInfoVO> itemList = new ArrayList<>(); 
			 for(int i=0;i<itemPriceStr.length; i++) { 
				 ItemInfoVO item = new ItemInfoVO();
				 item.setItemCnt(itemCnt[i]); 
				 item.setItemName(itemName[i]);
			 
			 itemList.add(item); 
			 }
			 
		
		  
		//주문자(회원) 정보 db에 저장하기
		PaymentDAO dao = new PaymentDAO();	  
		dao.insert(payment);
		
		//주문자(회원) 상품 db에 저장하기
		OrderDAO orderDAO = new OrderDAO();
		orderDAO.insert(orderList);
		
		//결제 완료 후에 쇼핑카트에서 상품 삭제하기
		CartDAO cartdao = new CartDAO();
		cartdao.delete(cartList);

		//결제 완료 후에 아이템인포에서 재고수량 변경하기
		
		
		 ItemDAO itemdao = new ItemDAO(); 
		 itemdao.update(itemList);
		 
		 
		
		
		
		
//		상품 주문 정보(orderList) 주문회원 정보(payment) 장바구니
		request.setAttribute("orderList", orderList);
		
		request.setAttribute("paymentList", payment);
		
		request.setAttribute("cartList", cartList);
		
		session.setAttribute("itemList", itemList);
	 
		return "cozastore-master/cart/Complete.jsp";
	}
}
