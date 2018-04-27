package easybuy.entity;

public class Cart {
	private int cartid;
	private String userid;
	private int shopid;
	private int count;
	private Double cost;
	private String shopname;
	private String shopul;
	
	public Cart(int cartid, String userid, int shopid, int count, Double cost,
			String shopname, String shopul) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.shopid = shopid;
		this.count = count;
		this.cost = cost;
		this.shopname = shopname;
		this.shopul = shopul;
	}
	public Cart(int count, Double cost, String shopname, String shopul) {
		super();
		this.count = count;
		this.cost = cost;
		this.shopname = shopname;
		this.shopul = shopul;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getShopul() {
		return shopul;
	}
	public void setShopul(String shopul) {
		this.shopul = shopul;
	}
	public Cart(int cartid, String userid, int shopid, int count, Double cost) {
		super();
		this.cartid = cartid;
		this.userid = userid;
		this.shopid = shopid;
		this.count = count;
		this.cost = cost;
	}
	public Cart(String userid, int shopid, int count, Double cost) {
		super();
		this.userid = userid;
		this.shopid = shopid;
		this.count = count;
		this.cost = cost;
	}
	public Cart() {
		super();
	}
	public int getCartid() {
		return cartid;
	}
	public void setCartid(int cartid) {
		this.cartid = cartid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}

}
