# *Real-semi*


![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=Real-semi/MovieInfoSite)
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fbarkong%2FReal-semi%2Fhit-counter&count_bg=%2374806B&title_bg=%231C3E88&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

## 💪Skills

##### 💾Databases ![MicrosoftSQLServer](https://img.shields.io/badge/Microsoft%20SQL%20Sever-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white)
##### 📚Frameworks, Platforms and Libraries ![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
##### ☁️Hosting/SaaS ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
##### 💻IDEs/Editors ![Eclipse IDE](https://img.shields.io/badge/Eclipse%20IDE-2C2255.svg?&style=for-the-badge&logo=Eclipse%20IDE&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC.svg?&style=for-the-badge&logo=Visual%20Studio%20Code&logoColor=white)
##### 📋 Languages ![HTML5](https://img.shields.io/badge/html5-%23E34F26.svg?style=for-the-badge&logo=html5&logoColor=white) ![Css](https://img.shields.io/badge/css-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-%23323330.svg?style=for-the-badge&logo=javascript&logoColor=%23F7DF1E) 
##### 🗄️ Servers ![Apache Tomcat](https://img.shields.io/badge/apache%20tomcat-%23F8DC75.svg?style=for-the-badge&logo=apache-tomcat&logoColor=black)


* * *



*🎬 영화 정보 사이트 🎬*
-------------
### 영화에 관련된 정보를 보여주는 사이트입니다. 
- 날짜 별 선택을 통해 박스오피스 순위별 정보
- 검색창을 통해 얻고싶은 영화 정보 
- 영화에 관련된 뉴스 정보
- 로그인을 통한 리뷰게시판, 자유게시판 소통
- 카카오맵을 통한 주변 영화관 위치 정보
- ~~장르별 영화정보~~ <br>

## 기능별 소개
* 회원(회원가입•수정•탈퇴, 로그인, 마이페이지)
* 게시판 (영화 리뷰, 자유)
* 영화 api (박스오피스, 검색, 뉴스)
* 카카오맵 api 

## 1. 회원

### 1.1 회원가입
*유효성검사*
- 내용이 하나라도 비어있으면 안됨
- 정해진 조건에 맞게 입력해야됨
- 영화 흥미 카테고리 체크박스, 전체체크중 체크안하면 관심사없음

### 1.2 로그인
- 로그인 세션이 남아있을때와 없을때 다르게 보이게 설정
- 세션이 없으면 로그인버튼이 나오게 -> 로그인 페이지로 이동
- 세션이 있으면 회원아이디 이름 마이페이지 버튼 로그아웃 버튼 보이게 설정

### 1.3 마이페이지
- 회원정보 전부 나옴
- 패스워드,이름,이메일,전화번호,좋아하는 장르 수정가능

## 2. 게시판 
- 글쓰기, 수정, 삭제, 페이징 기능 구현


### 2.1 영화 리뷰 게시판 (로그인 해야 사용 가능)
- 회원가입 해야 사용 가능하다.
- 영화에 관련된 리뷰 작성 및 수정 삭제 가능

### 2.2 자유 게시판
- 모두 다 사용 가능(글 쓰기, 수정, 삭제)


## 3. 영화 API
- 네이버 검색 api와 영화진흥위원회 api 등록후 사용

### 3-1. 키 발급
 <img src="https://user-images.githubusercontent.com/96048975/205032655-196075dc-e665-4533-90e1-c24dd7ad2b3c.PNG" width="50%" height="30%">
 <img src="https://user-images.githubusercontent.com/96048975/205032662-ede4bfd7-df4b-42f2-bf39-59fdec471fc5.PNG" width="50%" height="30%">
 <img src="https://user-images.githubusercontent.com/96048975/205032668-dd734fe2-3889-4db4-a314-e807ce73bd7e.PNG" width="50%" height="30%">

### 3-2. API 사용
Jquery, Java를 사용해 값을 받아왔다


