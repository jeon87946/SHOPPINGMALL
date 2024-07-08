package kr.ac.kopo.vo;

public class CartVO {
	
	private String id;
	private String item_Price;
	private String item_Name;
	private int item_Cnt;
	private String item_Code;
	
	public CartVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CartVO [id=" + id + ", item_Price=" + item_Price + ", item_Name=" + item_Name + ", item_Cnt=" + item_Cnt
				+ ", item_Code=" + item_Code + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItem_Price() {
		return item_Price;
	}

	public void setItem_Price(String item_Price) {
		this.item_Price = item_Price;
	}

	public String getItem_Name() {
		return item_Name;
	}

	public void setItem_Name(String item_Name) {
		this.item_Name = item_Name;
	}

	public int getItem_Cnt() {
		return item_Cnt;
	}

	public void setItem_Cnt(int item_Cnt) {
		this.item_Cnt = item_Cnt;
	}

	public String getItem_Code() {
		return item_Code;
	}

	public void setItem_Code(String item_Code) {
		this.item_Code = item_Code;
	}

	

	
	

	
	
	
}
