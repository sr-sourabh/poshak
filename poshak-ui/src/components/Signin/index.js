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
from './SigninElements'

const SignIn = () => {

    const [state , setState] = useState({
        email : "",
        password : "",
        datarecived : ""
    })

    const handleChange = (e) => {

    }

    function handleSubmit(e) {
        // alert(document.getElementById("email").value);
        // alert(document.getElementById("password").value);
        axios({
            method: 'put',
            url: 'http://localhost:8090/user/login',
            data: {
                "emailId": document.getElementById("email").value,
                "password":document.getElementById("password").value
            }
        })
        .then(res => alert(res.data ));
        // console.log("ddsfsdf");
        // console.log(state.datarecived);
    }

    return (
        <>
          <Container>
              <FormWrap>
                  <Icon to='/'>Poshak</Icon>
                  <FormContent>
                      <Form  >
                          <FormH1>Sign In to your account</FormH1>
                          <FormLabel htmlFor='for'>Email</FormLabel>
                          <FormInput id="email" type='email' placeholder='example@email.com' required />
                          <FormLabel htmlFor='for'>Password</FormLabel>
                          <FormInput id="password" type='password' placeholder='password' required />
                          <FormButton type='submit' onClick={handleSubmit} >Sign In</FormButton>
                          <Text>Forgot password</Text>
                      </Form>
                  </FormContent>
              </FormWrap>
          </Container>  
        </>
    )
}

export default SignIn;
