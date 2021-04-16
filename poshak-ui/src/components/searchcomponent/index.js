import {Input} from "antd"
import {useCombobox} from "downshift"
import React, {useEffect, useState} from "react"
import "./search.css"
import fooddata from './fooddata.json'


function SearchComp() {
    const [inputItems, setInputItems] = useState([])
    const [users, setUsers] = useState([])
    const [singleUser, setSingleUser] = useState("")

    useEffect(() => {
        fetch("https://poshak-ui-sr-sourabh.cloud.okteto.net/")
            .then((response) => response.json())
            .then((data) => setUsers(data))
    }, [])

    // useEffect(() => {
    //   fetch(`${fooddata}.json`)
    //     .then((response) => response.json())
    //     .then((data) => setUsers(data))
    // }, [])

    useEffect(() => {
        setUsers(fooddata)
    }, [])

    console.log(users);

    const {
        isOpen,
        getMenuProps,
        getInputProps,
        getComboboxProps,
        highlightedIndex,
        getItemProps,
    } = useCombobox({
        items: inputItems,
        onInputValueChange: ({inputValue}) => {
            setInputItems(
                users.filter((item) =>
                    item.food.toLowerCase().startsWith(inputValue.toLowerCase())
                )
            )
        },
    })


    return (
        <div className="App">
            <h1>Current Item: {singleUser}</h1>
            <div {...getComboboxProps()}>
                <Input
                    {...getInputProps()}
                    placeholder="Search"
                    enterButton="Search"
                    //   value={singleUser}
                    type="text"
                    size="large"
                />

            </div>
            <ul {...getMenuProps()}>
                {isOpen &&
                inputItems.map((item, index) => (
                    <span
                        key={item.id}
                        {...getItemProps({item, index})}
                        onClick={() => setSingleUser(item.food)}
                    >
              <li
                  style={highlightedIndex === index ? {background: "#ede"} : {}}
              >
                <h4>{item.food}</h4>
              </li>
            </span>
                ))}
            </ul>
            <h1><label for="quant">Quantity:</label><br/></h1>
            <input
                type="text"
                id="quant"
                name="quant"
            /> <br/><br/>
            <button type='submit' className="btn">Log</button>
        </div>
    )
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