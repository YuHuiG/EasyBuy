package easybuy.entity;

public class Comment {
	private int ecid;
	private String econten;
	private String ecrettime;
	private String ecreply;
	private String ecreplytime;
	private String ecnicename;
	
	public Comment(String econten, String ecrettime, String ecnicename) {
		super();
		this.econten = econten;
		this.ecrettime = ecrettime;
		this.ecnicename = ecnicename;
	}
	public Comment(int ecid, String ecreply, String ecreplytime) {
		super();
		this.ecid = ecid;
		this.ecreply = ecreply;
		this.ecreplytime = ecreplytime;
	}
	public Comment(int ecid, String econten, String ecrettime, String ecreply,
			String ecreplytime, String ecnicename) {
		super();
		this.ecid = ecid;
		this.econten = econten;
		this.ecrettime = ecrettime;
		this.ecreply = ecreply;
		this.ecreplytime = ecreplytime;
		this.ecnicename = ecnicename;
	}
	public Comment(String econten, String ecrettime, String ecreply,
			String ecreplytime, String ecnicename) {
		super();
		this.econten = econten;
		this.ecrettime = ecrettime;
		this.ecreply = ecreply;
		this.ecreplytime = ecreplytime;
		this.ecnicename = ecnicename;
	}
	public Comment() {
		super();
	}
	public int getEcid() {
		return ecid;
	}
	public void setEcid(int ecid) {
		this.ecid = ecid;
	}
	public String getEconten() {
		return econten;
	}
	public void setEconten(String econten) {
		this.econten = econten;
	}
	public String getEcrettime() {
		return ecrettime;
	}
	public void setEcrettime(String ecrettime) {
		this.ecrettime = ecrettime;
	}
	public String getEcreply() {
		return ecreply;
	}
	public void setEcreply(String ecreply) {
		this.ecreply = ecreply;
	}
	public String getEcreplytime() {
		return ecreplytime;
	}
	public void setEcreplytime(String ecreplytime) {
		this.ecreplytime = ecreplytime;
	}
	public String getEcnicename() {
		return ecnicename;
	}
	public void setEcnicename(String ecnicename) {
		this.ecnicename = ecnicename;
	}
	
}
