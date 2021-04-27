
import React, {useEffect, useState} from "react"
import "./search.css"
import axios from 'axios';


function Diet() {


    async function handleSubmit(e) {
        e.preventDefault();
        alert("hello");
        
    }


    return (
        <div className="App">
            <h1>Hello</h1> 
            <button type='submit' className="btn" onClick={handleSubmit}>Refresh</button>      
             </div>
    )
}

export default Diet;

