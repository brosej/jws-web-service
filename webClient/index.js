var input = document.getElementById('input');
var sendButton = document.getElementById('sendButton');
var responseP = document.getElementById('response');


function helloWorld(){

	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    	responseP.innerHTML = xhttp.responseText;
    } 
	};
	xhttp.open("GET", "http://localhost:8100/test", true);
	xhttp.setRequestHeader('Content-type','application/x-www-form-urlencoded');
	xhttp.send();

}


function request(name){

}