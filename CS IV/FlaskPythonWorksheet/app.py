from flask import Flask, render_template
app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html.j2', list=["one", "two", "three"])

@app.route('/factorial')
def factorialPage():
    numlist=[]
    for i in range(10):
        numlist.append(calculateFactorial(i+1))
    return render_template('factorial.html.j2', numlist=numlist)

def calculateFactorial(n):
    f = 1
    i = 1
    while i<=n:
        f = f*i
        i = i+1
    return f