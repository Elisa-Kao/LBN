from flask import Flask, request, jsonify
import openpyxl

app = Flask(__name__)

def login(username, password):
    # Load the workbook
    wb = openpyxl.load_workbook('user_data.xlsx')

    # Select the active sheet
    sheet = wb.active

    # Check if the provided username and password match any row in the Excel file
    for row in sheet.iter_rows(values_only=True):
        if row[0] == username and row[1] == password:
            return True

    return False

@app.route('/check_login', methods=['POST'])
def check_login():
    data = request.get_json()
    username = data.get('username')
    password = data.get('password')

    result = login(username, password)

    return jsonify({'success': result})

if __name__ == '__main__':
    app.run(debug=True)
