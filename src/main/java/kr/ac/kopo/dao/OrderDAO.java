package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.vo.ItemInfoVO;
import kr.ac.kopo.vo.MemberVO;
import kr.ac.kopo.vo.OrderVO;

public class OrderDAO {
	
	public SqlSession session;

	public OrderDAO() {
		session = new mybatisConfig().getInstance();
	}
	
	//
	public void insert(List<OrderVO> orderList) {
		session.insert("order.dao.orderDAO.insert", orderList);
		session.commit();
	}
	
	public List<OrderVO> orderAll(String id) {
			
		List<OrderVO> orderList = session.selectList("order.dao.orderDAO.orderAll", id);
		return orderList;
	}
}