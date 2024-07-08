package kr.ac.kopo.vo;

public class MemberVO {


	private String id;
	private String userName;
	private String userPassword;
	private int userAge;
	private String userSex;
	private String userNumber1;
	private String userNumber2;
	private String userNumber3;
	private String type;
	private String regDate;
	private String orderNum;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", userName=" + userName + ", userPassword=" + userPassword + ", userAge="
				+ userAge + ", userSex=" + userSex + ", userNumber1=" + userNumber1 + ", userNumber2=" + userNumber2
				+ ", userNumber3=" + userNumber3 + ", type=" + type + ", regDate=" + regDate + "]";
	}

	
}

	
	


