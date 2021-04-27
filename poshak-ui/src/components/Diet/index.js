
import React, {useEffect, useState} from "react"
import "./search.css"
import axios from 'axios';


function Diet() {
    const [items, setItems] = useState([]);

    async function handleSubmit(e) {
        e.preventDefault();
        alert("hello");
        let response1 = await axios({
            method: 'put',
            url: 'http://localhost:8090/trainer/get',
            data: {
                trainerEmail : "trainer@gmail.com",
                userEmail : "vijaya@gmail.com" 
                
            }

        // let response1 = await axios({
        //     method: 'put',
        //     url: 'http://localhost:8090/trainer/complete/6088354adfb36a5432d89e9d',
            
        });

        console.log(response1.data);
        setItems(response1.data);
        
    }

    async function handleSubmit1(e) {
        e.preventDefault();
        console.log(items);
        
    }
    async function handlelog(e) {
        console.log(e.target.id);
        
    }


    return (
        <>
        <div className="App">
            <h1>Hello</h1> 
            <button type='submit' className="btn" onClick={handleSubmit}>Refresh</button> 
            <button type='submit' className="btn" onClick={handleSubmit1}>check data</button>       
             </div>

             <div>
                <table class="table container">
                    <thead>
                    <tr>
                        <th scope="col">Food Name</th>
                        <th scope="col">Quantity</th>
                        <th scope="col">timeOfDay</th>
                        <th scope="col">timeOfDay</th>
                        <th scope="col">Checklist</th>
                    </tr>
                    </thead>
                    <tbody>
                    {items.map((d) => (
                        <tr key={d.Item}>
                        <th>{d.food.food}</th>
                        <td>{d.quantity}</td>
                        <td>{d.timeOfDay}</td>
                        <td>{d.date}</td>
                        <td><input id ={d.id} onClick={handlelog} type="checkbox" defaultChecked={d.completed} /></td>
                        </tr>
                    ))}
                    </tbody>
                </table>
             </div>
        </>
    )
}

export default Diet;

