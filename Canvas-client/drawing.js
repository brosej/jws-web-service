var testp = document.getElementById('testp')
var messages = []
var esource = new EventSource('http://localhost:8101/test')

var canvas = document.getElementById('line')
var ctx = canvas.getContext('2d')
var x = 40
var y = 40
ctx.beginPath()
ctx.moveTo(x,y)

function start(){
	esource.onmessage = (e) => {
		console.log(e.data);	
		switch(e.data){
		case "up":
		ctx.lineTo(x, y - 20)
		y+= -20
		ctx.stroke()
		break
		case "down":
		ctx.lineTo(x, y + 20)
		y+= 20
		ctx.stroke()
		break
		case "left":
		ctx.lineTo(x -20, y)
		x+= -20
		ctx.stroke()
		break
		case "right":
		ctx.lineTo(x+20, y)
		x+= 20
		ctx.stroke()
		break
		case "null":
		break
	}			
		}


	}
		
	


start()
	
	/*esource.onerror = () => {
  	console.log("no connection")
	}*/

	




/*esource.onopen = () => {
	console.log('connection open')
}*/

