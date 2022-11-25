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
	private static ArrayList<News> news;
	private static final NaverNews NA = new NaverNews();
			

	public NaverNews() {
		// TODO Auto-generated constructor stub
	}
	
	public static NaverNews getNa() {
		return NA;
	}

	public ArrayList<News> getNews(HttpServletRequest request) {

		HttpsURLConnection huc = null;

		try {
			request.setCharacterEncoding("UTF-8");

			String str = "영화";
			str = URLEncoder.encode(str, "utf-8");
			System.out.println(str);

			String url = "https://openapi.naver.com/v1/search/news.json";

			url += "?query=" + str;
			url += "&display=30";
			url += "&sort=sim";

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

				String time = (String) news1.get("pubDate");
				time = time.substring(0, 16);

				System.out.println("뉴스 제목  : " + title);
				System.out.println("요약 내용 : " + description);
				System.out.println("링크 : " + link);
				System.out.println("time : " + time);

				News n = new News(title, description, link, time);
				news.add(n);
				
			}
			request.setAttribute("news", news);
			return news;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	public void paging(int page,  HttpServletRequest req) {
		System.out.println("ddddd");
		req.setAttribute("curPageNo", page);
		
		ArrayList<News> news = (ArrayList<News>) req.getAttribute("news");

		// 전체 페이지수 계산
		int cnt = 5;
		int total = news.size();
		System.out.println(total);
		// 총 페이지 수
		int pageCount = (int) Math.ceil(((double) total / cnt));
		req.setAttribute("pageCount", pageCount); // 페이지넘기기 화살표를 위해 넘겨주는 것

		int start = total - (cnt * (page - 1));

		int end = (page == pageCount) ? -1 : start - (cnt + 1);
		
		ArrayList<News> items = new ArrayList<News>();

		for (int i = start - 1; i > end; i--) {

			items.add(news.get(i));
		}
		req.removeAttribute("news");
		
		req.setAttribute("news", items);
	}

}
