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
                      <Form action='/userPersonalInfo'>
                          <FormH1>Sign Up Today and start living a nourishing lifestyle</FormH1>
                          <FormLabel htmlFor='for'>Email</FormLabel>
                          <FormInput type='email' placeholder='example@email.com' required />
                          <FormLabel htmlFor='for'>Password</FormLabel>
                          <FormInput type='password' placeholder='enter password' required />
                          <FormLabel htmlFor='for'>Confirm Password</FormLabel>
                          <FormInput type='password' placeholder='confirm password' required />
                          <FormButton type='submit'>Sign up</FormButton>
                      </Form>
                  </FormContent>
              </FormWrap>
          </Container>  
        </>
    )
}

export default SignUp;
