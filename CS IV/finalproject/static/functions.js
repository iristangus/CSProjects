// 24 GAMEPLAY------------------------------------------------------------------------------

// keeps track of the value of the selected number buttons (floats)
var firstNumberValue = 0;
var secondNumberValue = 0;

// keeps track of the selected buttons themselves (html elements)
var firstButton;
var secondButton;

// selected operator value
var operator = "";

// selected operator button id & html element
var opButtonId;
var opButtonElement;

// number of operations made so far
var numOperations = 0;

// How many numbers have been chosen so far
// If 0, the number button selected will become the firstButton
// If 1, the number button selected will become the secondButton
// Resets to 0 after the calculation has been carried out with the two numbers so that two new numbers can be selected
var numbersChosen = 0;

// keeps track of how many times the user has already clicked a button before
var timesClicked = 0;

// whether the button clicked is of a new type
var newButton = true;

// code inspired by https://stackoverflow.com/questions/13077923/how-can-i-convert-a-string-into-a-math-operator-in-javascript
// given an operator and two numbers, calculates the value
// I used this because the operators were first sent over as strings and didn't actually do any math
var mathOperators = {
    '+': function (x, y) { return x + y; },
    '-': function (x, y) { return x - y; },
    '/': function (x, y) { return x / y; },
    '*': function (x, y) { return x * y; }
};


// runs when a number button is clicked
function clickNumber(button)
{

    timesClicked++;

    // finds the id of that button
    var buttonId = button.id;
    // sets a variable as the html element with that id (aka the number button that was just clicked)
    var buttonClicked = document.getElementById(buttonId);
    // finds the integer that's currently displayed by the button
    var numValue = parseFloat(buttonClicked.innerHTML);

    // darkens the button clicked
    buttonClicked.classList.remove('btn-outline-dark');
    buttonClicked.classList.add('btn-dark');

       
    // If 0 numbers have been chosen yet (this button is the first number)
    if (numbersChosen === 0) {

        // if they changed their mind and selects another button as the first number
        if (timesClicked > 1){
            // undarkens the first button
            firstButton.classList.remove('btn-dark');
            firstButton.classList.add('btn-outline-dark');
        }

        // sets the value & element variables for the first number
        firstNumberValue = numValue;
        firstButton = buttonClicked;
        // sends a message to the console (mostly used for debugging)
        console.log("set first number as " + firstNumberValue);

        //enables operator buttons
        document.getElementById("op1").classList.remove('disabled');
        document.getElementById("op2").classList.remove('disabled');
        document.getElementById("op3").classList.remove('disabled');
        document.getElementById("op4").classList.remove('disabled');
        
    // If this is the second number
    } else {

        // sets the value & element variables for the second number
        secondNumberValue = numValue;
        secondButton = buttonClicked;
        // sends a message to the console
        console.log("set the second number as " + secondNumberValue);
        
        // calculates the result
        var result = mathOperators[operator](firstNumberValue, secondNumberValue);
        // sends a console message
        console.log("the result is " + result);

        // hides the first button
        firstButton.style.display = "none";
        // sets the second button to display the result
        secondButton.innerHTML = result;
        
        // undarkens the result button
        secondButton.classList.remove('btn-dark');
        secondButton.classList.add('btn-outline-dark');

        // undarkens the operator button
        opButtonElement.classList.remove('btn-dark');
        opButtonElement.classList.add('btn-outline-dark');

        // adds one to the operations counter
        numOperations++;
        console.log("numOperations is currently " + numOperations);
        
        // resets the numbers chosen variable
        numbersChosen = 0;

        // checks if the final result equals 24
        if (numOperations === 3){
            if (result === 24){
                correct();
            } else {
                incorrect();
                console.log("incorrect");
            }
        }

        //disables operator buttons, must choose a number for the next action
        document.getElementById("op1").classList.add('disabled');
        document.getElementById("op2").classList.add('disabled');
        document.getElementById("op3").classList.add('disabled');
        document.getElementById("op4").classList.add('disabled');

    }

}


