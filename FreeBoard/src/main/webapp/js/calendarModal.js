/**
 * calendarModal.js
 */

/* onclick 방법
window.onclick = function(e){
	if(e.target == document.querySelector('#exampleModal')){
		modalClose();
	}
}
*/
window.addEventListener('click', function(e){
	if(e.target == document.querySelector('#exampleModal')){
		modalClose();
	}
})

 function modalShow(arg){
	 modalArg = arg;	//여러 함수에서 사용할 용도.
	 console.log(modalArg.start);
	 console.log(modalArg.end);
	 
	 let startString = modalArg.start.getFullYear()+'-'+
	 ((modalArg.start.getMonth()+1) < 10 ? '0' + (modalArg.start.getMonth()+1) : (modalArg.start.getMonth()+1))+'-'+
	 (modalArg.start.getDate() < 10 ? '0' + modalArg.start.getDate() : modalArg.start.getDate())+'T'+
	 (modalArg.start.getHours() < 10 ? '0' + modalArg.start.getHours() : modalArg.start.getHours())+':'+
	 (modalArg.start.getMinutes() < 10 ? '0' + modalArg.start.getMinutes() : modalArg.start.getMinutes())+':'+
	 (modalArg.start.getSeconds() < 10 ? '0' + modalArg.start.getSeconds() : modalArg.start.getSeconds());
	 
	 let endString = modalArg.end.getFullYear()+'-'+
	 ((modalArg.end.getMonth()+1) < 10 ? '0' + (modalArg.end.getMonth()+1) : (modalArg.end.getMonth()+1))+'-'+
	 (modalArg.end.getDate() < 10 ? '0' + modalArg.end.getDate() : modalArg.end.getDate())+'T'+
	 (modalArg.end.getHours() < 10 ? '0' + modalArg.end.getHours() : modalArg.end.getHours())+':'+
	 (modalArg.end.getMinutes() < 10 ? '0' + modalArg.end.getMinutes() : modalArg.end.getMinutes())+':'+
	 (modalArg.end.getSeconds() < 10 ? '0' + modalArg.end.getSeconds() : modalArg.end.getSeconds());
	 
	 
	 console.log(startString);
	 console.log(endString);
	 
	 let body = document.querySelector('body');
	 body.className = 'modal-open';
	 body.style.overflow = 'hidden';
	 body.style.paddingRight = '17px';
	 
	 let modal = document.querySelector('#exampleModal');
	 modal.classList.add('show');
	 modal.setAttribute('aria-modal', true);
	 modal.setAttribute('role', 'dialog');
	 modal.removeAttribute('aria-hidden');
	 modal.style.display = 'block';
	 
	 start.value = modalArg.startStr;
	 end.value = modalArg.endStr;	
	 sTime.value = startString;
	 eTime.value = endString;
	 
	 let div = document.createElement('div')
	 div.className = 'modal-backdrop fade show';
	 body.appendChild(div);
	 
	 let btnClose = document.querySelector('#exampleModal div.modal-dialog div.modal-content div.modal-footer button');
	 btnClose.addEventListener('click', modalClose);
	 let buttonX = document.querySelector('#exampleModal div.modal-dialog div.modal-content div.modal-header button');
	 buttonX.addEventListener('click', modalClose);
	 /* 얘는 어디를 눌러도 다 꺼져서 윈도우에 작업을 시도함(제일 위에 위치)
	 let outside = document.querySelector('#exampleModal');
	 outside.addEventListener('click', modalClose);
	 */
 }
 
 function modalClose(){
	 
	 let body = document.querySelector('body');
	/* body.classList.remove('modal-open');
	 body.style.overflow = '';
	 body.style.paddingRight = ''; */
	 body.removeAttribute('style');
	 body.removeAttribute('class');
	 
	 let modal = document.querySelector('#exampleModal');
	 modal.classList.remove('show');
	 modal.removeAttribute('aria-modal');
	 modal.removeAttribute('role');
	 modal.setAttribute('aria-hidden', true);
	 modal.style.display = 'none';
	 
	 body.lastChild.remove();
 }
 
 function modalSave(){
	 //title, startStr, endStr
	 let title = document.querySelector("#title").value;
	 let startStr = document.querySelector("#sTime").value;
	 let endStr = document.querySelector("#eTime").value;
	 fetch('addEvent.do?title=' + title + '&start=' + startStr + '&end=' + endStr )
        	.then(resolve => resolve.json())
        	.then(result => {
        		console.log(result);
        		if(result.retCode == 'OK'){
	        	//출력
    	      		calendar.addEvent({
        	    	title: title,
           			start: modalArg.start,
           			end: modalArg.end,
           			allDay: modalArg.allDay
          		})
          		modalClose();
				} else if(result.retCode == 'FAIL'){
					alert('등록에러');
				}
        	})
        	.catch(err => console.log(err));
 }
 
 function startChange(event){
	 console.log(event);
	 modalArg.start = new Date(event.target.value);
 }
 
 function endChange(event){
	 console.log(event);
	 modalArg.end = new Date(event.target.value);
	 
 }