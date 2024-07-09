package kr.ac.kopo.vo;

public class PaymentVO {

	private String receive;
	private String phone;
	private String Email;
	private String postcode;
	private String homeAddress;
	private String detailAddress;
	private String orderMsg;
	private String regDate;
	private String orderNum;

	public PaymentVO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "PaymentVO [receive=" + receive + ", phone=" + phone + ", Email=" + Email + ", postcode=" + postcode
				+ ", homeAddress=" + homeAddress + ", detailAddress=" + detailAddress + ", orderMsg=" + orderMsg
				+ ", regDate=" + regDate + ", orderNum=" + orderNum + "]";
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public String getOrderMsg() {
		return orderMsg;
	}

	public void setOrderMsg(String orderMsg) {
		this.orderMsg = orderMsg;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	

	

}
