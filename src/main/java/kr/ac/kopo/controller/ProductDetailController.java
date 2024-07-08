package kr.ac.kopo.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.ItemInfoVO;

public class ProductDetailController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String itemCode = request.getParameter("itemCode");
		ItemDAO itemDao = new ItemDAO();
		ItemInfoVO item = itemDao.selectItem(itemCode);
		request.setAttribute("item", item);
		
		return "/cozastore-master/product/product-detail.jsp";
	}

}
