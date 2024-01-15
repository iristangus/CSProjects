from flask import Flask, render_template, request
from flask_mysqldb import MySQL
app = Flask(__name__)
app.config['MYSQL_HOST'] = 'mysql.2223.lakeside-cs.org'
app.config['MYSQL_USER'] = 'student2223'
app.config['MYSQL_PASSWORD'] = 'm545CS42223'
app.config['MYSQL_DB'] = '2223playground'
app.config['MYSQL_CURSORCLASS'] = 'DictCursor'
mysql = MySQL(app)

@app.route('/')
def index():
    return render_template('index.html.j2') 

@app.route('/results', methods=['POST'])
def results():
    name = request.values.get("name")
    bday = request.values.get("bday")
    cursor = mysql.connection.cursor()
    query = "INSERT INTO iristang_test(name, birthday) VALUES (%s, %s)"
    queryVars = (name, bday)
    cursor.execute(query, queryVars)
    mysql.connection.commit()
    data = cursor.fetchall()
    return render_template('results.html.j2', data=data)

    
