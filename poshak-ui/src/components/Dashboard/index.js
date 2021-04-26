import React from "react";
import styled from 'styled-components';
import {Link as LinkR} from 'react-router-dom'
import PropTypes from "prop-types";
import { Container, Row, Col, FormSelect, } from "shards-react";
import "./dashboardStyles.css"
import PageTitle from "./dashboardComponents/PageTitle";
import SmallStats from "./dashboardComponents/SmallStats";
import UsersByDevice from "./dashboardComponents/UsersByDevice";
import Nutrients from "./dashboardComponents/nutrients";
import axios from 'axios';




import {
  CircularProgressbar,
  CircularProgressbarWithChildren,
  buildStyles
} from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import { RiGameFill } from "react-icons/ri";

// total standard value

const totalCalorie = 2000;
const totalProtein = 1000;
const totalFat = 800;
const totalCarbs = 1100;

const consumptionProtein = sessionStorage.getItem("Protein")*100/totalProtein;
const consumptionFat = sessionStorage.getItem("Fat")*100/totalFat;
const consumptionCarbs = sessionStorage.getItem("Carbs")*100/totalCarbs;




const percentage = sessionStorage.getItem("Calorie")*100/totalCalorie;



const NavBtn =styled.nav`

display: flex;

align-items: center;

@media screen and (max-width: 768px) {
    display: none;
}
`;

const NavBtnLink = styled(LinkR)`
border-radius: 50px;
background: #80dfff;
white-space: nowrap;
padding: 10px 22px;
color: #010606;
font-size: 16px;
outline: none;
cursor: pointer;
transition: all 0.2s ease-in-out;
text-decoration: none;
${'' /* position: fixed;
right: 7rem; */}

&:hover {
    transition: all 0.2s ease-in-out;
    background: #fff;
    color: #010606;
}

`;


function Example(props) {

  return (
      <div style={{ marginBottom: 80 }}>
        <hr style={{ border: "2px solid #ddd" }} />
        <div style={{ marginTop: 30, display: "flex" }}>
          <div style={{ width: "30%", paddingRight: 30 }}>{props.children}</div>
          <div style={{ width: "70%" }}>
            <h3 className="h5">{props.label}</h3>
            <p>{props.description}</p>
            <p>{props.description1}</p>
          </div>
        </div>
      </div>
  );
}


async function handleSubmit(e) {
  e.preventDefault();
        let response = await axios({
            method: 'put',
            url: "http://localhost:8090/logging/get",
            data: {
                // "emailId": sessionStorage.getItem("email")
                "email": "vijaya@gmail.com"
            }
        });

        console.log(response.data.log);
        console.log(response.data.log.length);
        var cal = 0;
        var pro = 0;
        var fat = 0;
        var carbs = 0;
        for(var i = 0; i < response.data.log.length; i++) {

          cal = cal + response.data.log[i].calorie;
          pro = pro + response.data.log[i].protein;
          fat = fat + response.data.log[i].fat;
          carbs = carbs + response.data.log[i].carbs;
          
        }
        console.log(cal);
        console.log(pro);
        console.log(fat);
        console.log(carbs);
        sessionStorage.setItem("Calorie", cal);
        sessionStorage.setItem("Protein", pro);
        sessionStorage.setItem("Fat", fat);
        sessionStorage.setItem("Carbs", carbs);


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

        // console.log(percentProtein);
        // console.log(percentFat);
        // console.log(percentCarbs);


        document.location = `/overview`;
}

async function handleSubmit1(e) {
  e.preventDefault();
        alert(e.target.value);
}

