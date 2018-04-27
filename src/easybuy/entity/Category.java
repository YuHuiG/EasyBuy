package easybuy.entity;

public class Category {
	private int epcid;
	private String epcname;
	private int parentid;

	public Category(int epcid, String epcname, int parentid) {
		super();
		this.epcid = epcid;
		this.epcname = epcname;
		this.parentid = parentid;
	}

	public Category() {
		super();
	}

	public int getEpcid() {
		return epcid;
	}

	public void setEpcid(int epcid) {
		this.epcid = epcid;
	}

	public String getEpcname() {
		return epcname;
	}

	public void setEpcname(String epcname) {
		this.epcname = epcname;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}

}
