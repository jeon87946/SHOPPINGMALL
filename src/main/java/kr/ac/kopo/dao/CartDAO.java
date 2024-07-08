package kr.ac.kopo.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.ItemInfoVO;

public class CartDAO {

	public SqlSession session;

	public CartDAO() {
		session = new mybatisConfig().getInstance();
		/*System.out.println("session" + " " + session);*/
	}
//	장바구니 추가
	public void insert(CartVO cart) {
		session.insert("item.dao.CartDAO.insert", cart);
		session.commit();
	}
//	장바구니 목록 받아오기 //상품디테일
	public List<CartVO> cartAll(String id) {
		List<CartVO> cartList = session.selectList("item.dao.CartDAO.cart", id);
		return cartList;
	}
// 장바구니 상품 확인	
	public int selectName(CartVO itemName) {
		int cnt = session.selectOne("item.dao.CartDAO.selectName", itemName);
		return cnt;
	}
//	장바구니 상품 확인 후 수량 변경
	public void update(CartVO cart) {
		session.update("item.dao.CartDAO.updateCnt", cart);
		session.commit();
	}
// 주문 후 장바구니 목록 삭제
	/* public void delete(CartVO cart) {} */
	
}

