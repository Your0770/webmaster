<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset='utf-8' />
<script src='js/index.global.js'></script>
<script>

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
    
      var calendar = new FullCalendar.Calendar(calendarEl, {
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
        var title = prompt('Event Title:');
        if (title) {
        	console.log(arg);	//start, end
        	//fetch('selectEvent.do?title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr )
        	
        	fetch('addEvent.do?title=' + title + '&start=' + arg.startStr + '&end=' + arg.endStr )
        	.then(resolve => resolve.json())
        	.then(result => {
        		console.log(result);
        	// title, start, end
        	//출력
          		calendar.addEvent({
            	title: title,
           		start: arg.start,
           		end: arg.end,
           		allDay: arg.allDay
          		})
        	})
        	.catch(err => console.log(err));
        	
        }
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

</body>
</html>
