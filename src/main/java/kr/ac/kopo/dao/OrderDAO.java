package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.vo.OrderVO;

public class OrderDAO {
	
	public SqlSession session;

	public OrderDAO() {
		session = new mybatisConfig().getInstance();
	}
	public void insert(OrderVO order) {
		session.insert("order.dao.orderDAO.insert", order);
		session.commit();
	}
}