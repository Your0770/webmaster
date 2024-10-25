<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <script>
    document.addEventListener('DOMContentLoaded', function (e) {
      createCalender(document.querySelector('#list'));
      
      createCalenderMy(document.querySelector('#list'));
    })

    // 달력생성함수.
    function createCalender(target) {
    	let firstDate = new Date('2024-10-01');
    	let day = ['Sun','Mon', 'Tue', 'Wed', 'Thr', 'Fri', 'Sat']; 
    	console.log(firstDate);
    	let dayName = day[firstDate.getDay()];
    	console.log(dayName);
      let tr = document.createElement('tr');
      for (let d = 1; d <= 31; d++) {
        let td = document.createElement('td');
        td.innerHTML = d;
        tr.appendChild(td);
        if (d % 7 == 0) {
          document.querySelector('#list').appendChild(tr);
          tr = document.createElement('tr'); // 토요일(7번 td를 생성하면)이 되면 tr을 새롭게 생성.
        }
    	
      }
      target.appendChild(tr);
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
    	if(d < 1) {
    		 td.innerHTML = d+30;
    		 td.style.color = '#ccc';
    	} else if (d > 31){
    		td.innerHTML = d-31;
    		 td.style.color = '#ccc';
    	}
      }
      target.appendChild(tr);
    }
  </script>
  <style>
  	#show tr, th, td{
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
<script src="js/exe2.js"></script>
</body>

</html>