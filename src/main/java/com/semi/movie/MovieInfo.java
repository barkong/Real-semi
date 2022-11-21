package com.semi.movie;

public class MovieInfo {
	
	String movieNm;
	String openDt;
	String genreAlt;
	String directors;
	String company;
	
	public MovieInfo() {
		// TODO Auto-generated constructor stub
	}

	public MovieInfo(String movieNm, String openDt, String genreAlt, String directors, String company) {
		super();
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.genreAlt = genreAlt;
		this.directors = directors;
		this.company = company;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getGenreAlt() {
		return genreAlt;
	}

	public void setGenreAlt(String genreAlt) {
		this.genreAlt = genreAlt;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	
	
	

}
