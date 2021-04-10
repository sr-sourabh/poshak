import React from 'react'

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

const SignUp = () => {
    return (
        <>
          <Container>
              <FormWrap>
                  <Icon to='/'>Poshak</Icon>
                  <FormContent>
                      <Form action='/overview'>
                          <FormH1>Sign Up to your account</FormH1>
                          <FormLabel htmlFor='for'>Email</FormLabel>
                          <FormInput type='email' required />
                          <FormLabel htmlFor='for'>Password</FormLabel>
                          <FormInput type='password' required />
                          <FormLabel htmlFor='for'>Confirm Password</FormLabel>
                          <FormInput type='password' required />
                          <FormButton type='submit'>Continue</FormButton>
                          
                      </Form>
                  </FormContent>
              </FormWrap>
          </Container>  
        </>
    )
}

export default SignUp;