// Runs when an operator button is clicked
function clickOperator(operatorValue, opButton)
{
    // runs once when the first operator button is clicked
    // resets timesClicked to 0 for the operator buttons to use
    if (newButton){
        timesClicked = 0;
        newButton = false;
    }

    timesClicked++;

    // updates chosen number count
    // because an operator has been chosen, the next number chosen will be the second number, not the first
    numbersChosen++;

    // if an operator button had been clicked before
    if (timesClicked > 1){
        // undarkens the first button
        opButtonElement.classList.remove('btn-dark');
        opButtonElement.classList.add('btn-outline-dark');
    }

    opButtonId = opButton.id;
    opButtonElement = document.getElementById(opButtonId);

    // darkens the operator button
    opButtonElement.classList.remove('btn-outline-dark');
    opButtonElement.classList.add('btn-dark');

    // sets the variable operator
    operator = operatorValue;
    
    // sends a message to the console
    console.log("set the operator as " + operator);
    
}

// Runs if the player correctly gets to 24
function correct(){
    console.log("correct");
    document.body.style.backgroundColor = "rgb(199, 233, 198)";
    document.getElementById("next").classList.remove('disabled');
   
}

// Runs if the player is unsuccessful
function incorrect(){
    document.body.style.backgroundColor = "#e9c6c6";
}


// TIMER----------------------------------------------------------------------------------------------------------------------

// given a time value, finds the number of seconds remaining
function findSeconds(time){
    var seconds = Math.floor((time % (1000 * 60)) / 1000);
    return seconds;
}

// given a time value, finds the number of minutes remaining
function findMinutes(time){
    var minutes = Math.floor((time % (1000 * 60 * 60)) / (1000 * 60));
    return minutes;
}


function startTimer(){

    var timerStartElement = document.getElementById('timerStart');

    // when the timer starts
    var start = new Date().getTime();
    console.log("set start time as " + start);

    timerStartElement.value = start;

}


// updates every interval
var x = setInterval(function() {

    var timerStartElement = document.getElementById('timerStart');

    start = timerStartElement.value;

    var timeNow = new Date().getTime();

    // time between current time and the start
    var elapsed = timeNow - start;
    console.log(elapsed);

    // finds seconds and minutes passed
    var seconds = findSeconds(elapsed);
    var minutes = findMinutes(elapsed);

    // displays it on the html page
    document.getElementById("timer").innerHTML = minutes + "m " + seconds + "s ";

}, 1000);


// RESULTS MODAL --------------------------------------------------------------------------------------------------------------------


var resultModal = document.getElementById("resultModal");

// Runs when the player goes to the next problem on timed.html

window.onload = function next(){

    var timerStartElement = document.getElementById('timerStart');
    var start = timerStartElement.value;

    var streak = document.formName.elements['numStreak'];
    var numStreak = streak.value;
    console.log("streak is " + numStreak);


    if (numStreak >= 5){
        resultModal.style.display = "block";
        clearInterval(x);
    }


    // finds the total time spent
    var endTime = new Date().getTime();

    console.log("end time: " + endTime);
    console.log("start time: " + start);

    var totalTime = endTime - start;
    console.log("total time: " + totalTime);
    document.formName.elements['totalTime'].value = totalTime;

    // finds seconds and minutes passed
    var seconds = findSeconds(totalTime);
    var minutes = findMinutes(totalTime);
    console.log("minutes: " + minutes + " seconds: " + seconds);

    document.getElementById('seconds').innerHTML = seconds;
    document.getElementById('minutes').innerHTML = minutes;

    document.formName.elements['secondsHidden'].value = seconds;
    document.formName.elements['minutesHidden'].value = minutes;

}

function close(){
    resultModal.style.display = "none";
}

// INSTRUCTIONS MODAL --------------------------------------------------------------------------------------------------------------

var instructionsModal = document.getElementById("instructionsModal");

var openInstructions = document.getElementById("instructionsBtn");

var span = document.getElementsByClassName("close")[0];

openInstructions.onclick = function() {
    instructionsModal.style.display = "block";
}

span.onclick = function() {
    instructionsModal.style.display = "none";
}


window.onclick = function(event) {
    if (event.target == instructionsModal) {
        instructionsModal.style.display = "none";
    }
}
