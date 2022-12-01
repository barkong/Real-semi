function call(){
	
	let id = document.myForm.id;
	let pw = document.myForm.pw;
	let pw2 = document.myForm.pw2;
	let name = document.myForm.name;
	let birth = document.myForm.birth;
	let phone = document.myForm.phone;
	let email = document.myForm.email;
	
	
	if(isEmpty(id)){
		alert('ID를 입력해주세요');
		id.focus();
		return false;
	}
	if(lessThan(id, 4) || notContains(id, "1234567890")){
		alert('ID양식을 확인해주세요');
		id.focus();
		return false;
	}
	if(isEmpty(pw)){
		alert('PW를 입력해주세요');
		pw.focus();
		return false;
	}
	if(lessThan(pw, 6) || notContains(pw, "1234567890") || notContains(pw, "QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert('PW양식을 확인해주세요');
		pw.focus();
		return false;
	}
	if(isEmpty(pw2)){
		alert('비밀번호 확인을 해주세요');
		pw2.focus();
		return false;
	}
	if(notEquals(pw, pw2)){
		alert('비밀번호 확인을 다시 해주세요');
		pw2.focus();
		return false;
	}
	if(isEmpty(name)){
		alert('이름을 입력해주세요');
		name.focus();
		return false;
	}
	if(isEmpty(birth)){
		alert('생일을 입력해주세요');
		return false;
	}
	if(isEmpty(phone)){
		alert('전화번호를 입력해주세요');
		phone.focus();
		return false;
	}
	if(isEmpty(email)){
		alert('email을 입력해주세요');
		email.focus();
		return false;
	}
	
	
}

function call2(){
	
	let id = document.myForm.id;
	let pw = document.myForm.pw;
	
	if(isEmpty(id)){
		alert('ID를 입력해주세요');
		id.focus();
		return false;
	}
	
	if(isEmpty(pw)){
		alert('PW를 입력해주세요');
		pw.focus();
		return false;
	}
	
}

function chkPW(){
	let pw = document.myForm.pw;
	let pw2 = document.myForm.pw2;
	let pwConfirm = document.getElementById("pwConfirm");
	pw2.addEventListener("keyup", function(){
		pw = document.myForm.pw;
		pw2 = document.myForm.pw2;
		if(pw.value != pw2.value){
			pwConfirm.style.display = "block";
			pwConfirm.style.color = "red";
			pwConfirm.innerText = "비밀번호 불일치";
		}else{
			pwConfirm.style.color = "green";
			pwConfirm.innerText = "비밀번호 일치 성공";
		}
	});
}

function selectAll(selectAll)  {
  const checkboxes 
       = document.getElementsByName('chk');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked;
  })
}

function deleteID(){
	
	let ok = confirm("정말 탈퇴 하시겠습니까?");
	
	if(ok == true){
		alert("탈퇴 처리 되었습니다")
		location.href='DeleteAccountC';
	} 
}

function idChk() {
			var myForm = document.myForm;
			var id = myForm.id;
			var idvar = id.value;
			if(isEmpty(id)){
			alert('ID를 입력해주세요');
			id.focus();
			return false;
		}
			if(lessThan(id, 4) || notContains(id, "1234567890")){
			alert('ID양식을 확인해주세요');
			id.focus();
			return false;
		}
            location.href ='IdCheckC?id='+idvar;
        }

function UpdateCheck(){
	
	let pw = document.myForm.pw;
	let name = document.myForm.name;
	let phone = document.myForm.phone;
	let email = document.myForm.email;
	
	
	if(isEmpty(pw)){
		alert('PW를 입력해주세요');
		pw.focus();
		return false;
	}
	if(lessThan(pw, 6) || notContains(pw, "1234567890") || notContains(pw, "QWERTYUIOPASDFGHJKLZXCVBNM")){
		alert('PW를 양식에 맞게 변경해주세요');
		pw.focus();
		return false;
	}
	if(isEmpty(name)){
		alert('이름을 입력해주세요');
		name.focus();
		return false;
	}
	if(isEmpty(phone)){
		alert('전화번호를 입력해주세요');
		phone.focus();
		return false;
	}
	if(isEmpty(email)){
		alert('email을 입력해주세요');
		email.focus();
		return false;
	}
}

