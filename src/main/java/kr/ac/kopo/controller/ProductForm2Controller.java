package kr.ac.kopo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.ItemDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.ItemInfoVO;

public class ProductForm2Controller implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ItemDAO itemDao = new ItemDAO();
		List<ItemInfoVO> itemList =  itemDao.productAll();
		request.setAttribute("itemList", itemList);
		
		return "/cozastore-master/product/product2.jsp";
	}

}
