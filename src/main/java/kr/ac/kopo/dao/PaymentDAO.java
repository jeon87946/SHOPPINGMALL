package kr.ac.kopo.dao;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.vo.PaymentVO;

public class PaymentDAO {

	public SqlSession session;
	
	public PaymentDAO() {
		session = new mybatisConfig().getInstance();
	}
	
	public void insert(PaymentVO payment) {
		session.insert("payment.dao.paymentDAO.insert", payment);
		session.commit();
	}
}
