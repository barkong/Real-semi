package com.semi.rec;


import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class NaverMovie{

	public static void main(HttpServletRequest request) {
		// id wgYXNy22kl9oxlPDE5QR
		// secret Zm1c9tQ_jW

		// https://openapi.naver.com/v1/search/movie.xml
		// query = 검색어(콘솔로 입력할 그 값)

		Scanner k = null;
		HttpsURLConnection huc = null;

		try {
//			k = new Scanner(System.in);
//			System.out.println("검색어: ");
			String str = k.next();

			str = URLEncoder.encode(str, "utf-8");

			String url = "https://openapi.naver.com/v1/search/movie.json?genre=2&display=30";
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

			// json 파싱하게 jsonparser 객체 준비
			JSONParser jp = new JSONParser();

			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);

			// 4가지 제목, 배우 , 감독 ,링크

			// JavasScript 에서
			// {} 객체
			// [] 배열
			JSONArray items = (JSONArray) naverData.get("items");
			for (int i = 0; i < items.size(); i++) {
				JSONObject movie = (JSONObject) items.get(i);
				String title = (String) movie.get("title");
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");
				String actor = (String) movie.get("actor");
				String director = (String) movie.get("director");
				String link =  movie.get("link")+"";		//문자열 캐스트 하는 또 다른 방법

				System.out.println("영화제목 : " + title);
				System.out.println("배우 : " + actor);
				System.out.println("감독 : " + director);
				System.out.println("링크 : " + link);
				System.out.println("-------------");
				
				

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}