import React, {useState} from 'react'
import axios from 'axios';
import auth from "./auth"
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

const SignIn = (props) => {

    
    

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
            sessionStorage.setItem("isLoggedIn", "true");
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
                    <Icon to='/'>Poshak</Icon>
                    <FormContent>
                        <Form >
                            <FormH1>Sign In to your account</FormH1>
                            <FormLabel htmlFor='for'>Email</FormLabel>
                            <FormInput id="email" type='email' placeholder='example@email.com' required/>
                            <FormLabel htmlFor='for'>Password</FormLabel>
                            <FormInput id="password" type='password' placeholder='password' required/>
                            <FormButton type='submit' onClick={handleSubmit}>Sign In</FormButton>
                            <Text>Forgot password</Text>
                        </Form>
                    </FormContent>
                </FormWrap>
            </Container>
        </>
    )
}

export default SignIn;
