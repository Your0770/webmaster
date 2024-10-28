<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {	//document.addEventListener("DOMContentLoaded", function(e){}) 돔객체를 생성로드 후 실행하게 해야함.
		let select1 = $("select:eq(0)");
		let select2 = $("select:eq(1)");
		$("button:eq(0)").on('click', function(e) {
			//select1.find($("option:selected")).appendTo(select2);	//복사가 아니라 이동으로 보는게 맞을듯
			select2.append(select1.find($("option:selected")));		//부모 append 자식
		})
		$("button:eq(1)").on('click', function(e) {
			select2.find($("option:selected")).appendTo(select1);	//자식 appendTo 부모
		})
	});
</script>
</head>

<body>
	<select multiple style="height: 150px">
		<option>option1</option>
		<option>option2</option>
		<option>option3</option>
		<option>option4</option>
		<option>option5</option>
	</select>
	<button>+</button>
	<button>-</button>
	<select multiple style="height: 150px">
		<option>option6</option>
		<option>option7</option>
		<option>option8</option>
		<option>option9</option>
		<option>option10</option>
	</select>
</body>

</html>