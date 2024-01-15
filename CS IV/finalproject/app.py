import random, time
from flask import Flask, render_template, redirect, request, url_for, session
from flask_mysqldb import MySQL
from werkzeug.security import generate_password_hash, check_password_hash

app = Flask(__name__)

app.config['MYSQL_HOST'] = 'mysql.2223.lakeside-cs.org'
app.config['MYSQL_USER'] = 'student2223'
app.config['MYSQL_PASSWORD'] = 'm545CS42223'
app.config['MYSQL_DB'] = '2223project_1'
app.config['MYSQL_CURSORCLASS'] = 'DictCursor'
app.config['SECRET_KEY'] = 'oeiuragehiorfnawo'
mysql = MySQL(app)


## THE MAIN PAGE, WHERE THE REDIRECTION LOGIC HAPPENS
@app.route('/', methods=['GET', 'POST'])
def index():

    # the button they pressed to get to the main page, determines where they are redirected
    submitButton = request.values.get("submitButton")

    ## FIRST TIME OPENING PAGE
    if (submitButton is None):

        # if they're already logged in from a previous session
        if (session.get('iristang_username')):
            # takes them to the home page
            return redirect(url_for('home', error=True))

        # if they aren't logged in yet
        else:
            # takes them to the very first page to log in or signup
            return render_template('index.html.j2')

    ## GO TO LOGIN PAGE
    # button on index.html
    elif (submitButton == "goToLogin"):
        # sends them to login.html
        return redirect(url_for('login', error=True))

    ## GO TO SIGNUP PAGE
    # button on index.html
    elif (submitButton == "goToSignup"):
        # send them to signup.html
        return redirect(url_for('signup', error=True))

    ## JUST SUBMITTED LOGIN FORM
    # button on login.html
    elif (submitButton == "login"):

        # username & password from the form
        formUsername = request.values.get("loginUsername")
        formPassword = request.values.get("loginPassword")

        # if no username is submitted reloads login.html w/ an error
        if len(formUsername) == 0:
            loginError = "Please enter a username"
            return render_template('login.html.j2', loginError = loginError)

        # if no password is submitted reloads login.html w/ an error
        if len(formPassword) == 0:
            loginError = "Please enter a password"
            return render_template('login.html.j2', loginError = loginError)

        # if the username doesn't exist, reloads login.html w/ an error
        if (doesUsernameExist(formUsername) == False):
            loginError = "That account does not exist."
            return render_template('login.html.j2', loginError = loginError)

        # if the username exists, check password on the database w/ a function
        else:

            # find corresponsing hashed password in the database
            cur = mysql.connection.cursor()
            query = "SELECT password FROM iristang_accounts WHERE username = %s;"
            queryVars = (formUsername,)
            cur.execute(query, queryVars)
            mysql.connection.commit()
            dbPassword = cur.fetchall()

            # the password column of the first item in the array dbPassword (aka the password we're looking for)
            accountPassword = dbPassword[0]['password']

            # if the password is correct
            if (check_password_hash(accountPassword, formPassword)):
                # updates the session username, logs in
                session['iristang_username'] = formUsername
                # sends user to the home page
                return redirect(url_for('home', error=True))
            
            # if the password is incorrect, reloads login.html w/ an error
            else:
                loginError = "Wrong password!"
                return render_template('login.html.j2', loginError = loginError)

        
    ## JUST SUBMITTED SIGNUP FORM
    # button on signup.html
    elif (submitButton == "signup"):

        # username & password from the form
        formUsername = request.values.get('newUsername')
        formPassword = request.values.get('newPassword')

        # if no username is submitted, reloads signup.html w/ an error
        if len(formUsername) == 0:
            newError = "Please enter a username"
            return render_template('signup.html.j2', newError = newError)

        # if no password is submitted, reloads signup.html w/ an error
        if len(formPassword) == 0:
            newError = "Please enter a password"
            return render_template('signup.html.j2', newError = newError)

        # if the username is taken already, reloads signup.html w/ an error
        if doesUsernameExist(formUsername) == True:
            newError = "An account with that name already exists."
            return render_template('signup.html.j2', newError = newError)

        # if the username is open, add account to the database
        else:
            # generates the hashed password
            securedPassword = generate_password_hash(formPassword)

            # sticks the username and hashed password into the database
            cur = mysql.connection.cursor()
            query = "INSERT INTO iristang_accounts (username, password) VALUES (%s, %s);"
            queryVars = (formUsername, securedPassword)
            cur.execute (query, queryVars)
            mysql.connection.commit()

            # updates the session username, successfully "signed in"
            session['iristang_username'] = formUsername

            # sends user to the home page
            return redirect(url_for('home', error=True))

    ## LOGOUT FROM ACCOUNT
    # button on home.html
    elif (submitButton == "logout"):
        # removes the session username
        session.pop('iristang_username', None)
        # sends user to index.html to login or signup again
        return redirect(url_for('index', error=True))

    ## SWITCH TO THE FREEPLAY PAGE
    # button on home.html
    elif (submitButton == "freeplay"):
        # sends user to freeplay.html
        return redirect(url_for('freeplay', error=True))

    ## SWITCH TO THE TIMED PAGE
    # button on home.html
    elif (submitButton == "timed"):

        session['iristang_timerStart'] = request.values.get("timerStart")

        # sends user to timed.html
        return redirect(url_for('timed', error=True))

    ## SWITCH TO THE HOME PAGE
    # button on freeplay.html, timed.html, and leaderboard
    elif (submitButton == "home"):
        return redirect(url_for('home', error=True))

    ## NEXT LEVEL
    # button on freeplay.html
    elif (submitButton == "freeplayNext"):
        return redirect(url_for('freeplay', error=True))

    ## RESET FREEPLAY
    # button on freeplay.html
    elif (submitButton == "freeplayReset"):

        # numArray was a hidden input in freeplay.html
        numArrayString = request.values.get("numArray")

        # converting the int list from string to an actual array
        numArrayString = numArrayString[1:-1]
        numArray = numArrayString.split(', ')
        numArray = [int(i) for i in numArray]

        session['iristang_freeplayStreak'] = 0
        numStreak = int(session['iristang_freeplayStreak'])

        return render_template('freeplay.html.j2', numArray = numArray, numStreak = numStreak)

    ## NEXT LEVEL
    # button on timed.html
    elif (submitButton == "timedNext"):
        return redirect(url_for('timed', error=True))

    ## RESET TIMED
    # button on timed.html
    elif (submitButton == "timedReset"):

        # numArray was a hidden input in timed.html
        numArrayString = request.values.get("numArray")

        # converting the int list from string to an actual array
        numArrayString = numArrayString[1:-1]
        numArray = numArrayString.split(', ')
        numArray = [int(i) for i in numArray]

        session['iristang_timedStreak'] = 0
        numStreak = int(session['iristang_timedStreak'])

        timerStart = session['iristang_timerStart']

        return render_template('timed.html.j2', numArray = numArray, numStreak = numStreak, timerStart = timerStart)

    ## RETURNS TO THE INDEX PAGE
    # button on login.html and signup.html
    elif (submitButton == "returnIndex"):
        return redirect(url_for('index', error=True))

    ## GOES TO THE LEADERBOARD
    # button on home.html
    elif (submitButton == "leaderboard"):
        return redirect(url_for('leaderboard', error=True))

    ## GOES FROM THE RESULTS MODAL TO THE LEADERBOARD
    # button on home.html
    elif (submitButton == "resultsToLeaderboard"):

        # values stored in timed.html
        seconds = request.values.get("secondsHidden")
        minutes = request.values.get("minutesHidden")
        totalTime = request.values.get("totalTime")

        # id of the user currently logged in
        userID = findUserID(session['iristang_username'])

        # adds the information to the database
        cur = mysql.connection.cursor()
        query = "INSERT INTO `iristang_scores`(`account_id`, `minutes`, `seconds`, `totalTime`) VALUES (%s, %s, %s, %s);"
        queryVars = (userID, minutes, seconds, totalTime)
        cur.execute(query, queryVars)
        mysql.connection.commit()
        dbPassword = cur.fetchall()

        return redirect(url_for('leaderboard', error=True))

    ## IF THE USER HAS A SUBMIT BUTTON THAT ISN'T ANY OF THE ABOVE OPTIONS
    # i don't actually know how anyone would be able to do that, but this is here just in case
    else:
        # sends them to the error page
        return redirect(url_for('error', error=True))

