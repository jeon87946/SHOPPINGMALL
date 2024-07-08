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
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		int userAge = Integer.parseInt(request.getParameter("userAge"));
		String userSex = request.getParameter("userSex");
		String userNumber1 = request.getParameter("userNumber1");
		String userNumber2 = request.getParameter("userNumber1");
		String userNumber3 = request.getParameter("userNumber1");
		
		MemberVO member = new MemberVO();
		
		member.setId(id);
		member.setUserName(userName);
		member.setUserPassword(userPassword);
		member.setUserAge(userAge);
		member.setUserSex(userSex);
		member.setUserNumber1(userNumber1);
		member.setUserNumber2(userNumber2);
		member.setUserNumber3(userNumber3);
		
		MemberDAO dao = new MemberDAO();
		dao.insert(member);
		
		return "/cozastore-master/join/joinDetail.jsp";
	}
}