const BlogOverview = ({ smallStats }) => (


  

 
  
  <Container fluid className="main-content-container px-4">
    {/* Page Header */}
    <Row noGutters className="page-header py-4">
      <PageTitle title="Your Nutrition Overview" subtitle="HI, Ron"  className="text-sm-left mb-3" />
      </Row>
    <Row>
      <Col>
        <a href="logging" className="button3" >Log my meal</a>
      </Col>
    </Row>
    <Row>
    <Col lg="9" md="6" sm="12">
      <NavBtn>
                    <NavBtnLink onClick={handleSubmit}>Refresh</NavBtnLink>
      </NavBtn>
    </Col>
    

    <Col>
    <Col>
              <FormSelect
                size="sm"
                // value="last-week"
                style={{ maxWidth: "130px" }}
                onChange={() => {}} onClick={handleSubmit1}>
                <option value="last-week">Last Week</option>
                <option value="today">Today</option>
                <option value="last-month">Last Month</option>
                <option value="last-year">Last Year</option>
              </FormSelect>
            </Col>
    </Col>
    
    </Row>


    {/* Small Stats Blocks */}
    <Row>
      {smallStats.map((stats, idx) => (
        <Col className="col-lg mb-4" key={idx} {...stats.attrs}>
          <SmallStats
            id={`small-stats-${idx}`}
            variation="1"
            chartData={stats.datasets}
            chartLabels={stats.chartLabels}
            label={stats.label}
            value={stats.value}
            percentage={stats.percentage}
            increase={stats.increase}
            decrease={stats.decrease}
          />
        </Col>
      ))}
    </Row>

    <Row>
      <Col>
        <Example label="Total Calories" description="today">
          <CircularProgressbarWithChildren value={percentage} strokeWidth={5}>
            {/* Put any JSX content in here that you'd like. It'll be vertically and horizonally centered. */}
            <div style={{ fontSize: 22, marginTop: 25 , marginBottom:-15}}>
              <p><b>{sessionStorage.getItem("Calorie")}</b> cal</p>
            </div>
            <div style={{ fontSize: 14, marginTop: -5 }}>
              <p>{percentage}% of Goal</p>
            </div>
          </CircularProgressbarWithChildren>
        </Example>
      </Col>
      <Col>
        <Example label="Macronutrients Goals" description="today">
          <CircularProgressbarWithChildren
              value={consumptionProtein}
              counterClockwise
              strokeWidth={5}
              styles={buildStyles({
                pathColor: "#ff1a75"

              })}
          >
            {/*
          Width here needs to be (100 - 2 * strokeWidth)%
          in order to fit exactly inside the outer progressbar.
        */}
            <div style={{ width: "80%" }}>
              <CircularProgressbarWithChildren
                  value={consumptionCarbs}
                  strokeWidth={5}
                  counterClockwise
                  styles={buildStyles({
                    pathColor: "#80dfff",
                    strokeLinecap: "round"
                  })}
              >
                <div style={{ width: "78%" }}>
                  <CircularProgressbarWithChildren
                      value={consumptionFat}
                      strokeWidth={6}
                      counterClockwise
                      styles={buildStyles({
                        pathColor: "#00e600",
                        strokeLinecap: "round"
                      })}
                  >
                    <div style={{ fontSize: 15, marginTop: 165 , marginBottom:-3}}>
                      <p>fat</p>
                    </div>
                    <div style={{ fontSize: 15, marginTop: -5 }}>
                      <p>carbs</p>
                    </div>
                    <div style={{ fontSize: 15, marginTop: -5 }}>
                      <p>protein</p>
                    </div>
                  </CircularProgressbarWithChildren>
                </div>
              </CircularProgressbarWithChildren>
            </div>

          </CircularProgressbarWithChildren>
        </Example>
      </Col>
      

    </Row>

    <Row>
      {/* Users Overview */}
      {/* <Col lg="8" md="12" sm="12" className="mb-4">
        <UsersOverview />
      </Col> */}

      {/* Users by Device */}
      <Col lg="4" md="6" sm="12" className="mb-4">
        <UsersByDevice />
      </Col>

      {/* Users by Device */}
      <Col lg="4" md="6" sm="12" className="mb-4">
        <Nutrients />
      </Col>

      </Row>

      {/* <Row>
      <Col lg="4" md="6" sm="12" className="mb-4">
        <UsersByDevice />
      </Col>

      <Col lg="4" md="6" sm="12" className="mb-4">
        <UsersByDevice />
      </Col> */}

      {/* New Draft */}
      {/* <Col lg="4" md="6" sm="12" className="mb-4">
        <NewDraft />
      </Col> */}

      {/* Discussions */}
      {/* <Col lg="5" md="12" sm="12" className="mb-4">
        <Discussions />
      </Col> */}

      {/* Top Referrals */}
      {/* <Col lg="3" md="12" sm="12" className="mb-4">
        <TopReferrals />
      </Col> */}
    {/* </Row> */}
  </Container>
);

