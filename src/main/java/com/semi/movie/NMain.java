package com.semi.movie;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class NMain {
	public static void main(String[] args) {

		Scanner k = null;
		HttpsURLConnection huc = null;

		try {
			k = new Scanner(System.in);
			System.out.println("�˻���: ");
			String str = k.next();

			str = URLEncoder.encode(str, "utf-8");

			String url = "https://openapi.naver.com/v1/search/movie.json";
			url += "?query=" + str;
			url += "&display=30";

			System.out.println(url);

			URL u = new URL(url);
			huc = (HttpsURLConnection) u.openConnection();

			huc.addRequestProperty("X-Naver-Client-Id", "wBayTv1h7ArsOiRy1fOC");
			huc.addRequestProperty("X-Naver-Client-Secret", "woPx3YtjhA");

			InputStream is = huc.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			System.out.println(is);

			JSONParser jp = new JSONParser();
			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);

			JSONArray items = (JSONArray) naverData.get("items");
			String title = null;
			String actor = null;
			String director = null;
			String link = null;
			
			for (int i = 0; i < items.size(); i++) {
				JSONObject movie = (JSONObject) items.get(i);

				title = (String) movie.get("title");
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");

				actor = (String) movie.get("actor");
				director = movie.get("director") + "";  
				link = (String) movie.get("link");

				System.out.println(i + 1);
				System.out.println("영화제목: " + title);
				System.out.println("배우: " + actor);
				System.out.println("감독: " + director);
				System.out.println("링크: " + link + "\n");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
