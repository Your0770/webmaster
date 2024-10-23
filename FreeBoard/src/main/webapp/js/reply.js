/**
 * reply.js
 * replyService 생성했던 메소드 활용.
 * 
 * <table id="replyList" class="table">
	<thead>
		<tr>
			<th>댓글번호</th>
			<th colspan="5">내용</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
	</thead>
	<tbody>

	</tbody>
</table>
 * 
 */

let page = 1; //댓글 페이지 변수
// 댓글등록 버튼
document.querySelector('#addReply').addEventListener('click', addReplyHandlerFnc);

function addReplyHandlerFnc(e) {
	let reply = document.querySelector('#reply').value;
	svc.addReply({ bno, reply, replyer: logId },
		result => {
			console.log(result);
			if (result.retCode == 'OK') {
				//let template = document.querySelector(".reply ul li").cloneNode(true);
				//template.querySelector("span").innerText = result.retVal["replyNo"];
				//template.querySelector("span:nth-of-type(2)").innerText = result.retVal["reply"];
				//template.querySelector("span:nth-of-type(3)").innerText = result.retVal["replyer"];
				//template.querySelector("span:nth-of-type(4)").innerHTML = "<button onclick='deleteRow(event)'>삭제</button>";
				//document.querySelector(".reply ul").appendChild(template);
				page = 1;
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err));
			} else if (result.retCode == 'FAIL') {
				alert('처리중 오류 발생');
			}
		},
		err => console.log(err)
	)
}
function linkMove() {
	// nav 하위 a 클릭이벤트
	document.querySelectorAll('nav ul.pagination a').forEach(function(aTag) {
		aTag.addEventListener('click', function(e) {
			e.preventDefault();	//이동 차단
			page = aTag.dataset.page;  //<a data-page="2">2</a>
			showList();
			svc.getReplyCount(bno, createPageList, err => console.log(err));
		})
	})
}


// 페이지 목록 출력 함수
svc.getReplyCount(bno, createPageList, err => console.log(err));
//createPageList();
function createPageList(result) {
	let totalCnt = result.totalCount;
	let startPage, endPage, realEnd;
	let prev, next;

	endPage = Math.ceil(page / 5) * 5;
	startPage = endPage - 4;
	realEnd = Math.ceil(totalCnt / 5)
	endPage = endPage > realEnd ? realEnd : endPage;

	prev = startPage > 1;
	next = endPage < realEnd;

	//페이지 출력
	let list = '';
	list += '<li class="page-item">';
	if (prev) {
		list += '  <a class="page-link" href="#" aria-label="Previous" data-page="' + (startPage - 1) + '">';
	} else {
		list += '  <a class="page-link disabled" aria-label="Previous">';
	}
	list += '    <span aria-hidden="true">&laquo;</span></a></li>';

	for (let p = startPage; p <= endPage; p++) {
		list += '<li class="page-item"><a class="page-link" href="#" data-page="' + p + '">' + p + '</a></li>';
	}

	list += '<li class="page-item">';
	if (next) {
		list += '  <a class="page-link" href="#" aria-label="Next" data-page="' + (endPage + 1) + '">';
	} else {
		list += '  <a class="page-link disabled" aria-label="Next">';
	}
	list += '    <span aria-hidden="true">&raquo;</span></a></li>';

	document.querySelector('nav ul.pagination').innerHTML = list;
	linkMove();
}


// 댓글 목록 출력 함수
showList();
function showList() {
	// 출력목록을 화면에서 지우고
	document.querySelectorAll('div.reply div.content li').forEach(function(li, idx) {
		if (idx > 0) li.remove();
	})
	// 목록출력
	svc.relist({ bno, page }, 	// bno
		function(result) {
			for (let i = 0; i < result.length; i++) {
				let template = document.querySelector(".reply ul li").cloneNode(true);
				template.querySelector("span").innerText = result[i]["replyNo"];
				template.querySelector("span:nth-of-type(2)").innerText = result[i]["reply"];
				template.querySelector("span:nth-of-type(3)").innerText = result[i]["replyer"];
				template.querySelector("span:nth-of-type(4)").innerHTML = "<button onclick='deleteRow(event)'>삭제</button>";
				document.querySelector(".reply ul").appendChild(template);
			}
		} //successFnc
		, function(err) {
			console.log(err);
		} //errorFnc 
	)
}

function deleteRow(e) {
	console.log(e);
	let rno = e.target.parentElement.parentElement.firstElementChild.innerText;
	console.log(rno);
	//삭제기능 호출
	svc.removeReply(rno,	//삭제할 댓글번호
		function(result) {
			if (result.retCode == 'OK') {
				alert('정상처리');
				//e.target.parentElement.parentElement.remove();
				if(document.querySelectorAll('div.reply div.content li').length == 2) page--;
				showList();
				svc.getReplyCount(bno, createPageList, err => console.log(err));
			} else if (result.retCode == 'FAIL') {
				alert('처리중 예외발생')
			} else {
				alert('알 수 없는 코드')
			}
		},		//정상처리 실행함수
		err => console.log(err)			//예외발생 실행함수
	)
}

// 사용 안함
function makeList(result) {
	for (let i = 0; i < result.length; i++) {
		let fields = ["replyNo", "reply", "replyer", "replyDate"];
		let tr = document.createElement('tr');
		for (let j = 0; j < fields.length; j++) {
			let td = document.createElement('td');
			td.innerHTML = result[i][fields[j]];
			tr.appendChild(td);
		}
		document.querySelector("#replyList tbody").appendChild(tr);
	}
}