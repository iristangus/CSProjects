from flask import Flask, render_template, redirect, request, session
from flask_mysqldb import MySQL

app = Flask(__name__)

app.config['MYSQL_HOST'] = 'mysql.2223.lakeside-cs.org'
app.config['MYSQL_USER'] = 'student2223'
app.config['MYSQL_PASSWORD'] = 'm545CS42223'
app.config['MYSQL_DB'] = '2223playground'
app.config['MYSQL_CURSORCLASS'] = 'DictCursor'
mysql = MySQL(app)

# session setup from https://www.geeksforgeeks.org/how-to-use-flask-session-in-python-flask/
# and https://pythonbasics.org/flask-sessions/
app.config["SESSION_PERMANENT"] = True
app.config["SESSION_TYPE"] = "filesystem"
app.secret_key = "username"


@app.route('/', methods=['GET', 'POST'] )
def board():

    # Whichever submit button the user pressed last
    submitButton = request.values.get("submitButton")

    ## FIRST TIME OPENING THE BOARD, DEFAULT TO GUEST
    if submitButton is None:

        # Default account is "Guest"
        session["username"] = "Guest"

        posts = allPosts()      
        return render_template('board.html.j2', posts=posts, username=session["username"])

    ## FILLED OUT LOGIN FORM
    elif submitButton == "login":

        # username & password from the form
        formUsername = request.values.get("loginUsername")
        formPassword = request.values.get("loginPassword")

        # if no username is submitted
        if len(formUsername) == 0:
            loginError = "Please enter a username"
            return render_template('account.html.j2', loginError = loginError)

        # if no password is submitted
        if len(formPassword) == 0:
            loginError = "Please enter a password"
            return render_template('account.html.j2', loginError = loginError)

        # if the username exists, look for the corresponding password
        if doesUsernameExist(formUsername) == True:
            cur = mysql.connection.cursor()
            query = "SELECT password FROM iristang_accounts WHERE username = %s;"
            queryVars = (formUsername,)
            cur.execute(query, queryVars)
            mysql.connection.commit()
            accountPassword = cur.fetchall()

            # if the password is correct
            # the password column of the first item in the array accountPassword
            if accountPassword[0]['password'] == formPassword:
                session["username"] = formUsername

                posts = allPosts()
                return render_template('board.html.j2', posts=posts, username=session["username"])
            
            # if the password is incorrect
            else:
                loginError = "Wrong password!"
                return render_template('account.html.j2', loginError = loginError)

        # if the username doesn't exist
        else:
            loginError = "That account does not exist."
            return render_template('account.html.j2', loginError = loginError)
    

    ## CREATED A NEW ACCOUNT
    elif submitButton == "newAccount":

        # username & password from the form
        formUsername = request.values.get('newUsername')
        formPassword = request.values.get('newPassword')

        # if no username is submitted
        if len(formUsername) == 0:
            newError = "Please enter a username"
            return render_template('account.html.j2', newError = newError)

        # if no password is submitted
        if len(formPassword) == 0:
            newError = "Please enter a password"
            return render_template('account.html.j2', newError = newError)

        # if the username is taken already
        if doesUsernameExist(formUsername) == True:
            newError = "An account with that name already exists."
            return render_template('account.html.j2', newError = newError)

        # if the username is open, add account to the database
        else:
            cur = mysql.connection.cursor()
            query = "INSERT INTO iristang_accounts (username, password) VALUES (%s, %s);"
            queryVars = (formUsername, formPassword)
            cur.execute (query, queryVars)
            mysql.connection.commit()

            # updates the username
            session["username"] = formUsername

            posts = allPosts()
            return render_template('board.html.j2', posts=posts, username=session["username"])
    
    ## CONTINUE WITH GUEST MODE
    elif submitButton == "guest":
        session["username"] = "Guest"
        posts = allPosts()
        return render_template('board.html.j2', posts=posts, username=session["username"])

    ## JUST MADE A NEW POST
    elif submitButton == "newPost":
        
        formText = request.values.get("textPost")

        # If the post submitted is blank
        if len(formText) == 0:
            postError = "Please include some text in your post"
            return render_template('newPost.html.j2', postError = postError)

        username = session["username"]
        userID = findUserID(username)

        # add post to the database
        cur = mysql.connection.cursor()
        query = "INSERT INTO iristang_posts(content, account_id) VALUES (%s, %s);"
        queryVars = (formText, userID)
        cur.execute (query, queryVars)
        mysql.connection.commit()

        posts = allPosts()
        return render_template('board.html.j2', posts=posts, username=session["username"])

    ## REDIRECT TO THE ACCOUNT PAGE
    elif submitButton == "redirectAccount":
        return render_template('account.html.j2')

    ## REDIRECT TO THE NEW POST PAGE
    elif submitButton == "redirectNewPost":
        username = session["username"]
        return render_template('newPost.html.j2', username=username)

    ## ERROR
    else:
        return render_template('error.html.j2')


## DETERMINES IF THE GIVEN USERNAME EXISTS IN THE DATABASE
def doesUsernameExist(username):
    cur = mysql.connection.cursor()
    query = "SELECT username FROM iristang_accounts;"
    cur.execute(query)
    mysql.connection.commit()
    usernameList = cur.fetchall()

    for eachUsername in usernameList:
        if eachUsername['username'] == username:
            return True
    
    return False

## RETURNS ALL POSTS CURRENTLY IN THE DATABASE
## the content of the post & the account that posted it
def allPosts():
    cur = mysql.connection.cursor()
    query = "SELECT p.content, a.username FROM iristang_accounts a JOIN iristang_posts p ON a.id = p.account_id ORDER BY p.time DESC;"
    cur.execute(query)
    mysql.connection.commit()
    posts = cur.fetchall()
    return posts
    
## FINDS THE ID OF A GIVEN USERNAME
def findUserID(username):
    cur = mysql.connection.cursor()
    query = "SELECT a.id FROM iristang_accounts a WHERE a.username=%s;"
    queryVars = (username,)
    cur.execute(query, queryVars)
    mysql.connection.commit()
    user = cur.fetchall()[0]
    return user['id']