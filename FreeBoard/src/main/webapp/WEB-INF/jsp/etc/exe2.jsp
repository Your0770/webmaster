<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script>
	document.addEventListener('DOMContentLoaded', function(e) {
		createCalender(document.querySelector('#list'));

		//createCalenderMy(document.querySelector('#list'));
	})
	var finalday = 0;
	// 달력생성함수.
	function createCalender(target) {
		let year = prompt('년도를 입력하세요. ex) 2000')
		let month = prompt('월을 입력하세요. ex) 8')
		if (month.length < 2)
			month = '0' + month;
		let dayName = [ '일', '월', '화', '수', '목', '금', '토' ];
		let firstDate = new Date(year + '-' + month + '-01');
		let dateString = firstDate.getFullYear() + '년 '
				+ (firstDate.getMonth() + 1) + '월 ' + firstDate.getDate()
				+ '일 ' + dayName[firstDate.getDay()] + '요일';
		console.log(dateString);
		finaldate(year, month);
		console.log('마지막날 = ' + finalday);
		let day = firstDate.getDay();
		console.log('시작 = '+day);
		let tr = document.createElement('tr');
		for (let d = 1; d <= day; d++) {
			let td = document.createElement('td');
			tr.appendChild(td);
			td.style.color = '#ccc';
		}
		for (let d = 1; d <= finalday; d++) {
			let td = document.createElement('td');
			td.innerHTML = d;
			tr.appendChild(td);
			if (d % 7 == (day == 0 ? 0 : 7 - day)) {
				document.querySelector('#list').appendChild(tr);
				tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
			}

		}
		target.appendChild(tr);
	}

	// 그달의 마지막날 계산 함수(윤년 포함)
	function finaldate(year, month) {
		if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8
				|| month == 10 || month == 12) {
			finalday = 31;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			finalday = 30;
		} else if (month == 2) {
			if (year % 4 == 0 && year % 100 != 0) {
				finalday = 29;
			} else if (year % 400 == 0) {
				finalday = 29;
			} else {
				finalday = 28;
			}
		}
		return;
	}

	function createCalenderMy(target) {
		let tr = document.createElement('tr');
		for (let d = -1; d <= 33; d++) {
			let td = document.createElement('td');
			td.innerHTML = d;
			tr.appendChild(td);
			if (d % 7 == 5) {
				document.querySelector('#list').appendChild(tr);
				tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
			}
			if (d < 1) {
				td.innerHTML = d + 30;
				td.style.color = '#ccc';
			} else if (d > 31) {
				td.innerHTML = d - 31;
				td.style.color = '#ccc';
			}
		}
		target.appendChild(tr);
	}
</script>
<style>
#show tr, th, td {
	border: 1px, solid, #000;
	width: 40px;
}
</style>
</head>

<body>

	<div id="show">
		<table border="1">
			<thead>
				<tr>
					<th>Sun</th>
					<th>Mon</th>
					<th>Tue</th>
					<th>Wed</th>
					<th>Thr</th>
					<th>Fri</th>
					<th>Sat</th>
				</tr>
			</thead>
			<tbody id="list"></tbody>
		</table>

	</div>
</body>

</html>