package com.semi.movie;

public class Movie {

	private String title;
	private String director;
	private String actor;
	private String link;
	private String img;
	private String rating;
	private String subTitle;
	private String pubDate;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String director, String actor, String link, String img, String rating, String subTitle,
			String pubDate) {
		super();
		this.title = title;
		this.director = director;
		this.actor = actor;
		this.link = link;
		this.img = img;
		this.rating = rating;
		this.subTitle = subTitle;
		this.pubDate = pubDate;
	}

	public String getSubTitle() {
		return subTitle;
	}

	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	public String getPubDate() {
		return pubDate;
	}

	public void setPubDate(String pubDate) {
		this.pubDate = pubDate;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}


	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

}
