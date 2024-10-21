/**
 *  basic.js
 */
console.log("basic.js");

let name = "홍길동";
let age = 20;
let obj = {name: "홍길동"
           ,age:   20
           ,showinfo: function(){
			   return this.name + " = " + this.age;
		   }};

console.log(obj);
console.log(obj.name);
console.log(obj['age']);
console.log(obj.showinfo());

//DOM
//<li>
let li = document.createElement("li");
li.innerText = 'Cherry';
console.log(li);
let ul = document.querySelector('#show ul');
ul.appendChild(li);
console.log(ul);
document.querySelectorAll('#show ul li')
.forEach( function(fruit){
	fruit.style.color = 'red';
	fruit.addEventListener('click', function(e){
		fruit.remove();
	})
	console.log(fruit);	
	console.log(fruit.innerHTML);	
});

let tbody = document.querySelector('#show table tbody')
let tr = document.createElement("tr");
let th = document.createElement("th");
let td = document.createElement("td");
th.innerText = '이름';
td.innerText = name;
tr.appendChild(th);
tr.appendChild(td);
tbody.appendChild(tr);

let data = [obj]
data.push({name: "박민수", age: 22});
data.push({name: "송민혁", age: 25});


// layout을 이용하는 방법
document.querySelector('#show table:nth-of-type(2)').className = 'table';
let layout = "";
let last = document.querySelector('#show').lastElementChild.querySelector("tbody");

data.forEach(function(array){
	layout += "<tr><td>" + array.name + "</td><td>" + array.age + "</td></tr>"
})
console.log(layout);
last.innerHTML = layout;


// 정석적인 방법 (메소드도 이용 가능하다)
function makeList(){
	
	for(let i = 0; i < data.length; i++){
		let tr = document.createElement("tr");
		let td = document.createElement("td");
		td.innerHTML = data[i]['name'];
		tr.appendChild(td);
		td = document.createElement('td');
		td.innerHTML = data[i]['age'];
		tr.appendChild(td);
		document.querySelector('#show table:nth-of-type(2) tbody').appendChild(tr);
	}
} //makeList()

makeList();
