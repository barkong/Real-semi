# *Real-semi*


![header](https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=Real-semi/MovieInfoSite)
[![Hits](https://hits.seeyoufarm.com/api/count/incr/badge.svg?url=https%3A%2F%2Fgithub.com%2Fbarkong%2FReal-semi%2Fhit-counter&count_bg=%2374806B&title_bg=%231C3E88&icon=&icon_color=%23E7E7E7&title=hits&edge_flat=false)](https://hits.seeyoufarm.com)

## 💪Skills

##### 💾Database ![MicrosoftSQLServer](https://img.shields.io/badge/Microsoft%20SQL%20Sever-CC2927?style=for-the-badge&logo=microsoft%20sql%20server&logoColor=white)
##### 📚Libraries ![jQuery](https://img.shields.io/badge/jquery-%230769AD.svg?style=for-the-badge&logo=jquery&logoColor=white)
##### ☁️Hosting/SaaS ![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
##### 💻IDEs/Editors ![Eclipse IDE](https://img.shields.io/badge/Eclipse%20IDE-2C2255.svg?&style=for-the-badge&logo=Eclipse%20IDE&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-007ACC.svg?&style=for-the-badge&logo=Visual%20Studio%20Code&logoColor=white) <img src="https://img.shields.io/badge/Sourcetree-0052CC?style=for-the-badge&logo=Sourcetree&logoColor=white">
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
* 회원(회원가입•탈퇴, 로그인, 회원정보 조회•수정)
* 게시판 (영화 리뷰, 자유, 내가쓴글)
* 영화 api (박스오피스, 검색, 뉴스)
* 카카오맵 api 

## 1. 회원

### 1.1 회원가입
*유효성검사*
- 항목마다 다른 조건을 걸어 다양한 function을 활용
- 좋아하는 장르 카테고리 체크박스 기능

### 1.2 로그인
- 로그인 세션의 유무에 따라 다른 페이지

### 1.3 로그인에 따른 페이지 컨트롤
로그인시 보고있던페이지로 가도록 구현
```java
// 보고 있는 페이지 컨트롤러 코드
@WebServlet("/HC")
public class HC extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String watchingPage = request.getRequestURL().toString();
		String param = request.getQueryString();
		if (request.getQueryString() != null) {
			watchingPage = watchingPage + "?" + param;
		}
		request.getSession().setAttribute("watchingPage", watchingPage);

		Model.loginCheck(request);
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
		
// 로그인 컨트롤러 코드
@WebServlet("/LoginC")
public class LoginC extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Model.login(request);
		
		if (Model.loginCheck(request)) {
			String watchingPage1 = request.getRequestURL().toString();
			HttpSession hs = request.getSession();
			String watchingPage = (String) hs.getAttribute("watchingPage");
			System.out.println("LoginC watchingPage = " + watchingPage);

			if (watchingPage == null || watchingPage.equals(watchingPage1)) {
				request.setAttribute("contentPage", "home.jsp");
				request.getRequestDispatcher("index.jsp").forward(request, response);
			} else {
				response.sendRedirect(watchingPage);
			}
			
		} else {
			request.setAttribute("contentPage", "jsp/jw/loginPage.jsp");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
	}
}	
```

### 1.4 마이페이지
- 패스워드,이름,이메일,전화번호,좋아하는 장르 수정가능
- 내가쓴글목록 : 마이페이지에서 두가지 게시판 불러와 조회

## 2. 게시판 (리뷰, 자유)
- 글쓰기, 수정, 삭제, 페이징, 조회, 검색기능 구현
- 두 게시판에 게시판별 최신/최다조회글 배치
- 게시판 목록 상단에 최다조회글 3개 상시배치
- DB저장시 모델에서 <br>값으로 replace해서 저장
- DB에서 가져올땐 모델에서 처리하는 것보다 JSTL에서 처리하는 것이 좋다

```jsp
	<!-- JSP상단 --> 
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<% pageContext.setAttribute("br", "<br>"); %>
	<% pageContext.setAttribute("cn", "\n"); %>
	
	<!-- JSP본문 -->
	${fn:replace(paramVO.content, br, "cn")}
```


### 2.1 영화 리뷰 게시판 (로그인 해야 사용 가능)
- 회원가입 해야 사용 가능하다.
- 영화에 관련된 리뷰 작성 및 수정 삭제 가능


### 2.2 자유 게시판
- 모두 다 사용 가능(글 쓰기, 수정, 삭제)


### 2.3 조회수 기능
- ip값을 활용하여 본인글 클릭하면 조회수 안올라 가도록 설계

```java
public static boolean ipCheck(HttpServletRequest request) {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "select f_ip from semi_review where f_no=?";
	String regIp = null; // 글에 등록되어 있는  ip
	String urIp = request.getRemoteAddr(); //현재 사용자 ip
	System.out.println("urIp : " + urIp);

	try {
		String no = request.getParameter("no");
		System.out.println("param no : " + no);

		con = DBManager.connect();
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, no);

		rs = pstmt.executeQuery();
		if (rs.next()) {
			regIp = rs.getString("f_ip");
		}

	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("r", "서버 오류..");
	} finally {
		DBManager.close(con, pstmt, rs);
	}
	System.out.println("regIp : " + regIp);

	if (urIp.equals(regIp)) {
		return false;
	} else {
		return true;
	}
}


### 2.4 다양한 경우의 수에 대비
- 세션이 만료된 경우
- 검색후 재검색 및 페이징
```

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

### 3-3. 박스오피스
캘린더 구현해서 날짜 선택시 값 넘어가도록 설정
이로인해 날짜 클릭시 편리한 박스오피스 순위 조회가능

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
(추가설명은 하단의 info.txt 참고)<br>


* * *


## DB 구조

### *semi_account*

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

### *semi_review*

COLUM_NAME|DATA_TYPE|NULLABLE|PKEY|
---|---|---|---|
R_NO|NUMBER(3,0)|NO|Y|
R_ID|VARCHAR2(30 BYTE)|NO|N|
R_MOVIE|VARCHAR2(50 CHAR)|NO|N|
R_TITLE|VARCHAR2(200 CHAR)|NO|N|
R_DETAIL|VARCHAR2(1000 CHAR)|NO|N|
R_IMG|VARCHAR2(500 CHAR)|YES|N|
R_DATE|DATE|NO|N|
R_COUNT|NUMBER(5,0)|YES|N|
R_IP|VARCHAR2(25 BYTE)|YES|N|

### *semi_free*

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

- DATE의 저장방식과 불러오기에 주의요함
- 게시판 ID칼럼은 ACCOUNT 테이블과 관계형을 위한 매개
- 게시판 IP칼럼은 중복조회를 체크하기 위함

* * *

## TEAM 

팀원|이메일|Task|
---|---|---|
김태형|`trainst37@gmail.com`|팀관리•문서•PageTrans•게시판•내가쓴글•글DB•css정리|
이동우|`leedongwoo564@gmail.com`|주변영화관 찾기•박스오피스 정보•페이징•영화뉴스 정보•영화검색•전체 css•readme|
김수현|`kimsouhyne@gmail.com`|주변영화관 찾기•박스오피스 정보•페이징•영화뉴스 정보•영화검색•전체 css•git|
송준우|`thdwnsdn98@gmail.com`|로그인•회원가입•마이페이지•회원관리DB•css(게시판포함)•ppt|

### *참조파일*
* info(Real-semi).txt : [Click](https://github.com/barkong/Real-semi/files/10151036/infoReal-semi.2.txt)<br>
* PPT(Real-semi) [Click](https://github.com/barkong/Real-semi/files/10151129/Real-semi.pptx)

