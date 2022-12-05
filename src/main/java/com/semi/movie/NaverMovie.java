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

public class NaverMovie {
	private static ArrayList<Movie> movies;
	private static final NaverMovie NM = new NaverMovie();

	public NaverMovie() {
		// TODO Auto-generated constructor stub
	}

	public static NaverMovie getNM() {
		return NM;
	}

	public JSONObject getMovie(HttpServletRequest request) {
		HttpsURLConnection huc = null;

		try {

			// 네이버 검색 api
			request.setCharacterEncoding("UTF-8");
			String str = request.getParameter("movie");
			

			str = URLEncoder.encode(str, "utf-8");
			

			String url = "https://openapi.naver.com/v1/search/movie.json";
			url += "?query=" + str;
			url += "&display=100";
			url += "&start=1";

			

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			huc.addRequestProperty("X-Naver-Client-Id", "_dGZX3vm4d9iUQCSPrmu");
			huc.addRequestProperty("X-Naver-Client-Secret", "CPXPizei_I");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			JSONParser jp = new JSONParser();

			JSONObject naverData = (JSONObject) jp.parse(isr);

			JSONArray items = (JSONArray) naverData.get("items");
			

			/*
			 * ArrayList<Movie> movies = new ArrayList<>();
			 * 
			 * for (int i = 0; i < items.size(); i++) {
			 * 
			 * JSONObject movie = (JSONObject) items.get(i);
			 * 
			 * String title = (String) movie.get("title"); 
			 * title = title.replace("<b>", "");
			 * title = title.replace("</b>", "");
			 * 
			 * String actor = (String) movie.get("actor"); actor = actor.replace("|", ",");
			 * 
			 * String director = (String) movie.get("director");
			 * 
			 * director = director.replace("|", "");
			 * 
			 * String link = movie.get("link") + "";
			 * 
			 * String img = (String) movie.get("image");
			 * 
			 * String rating = (String) movie.get("userRating");
			 * 
			 * String pubDate = (String) movie.get("pubDate");
			 * 
			 * String subTitle = (String) movie.get("subtitle");
			 * 
			 * 
			 * Movie m = new Movie(title, director, actor, link, img, rating, subTitle,
			 * pubDate);
			 * 
			 * movies.add(m);
			 * 
			 * }
			 * 
			 * request.setAttribute("movies", movies);
			 */
			JSONObject job = new JSONObject();
			job.put("items", items);
			return job;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void paging(int page, HttpServletRequest req) {
		req.setAttribute("curPageNo", page);

		ArrayList<Movie> movies = (ArrayList<Movie>) req.getAttribute("movies");

		// 전체 페이지수 계산
		int cnt = 5;
		int total = movies.size();
		// 총 페이지 수
		int pageCount = (int) Math.ceil(((double) total / cnt));
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);

		ArrayList<Movie> items = new ArrayList<Movie>();

		for (int i = start - 1; i > end; i--) {

			items.add(movies.get(i));
		}
		req.removeAttribute("movies");

		req.setAttribute("moives", items);
	}

}
