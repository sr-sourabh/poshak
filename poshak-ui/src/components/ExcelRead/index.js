import React, { useState } from "react";
import * as XLSX from "xlsx";
import styled from 'styled-components'
import axios from 'axios';
import "./style.css"

const FormButton = styled.button`
background: #01bf71;
padding: 16px 0;
border: none;
border-radius: 50px;
color: #fff;
font-size: 20px;
cursor: pointer;
padding: 10px 22px;
`;


// border-radius: 50px;
// background: #01bf71;
// white-space: nowrap;
// padding: 10px 22px;
// color: #010606;
// font-size: 16px;
// outline: none;
// cursor: pointer;
// transition: all 0.2s ease-in-out;
// text-decoration: none;
// position: fixed;
// right: 7rem;

// &:hover {
//     transition: all 0.2s ease-in-out;
//     background: #fff;
//     color: #010606;




const Excel = () => {

    const [items, setItems] = useState([]);

    const readExcel = (file) => {
        const promise = new Promise((resolve, reject) => {
          const fileReader = new FileReader();
          fileReader.readAsArrayBuffer(file);
    
          fileReader.onload = (e) => {
            const bufferArray = e.target.result;
    
            const wb = XLSX.read(bufferArray, { type: "buffer" });
    
            const wsname = wb.SheetNames[0];
    
            const ws = wb.Sheets[wsname];
    
            const data = XLSX.utils.sheet_to_json(ws);
            
            
            resolve(data);
          };
    
          fileReader.onerror = (error) => {
            reject(error);
          };
        });
    
        promise.then((d) => {
            setItems(d);
        });

        // setItems(d);

        
      };

      async function handleSubmit(e) {
        e.preventDefault();
        console.log(items);

        let response = await axios({
            method: 'put',
            url: "http://localhost:8090/trainer",
            data: {
                trainerEmail: "trainer@gmail.com",
                excelFoods : items
                }
        });
        console.log(response)


    }

    return (
        <>  
            <h1 className="nav-expanded ">Please Select the diet chart to upload</h1>
            <div className="nav-expanded ">
            <input
                type="file"
                onChange={(e) => {
                const file = e.target.files[0];
                readExcel(file);
                }}    
            />
            <FormButton type='submit' onClick={handleSubmit}> Reload</FormButton>

            </div>
            <table class="table container">
        <thead>
          <tr>
            <th scope="col">userEmail</th>
            <th scope="col">foodName</th>
            <th scope="col">quantity</th>
            <th scope="col">timeOfDay</th>
            <th scope="col">day</th>
            <th scope="col">month</th>
            <th scope="col">year</th>
            {/* <th scope="col">Checkbox</th> */}
          </tr>
        </thead>
        <tbody>
          {items.map((d) => (
            <tr key={d.Item}>
              <th>{d.userEmail}</th>
              <td>{d.foodName}</td>
              <td>{d.quantity}</td>
              <td>{d.timeOfDay}</td>
              <td>{d.day}</td>
              <td>{d.month}</td>
              <td>{d.year}</td>
              {/* <td><input type="checkbox"/></td> */}
            </tr>
          ))}
        </tbody>
      </table>


        </>
    )
}

export default Excel;
