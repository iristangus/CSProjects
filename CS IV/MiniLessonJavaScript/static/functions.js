function alertHello()
{
	alert("Hello world!");
	console.log("Look, a console log!");
}

function alertFromTextbox()
{
	var userInput = document.getElementById("user-input");
	alert(userInput.value);
}

function changeText()
{
	var textToChange = document.getElementById("text-to-change");
	textToChange.innerHTML = "Oh look, some new text!";
	textToChange.style.color = "blue";
	/*
	CSS: 
		color: blue;
	JS:
		style.color = 'blue';
	*/
}

function makeDisappear()
{
	var textToDis = document.getElementById("text-to-disappear");
	textToDis.style.display = 'none';
}

function makeAppear()
{
	var textToDis = document.getElementById("text-to-disappear");
	textToDis.style.display = 'block'; //other options: inline, inline-block, table, etc
}

function alertButton()
{
	alert(this.innerHTML);
}

var buttonCount = 0;

function addButton()
{
	buttonCount++;
	var newButton = document.createElement("button"); //Creates a <button>
	newButton.innerHTML = "I'm button number " + buttonCount;
	newButton.onclick = alertButton;
	document.body.appendChild(newButton);
}