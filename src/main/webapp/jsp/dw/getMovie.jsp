<%@page import="org.apache.catalina.webresources.TomcatJarInputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.json.simple.JSONArray"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="javax.net.ssl.HttpsURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="org.json.simple.parser.JSONParser"%>
<%
String str = request.getParameter("title");

str = URLEncoder.encode(str, "utf-8");

String url = "https://openapi.naver.com/v1/search/movie.json";
url += "?query=" + str;
url += "&display=1";


URL u = new URL(url);
HttpURLConnection huc = (HttpsURLConnection) u.openConnection();

huc.addRequestProperty("X-Naver-Client-Id", "_dGZX3vm4d9iUQCSPrmu");
huc.addRequestProperty("X-Naver-Client-Secret", "CPXPizei_I");

InputStream is = huc.getInputStream();
InputStreamReader isr = new InputStreamReader(is, "utf-8");

JSONParser jp = new JSONParser();

JSONObject naverData = (JSONObject) jp.parse(isr);

JSONArray items = (JSONArray) naverData.get("items");
JSONObject item = (JSONObject) items.get(0);
String img = (String) item.get("image");
String director = (String) item.get("director");
director = director.replace("|", "");
String actor = (String) item.get("actor");
actor = actor.replace("|", ",");
String link = (String) item.get("link") + "";
String pubDate = (String) item.get("pubDate");
String subtitle = (String) item.get("subtitle");

JSONObject joo = new JSONObject();
joo.put("img", img);
joo.put("link", link);
joo.put("director", director);
joo.put("actor", actor);
joo.put("pubDate", pubDate);
joo.put("subtitle", subtitle);

response.setContentType("application/json");
response.setCharacterEncoding("utf-8");
out.print(joo.toJSONString());

// ArrayList<Movie> movies = new ArrayList<>();
%>