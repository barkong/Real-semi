package com.semi.news;

public class News {
	private String title;
	private String description;
	private String link;
	private String time;

	public News() {
		// TODO Auto-generated constructor stub
	}

	public News(String title, String description, String link, String time) {
		super();
		this.title = title;
		this.description = description;
		this.link = link;
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
