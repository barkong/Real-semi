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
		// query = 寃��깋�뼱(肄섏넄濡� �엯�젰�븷 洹� 媛�)

		Scanner k = null;
		HttpsURLConnection huc = null;

		try {
//			k = new Scanner(System.in);
//			System.out.println("寃��깋�뼱: ");
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

			// json �뙆�떛�븯寃� jsonparser 媛앹껜 以�鍮�
			JSONParser jp = new JSONParser();

			JSONObject naverData = (JSONObject) jp.parse(isr);
			System.out.println(naverData);

			// 4媛�吏� �젣紐�, 諛곗슦 , 媛먮룆 ,留곹겕

			// JavasScript �뿉�꽌
			// {} 媛앹껜
			// [] 諛곗뿴
			JSONArray items = (JSONArray) naverData.get("items");
			for (int i = 0; i < items.size(); i++) {
				JSONObject movie = (JSONObject) items.get(i);
				String title = (String) movie.get("title");
				title = title.replace("<b>", "");
				title = title.replace("</b>", "");
				String actor = (String) movie.get("actor");
				String director = (String) movie.get("director");
				String link =  movie.get("link")+"";		

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
