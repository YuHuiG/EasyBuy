package easybuy.entity;

public class Order {
	private int eoid;
	private int userid;
	private String username;
	private String useraddress;
	private String time;
	private double price;
	private int status;
	
	public Order(int userid, String username, String useraddress, String time,
			double price) {
		super();
		this.userid = userid;
		this.username = username;
		this.useraddress = useraddress;
		this.time = time;
		this.price = price;
	}
	public Order(int eoid, int userid, String username, String useraddress,
			String time, double price, int status) {
		super();
		this.eoid = eoid;
		this.userid = userid;
		this.username = username;
		this.useraddress = useraddress;
		this.time = time;
		this.price = price;
		this.status = status;
	}
	public Order() {
		super();
	}
	public Order(int userid, String username, String useraddress, String time,
			double price, int status) {
		super();
		this.userid = userid;
		this.username = username;
		this.useraddress = useraddress;
		this.time = time;
		this.price = price;
		this.status = status;
	}
	public int getEoid() {
		return eoid;
	}
	public void setEoid(int eoid) {
		this.eoid = eoid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}
