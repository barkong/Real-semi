package com.semi.movie;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

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

				System.out.println("영화제목 : " + title);
				System.out.println("배우 : " + actor);
				System.out.println("감독 : " + director);
				System.out.println("링크 : " + link);
				System.out.println("-------------");

				
				Movie m = new Movie(title, director, actor, link);

				movies.add(m);

			}

			// for end
			request.setAttribute("movies", movies);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
