package kr.ac.kopo.framework;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.controller.ShoppingMallController;

public class DispatcherServlet  extends HttpServlet{

	
	private HandlerMapping mappings;//멤버변수
	
	@Override
	public void init(ServletConfig config) throws ServletException { //하나 돌리기
		
		String propLoc = config.getInitParameter("propLoc");	
		
		mappings = new HandlerMapping(propLoc);  //2.한번만 호출하기
	} 

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		uri = uri.substring(request.getContextPath().length()); 
		
		System.out.println("URI 요청" + uri);
		
		try {
			Controller control = mappings.getController(uri);
			String callPage = control.handleRequest(request, response);
//			mappings = new HandlerMapping(propLoc); //1. 여러번 호출
			

//		callPage = control.handleRequest(request, response); 1//
			
			if(callPage.startsWith("redirect:")) {
				response.sendRedirect(request.getContextPath() +  callPage.substring("redirect:".length()));
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				dispatcher.forward(request, response);
			}
				
				
		}catch(Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}
}
