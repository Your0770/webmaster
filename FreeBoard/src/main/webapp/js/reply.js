/**
 * reply.js
 * replyService 생성했던 메소드 활용.
 */
svc.relist(bno // bno
	, function(result) {
		console.log(bno);
		console.log(result);
		for (let i = 0; i < result.length; i++) {
			let fields = ["replyNo", "reply", "replyer", "replyDate"];
			let tr = document.createElement('tr');
			for (let j = 0; j < fields.length; j++) {
				let td = document.createElement('td');
				td.innerHTML = result[i][fields[j]];
				if(j == 1){
					td.colSpan = "5";
				}
				tr.appendChild(td);
			}
			document.querySelector("#replyList tbody").appendChild(tr);
		}

	} //successFnc
	, function(err) {
		console.log(err)
	} //errorFnc 
)