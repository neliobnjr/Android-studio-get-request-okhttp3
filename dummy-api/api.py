from flask import Flask, request

import json


app = Flask(__name__)

@app.route('/users', methods=['GET','POST'])
def home():
    print(request.form)
    return 'hello world!'

if __name__ == "__main__":
    app.run(debug=True,host='192.168.0.243',port=80)