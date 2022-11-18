function call(){
	
	let id = document.myForm.id;
	let pw = document.myForm.pw;
	let pw2 = document.myForm.pw2;
	let name = document.myForm.name;
	let birth = document.myForm.birth;
	let gender = document.myForm.gender;
	let email = document.myForm.email;
	let phone = document.myForm.phone;
	
	console.log(name.value);
	console.log(id.value);
	console.log(pw.value);
	console.log(pw2.value);
	console.log(birth.value);
	console.log(gender.value);
	console.log(email.value);
	console.log(phone.value);
	
	if(isEmpty(name)){
		alert('이름 에러');
		name.focus();
		
		return false;
	}
	
	if(lessThan(id,5) || containKR(id)){
		alert('id 에러');
		id.focus();
		
		return false;
	}
	
	if(lessthan(pw,3)){
		alert('pw 에러');
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