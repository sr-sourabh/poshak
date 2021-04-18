import React, {useEffect, useState} from 'react';
import Commons from "../components/commons";
import {Card, Progress, Row} from "antd";

function Admin() {

    const [data, setData] = useState({value: 0, target: 100});
    let eventSource = undefined;

    useEffect(() => {
        eventSource = new EventSource("http://localhost:8090/kafka/live");

        eventSource.addEventListener(Commons.TOPIC, (event) => {
            var result;
            try {
                result = JSON.parse(event.data);
            } catch (e) {
                console.log('Exception while parsing json ', e);
            }
            console.log("received:", result);
            setData(result)
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

    }, [])

    return (

        <>
            <Card title="Progress Circle">
                <Row justify="center">
                    <Progress type="circle" percent={data.value / data.target * 100}/>
                </Row>
            </Card>
            <Card title="Progress Line">
                <Row justify="center">
                    <Progress percent={data.value / data.target * 100}/>
                </Row>
            </Card>
        </>


    );
}

export default Admin;