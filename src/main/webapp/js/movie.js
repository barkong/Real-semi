$(function() {
	
	$("#searchInput").keyup(function(e){
		if(e.keyCode == 13){
			if(this.value != ""){
				console.log(this.value)
		$.ajax({
			url : "MovieSearchC2",
			data : {movie : this.value},
			dataType : "json",
			success : function(data) {
				successCall2(data);
			}
		});
			}
		}
	});
	
	});
	
	function successCall2(data) {

		let container = $('#pagination');
		console.log(container)
		container.pagination({
					dataSource : data.items,
					pageSize : 5,
					callback : function(data, pagination) {
						$("#content").remove();
						$("#newsContainer").remove();
						console.log("asdasdsadasdassda");	
					let content = "";
						$.each(data,function(index, i) {
				console.log(content);
				content += "<form action='MovieSearchC'><div id='movie'><div class='poster'>"
				+ "<a href='"+ i.link + "'>+"+
				"<img src='"+ i.image + "'/></a></div>" 
				+"<div class='content'><span class='title'>"
				+i.title
				+"</span><br><span class='subTitle> (" 
				+i.subTitle
				+")</span>'"
				+ "<div class='etc' 개봉년도 >"
				+i.pubDate + "<br> 배우 -"
				+i.actor +"<br> 감독 -" 
				+i.director +"<br> 평점" 
				+i.rating +"</div></div></div></form>"
						});

			$("#searchResultContainer").html(content);
					}
				});
	}
