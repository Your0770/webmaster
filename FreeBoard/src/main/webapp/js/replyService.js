/**
 * replyService.js
 * 메소드 : 목록, 등록, 삭제
 */

const svc = {
	relist(bno = 1,successFnc, errorFnc) { //목록 출력
		// Ajax 호출
		fetch('replyList.do?bno=' + bno)
			.then(resolve => resolve.json())
			.then(successFnc)
			.catch(errorFnc)

	}
}

let bno = document.querySelector('form table tr:nth-child(1) td').innerHTML;
console.log(bno);
