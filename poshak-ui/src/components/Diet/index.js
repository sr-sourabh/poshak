
import React, {useEffect, useState} from "react"
import "./search.css"
import axios from 'axios';
import { array } from "shards-react";


function Diet() {
    const [items, setItems] = useState([]);
    // useEffect(function()
    // {
    //     console.log(items);
    // },[items])

    // url: process.env.REACT_APP_POSHAK_SERVICE + "/user/login",
    sessionStorage.getItem("email")

    async function handleSubmit(e) {
        // alert("hello");
        e.preventDefault();
        console.log(items);
        let response1 = await axios({
            method: 'put',
            url: process.env.REACT_APP_POSHAK_SERVICE +"/trainer/get",
            data: {
                trainerEmail : "trainer@gmail.com",
                userEmail : sessionStorage.getItem("email") 
                
            }

        // let response1 = await axios({
        //     method: 'put',
        //     url: 'http://localhost:8090/trainer/complete/6088354adfb36a5432d89e9d',
            
        });

        setItems(response1.data);
        console.log(items);
        // document.location = `/diet`;
        
    }
    async function handlelog(e) {
        e.preventDefault();
        console.log(e.target.id);
        
        let response1 = await axios({
            method: 'put',
            url: process.env.REACT_APP_POSHAK_SERVICE +"/trainer/complete/"+e.target.id
            
        });

        console.log(response1.data);
        // document.location.reload();
        handleSubmit(e);
        
    }


    return (
        <>
        <div className="App" >
            <h1>Diet Chart</h1> 
            <button type='submit' className="btn" onClick={handleSubmit}>Refresh</button> 
             </div>

             <div className="beautify">
                <table className="table container ">
                    <thead>
                    <tr>
                        <th scope="col">Food Name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">timeOfDay</th>
                        <th scope="col">Date</th>
                        <th scope="col">Checklist</th>
                    </tr>
                    </thead>
                    <tbody>
                    {items.map((d) => (
                        <tr key={d.id}>
                        <th>{d.food.food}</th>
                        <td>{d.quantity}</td>
                        <td>{d.timeOfDay}</td>
                        <td>{d.date}</td>
                        <td><input id ={d.id} onClick={handlelog} type="checkbox" checked={d.completed} /></td>
                        </tr>
                    ))}
                    </tbody>
                </table>
             </div>
        </>
    )
}

export default Diet;

