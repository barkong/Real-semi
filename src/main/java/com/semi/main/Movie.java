package com.semi.main;

public class Movie {

	String title;
	String director;
	String actor;
	String link;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, String director, String actor, String link) {
		super();
		this.title = title;
		this.director = director;
		this.actor = actor;
		this.link = link;
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
