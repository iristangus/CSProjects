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
    firstName = request.form.get("firstname")

    cursor = mysql.connection.cursor()
    query = "SELECT email FROM cs4quiz_users WHERE first_name=%s;"
    queryVars = (firstName,)
    cursor.execute(query, queryVars)
    mysql.connection.commit()
    rows = cursor.fetchall()
    return render_template('results.html.j2', rows=rows)
