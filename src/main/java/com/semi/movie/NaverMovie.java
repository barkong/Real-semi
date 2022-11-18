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
		// id wgYXNy22kl9oxlPDE5QR
		// secret Zm1c9tQ_jW

		// https://openapi.naver.com/v1/search/movie.xml
		// query = 寃��깋�뼱(肄섏넄濡� �엯�젰�븷 洹� 媛�)

		// Scanner k = null;
		HttpsURLConnection huc = null;

		try {

			// k = new Scanner(System.in);
			// System.out.println("寃��깋�뼱: ");
			request.setCharacterEncoding("UTF-8"); // �븳湲�源⑥쭚�빐寃곕갑踰�
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

			// json �뙆�떛�븯寃� jsonparser 媛앹껜 以�鍮�
			JSONParser jp = new JSONParser();

			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);

			// 4媛�吏� �젣紐�, 諛곗슦 , 媛먮룆 ,留곹겕

			// JavasScript �뿉�꽌
			// {} 媛앹껜
			// [] 諛곗뿴
			JSONArray items = (JSONArray) naverData.get("items");

			ArrayList<Movie> movies = new ArrayList<>();
			for (int i = 0; i < items.size(); i++) {
				JSONObject movie = (JSONObject) items.get(i);
				String title = (String) movie.get("title");
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");
				String actor = (String) movie.get("actor");
				String director = (String) movie.get("director");
				String link = movie.get("link") + ""; // 臾몄옄�뿴 罹먯뒪�듃 �븯�뒗 �삉 �떎瑜� 諛⑸쾿

				System.out.println("�쁺�솕�젣紐� : " + title);
				System.out.println("諛곗슦 : " + actor);
				System.out.println("媛먮룆 : " + director);
				System.out.println("留곹겕 : " + link);
				// System.out.println("-------------");

				// �젣紐�, 媛먮룆, 諛곗슦, 留�
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
