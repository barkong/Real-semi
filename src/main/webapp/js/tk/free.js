function freeDel(n) {
	
	let ok = confirm('정말 삭제합니까?')
	if(ok) {
		location.href="FreeDelC?no=" + n;
	}
}