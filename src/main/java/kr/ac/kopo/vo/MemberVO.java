package kr.ac.kopo.vo;

public class MemberVO {


	private String id;
	private String Name;
	private String Password;
	private String gender;
	private String email;
	private String phone;
	private String postcode;
	private String home_Address;
	private String detail_Address;
	private String reg_Date;
	
	public MemberVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", Name=" + Name + ", Password=" + Password + ", gender=" + gender + ", email="
				+ email + ", phone=" + phone + ", postcode=" + postcode + ", home_Address=" + home_Address
				+ ", detail_Address=" + detail_Address + ", reg_Date=" + reg_Date + "]";
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

	public String getHome_Address() {
		return home_Address;
	}

	public void setHome_Address(String home_Address) {
		this.home_Address = home_Address;
	}

	public String getDetail_Address() {
		return detail_Address;
	}

	public void setDetail_Address(String detail_Address) {
		this.detail_Address = detail_Address;
	}

	public String getReg_Date() {
		return reg_Date;
	}

	public void setReg_Date(String reg_Date) {
		this.reg_Date = reg_Date;
	}

	

	
}

	
	


