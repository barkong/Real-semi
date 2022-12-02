package com.semi.movie;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieDetail {

	public static void getDetail(HttpServletRequest request) {

		HttpsURLConnection huc = null;

		try {

			String url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=9277299fa5d76d3f8ea02bb835de6f09&movieCd=20124079";

			System.out.println(url);

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			

			JSONParser jp = new JSONParser();

			JSONObject movieData = (JSONObject) jp.parse(isr);
			

			JSONArray items = (JSONArray) movieData.get("movieinfo");

			ArrayList<MovieInfo> movies = new ArrayList<>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject movieInfo = (JSONObject) items.get(i);
				String movieNm = (String) movieInfo.get("movieNm");

				String openDt = (String) movieInfo.get("openDt");
				String directors = (String) movieInfo.get("directors");
				String genreAlt = (String) movieInfo.get("genreAlt");
				String company = (String) movieInfo.get("company");

				
				MovieInfo m1 = new MovieInfo(movieNm, openDt, genreAlt, directors, company);
				movies.add(m1);

			}

			// for end
			request.setAttribute("movies", movies);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
