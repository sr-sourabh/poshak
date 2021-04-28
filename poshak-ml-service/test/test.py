import requests

resp = requests.post("http://0.0.0.0:5000/predict", files={'file': open('banana.jpg','rb')})

print(resp.text)