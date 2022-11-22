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

public class NaverNews {

	public static void getNews(HttpServletRequest request) {

		HttpsURLConnection huc = null;

		try {

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
				
				String description = (String) news1.get("description");
				
				String link = (String) news1.get("link");

				System.out.println("뉴스 제목  : " + title);
				System.out.println("요약 내용 : " + description);
				System.out.println("링크 : " + link);

				News n = new News(title, description, link);

				news.add(n);

			}

			// for end
			request.setAttribute("news", news);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
