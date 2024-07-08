package kr.ac.kopo.vo;

public class CartVO {
	
	private String id;
	private int itemPrice;
	private String itemName;
	private int itemCnt;
	private String itemCode;
	
	public CartVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CartVO [id=" + id + ", itemPrice=" + itemPrice + ", itemName=" + itemName + ", itemCnt=" + itemCnt
				+ ", itemCode=" + itemCode + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
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


	
	
	
}
