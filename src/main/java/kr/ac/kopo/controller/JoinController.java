package kr.ac.kopo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.dao.MemberDAO;
import kr.ac.kopo.framework.Controller;
import kr.ac.kopo.vo.MemberVO;

//   /joinpro.do
public class JoinController implements Controller{
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String Name = request.getParameter("Name");
		String Password = request.getParameter("Password");
		
		
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setName(Name);
		member.setPassword(Password);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(member);
		
		return "/cozastore-master/join/joinDetail.jsp";
	}
}
