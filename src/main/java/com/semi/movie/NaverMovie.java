package com.semi.movie;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.semi.main.Movie;

public class NaverMovie {

	public static void getMovie(HttpServletRequest request) {
		HttpsURLConnection huc = null;

		try {

			// 네이버 검색 api
			request.setCharacterEncoding("UTF-8");
			String str = request.getParameter("movie");
			System.out.println(str);

			str = URLEncoder.encode(str, "utf-8");
			System.out.println(str);

			String url = "https://openapi.naver.com/v1/search/movie.json";
			url += "?query=" + str;
			url += "&display=30";

			System.out.println(url);

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			huc.addRequestProperty("X-Naver-Client-Id", "_dGZX3vm4d9iUQCSPrmu");
			huc.addRequestProperty("X-Naver-Client-Secret", "CPXPizei_I");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(is);
			JSONParser jp = new JSONParser();

			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);

			JSONArray items = (JSONArray) naverData.get("items");

			ArrayList<Movie> movies = new ArrayList<>();

			for (int i = 0; i < items.size(); i++) {

				JSONObject movie = (JSONObject) items.get(i);

				String title = (String) movie.get("title");
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");

				String actor = (String) movie.get("actor");

				String director = (String) movie.get("director");

				String link = movie.get("link") + "";
				String img = (String) movie.get("image");
				String rating = (String) movie.get("userRating");

				System.out.println("포스터: " + img);
				System.out.println("영화제목 : " + title);
				System.out.println("배우 : " + actor);
				System.out.println("감독 : " + director);
				System.out.println("평점 :");
				System.out.println("링크 : " + link);

				Movie m = new Movie(title, director, actor, link, img, rating);

				movies.add(m);

			}

			request.setAttribute("movies", movies);
			System.out.println("okokok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {

			// 네이버 검색 뉴스 api query = '영화'
			request.setCharacterEncoding("UTF-8");
			String str = "영화";

			str = URLEncoder.encode(str, "utf-8");
			System.out.println(str);

			String url = "https://openapi.naver.com/v1/search/news.json";
			url += "?query=" + str;
			url += "&display=30";

			System.out.println(url);

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			huc.addRequestProperty("X-Naver-Client-Id", "_dGZX3vm4d9iUQCSPrmu");
			huc.addRequestProperty("X-Naver-Client-Secret", "CPXPizei_I");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(is);

			JSONParser jp = new JSONParser();

			JSONObject newsData = (JSONObject) jp.parse(isr);
			System.out.println(newsData);

			JSONArray items = (JSONArray) newsData.get("items");

			ArrayList<News> news = new ArrayList<>();

			for (int i = 0; i < items.size(); i++) {

				JSONObject news1 = (JSONObject) items.get(i);

				String title = (String) news1.get("title");
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");

				String description = (String) news1.get("description");
				description = description.replace("<b>", "");
				description = description.replace("</b>", "");

				String originallink = (String) news1.get("originallink");

				System.out.println("기사제목: " + title);
				System.out.println("요약 정보 : " + description);
				System.out.println("원문 url : " + originallink);

				News n = new News(title, description, originallink);

				news.add(n);

			}

			request.setAttribute("news", news);

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// 영화진흥위원회 api 영화 정보

			request.setCharacterEncoding("UTF-8");

			String url = "http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=9277299fa5d76d3f8ea02bb835de6f09";

			System.out.println(url);

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(is);

			JSONParser jp = new JSONParser();

			JSONObject movieData = (JSONObject) jp.parse(isr);
			System.out.println();

			JSONArray items = (JSONArray) movieData.get("movieListResult");

			ArrayList<MovieInfo> movieInfos = new ArrayList<>();

			for (int i = 0; i < items.size(); i++) {
				JSONObject movieInfos1 = (JSONObject) items.get(i);

				String movieNm = (String) movieInfos1.get("movieNm");
				movieNm = movieNm.replace("<b>", "");
				movieNm = movieNm.replace("</b>", "");
				String openDt = (String) movieInfos1.get("openDt");
				String genreAlt = (String) movieInfos1.get("genreAlt");
				String directors = (String) movieInfos1.get("directors");
				String companys = (String) movieInfos1.get("companys");

				System.out.println("제목: " + movieNm);
				System.out.println("상영일: " + openDt);
				System.out.println("장르: " + genreAlt);
				System.out.println("감독: " + directors);
				System.out.println("회사: " + companys);

				MovieInfo m1 = new MovieInfo(movieNm, openDt, genreAlt, directors, companys);

				movieInfos.add(m1);
			}

			request.setAttribute("movieInfos", movieInfos);
			System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
