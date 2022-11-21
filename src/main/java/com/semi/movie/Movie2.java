package com.semi.movie;

public class Movie2 {
	String movieNm;
	String directors;
	String genre;
	
	public Movie2() {
		// TODO Auto-generated constructor stub
	}

	public Movie2(String movieNm, String directors, String genre) {
		super();
		this.movieNm = movieNm;
		this.directors = directors;
		this.genre = genre;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getDirectors() {
		return directors;
	}

	public void setDirectors(String directors) {
		this.directors = directors;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	

}
