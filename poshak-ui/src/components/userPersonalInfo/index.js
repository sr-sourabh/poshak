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
} from './userPersonalInfoElements'



const UserPersonalInfo = () => {
    function handleSubmit(e) {
        e.preventDefault();
        
        var url = new URL(window.location.href);
        var c1 = atob(url.searchParams.get(("x")));
        var c2 = atob(url.searchParams.get(("y")));
        console.log(c1);
        console.log(c2);
    
    }
    // action='/overview'
    return (
        <>
            <Container>
                <FormWrap>
                    <Icon to='/'>Poshak</Icon>
                    <FormContent>
                        <Form >
                            <FormH1>Enter the below details to complete your profile</FormH1>
                            <FormLabel htmlFor='for'>Name</FormLabel>
                            <FormInput type='text' placeholder='enter your full name' required />
                            <FormLabel htmlFor='for'>Height</FormLabel>
                            <FormInput type='float' placeholder='enter height in centimeters' required />
                            <FormLabel htmlFor='for'>Weight</FormLabel>
                            <FormInput type='float' placeholder='enter weight in kilograms' required />
                            <FormButton type='submit' onClick={handleSubmit}>Submit Info</FormButton>
                        </Form>
                    </FormContent>
                </FormWrap>
            </Container>
        </>
    )
}

export default UserPersonalInfo;