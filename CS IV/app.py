from flask import Flask, redirect
app = Flask(__name__)

@app.route('/')
def index():
    #If you go to the homepage, just redirect to the student list
    return redirect('/AmandaONeal/StudentList')
