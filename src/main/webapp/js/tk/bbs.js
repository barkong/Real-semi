function reviewDel(n) {

	let ok = confirm('리뷰 삭제합니까?');
	if (ok) {
		location.href = "ReviewDelC?no=" + n;
	}
}

function freeDel(n) {

	let ok = confirm('자유글 삭제합니까?');
	if (ok) {
		location.href = "FreeDelC?no=" + n;
	}
}

function bbsLoginCheck() {

	alert('로그인하세요');
	location.href = ""

}


function bbsPageCheck() {

	var session = "${empty sessionScope.accountInfo.a_id}";

	if (session == "null") {
		alert("로그인이 필요한 항목입니다.");
	}
	else {
		location.href = "ReviewRegC";
	}
}

function bbsCall() {

	let title = document.bbsForm.title;
	let movie = document.bbsForm.movie;
	let detail = document.bbsForm.detail;

	if (isEmpty(title)) {
		alert('글제목을 채워주세요');
		title.focus();
		return false;
	}

	if (isEmpty(movie)) {
		alert('영화이름을 적어주세요');
		movie.focus();
		return false;
	}

	if (isEmpty(detail)) {
		alert('리뷰내용을 적어주세요');
		detail.focus();
		return false;
	}

	return true;
}

function search() {

	let searchText = document.searchForm.searchText;

	if (isEmpty(searchText)) {
		alert('검색어정돈 입력해라');
		searchText.focus();
		return false;
	}

	document.searchForm.submit();
}