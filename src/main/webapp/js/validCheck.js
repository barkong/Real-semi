// 일반적으로 유효성 검사 하는 것들
// JS 라이브러리 완성



// 함수형태로 정리해서
// 나중에 필요할때 쓸라고 (쓰게 편하게 작업)
// .jar 가져다 쓰듯이 (lib)


// 문제가 있으면 true, 아니면 false


// <input>을 넣으면..
// 거기에 글자가 없으면 true, 있으면 false

function isEmpty(input) {
	return !input.value; // 값이 없다
}

// <input>과, 글자 수를 넣으면
// 그 글자수보다 적으면 true, 아니면 false

function lessThan(input, length) {
	return input.value.length < length;
}


// <input>을 넣으면
// 한글/특수문자 들어있으면 true, 아니면 false
function containKR(input) {
	
// mz => ㅎmz
	let ok = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM@._";

	for (let i = 0; i < input.value.length; i++) {
		if(ok.indexOf(input.value[i]) == -1)
		return true;
	}



}


// Test

// <input> x2 넣으면 (비번확인)
// 내용이 다르면 true, 아니면 false

function notEquals(input1, input2){
	if(input1.value != input2.value){
		return true;
	}
}

// <input>, 문자열세트
// 그 문자열 세트가 포함 안되있으면 true
// 들어있으면 false

function notContains(input, set){

// input : 1qwerASD
// input : ASD
	
// set : 1234567890 숫자를 반드시 포함 시키고 싶다.
// set : QWERTYUIOPASDFGHJKLZXCVBNM	대문자를 반드시 포함

	for(let i = 0; i< set.length; i++){
		if(input.value.indexOf(set[i]) != -1){
			return false;
		}
		
	}	
	return true;
}


// <input>을 넣어서
// 숫자가 아니면 true, 숫자면 false

// input : 123
// input : aaa

function isNotNumber(input){
	return isNaN(input.value);
}


// <input>, 확장자를 넣으면
// 그게 아니면 true, 괜찮으면 false

function isNotType(input, type){
	// a.mp4
	
	type = "." + type;	// png
	return input.value.indexOf(type) == -1;
	
}
