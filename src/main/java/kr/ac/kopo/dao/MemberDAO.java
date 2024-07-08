package kr.ac.kopo.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.vo.MemberVO;

public class MemberDAO {

	public SqlSession session;

	public MemberDAO() {
		session = new mybatisConfig().getInstance();
		System.out.println("session" + " " + session);
	}

	public void insert(MemberVO member) {
//		System.out.println(member);
//		System.out.println("insert시작");
		// MemberVO member = new MemberVO();
		session.insert("member.dao.MemberDAO.insert", member);
		session.commit();
//		System.out.println("insert 종료");

	}

	//public void work() {

	//}

	public MemberVO login(MemberVO vo) {
		
		MemberVO loginMember = session.selectOne("member.dao.MemberDAO.login", vo);
		
		return loginMember;
	}
	

	/*
	 * //교수님 코드 시작 
	 * public void selectTest() {
	 * 
	 * MemberVO vo = session.selectOne("member.dao.MemberDAO.selectTest");
	 * System.out.println(vo);
	 * 
	 * 
	 * List<MemberVO> vo = session.selectList("member.dao.MemberDAO.selectTest");
	 * for(MemberVO m : vo) { System.out.println(m); }
	 * 
	 * 
	 * Map<String, Object> map =
	 * session.selectOne("member.dao.MemberDAO.selectTest2"); Set<String> keys =
	 * map.keySet(); for(String key : keys) { System.out.println(key + " : " +
	 * map.get(key)); } }
	 */

	/*
	 * public static void main(String[] args) {
	 * 
	 * MemberDAO dao = new MemberDAO(); dao.selectTest();
	 * 
	 * } //교수님 코드 끝
	 */

//	public void join() {
//		Map<String, Object> map = session.selectList("member.dao.MemberDAO.join");
//		Set<String> keys = map.keySet();
//		for(String)
//	}

	/*
	 * public String login() {
	 * 
	 * MemberVO member = new MemberVO();
	 * 
	 * List<MemberVO> list = session.selectList("member.dao.MemberDAO.", member);
	 * for(MemberVO vo : list) }
	 */
}
