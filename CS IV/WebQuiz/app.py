from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/')
def index():
    return render_template('index.html.j2')

@app.route('/process', methods=['POST'])
def process():
    name = request.values.get("name")
    email = request.values.get("emailValue")
    return render_template('results.html.j2', emailAddress=email, name=name)
