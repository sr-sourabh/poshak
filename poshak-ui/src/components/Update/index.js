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
            url: Commons.POSHAK_SERVICE + '/user/login',
            data: {
                "emailId": document.getElementById("email").value,
                "password": document.getElementById("password").value
            }
        });

        console.log(response);
        if (response && response.data !== "" && response.data.id !== "") {
            console.log("hello");
            // alert("hello");
            // setPath("/overview");
            // document.location = `/overview?x=${btoa(document.getElementById("email").value)}`;
            // auth.login(() => {
            //     // this.props.hashHistory.push("/");
            //     document.location = `/overview?x=${btoa(document.getElementById("email").value)}`;
            // })
            var email_check = document.getElementById("email").value;
            sessionStorage.setItem("isLoggedIn", "true");
            sessionStorage.setItem("email", email_check);
            document.location = `/overview?x=${btoa(document.getElementById("email").value)}`;


        } else {
            // alert("bello");
            // setPath("/signin");
            document.location = "/signin"
        }

    }

    return (
        <>
            <Container>
                <FormWrap>
                    
                    <FormContent>
                        <Form >
                            <FormH1>Enter the below details to Update Your Information</FormH1>
                            <FormLabel htmlFor='for'>Name</FormLabel>
                            <FormInput id="name" type='text' placeholder='enter your full name' required />
                            <FormLabel htmlFor='for'>Height</FormLabel>
                            <FormInput id="height" type='float' placeholder='enter height in centimeters' required />
                            <FormLabel htmlFor='for'>Weight</FormLabel>
                            <FormInput id="weight" type='float' placeholder='enter weight in kilograms' required />
                            <FormButton type='submit' onClick={handleSubmit}>Update</FormButton>
                        </Form>
                    </FormContent>
                </FormWrap>
            </Container>
        </>
    )
}

export default UpdateData;
