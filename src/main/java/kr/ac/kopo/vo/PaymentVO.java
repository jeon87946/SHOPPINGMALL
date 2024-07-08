package kr.ac.kopo.vo;

public class PaymentVO {

	private String receive;
	private String userNumber1;
	private String userNumber2;
	private String userNumber3;
	private String userEmail;
	private String post;
	private String address;
	private String detailAddress;
	private String orderMsg;
	private String regDate;
	private String orderNum;

	public PaymentVO() {
		// TODO Auto-generated constructor stub
	}

	public String getReceive() {
		return receive;
	}

	public void setReceive(String receive) {
		this.receive = receive;
	}

	public String getUserNumber1() {
		return userNumber1;
	}

	public void setUserNumber1(String userNumber1) {
		this.userNumber1 = userNumber1;
	}

	public String getUserNumber2() {
		return userNumber2;
	}

	public void setUserNumber2(String userNumber2) {
		this.userNumber2 = userNumber2;
	}

	public String getUserNumber3() {
		return userNumber3;
	}

	public void setUserNumber3(String userNumber3) {
		this.userNumber3 = userNumber3;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	@Override
	public String toString() {
		return "PaymentVO [receive=" + receive + ", userNumber1=" + userNumber1 + ", userNumber2=" + userNumber2
				+ ", userNumber3=" + userNumber3 + ", userEmail=" + userEmail + ", post=" + post + ", address="
				+ address + ", detailAddress=" + detailAddress + ", orderMsg=" + orderMsg + ", regDate=" + regDate
				+ ", orderNum=" + orderNum + "]";
	}

}
