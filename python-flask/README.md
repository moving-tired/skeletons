# Setup

## Development

You can use visual studio code or pycharm.

## Ubuntu

- First we need to install python 3.6 and pip

``` bash
sudo apt-get update
sudo apt-get install python 3.6
sudo apt install python3-pip
```

- After use a virtualenv folder
``` bash
pip3 install virtualenv
```

- After that we will use virtualenv 
``` bash
source venv/bin/activate
```

This will enable project dependencies.

Then run `pip install -r requirements.txt`

# Running application

## Development

``` bash
env FLASK_APP=app/main.py flask run
```

## Production

## Usage

Go to:
```
http://localhost:5000/api/v1/users/
```

And check the endpoints there.