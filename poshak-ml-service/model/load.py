import tensorflow as tf
from tensorflow.keras.models import model_from_json

import os

# cwd = os.getcwd()  # Get the current working directory (cwd)
# files = os.listdir(cwd)  # Get all the files in that directory
# print("Files in %r: %s" % (cwd, files))

def init():
    json_file = open("model/model.json", 'r')
    loaded_model_json = json_file.read()
    json_file.close()
    loaded_model = model_from_json(loaded_model_json)
    loaded_model.load_weights("model/model.h5")
    print("Loaded Model from disk")

    loaded_model.compile(loss='categorical_crossentropy',optimizer='rmsprop',metrics=['accuracy'])
    graph = tf.compat.v1.get_default_graph()

    return loaded_model, graph
