<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script type="text/javascript" src="jw/check.js"></script>
  </head>
  <body>
    <form
      name="myForm"
      action="AccountC"
      method="post"
      onsubmit="return call()"
    >
      <fieldset>
        <legend>회원가입</legend>
        <div>ID : <input name="id" placeholder="한글x, 5글자 이상" /></div>
        <div>
          PW : <input name="pw" placeholder="3글자 이상, 대,소,숫 포함" />
        </div>
        <div>
          PW 확인 :
          <input
            name="pw2"
            placeholder="비번 재확인"
            autocomplete="off"
            onkeyup="chkPW()"
          />
        </div>
        <div>이름 : <input name="name" placeholder="필수" /></div>
        <div>생일 : <input type="date" name="birth" /></div>
        <div>
          성별 : 남<input
            type="radio"
            name="gender"
            value="남"
            checked="checked"
          />
          여<input type="radio" name="gender" value="여" />
        </div>
        <div>
          email : <input type="email" name="email" size="30" required />
        </div>
        <div>전화번호 : <input type="tel" name="phone" /></div>
        <div>
          좋아하는 장르 : All<input
            type="checkbox"
            name="chk"
            value="all"
            onclick="selectAll(this)"
          /><br />
          <input type="checkbox" name="chk" value="" />
          <input type="checkbox" name="chk" value="" />
          <input type="checkbox" name="chk" value="" />
          <input type="checkbox" name="chk" value="" />
        </div>
        <div><button>가입</button></div>
      </fieldset>
    </form>
  </body>
</html>
