import { Input } from "antd";
import { useCombobox } from "downshift";
import React, { useEffect, useState } from "react";
import "./search.css";
import fooddata from "./fooddata.json";
import axios from "axios";

function SearchComp() {
  const [inputItems, setInputItems] = useState([]);
  const [users, setUsers] = useState([]);
  const [singleUser, setSingleUser] = useState("");

  useEffect(() => {
    fetch(process.env.REACT_APP_POSHAK_SERVICE + "/food/all")
      .then((response) => response.json())
      .then((data) => setUsers(data));
  }, []);

  // dont delete

  // useEffect(() => {
  //   fetch(`${fooddata}.json`)
  //     .then((response) => response.json())
  //     .then((data) => setUsers(data))
  // }, [])

  // useEffect(() => {
  //     setUsers(fooddata)
  // }, [])

  // console.log(users);

  const {
    isOpen,
    getMenuProps,
    getInputProps,
    getComboboxProps,
    highlightedIndex,
    getItemProps,
  } = useCombobox({
    items: inputItems,
    onInputValueChange: ({ inputValue }) => {
      setInputItems(
        users.filter((item) =>
          item.food.toLowerCase().startsWith(inputValue.toLowerCase())
        )
      );
    },
  });
  // url: process.env.REACT_APP_POSHAK_SERVICE + "/user/login",

  async function handleSubmit(e) {
    e.preventDefault();
    let response = await axios({
      method: "get",
      url: process.env.REACT_APP_POSHAK_SERVICE + "/foodByName/" + singleUser,
    });

    //  console.log(response);
    if (response && response.data !== "" && response.data.id !== "") {
      // console.log(response.data[0].calories);
      // console.log(response.data[0].protein);
      // console.log(response.data[0].fat);
      // console.log(response.data[0].carbs);
      var today = new Date();
      var dd = parseInt(String(today.getDate()).padStart(2, "0"));
      var mm = parseInt(String(today.getMonth() + 1).padStart(2, "0")); //January is 0!
      var yyyy = today.getFullYear();

      // console.log(sessionStorage.getItem("email"));

      // e.preventDefault();
      var Quantity = document.getElementById("quant").value;
      console.log(Quantity);
      let response1 = await axios({
        method: "put",
        url: process.env.REACT_APP_POSHAK_SERVICE + "/logging/log",
        data: {
          email: sessionStorage.getItem("email"),
          calorie: parseInt(response.data[0].calories) * Quantity,
          protein: parseInt(response.data[0].protein) * Quantity,
          fat: parseInt(response.data[0].fat) * Quantity,
          carbs: parseInt(response.data[0].carbs) * Quantity,
          day: dd,
          month: mm,
          year: yyyy,
          foodName: response.data[0].food,
          quantity: Quantity,
        },
      });
      console.log(response1);
    }
    // document.location = '/overview';
  }

  const [imageFile, setImageFile] = useState(null);
  const [imagePreview, setImagePreview] = useState("");
  const [predImage, setPredImage] = useState("");

  async function handleImageChange(e) {
    if(e.target.files[0]) {
      let image_as_base64 = URL.createObjectURL(e.target.files[0]);
      let image_as_files = e.target.files[0];
      setImageFile(image_as_files);
      setImagePreview(image_as_base64);
    }
  }

    async function handleImageSubmit(e) {
        e.preventDefault();
        let formData = new FormData();
        formData.append('file',imageFile);
        axios.post(
            //"http://0.0.0.0:5000/predict",
            process.env.REACT_APP_POSHAK_ML_SERVICE + "/predict",
            formData,{
                headers:{
                    "Content-Type": "multipart/form-data"
                },
            }
        ).then(res => {
            setPredImage(res.data);
            setSingleUser(res.data);
            console.log('Success' + res.data);
        } ).catch(err => {
            console.log(err);
        })
    }


  return (
    <div className="logging-outer-div">
      <div className="alignleft box-padding">
        <h2>Log Food Using Image</h2>
        <span className="display-inline alignleft large-font">
          Search Item:
        </span>
        <div {...getComboboxProps()} className="display-inline alignright">
          <Input
            {...getInputProps()}
            placeholder="Search"
            enterButton="Search"
            // value={singleUser}
            type="text"
            size="large"
          />
        </div>
        <div>
          <ul {...getMenuProps()}>
            {isOpen &&
              inputItems.map((item, index) => (
                <span
                  key={item.id}
                  {...getItemProps({ item, index })}
                  onClick={() => setSingleUser(item.food)}
                >
                  <li
                    style={
                      highlightedIndex === index ? { background: "#ede" } : {}
                    }
                  >
                    <h4>{item.food}</h4>
                  </li>
                </span>
              ))}
          </ul>
        </div>

        <span className="display-inline alignleft large-font separator-top-padding">
          <label >Selected Item:</label>
        </span>
        <div className="display-inline alignright separator-top-padding">
          <input className="large-font" type="text" value={singleUser}/>
        </div>
        <br />

        <span className="display-inline alignleft large-font separator-top-padding">
          <label for="quant">Quantity:</label>
        </span>
        <div className="display-inline alignright separator-top-padding">
          <input className="large-font" type="text" id="quant" name="quant" />
        </div>
        <br />
        <div className="button-class">
          <button type="submit" className="btn-green" onClick={handleSubmit}>
            Log
          </button>
        </div>
      </div>

      <div className="alignright box-padding">

        <h2>Log food using image</h2>

        <input
          type="file"
          id="myFile"
          name="filename"
          onChange={handleImageChange}
        />

        <div className="button-class2">
          <button type="submit" className="btn-green" onClick={handleImageSubmit}>
            {" "}
            Submit...{" "}
          </button>
        </div>

        <h3 className="separator-top-padding ">
          Predicted image : {predImage}
        </h3>
      </div>
    </div>
  );
}

export default SearchComp;

// import React, {useEffect, useState} from 'react'
// import './search.css'
// import {useCombobox} from 'downshift'

//  function searchComp() {

//     const [inputItems, setInputItems] = useState([])
//     const [users, setUsers] = useState([])
//     const [singleuser, setSingleUser] = useState('')

//     useEffect(() => {
//         fetch("https://jsonplaceholder.typicode.com/users").then((response) => response.json()).then((data) => setUsers(data))
//     }, [])

//     // console.log(users)

//     const {
//         isOpen,
//         getMenuProps,
//         getInputProps,
//         getComboboxProps,
//         highlightedIndex,
//         getItemProps,
//     } = useCombobox({
//         items: inputItems,
//         onInputValueChange: ({inputValue}) => {
//             setInputItems(
//                 users.filter((item) =>
//                 item.name.toLower().startWith(inputValue.toLocaleLowerCase())
//                 )
//             )
//         },

//     })

//     return (
//         <div className= 'App'>
//             <h2>Currrent User: {singleuser}</h2>
//             <div {...getComboboxProps()}>
//             <Input {...getInputProps()}
//                 placeholder = "Search"
//                 enterButton="Search"
//                 size= "large"
//             />
//             </div>
//         </div>
//     )
// }

// export default searchComp ;
