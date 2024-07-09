package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.ItemInfoVO;

public class ShoppingMallController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession httpSession = request.getSession();
		//객체 생성 후 값 가지고 오기
//		MemberDAO dao = new MemberDAO();
//		dao.insert();
		
		
		//받을때
//		request.setAttribute(null, response);
		
		ItemDAO itemDao = new ItemDAO();
		List<ItemInfoVO> itemList =  itemDao.productAll();
		System.out.println("index" + itemList);
		
		request.setAttribute("ItemList", itemList);
		httpSession.setAttribute("ItemList", itemList);
		
		return "/index.jsp";
	}
	
}
