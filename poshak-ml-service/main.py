from flask import Flask, render_template,request,jsonify
import PIL
import logging
import tensorflow.keras.models
from flask_cors import CORS,cross_origin
from tensorflow.keras.preprocessing.image import img_to_array, load_img
import tensorflow as tf
import numpy as np
import io
from PIL import Image
import sys
import os
sys.path.append(os.path.abspath("./model"))
from load import *

# initialize flask app
app = Flask(__name__)
app.config['CORS_HEADERS'] = 'Content-Type'
cors = CORS(app, resources={r"/predict": {"origins": "http://localhost:3000"}})
global model,graph
model,graph = init()

ALLOWED_EXTENSIONS = {'png', 'jpg', 'jpeg'}
def allowed_file(filename):
    return '.' in filename and filename.rsplit('.', 1)[1].lower() in ALLOWED_EXTENSIONS

labels = {0: 'Apple Braeburn',
          1: 'Apple Crimson Snow',
          2: 'Apple Golden 1',
          3: 'Apple Golden 2',
          4: 'Apple Golden 3',
          5: 'Apple Granny Smith',
          6: 'Apple Pink Lady',
          7: 'Apple Red 1',
          8: 'Apple Red 2',
          9: 'Apple Red 3',
          10: 'Apple Red Delicious',
          11: 'Apple Red Yellow 1',
          12: 'Apple Red Yellow 2',
          13: 'Apricot',
          14: 'Avocado',
          15: 'Avocado ripe',
          16: 'Banana',
          17: 'Banana Lady Finger',
          18: 'Banana Red',
          19: 'Beetroot',
          20: 'Blueberry',
          21: 'Cactus fruit',
          22: 'Cantaloupe 1',
          23: 'Cantaloupe 2',
          24: 'Carambula',
          25: 'Cauliflower',
          26: 'Cherry 1',
          27: 'Cherry 2',
          28: 'Cherry Rainier',
          29: 'Cherry Wax Black',
          30: 'Cherry Wax Red',
          31: 'Cherry Wax Yellow',
          32: 'Chestnut',
          33: 'Clementine',
          34: 'Cocos',
          35: 'Corn',
          36: 'Corn Husk',
          37: 'Cucumber Ripe',
          38: 'Cucumber Ripe 2',
          39: 'Dates',
          40: 'Eggplant',
          41: 'Fig',
          42: 'Ginger Root',
          43: 'Granadilla',
          44: 'Grape Blue',
          45: 'Grape Pink',
          46: 'Grape White',
          47: 'Grape White 2',
          48: 'Grape White 3',
          49: 'Grape White 4',
          50: 'Grapefruit Pink',
          51: 'Grapefruit White',
          52: 'Guava',
          53: 'Hazelnut',
          54: 'Huckleberry',
          55: 'Kaki',
          56: 'Kiwi',
          57: 'Kohlrabi',
          58: 'Kumquats',
          59: 'Lemon',
          60: 'Lemon Meyer',
          61: 'Limes',
          62: 'Lychee',
          63: 'Mandarine',
          64: 'Mango',
          65: 'Mango Red',
          66: 'Mangostan',
          67: 'Maracuja',
          68: 'Melon Piel de Sapo',
          69: 'Mulberry',
          70: 'Nectarine',
          71: 'Nectarine Flat',
          72: 'Nut Forest',
          73: 'Nut Pecan',
          74: 'Onion Red',
          75: 'Onion Red Peeled',
          76: 'Onion White',
          77: 'Orange',
          78: 'Papaya',
          79: 'Passion Fruit',
          80: 'Peach',
          81: 'Peach 2',
          82: 'Peach Flat',
          83: 'Pear',
          84: 'Pear 2',
          85: 'Pear Abate',
          86: 'Pear Forelle',
          87: 'Pear Kaiser',
          88: 'Pear Monster',
          89: 'Pear Red',
          90: 'Pear Stone',
          91: 'Pear Williams',
          92: 'Pepino',
          93: 'Pepper Green',
          94: 'Pepper Orange',
          95: 'Pepper Red',
          96: 'Pepper Yellow',
          97: 'Physalis',
          98: 'Physalis with Husk',
          99: 'Pineapple',
          100: 'Pineapple Mini',
          101: 'Pitahaya Red',
          102: 'Plum',
          103: 'Plum 2',
          104: 'Plum 3',
          105: 'Pomegranate',
          106: 'Pomelo Sweetie',
          107: 'Potato Red',
          108: 'Potato Red Washed',
          109: 'Potato Sweet',
          110: 'Potato White',
          111: 'Quince',
          112: 'Rambutan',
          113: 'Raspberry',
          114: 'Redcurrant',
          115: 'Salak',
          116: 'Strawberry',
          117: 'Strawberry Wedge',
          118: 'Tamarillo',
          119: 'Tangelo',
          120: 'Tomato 1',
          121: 'Tomato 2',
          122: 'Tomato 3',
          123: 'Tomato 4',
          124: 'Tomato Cherry Red',
          125: 'Tomato Heart',
          126: 'Tomato Maroon',
          127: 'Tomato Yellow',
          128: 'Tomato not Ripened',
          129: 'Walnut',
          130: 'Watermelon'}

@app.route('/predict',methods=['GET','POST'])
@cross_origin(origin='localhost',headers=['Content- Type'])
def predict():
    if request.method == 'POST':
        file = request.files.get('file')
        if file is None or file.filename == "":
            return jsonify({'error': 'no file'})
        if not allowed_file(file.filename):
            return jsonify({'error': 'format not supported'})

        try:
            img_bytes = file.read()
            imgg = Image.open(io.BytesIO(img_bytes))
            target_size = (100,100)
            img = imgg.resize(target_size)
            img_arr = img_to_array(img)
            img_batch = np.expand_dims(img_arr, axis=0)
            pred = model.predict(img_batch)
            pred = np.argmax(pred,axis=1)
            pred = [labels[k] for k in pred]
            final_prediction = pred[0].split(" ")[0]
            data = {'prediction': final_prediction, 'class_name': str(final_prediction)}
            return final_prediction
        except:
            return jsonify({'error': 'error during prediction'})


if __name__ == "__main__":
    port = int(os.environ.get('PORT', 5000))
    app.run(host='0.0.0.0', port=port)