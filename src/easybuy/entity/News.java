package easybuy.entity;

public class News {
	private int id;
	private String title;
	private String content;
	private String time;
	
	public News(int id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public News(String title, String content, String time) {
		super();
		this.title = title;
		this.content = content;
		this.time = time;
	}
	public News(int id, String title, String content, String time) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.time = time;
	}
	public News(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}
	public News() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

}
