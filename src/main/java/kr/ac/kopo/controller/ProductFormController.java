package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.ItemInfoVO;

public class ProductFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession Session = request.getSession();
		
		ItemDAO itemDao = new ItemDAO();
		List<ItemInfoVO> itemList =  itemDao.productAll();
		/* System.out.println(itemList.get(0)); */
		
		
		request.setAttribute("itemList", itemList);
		//세션저장
		Session.setAttribute("itemList", itemList);
		System.out.println(itemList);
		
		return "/cozastore-master/product/product.jsp";
	}

}