BlogOverview.propTypes = {
  /**
   * The small stats dataset.
   */
  smallStats: PropTypes.array
};

BlogOverview.defaultProps = {
  smallStats: [
    {
      label: "Protein",
      value: sessionStorage.getItem("Protein"),
      percentage: "4.7%",
      increase: true,
      chartLabels: [null, null, null, null, null, null, null],
      attrs: { md: "6", sm: "6" },
      datasets: [
        {
          label: "Today",
          fill: "start",
          borderWidth: 1.5,
          backgroundColor: "rgba(0, 184, 216, 0.1)",
          borderColor: "rgb(0, 184, 216)",
          data: [1, 2, 1, 3, 5, 4, 7]
        }
      ]
    },
    {
      label: "Fat",
      value: sessionStorage.getItem("Fat"),
      percentage: "12.4",
      increase: true,
      chartLabels: [null, null, null, null, null, null, null],
      attrs: { md: "6", sm: "6" },
      datasets: [
        {
          label: "Today",
          fill: "start",
          borderWidth: 1.5,
          backgroundColor: "rgba(23,198,113,0.1)",
          borderColor: "rgb(23,198,113)",
          data: [1, 2, 3, 3, 3, 4, 4]
        }
      ]
    },
    {
      label: "Carbohydrates",
      value: sessionStorage.getItem("Carbs"),
      percentage: "3.8%",
      increase: false,
      decrease: true,
      chartLabels: [null, null, null, null, null, null, null],
      attrs: { md: "4", sm: "6" },
      datasets: [
        {
          label: "Fat",
          fill: "start",
          borderWidth: 1.5,
          backgroundColor: "rgba(255,180,0,0.1)",
          borderColor: "rgb(255,180,0)",
          data: [2, 3, 3, 3, 4, 3, 3]
        }
      ]
    },
    // {
    //   label: "New Customers",
    //   value: "29",
    //   percentage: "2.71%",
    //   increase: false,
    //   decrease: true,
    //   chartLabels: [null, null, null, null, null, null, null],
    //   attrs: { md: "4", sm: "6" },
    //   datasets: [
    //     {
    //       label: "Today",
    //       fill: "start",
    //       borderWidth: 1.5,
    //       backgroundColor: "rgba(255,65,105,0.1)",
    //       borderColor: "rgb(255,65,105)",
    //       data: [1, 7, 1, 3, 1, 4, 8]
    //     }
    //   ]
    // },
    // {
    //   label: "Subscribers",
    //   value: "17,281",
    //   percentage: "2.4%",
    //   increase: false,
    //   decrease: true,
    //   chartLabels: [null, null, null, null, null, null, null],
    //   attrs: { md: "4", sm: "6" },
    //   datasets: [
    //     {
    //       label: "Today",
    //       fill: "start",
    //       borderWidth: 1.5,
    //       backgroundColor: "rgb(0,123,255,0.1)",
    //       borderColor: "rgb(0,123,255)",
    //       data: [3, 2, 3, 2, 4, 5, 4]
    //     }
    //   ]
    // }
  ]
};

export default BlogOverview;
