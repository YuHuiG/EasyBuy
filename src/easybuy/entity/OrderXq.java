package easybuy.entity;

public class OrderXq {
	private int eodid;
	private int eoid;
	private int epid;
	private int num;
	private double price;
	public OrderXq(int eodid, int eoid, int epid, int num, double price) {
		super();
		this.eodid = eodid;
		this.eoid = eoid;
		this.epid = epid;
		this.num = num;
		this.price = price;
	}
	public OrderXq() {
		super();
	}
	public OrderXq(int eoid, int epid, int num, double price) {
		super();
		this.eoid = eoid;
		this.epid = epid;
		this.num = num;
		this.price = price;
	}
	public int getEodid() {
		return eodid;
	}
	public void setEodid(int eodid) {
		this.eodid = eodid;
	}
	public int getEoid() {
		return eoid;
	}
	public void setEoid(int eoid) {
		this.eoid = eoid;
	}
	public int getEpid() {
		return epid;
	}
	public void setEpid(int epid) {
		this.epid = epid;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
