import React, {useState} from 'react'
import axios from 'axios';
import auth from "./auth"
import { hashHistory } from 'react-router';
import "./style.css"

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
    Text,
    Button1
}
    from './SigninElements';

import Commons from '../commons.js';



const SignIn = (props) => {

    
    

    async function handleSubmit(e) {
        e.preventDefault();
        let response = await axios({
            method: 'put',
            url: process.env.REACT_APP_POSHAK_SERVICE + "/user/login",
            data: {
                "emailId": document.getElementById("email").value,
                "password": document.getElementById("password").value
            }
        });

        console.log(response);
        if (response && response.data !== "" && response.data.id !== "") {
            console.log("hello");
            var email_check = document.getElementById("email").value;
            sessionStorage.setItem("isLoggedIn", "true");
            sessionStorage.setItem("email", email_check);
            sessionStorage.setItem("BMI", 10);
            document.location = `/overview`;

        } else {
            // alert("bello");
            // setPath("/signin");
            document.location = "/signin"
        }

    }


    async function handletrainer(e) {
        e.preventDefault();
        document.location = `/trainersignin`;
        }

    

    return (
        <>
            <Container>
                <FormWrap>
                    
                    <Icon to='/'>Poshak</Icon>
                    
                    <div className="right_align">
                    <Button1 type='submit' onClick={handletrainer}>Sign In As Trainer</Button1>
                    </div>
                    <FormContent>
                        <Form >
                            <FormH1>Sign In to your account</FormH1>
                            <FormLabel htmlFor='for'>Email</FormLabel>
                            <FormInput id="email" type='email' placeholder='example@email.com' required/>
                            <FormLabel htmlFor='for'>Password</FormLabel>
                            <FormInput id="password" type='password' placeholder='password' required/>
                            <FormButton type='submit' onClick={handleSubmit}>Sign In</FormButton>
                            {/* <Text>Forgot password</Text> */}
                        </Form>
                    </FormContent>
                </FormWrap>
            </Container>
        </>
    )
}

export default SignIn;



