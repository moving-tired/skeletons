from flask import Flask

app = Flask("skeleton-python-flask")

@app.route("/api/v1/users/")
def get_user():
    return "Endpoint to get users"
