import React, {useState} from 'react'
import axios from 'axios';

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

const SignIn = () => {

    const [state, setState] = useState({
        email: "",
        password: "",
        datarecived: ""
    })

    const [path, setPath] = useState("/signin")

    const handleChange = (e) => {

    }

    function handleSubmit(e) {
        e.preventDefault();
        axios({
            method: 'put',
            url: Commons.POSHAK_SERVICE + '/user/login',
            data: {
                "emailId": document.getElementById("email").value,
                "password": document.getElementById("password").value
            }
        }).then(res => {
            console.log(res);
            if (res && res.data !== "" && res.data.id !== "") {
                console.log("set path to overview");
                setPath("/overview");
            } else {
                console.log("prevent default");
            }
        });
    }

    return (
        <>
            <Container>
                <FormWrap>
                    <Icon to='/'>Poshak</Icon>
                    <FormContent>
                        <Form action={path}>
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
