from flask import Flask, render_template, request
app = Flask(__name__)

@app.route('/', methods=['GET', 'POST'])
def index():

    if request.method == 'GET':
        return render_template('index.html.j2')
        
    else:
        inputName = request.values.get("fullname")
        inputRadio = request.values.get("sushi")
        inputCheckbox = request.values.getlist("vehicle")
        return render_template('results.html.j2', name=inputName, radio=inputRadio, checkbox=inputCheckbox)


    
