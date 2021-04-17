import React from 'react'
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
} from './userPersonalInfoElements'
import Commons from '../commons.js';


const UserPersonalInfo = () => {
    async function handleSubmit(e) {
        e.preventDefault();
        
        var url = new URL(window.location.href);
        var email = atob(url.searchParams.get(("x")));
        var pass = atob(url.searchParams.get(("y")));
        // console.log(c1);
        // console.log(c2);

        let response = await axios({
            method: 'put',
            url: Commons.POSHAK_SERVICE + '/user/signup',
            data: {
                "emailId": email,
                "password": pass,
                "status": 1,
                "name": document.getElementById("name").value,
                "height": document.getElementById("height").value,
                "weight": document.getElementById("weight").value
            }
        });

        console.log(response);
        if (response && response.data !== "" && response.data.id !== "") {
            document.location = "/overview"
        } else {
            document.location = "/signup"
        }
    
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
                            <FormInput id="name" type='text' placeholder='enter your full name' required />
                            <FormLabel htmlFor='for'>Height</FormLabel>
                            <FormInput id="height" type='float' placeholder='enter height in centimeters' required />
                            <FormLabel htmlFor='for'>Weight</FormLabel>
                            <FormInput id="weight" type='float' placeholder='enter weight in kilograms' required />
                            <FormButton type='submit' onClick={handleSubmit}>Submit Info</FormButton>
                        </Form>
                    </FormContent>
                </FormWrap>
            </Container>
        </>
    )
}

export default UserPersonalInfo;