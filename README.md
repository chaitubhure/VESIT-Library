# VESIT Library

The VESIT-Library Android Application aims to integrate the library workforce along with new age technology. This application caters to the most common need of the students associated with the library. Just by entering your library card number, the student can view all the varied varieties of books and their respective issued books. 
They can also go through the digital reference section and know about the library timings.

### Some screenshots from the application

<p float="left">
<img src="https://github.com/chaitubhure/VESIT-Library/blob/master/vesit_navigationpage.png" width="250">
<img src="https://github.com/chaitubhure/VESIT-Library/blob/master/vesit_issuedbook.png" width="250">
<img src="https://github.com/chaitubhure/VESIT-Library/blob/master/vesit_booklist.png" width="250">
                                                                                                  </p>
                                                                                                  
### Technology and platfroms

This project makes use of the [Google Colaboratory](https://colab.research.google.com/notebooks/welcome.ipynb#recent=true) platform with a free access to GPU for the image processing tasks. It took 3 hours to train the complete model on Colab and the other technologies used in this project are as follows:

* [Tensorflow](https://www.tensorflow.org/) - Most popular, deep learning framework
* [Slim](https://www.tensorflow.org/api_docs/python/tf/contrib/slim) - High level representation of Tensorflow
* [Pandas](https://pandas.pydata.org/) - Python library for performing operations on data

### Running the code

After installing the above mentioned dependencies, run the following commands in the Google Colab environment.

```
!git clone https://github.com/chaitubhure/HARRISON_tagprediction.git
!cd HARRISON_tagprediction
!python3 preprocess.py
!python3 train.py
!python3 evaluate.py
```

### High Level View of the Model and Working

![Overview of the model](https://github.com/chaitubhure/HARRISON_tagprediction/blob/master/Overview%20of%20the%20model.png)

### Authors

* [Chaitanya Bhure](https://github.com/chaitubhure)

### License

This project is licensed under the MIT License - see the [LICENSE](https://github.com/chaitubhure/HARRISON_tagprediction/blob/master/LICENSE) file for details

### Acknowledgments

* The dataset
```
@misc{HARRISON16,
Author = {Minseok Park and Hanxiang Li and Junmo Kim},
Title = {HARRISON: A Benchmark on HAshtag Recommendation for Real-world Images in Social Networks},
Year = {2016},
Eprint = {arXiv:1605.05054},
}
```

