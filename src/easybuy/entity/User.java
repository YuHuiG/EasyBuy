package easybuy.entity;

public class User {
	private String uid;
	private String uname;
	private String upwd;
	private String sex;
	private String birthday;
	private String idcard;
	private String email;
	private String phone;
	private String address;
	private int login;
	private int status;

	
	public User(String uid, String uname, String upwd, String sex,
			String birthday, String phone, String address) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
	}

	public User() {
		super();
	}

	public User(String uid, String uname, String upwd) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
	}

	public User(String uid, String uname, String upwd, String sex,
			String birthday, String idcard, String email, String phone,
			String address, int login, int status) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.sex = sex;
		this.birthday = birthday;
		this.idcard = idcard;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.login = login;
		this.status = status;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}


}
