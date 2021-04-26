import React, {useEffect, useState} from 'react';
import Commons from "../components/commons";
import {Card, Progress, Row} from "antd";
import axios from "axios";

export default function Admin() {

    const [state, setState] = useState(23);
    var eventSource = undefined;


    useEffect(() => {
        var initialData = {};
        axios({
            method: 'put',
            url: Commons.POSHAK_SERVICE + '/logging/filter',
            data: {
                "emails": ["vijaya@gmail.com", "sr@sr.com", "srtest@sr.com"],
                "lastWeek": true
            }
        }).then((response) => {
            response.data.forEach(
                (user) => {
                    initialData[user.userId] = user;
                }
            )
            setState(initialData);
        });

        eventSource = new EventSource(Commons.POSHAK_SERVICE + "/kafka/live");

        eventSource.addEventListener(Commons.TOPIC, (event) => {
            var result;
            try {
                result = JSON.parse(event.data);
            } catch (e) {
                console.log('Exception while parsing json ', e);
            }
            console.log("received:", result);
            if (result && result.userId) {
                initialData[result.userId] = result;
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
                <Card title={state[key].userName}>
                    <Row justify="center">
                        <Progress type="circle"
                                  percent={parseFloat(state[key].calorieValue / state[key].calorieGoal * 100)
                                      .toFixed(2)}/>
                    </Row>
                </Card>
            </div>;
        })
    );
}