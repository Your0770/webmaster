/**
 * ajax1.js
 * Asynchronous Javascript And Xml (비동기 방식 js와 xml) 
 * 동기 방식 = 순차적으로 일어나는 방식
 * 비동기 방식 => 시간이 걸리는 것을 대기열에 넣어두고 다른거 실행(시간을 절약) 
 */
let xhtp = new XMLHttpRequest();	//비동기방식처리(Ajax)
xhtp.open('get', 'memberJson.do');
xhtp.send();	//서버상 resource -> 작업시작

let data = [];
xhtp.onload = function(){
	let obj = JSON.parse(xhtp.responseText);
	console.log('0', obj);
	data = obj;
	console.log('1', data);
for(let i = 0; i<data.length; i++){
	console.log('3', data[i]);	//데이터가 없어서 안나옴
}	
}
	console.log('2', data);

