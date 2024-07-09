package kr.ac.kopo.vo;

public class MemberVO {


	private String id;
	private String Name;
	private String Password;
	private String gender;
	private String email;
	private String phone;
	private String postcode;
	private String homeAddress;
	private String detailAddress;
	private String regDate;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", Name=" + Name + ", Password=" + Password + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + ", postcode=" + postcode + ", homeAddress=" + homeAddress
				+ ", detailAddress=" + detailAddress + ", regDate=" + regDate + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	

	

	

	
}

	
	


