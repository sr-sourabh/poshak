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

    const [path, setPath] = useState("")

    const handleChange = (e) => {

    }

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
            setPath("/overview");
        } else {
            setPath("/signin");
        }

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
