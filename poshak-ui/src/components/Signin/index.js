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
from './SigninElements'

const SignIn = () => {
    return (
        <>
          <Container>
              <FormWrap>
                  <Icon to='/'>Poshak</Icon>
                  <FormContent>
                      <Form action='/overview'>
                          <FormH1>Sign In to your account</FormH1>
                          <FormLabel htmlFor='for'>Email</FormLabel>
                          <FormInput type='email' required />
                          <FormLabel htmlFor='for'>Password</FormLabel>
                          <FormInput type='password' required />
                          <FormButton type='submit'>Continue</FormButton>
                          <Text>Forgot password</Text>
                      </Form>
                  </FormContent>
              </FormWrap>
          </Container>  
        </>
    )
}

export default SignIn;
