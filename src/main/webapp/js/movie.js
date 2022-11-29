$(function() {

	$("#searchInput").keyup(function(e) {
		if (e.keyCode == 13) {
			if (this.value != "") {
				console.log(this.value)
				$.ajax({
					url: "MovieSearchC2",
					data: { movie: this.value },
					dataType: "json",
					success: function(data) {
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
		dataSource: data.items,
		pageSize: 5,
		callback: function(data, pagination) {
			$("#content").remove();
			$("#newsContainer").remove();
			let content = "";
			
			$.each(data, function(index, i) {
			let director = i.director;
			let actor = i.actor;
		
			director = director.replace(/\|/g, "");
			actor = actor.replace(/\|/g, ",");
			
				content += "<form action='MovieSearchC'><div id='movie'><div class='poster'>"
					+ "<a href='" + i.link + "'>+" +
					"<img src='" + i.image + "'/></a></div>"
					+ "<div class='content'><span class='searchTitle'>"
					+ i.title 
					+ "</span><br><span class='subTitle'>"
					+ i.subtitle
					+ "</span>"
					+ "<div class='etc'><div class='searchSpanDiv'><span class='searchSpan'>개봉년도</span></div><div class='searchRDiv'>"
					+ i.pubDate + "</div>년 <br><div class='searchSpanDiv'><span class='searchSpan'>배우</span></div><div class='searchRDiv'>"
					+ actor + "</div><br><div class='searchSpanDiv'><span class='searchSpan'>감독</span></div><div class='searchRDiv'>"
					+ director + "</div><br><div class='searchSpanDiv'><span class='searchSpan'>평점</span></div><div class='searchRDiv'>"
					+ i.userRating + "</div></div></div></div></form>"
			});

			$("#searchResultContainer").html(content);
		}
	});
}
