/**
 * jreply.js
 */

function list(){
// jQuery 방식의 Ajax 호출
$.ajax('replyList.do?bno=' + bno + '&page=1')
	.done(function(result) {
		console.log(result);
		//목록지우기
		$("div.content ul li:not(:eq(0))").remove();
		//목록
		result.forEach((item) => {
			$('<li/>').append(
				$('<span/>').addClass('col-sm-2').text(item.replyNo),				//글번호
				$('<span/>').addClass('col-sm-5').text(item.reply),				//댓글내용
				$('<span/>').addClass('col-sm-2').text(item.replyer),				//작성자
				$('<span/>').addClass('col-sm-2').append($('<button>삭제</button>'))	//삭제버튼
			).appendTo($('div.content ul'));
		});
	})
	.fail(function(err) {
		console.log(err);
	})
}
list();
//데이터 삭제
$('div.content ul').on('click', 'button', function(e) {
	console.log($(e.target).closest("li").find('span:eq(0)').text());
	let rno = $(e.target).closest("li").find('span:eq(0)').text();
	$.ajax({
		url: 'removeReply.do',
		data: {rno: rno},
		method: "GET",
		dataType: "json"	//문자열 => 자바스크립트 객체
	})
	.done(function(result){
		if(result.retCode == 'OK'){
			console.log(result);
			//화면 삭제
			//$(e.target).closest("li").remove();
			//재목록
			list();
		}
	})
	.fail(function(err){
		console.log(err);
	});
});

$('#addReply').on('click', function(e){
	console.log($(e.target).closest('div.header').find('input').val());
	let reply = $(e.target).closest('div.header').find('input').val();
	if(!reply || !logId){
		alert('값을 입력해주세요');
		return;
	}
	$.ajax({
		url: 'addReply.do',
		data: {bno: bno, reply: reply, replyer: logId},
		method: "GET",
		dataType: "json"
	})
	.done(function(result){
		if(result.retCode == 'OK'){
			console.log(result);
			/*
			목록을 첫번째 <li/> 뒤에 추가
			$('div.content ul li:first').after(
			$('<li/>').append(
				$('<span/>').addClass('col-sm-2').text(result.retVal["replyNo"]),				//글번호
				$('<span/>').addClass('col-sm-5').text(result.retVal["reply"]),				//댓글내용
				$('<span/>').addClass('col-sm-2').text(result.retVal["replyer"]),				//작성자
				$('<span/>').addClass('col-sm-2').append($('<button>삭제</button>')))	//삭제버튼
			);
			*/
			list();
		}
	})
	.fail(function(err){
		console.log(err);
	})
})