일부 예시
```jsp
<%
String str = request.getParameter("title");
System.out.println(str);

str = URLEncoder.encode(str, "utf-8");
System.out.println(str);

String url = "https://openapi.naver.com/v1/search/movie.json";
url += "?query=" + str;
url += "&display=1";

System.out.println(url);

URL u = new URL(url);
HttpURLConnection huc = (HttpsURLConnection) u.openConnection();

huc.addRequestProperty("X-Naver-Client-Id", "_dGZX3vm4d9iUQCSPrmu");
huc.addRequestProperty("X-Naver-Client-Secret", "CPXPizei_I");

InputStream is = huc.getInputStream();
InputStreamReader isr = new InputStreamReader(is, "utf-8");
System.out.println(is);

JSONParser jp = new JSONParser();

JSONObject naverData = (JSONObject) jp.parse(isr);
System.out.println(naverData.get("items"));

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
```
``` js
   $.ajax({
                url: "jsp/dw/getMovie.jsp", // 클라이언트가 HTTP 요청을 보낼 서버의 URL 주소
                async: false,
                data: { title: movieList[i].movieNm }, // HTTP 요청과 함께 서버로 보낼 데이터
                method: "GET", // HTTP 요청 메소드(GET, POST 등)
                dataType: "json", // 서버에서 보내줄 데이터의 타입
              })
```

## 4. 카카오맵 api

- 키워드로 장소검색하고 목록으로 표출하기 (키워드에 영화 넣고 현위치에서 지도가 생성되게 하였다)


```js
let lat;
	let lon;
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			lat = position.coords.latitude;
			lon = position.coords.longitude;
		}
    
var markers = [];

		var mapContainer = document.getElementById('map'), 
		
		mapOption = {
			center : new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
			level : 1
		};
```


자세한 내용은 Click[PPT](피피티 pdf파일)<br>
* * *


## DB 구조

*semi_account*
* * *
COLUM_NAME|DATA_TYPE|NULLABLE|PKEY|
---|---|---|---|
A_ID|VARCHAR2(30 BYTE)|NO|Y|
A_PASSWORD|VARCHAR2(20 BYTE)|NO|N|
A_NAME|VARCHAR2(100 BYTE)|NO|N|
A_BIRTH|DATE|YES|N|
A_GENDER|VARCHAR2(10 BYTE)|NO|N|
A_EMAIL|VARCHAR2(30 BYTE)|NO|N|
A_PHONE|VARCHAR2(20 BYTE)|NO|N|
A_INTEREST|VARCHAR2(200 BYTE)|NO|N|

*semi_review*
* * *
COLUM_NAME|DATA_TYPE|NULLABLE|PKEY|
---|---|---|---|
R_NO|NUMBER(3,0)|NO|N|
R_ID|VARCHAR2(30 BYTE)|NO|N|
R_MOVIE|VARCHAR2(50 CHAR)|NO|N|
R_TITLE|VARCHAR2(200 CHAR)|NO|N|
R_DETAIL|VARCHAR2(1000 CHAR)|NO|N|
R_IMG|VARCHAR2(500 CHAR)|YES|N|
R_DATE|DATE|NO|N|
R_COUNT|NUMBER(5,0)|YES|N|
R_IP|VARCHAR2(25 BYTE)|YES|N|

*semi_free*
* * *
COLUM_NAME|DATA_TYPE|NULLABLE|PKEY|
---|---|---|---|
F_NO|NUMBER(8,0)|NO|Y|
F_ID|VARCHAR2(30 BYTE)|NO|N|
F_TITLE|VARCHAR2(200 CHAR)|NO|N|
F_DETAIL|VARCHAR2(1000 CHAR)|NO|N|
F_IMG|VARCHAR2(500 CHAR)|YES|N|
F_DATE|DATE|NO|N|
F_COUNT|NUMBER(5,0)|YES|N|
F_IP|VARCHAR2(25 BYTE)|YES|N|


## TEAM 
* * *
팀원|이메일|Task|
---|---|---|
김태형|`trainst37@gmail.com`|로그인•내가 쓴글•마이페이지•게시판, 회원가입, css|
이동우|`leedongwoo564@gmail.com`|주변 영화관 찾기, 박스오피스 정보, 영화 뉴스 정보, 검색, 전체 css|
김수현|`kimsouhyne@gmail.com`|박스오피스 정보, 영화 뉴스 정보, 검색, 주변 영화관 찾기, 전체 css|
송준우|`thdwnsdn98@gmail.com`|로그인•내가 쓴글•마이페이지•게시판, 회원가입, css|
