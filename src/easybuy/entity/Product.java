package easybuy.entity;

public class Product {
	private int epid;
	private String epname;
	private String epdescription;
	private Double price;
	private int stock;
	private int epcid;
	private int epcchildid;
	private String ul;
	
	public Product(String epname, String epdescription, Double price,
			int stock, int epcid, int epcchildid, String ul) {
		super();
		this.epname = epname;
		this.epdescription = epdescription;
		this.price = price;
		this.stock = stock;
		this.epcid = epcid;
		this.epcchildid = epcchildid;
		this.ul = ul;
	}
	public Product(int epid, String epname, String epdescription, Double price,
			int stock, int epcid, int epcchildid, String ul) {
		super();
		this.epid = epid;
		this.epname = epname;
		this.epdescription = epdescription;
		this.price = price;
		this.stock = stock;
		this.epcid = epcid;
		this.epcchildid = epcchildid;
		this.ul = ul;
	}
	public Product() {
		super();
	}
	public int getEpid() {
		return epid;
	}
	public void setEpid(int epid) {
		this.epid = epid;
	}
	public String getEpname() {
		return epname;
	}
	public void setEpname(String epname) {
		this.epname = epname;
	}
	public String getEpdescription() {
		return epdescription;
	}
	public void setEpdescription(String epdescription) {
		this.epdescription = epdescription;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getEpcid() {
		return epcid;
	}
	public void setEpcid(int epcid) {
		this.epcid = epcid;
	}
	public int getEpcchildid() {
		return epcchildid;
	}
	public void setEpcchildid(int epcchildid) {
		this.epcchildid = epcchildid;
	}
	public String getUl() {
		return ul;
	}
	public void setUl(String ul) {
		this.ul = ul;
	}
	
}