## LAUNCHES THE LOGIN PAGE
@app.route('/login', methods=['GET', 'POST'])
def login():
    return render_template('login.html.j2')

## LAUNCHES THE SIGNUP PAGE
@app.route('/signup', methods=['GET', 'POST'])
def signup():
    return render_template('signup.html.j2')

## LAUNCHES THE HOME PAGE
@app.route('/play', methods=['GET', 'POST'])
def home():
    session['iristang_freeplayStreak'] = -1
    session['iristang_timedStreak'] = -1
    username = session['iristang_username']
    return render_template('home.html.j2', username = username)

## LAUNCHES THE FREEPLAY PAGE
@app.route('/freeplay', methods=['GET', 'POST'])
def freeplay():
    numArray = fourRandomNumbers()

    numStreak = int(session['iristang_freeplayStreak'])
    numStreak += 1
    session['iristang_freeplayStreak'] = numStreak

    return render_template('freeplay.html.j2', numArray = numArray, numStreak = numStreak)

## LAUNCHES THE TIMED PAGE
@app.route('/timed', methods=['GET', 'POST'])
def timed():

    numArray = fourRandomNumbers()

    numStreak = int(session['iristang_timedStreak'])

    seconds = request.values.get("seconds")
    minutes = request.values.get("minutes")

    timerStart = session['iristang_timerStart']

    numStreak += 1
    session['iristang_timedStreak'] = numStreak

    return render_template('timed.html.j2', numArray = numArray, numStreak = numStreak, timerStart = timerStart)

