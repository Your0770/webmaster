<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='js/index.global.js'></script>
<script>
	let modalArg = null;	//arg 공유할 목적
	var calendar = null;	//calendar 공유할 목적
  document.addEventListener('DOMContentLoaded', async function() {
    var calendarEl = document.getElementById('calendar');
    
    
    
    
    
    
    
    //new Promise(function(){}, function(){})
    //Promise 객체가 반환될때 await 수행코드.
    var eventData = [];
    let resolve = await fetch('eventList.do')
	let result = await resolve.json();			//.then(resolve => resolve.json())
	eventData = result;							//.then(result => {
												//	result.forEach((event) => {
												//		if(event.end != null){
												//			eventData.push({ title: event.title, start: event.start, end: event.end})
			  									//    	} else {
												//			eventData.push({ title: event.title, start: event.start})
									  		    //    	}
	     										//  })
		 										//	console.log(eventData);
	  											//})
												//.catch(err => console.log(err));
    
      calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,next today',
        center: 'title',
        right: 'dayGridMonth,timeGridWeek,timeGridDay'
      },
      initialDate: '2024-10-24',
      navLinks: true, // can click day/week names to navigate views
      selectable: true,
      selectMirror: true,
      select: function(arg) {
    	  modalShow(arg);
  	  /*
        var title = prompt('Event Title:');
        if (title) {
        	console.log(arg);	//start, end
        	
        	
        	fetch('selectEvent.do?title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr )
        	.then(resolve => resolve.json())
        	.then(result => {
        		
        	})
        	.catch(err => console.log(err));
        	
        
        	
        }
     	*/
        calendar.unselect()
      },
      eventClick: function(arg) {
    	  console.log(arg);
        if (confirm('Are you sure you want to delete this event?')) {
        	fetch('removeEvent.do?title=' + arg.event.title + '&start=' + arg.event.startStr + '&end=' + arg.event.endStr)
        	.then(resolve => resolve.json())
        	.then(result => {
    	  		console.log(result);
        		if(result.retCode == 'OK'){
		          arg.event.remove();
        		} else if (result.retCode == 'FAIL'){
        			alert('삭제 실패');
        		}
        	})
        	.catch(err => console.log(err));
        }
      },
      editable: true,
      
      dayMaxEvents: true, // allow "more" link when too many events
      
      events: eventData
    });

    calendar.render();
  });

</script>
<script src="js/calendarModal.js"></script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: Arial, Helvetica Neue, Helvetica, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 1100px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

		<!-- Button trigger modal -->
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Launch demo modal</button>
	
		<!-- Modal -->
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Modal title</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
						타이틀: <input type="text" id="title"><br>
						시작일시: <input type="date" id="start" onchange="startChange(event)"><br>
						종료일시: <input type="date" id="end" onchange="endChange(event)"><br>
						<input type="datetime-local" id="sTime"><br>
						<input type="datetime-local" id="eTime"><br>
						
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary" onclick="modalSave()">Save changes</button>
					</div>
				</div>
			</div>
		</div>

</body>
</html>
