import React, {useState} from 'react'
import {Router} from 'react-router-dom'

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
from './SignupElements'

// const emailsign="";
var passSign="";

const SignUp = () => {

    function handleSubmit(e) {
        e.preventDefault();
            if(document.getElementById("passSignup").value == document.getElementById("confirmPassSignup").value)
            {
                

                // alert(document.getElementById("passSignup").value);
                // alert(document.getElementById("confirmPassSignup").value);
                document.location = `/userPersonalInfo?x=${btoa(document.getElementById("emailSignup").value)}&y=${btoa(document.getElementById("confirmPassSignup").value)}`;
                
                
            }
        }
    
    return (
        <>
          <Container>
              <FormWrap>
              <Icon to='/'>Poshak</Icon>
                  <FormContent>
                      <Form >
                          <FormH1>Sign Up Today and start living a nourishing lifestyle</FormH1>
                          <FormLabel htmlFor='for'>Email</FormLabel>
                          <FormInput id="emailSignup" type='email' placeholder='example@email.com' required />
                          <FormLabel htmlFor='for'>Password</FormLabel>
                          <FormInput id="passSignup" type='password' placeholder='enter password' required />
                          <FormLabel htmlFor='for'>Confirm Password</FormLabel>
                          <FormInput id="confirmPassSignup" type='password' placeholder='confirm password' required />
                          <FormButton type='submit' onClick={handleSubmit}>Sign up</FormButton>
                      </Form>
                  </FormContent>
              </FormWrap>
          </Container>  
        </>
    )
}

export default SignUp;