## LAUNCHES THE LEADERBOARD PAGE
@app.route('/leaderboard', methods=['GET', 'POST'])
def leaderboard():
    scores = allScores()
    return render_template('leaderboard.html.j2', scores = scores)

## LAUNCHES THE RESULTS PAGE
@app.route('/results', methods=['GET', 'POST'])
def results():
    return render_template('results.html.j2')

## LAUNCHES THE ERROR PAGE
@app.route('/error', methods=['GET', 'POST'])
def error():
    return render_template('error.html.j2')


## DATABASE FUNCTIONS ------------------------------------------------------------------------------------

## FINDS THE ID OF A GIVEN USERNAME
def findUserID(username):
    cur = mysql.connection.cursor()
    query = "SELECT a.id FROM iristang_accounts a WHERE a.username=%s;"
    queryVars = (username,)
    cur.execute(query, queryVars)
    mysql.connection.commit()
    user = cur.fetchall()[0]
    return user['id']


## RETURNS ALL SCORES CURRENTLY IN THE DATABASE
## the account that scored it, the number of minutes, number of seconds, and the time the score was obtained
def allScores():
    cur = mysql.connection.cursor()
    query = "SELECT a.username, s.minutes, s.seconds, date(s.time_obtained) AS day_obtained FROM iristang_scores s JOIN iristang_accounts a ON a.id = s.account_id ORDER BY s.totalTime;"
    cur.execute(query)
    mysql.connection.commit()
    scores = cur.fetchall()
    return scores

## DETERMINES IF THE GIVEN USERNAME EXISTS IN THE DATABASE
def doesUsernameExist(username):
    # finds all usernames using mysql
    cur = mysql.connection.cursor()
    query = "SELECT username FROM iristang_accounts;"
    cur.execute(query)
    mysql.connection.commit()
    usernameList = cur.fetchall()

    # goes through every username, returning True if it finds a match
    for eachUsername in usernameList:
        if eachUsername['username'] == username:
            return True
    
    # if nothing is found, returns False
    return False


### FUNCTIONS FOR 24 GAMEPLAY -----------------------------------------------------------------------------
    
## RETURNS 4 RANDOM NUMBERS 1-9
def fourRandomNumbers():
    numList = []
    for x in range(4):
        num = random.randint(1, 9)
        numList.append(num)
    
    # checks if the 4 random numbers are solvable
    # if not, runs the function until it gets a solvable game
    if isSolvableGame(numList):
        return numList
    else:
        return fourRandomNumbers()


### CHECKING IF A GAME OF 24 IS VALID ----------------------------------------------------------------------------------
## from https://leetcode.com/problems/24-game/solutions/2126034/24-game/
## (I did the spongebob method with the exception of one line, which will be marked out)

# Takes two numbers and finds all possible results after performing an operation
def allPossibleResults(num1, num2):
    # list of all the results
    results = [num1 + num2, num1 - num2, num2 - num1, num1 * num2]

    # checks that the numbers aren't 0 before dividing
    if (num1 != 0):
        results.append(num2 / num1)
    if (num2 != 0):
        results.append(num1 / num2)

    return results

## Determines if a given list of numbers is capable of becoming 24
def isSolvableGame(numList):

    # BASE CASE
    # where there is only one number in the list
    if len(numList) == 1:
        # if that number equals 24, return True, else False
        if numList[0] == 24:
            return True
        else:
            return False

    # RECURSION
    # if the list has more than 1 number
    else:

        # cycles through each combination of two indices in the list
        for i in range(len(numList)):
            for j in range(i+1, len(numList)):

                # creates a new list with all the terms except for the two that were picked
                # this is the line of code that's directly from the leetcode solution
                newList = [number for k, number in enumerate(numList) if (k != i and k != j)]

                # finds a list of all the possible results of performing an operation on those two numbers
                allPairResults = allPossibleResults(numList[i], numList[j])

                # goes through each possible operation result
                for pairResult in allPairResults:

                    # adds the result to the list of numbers
                    newList.append(pairResult)

                    # goes through the function again with the new list (which has one less number than the original)
                    # if the list eventually gets to the base case (24), returns True
                    if (isSolvableGame(newList)):
                        return True

                    # otherwise removes that result from the list
                    # moves onto the next possible result
                    newList.pop()

        # loops through selecting every possible pair of numbers in numList
        # if it goes through the whole thing and never returns True, returns False 
        # (is not a solvable game of 24)
        return False