/**
 * members.js
 * 
 * 
	<table class="table">
		<tr>
			<th>회원ID</th>
			<td><input type="text" id="mid"></td>
		</tr>
		<tr>
			<th>이름</th>
			<td><input type="text" id="mname"></td>
		</tr>
		<tr>
			<th>연락처</th>
			<td><input type="text" id="mphone"></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><button id="addBtn">등록</button></td>
		</tr>
	</table>
	
<div id="show">


	<!-- 회원목록 출력 -->
	<table class="table">
		<thead>
			<tr>
				<th>회원아이디</th>
				<th>회원이름</th>
				<th>연락처</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>
	</div>
 * 
 */
// jsp => req.getRequestDispatcher("....tiles").forward(req.resp);
// json => json 데이터 활용 페이지 작성
// json 형태의 회원 목록을 출력하는 데이터 생성
// "등록" 버튼에 이벤트 추가
document.querySelector('#addBtn').addEventListener("click", function(e) {
	let id = document.querySelector('#mid').value;
	let name = document.querySelector('#mname').value;
	let phone = document.querySelector('#mphone').value;

	fetch('addMemberJson.do?id=' + id + '&name=' + name + '&phone=' + phone)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result); //{retCode: 'OK'}
			if (result.retCode == 'OK') {
				let tr = makeRow({ memberId: id, memberName: name, phone: phone });
				document.querySelector("#show tbody").appendChild(tr);
			} else if (result.retCode == 'FAIL') {
				alert('처리중 에러가 발생')
			}
		})
		.catch(err => console.log(err))
});




// 1.목록출력
fetch('memberJson.do')
	.then(resolve => resolve.json())
	.then(result => {
		console.log(result);
		makeList(result);
	})
	.catch(err => console.log(err))

function makeList(obj = []) {
	// 작성
	for (let i = 0; i < obj.length; i++) {
		let tr = makeRow(obj[i]);
		document.querySelector("#show tbody").appendChild(tr);
	}

}

function makeRow(obj = {}) {
	let fields = ["memberId", "memberName", "phone"];
	let tr = document.createElement('tr');
	tr.setAttribute('data-id', obj.memberId);
	for (let j = 0; j < fields.length; j++) {
		let td = document.createElement('td');
		td.innerHTML = obj[fields[j]];
		tr.appendChild(td);
	}
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.innerHTML = '삭제';
	btn.addEventListener("click", deleteRowFun)
	td.appendChild(btn);
	tr.appendChild(td);
	return tr;
}

function deleteRowFun(e) {
	//console.log(e.target.parentElement.parentElement.firstElementChild.innerText);
	console.log(e.target.parentElement.parentElement.dataset.id);
	let id = e.target.parentElement.parentElement.dataset.id;
	fetch('removeMemberJson.do?id=' + id)
		.then(resolve => resolve.json())
		.then(result => {
			console.log(result);
			if (result.retCode == 'OK') {
				e.target.parentElement.parentElement.remove();

			} else if (result.retCode == 'FAIL') {
				alert('처리중 에러 발생');
			}
		})
		.catch(err => console.log(err))



}