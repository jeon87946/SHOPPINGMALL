package kr.ac.kopo.dao;


import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.ibatis.session.SqlSession;

import kr.ac.kopo.vo.CartVO;
import kr.ac.kopo.vo.ItemInfoVO;

public class ItemDAO {
	
	public SqlSession session;
	
	
	//세션 만들기
	public ItemDAO() {
		session = new mybatisConfig().getInstance();
		System.out.println("session" + " " + session);
	}
	
	//상품 페이지
	public List<ItemInfoVO> productAll() {
		
		List<ItemInfoVO> ItemList = session.selectList("item.dao.ItemDAO.productAll");
		/* System.out.println(ItemList.get(0)); */
		return ItemList;
	}
	
	
	//상품 하나 조회(상품디테일)
	public ItemInfoVO selectItem(String itemCode) {
		ItemInfoVO item = session.selectOne("item.dao.ItemDAO.ItemInfo",itemCode);
		return item;
	}
	//상품하나 조회 이름(쇼핑카트)
	public List<ItemInfoVO> selectName(String itemName) {
		List<ItemInfoVO> item = session.selectOne("item.dao.ItemDAO.ItemName",itemName);
		return item;
	}
	 
	//결제 후 상품 재고수량 삭제
	
	 public void update(List<ItemInfoVO> itemList) {
	 session.update("item.dao.ItemDAO.updateCnt", itemList); 
	 session.commit();
	 System.out.println("ITEMDAO"+itemList); }
	 
	
	
	
	
	
	
	
	
	
	
	
	
	//상품 정보 페이지
	/*
	 * public List<ItemInfoVO> productDetail() {
	 * 
	 * return detail; }
	 */
	
	/*
	 * public ItemInfoVO productTest(ItemInfoVO vo) { ItemInfoVO info =
	 * session.selectOne("item.dao.ItemDAO.porduct", vo);
	 * session.selectOne("item.dao.ItemDAO.product", vo);
	 * 
	 * request.set return info; }
	 */
//	public static void main(String []args) {
//		ItemDAO itemDAO = new ItemDAO();
//		List<ItemInfoVO> itemList=itemDAO.productAll();
//		System.out.println("itemList="+itemList);
//	}
}
