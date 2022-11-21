package com.semi.movie;

public class news {
	String title;
	String description;
	String originallink;

	public news(String title, String description, String originallink) {
		super();
		this.title = title;
		this.description = description;
		this.originallink = originallink;
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

	public String getOriginallink() {
		return originallink;
	}

	public void setOriginallink(String originallink) {
		this.originallink = originallink;
	}

}
