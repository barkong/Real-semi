package com.semi.movie;

public class MovieInfo {
	String movieNm;
	String openDt;
	String genreAlt;
	String directors;	
	String companys;

	public MovieInfo(String movieNm, String openDt, String genreAlt, String directors, String companys) {
		super();
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.genreAlt = genreAlt;
		this.directors = directors;
		this.companys = companys;
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
	public String getCompanys() {
		return companys;
	}
	public void setCompanys(String companys) {
		this.companys = companys;
	}	
	
	
	
}
