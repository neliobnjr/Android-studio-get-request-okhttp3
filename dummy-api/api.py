from flask import Flask, request
from flask import abort, current_app as app

import json

global example
example = {
    "glossary": {
        "title": "example glossary",
		"GlossDiv": {
            "title": "S",
			"GlossList": {
                "GlossEntry": {
                    "ID": "SGML",
					"SortAs": "SGML",
					"GlossTerm": "Standard Generalized Markup Language",
					"Acronym": "SGML",
					"Abbrev": "ISO 8879:1986",
					"GlossDef": {
                        "para": "A meta-markup language, used to create markup languages such as DocBook.",
						"GlossSeeAlso": ["GML", "XML"]
                    },
					"GlossSee": "markup"
                }
            }
        }
    }
}
app = Flask(__name__)

# ip_white_list = ['187.181.64.79']
# @app.before_request
# def block_method():
#     ip = request.environ.get('REMOTER_ADDR')
#     if ip not in ip_white_list:
#         abort(403)
@app.route('/users', methods=['GET','POST'])
def home():
    print(request.form)
    return example

if __name__ == "__main__":
    app.run(debug=True,host='192.168.0.243',port=80)