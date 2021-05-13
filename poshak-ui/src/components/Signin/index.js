import React, {useState} from 'react'
import axios from 'axios';
import auth from "./auth"
import { hashHistory } from 'react-router';
import "./style.css"

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
    Text,
    Button1
}
    from './SigninElements';

import Commons from '../commons.js';



const SignIn = (props) => {

    async function handleload(e) {
        e.preventDefault();
              
              var com = "lastYear";
            let response = await axios({
                  method: 'put',
                  url: process.env.REACT_APP_POSHAK_SERVICE + "/logging/filter",
                  data: {
                      // "emailId": sessionStorage.getItem("email")
                      "emails": [sessionStorage.getItem("email")],
                      [com] : true
                  }
              });
               console.log(response);
            //    alert("lastYear");
      
               var cal = response.data[0].calorieValue;
              var pro = response.data[0].proteinValue;
              var fat = response.data[0].fatValue;
              var carbs = response.data[0].carbsValue;
      
              var calGoal = response.data[0].calorieGoal;
              var proGoal = response.data[0].proteinGoal;
              var fatGoal = response.data[0].fatGoal;
              var carbsGoal = response.data[0].carbsGoal;
      
              console.log(cal);
              console.log(pro);
              console.log(fat);
              console.log(carbs);
      
      
              sessionStorage.setItem("Calorie", cal);
              sessionStorage.setItem("Protein", pro);
              sessionStorage.setItem("Fat", fat);
              sessionStorage.setItem("Carbs", carbs);
      
              sessionStorage.setItem("calGoal", calGoal);
              sessionStorage.setItem("proGoal", proGoal);
              sessionStorage.setItem("fatGoal", fatGoal);
              sessionStorage.setItem("carbsGoal", carbsGoal);
      
      
              var total = pro + fat + carbs;
      
              var percentProtein = pro*100/total;
              percentProtein = percentProtein.toFixed(2);
      
              var percentFat = fat*100/total;
              percentFat = percentFat.toFixed(2);
      
              var percentCarbs = carbs*100/total;
              percentCarbs = percentCarbs.toFixed(2);
      
              sessionStorage.setItem("PercentProtein", percentProtein);
              sessionStorage.setItem("PercentFat", percentFat);
              sessionStorage.setItem("PercentCarbs", percentCarbs);
      
      
              let response1 = await axios({
                  method: 'put',
                  url: process.env.REACT_APP_POSHAK_SERVICE + "/user/signup",
                  data: {
                      // "emailId": sessionStorage.getItem("email")
                      "emailId": sessionStorage.getItem("email")
                  }
              });
      
              var h = response1.data.height/100;
              var w = response1.data.weight ;
              var bmi1 = ((w/h)/h).toFixed(2);
              console.log(response1.data.height);
              console.log(response1.data.weight);
              console.log(bmi1);
              sessionStorage.setItem("BMI", bmi1);
              document.location = `/overview`;
            }
    

    async function handleSubmit(e) {
        e.preventDefault();
        let response = await axios({
            method: 'put',
            url: process.env.REACT_APP_POSHAK_SERVICE + "/user/login",
            data: {
                "emailId": document.getElementById("email").value,
                "password": document.getElementById("password").value
            }
        });

        console.log(response);
        if (response && response.data !== "" && response.data.id !== "") {
            console.log("hello");
            var email_check = document.getElementById("email").value;
            sessionStorage.setItem("isLoggedIn", "true");
            sessionStorage.setItem("email", email_check);
            sessionStorage.setItem("BMI", 10);
            // console.log(response.data.name)
            sessionStorage.setItem("name", response.data.name);
            handleload(e);
            // document.location = `/overview`;

        } else {
            // alert("bello");
            // setPath("/signin");
            alert("wrong email or password")
            document.location = "/signin"
        }

    }


    async function handletrainer(e) {
        e.preventDefault();
        document.location = `/trainersignin`;
        }

    

    return (
        <>
            <Container>
                <FormWrap>
                    
                    <Icon to='/'>Poshak</Icon>
                    
                    <div className="right_align">
                    <Button1 type='submit' onClick={handletrainer}>Sign In As Trainer</Button1>
                    </div>
                    <FormContent>
                        <Form >
                            <FormH1>Sign In to your account</FormH1>
                            <FormLabel htmlFor='for'>Email</FormLabel>
                            <FormInput id="email" type='email' placeholder='example@email.com' required/>
                            <FormLabel htmlFor='for'>Password</FormLabel>
                            <FormInput id="password" type='password' placeholder='password' required/>
                            <FormButton type='submit' onClick={handleSubmit}>Sign In</FormButton>
                            {/* <Text>Forgot password</Text> */}
                        </Form>
                    </FormContent>
                </FormWrap>
            </Container>
        </>
    )
}

export default SignIn;



