/**
 * exe1.js
 */

let delBtn = document.querySelector('#delBtn');
let gap = document.querySelector('#userValue');
gap.focus();
 delBtn.addEventListener('click', function(){
	let spans = document.querySelectorAll('div.container span');
	spans.forEach(function(span){
		console.log(span);
		if(span.innerHTML == gap.value){
			span.remove();
			gap.value = '';
		}
			gap.focus();
	})
 } );
 
