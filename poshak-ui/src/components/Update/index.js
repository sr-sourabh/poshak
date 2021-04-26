import React, {useState} from 'react'
import axios from 'axios';
import { hashHistory } from 'react-router';

import {
    Container,
    FormWrap,
    Icon,
    FormContent,
    Form,
    FormH1,
    FormLabel,
    FormInput,
    FormButton,
    Text
}
    from './SigninElements';

import Commons from '../commons.js';

const UpdateData = (props) => {

    
    

    async function handleSubmit(e) {
        e.preventDefault();
        
        let response = await axios({
            method: 'put',
            url: "http://localhost:8090/user/signup",
            data: {
                "emailId": "vijaya@gmail.com",
                "name": document.getElementById("name1").value,
                "height": document.getElementById("height1").value,
                "weight": document.getElementById("weight1").value
            }
        });

        console.log(response);
        document.location = `/overview`;


        

    }

    return (
        <>
            {/* <Container> */}
                <FormWrap>
                    
                    <FormContent>
                        <Form >
                            <FormH1>Enter the below details to Update Your Information</FormH1>
                            <FormLabel htmlFor='for'>Name</FormLabel>
                            <FormInput id="name1" type='text' placeholder='enter your full name' required />
                            <FormLabel htmlFor='for'>Height</FormLabel>
                            <FormInput id="height1" type='float' placeholder='enter height in centimeters' required />
                            <FormLabel htmlFor='for'>Weight</FormLabel>
                            <FormInput id="weight1" type='float' placeholder='enter weight in kilograms' required />
                            <FormButton type='submit' onClick={handleSubmit}>Update</FormButton>
                        </Form>
                    </FormContent>
                </FormWrap>
            {/* </Container> */}
        </>
    )
}

export default UpdateData;
