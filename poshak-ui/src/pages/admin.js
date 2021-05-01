import React, {useEffect, useState} from 'react';
import Commons from "../components/commons";
import {Card, Progress, Row} from "antd";
import axios from "axios";

export default function Admin() {

    const [state, setState] = useState(23);
    var eventSource = undefined;


    useEffect(() => {
        console.log(process.env.REACT_APP_POSHAK_SERVICE);
        var initialData = {};
        axios({
            method: 'get',
            url: process.env.REACT_APP_POSHAK_SERVICE + '/trainer/trainer@gmail.com',
        }).then((response) => {
            response.data.forEach(
                (user) => {
                    initialData[user.userEmail] = user;
                }
            )
            setState(initialData);
        });

        eventSource = new EventSource(process.env.REACT_APP_POSHAK_SERVICE + "/kafka/live");

        eventSource.addEventListener(Commons.TOPIC, (event) => {
            var result;
            try {
                result = JSON.parse(event.data);
            } catch (e) {
                console.log('Exception while parsing json ', e);
            }
            console.log("received:", result);
            if (result && result.userEmail) {
                initialData[result.userEmail] = result;
                setState({...initialData});
            }
        });

        eventSource.onerror = (event) => {
            console.log(event.target.readyState)
            if (event.target.readyState === EventSource.CLOSED) {
                console.log('SSE closed (' + event.target.readyState + ')')
                eventSource.close();
            }
        }

        eventSource.onopen = (event) => {
            console.log("connection opened")
        }

        return () => {
            eventSource.close();
            console.log("event closed");
        }

    }, []);

    return (
        Object.keys(state).map((key) => {
            return <div key={key}>
                <Card title={state[key].userEmail}>
                    <Row justify="center">
                        <Progress type="circle"
                                  percent={parseFloat(state[key].foodValue / state[key].foodGoal * 100)
                                      .toFixed(2)}/>
                        <div>
                            Total food to eat : {state[key].foodGoal}
                            <br></br>
                            Total food eaten : {state[key].foodValue}
                        </div>
                    </Row>
                </Card>
            </div>;
        })
    );
}