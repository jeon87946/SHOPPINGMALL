package kr.ac.kopo.vo;

public class OrderVO {

	 private String orderDate;
	 private String orderNum;
	 private String itemPrice;
	 private int itemCnt;
	 private String itemCode;
	 private String itemName;
	 private String id;

	
	public OrderVO() {
	// TODO Auto-generated constructor stub

	}


	@Override
	public String toString() {
		return "OrderVO [orderDate=" + orderDate + ", orderNum=" + orderNum + ", itemPrice=" + itemPrice + ", itemCnt="
				+ itemCnt + ", itemCode=" + itemCode + ", itemName=" + itemName + ", id=" + id + "]";
	}


	public String getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}


	public String getOrderNum() {
		return orderNum;
	}


	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}


	public String getItemPrice() {
		return itemPrice;
	}


	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}


	public int getItemCnt() {
		return itemCnt;
	}


	public void setItemCnt(int itemCnt) {
		this.itemCnt = itemCnt;
	}


	public String getItemCode() {
		return itemCode;
	}


	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}


	public String getItemName() {
		return itemName;
	}


	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	


	
}
