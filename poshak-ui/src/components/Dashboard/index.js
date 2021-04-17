import React from "react";
import PropTypes from "prop-types";
import { Container, Row, Col } from "shards-react";
import "./dashboardStyles.css"
import PageTitle from "./dashboardComponents/PageTitle";
import SmallStats from "./dashboardComponents/SmallStats";
import UsersByDevice from "./dashboardComponents/UsersByDevice";
import Nutrients from "./dashboardComponents/nutrients";

import {
  CircularProgressbar,
  CircularProgressbarWithChildren,
  buildStyles
} from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
const percentage = 66;

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


const BlogOverview = ({ smallStats }) => (
  <Container fluid className="main-content-container px-4">
    {/* Page Header */}
    <Row noGutters className="page-header py-4">
      <PageTitle title="Your Nutrition Overview" subtitle="Dashboard" className="text-sm-left mb-3" />
      </Row>
    <Row>
      <Col>
        <a href="logging" className="button3" >Log my meal</a>
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
        <Example label="Total Calories" description="Today">
          <CircularProgressbarWithChildren value={66} strokeWidth={5}>
            {/* Put any JSX content in here that you'd like. It'll be vertically and horizonally centered. */}
            <div style={{ fontSize: 12, marginTop: 25 , marginBottom:-3}}>
              <p><b>2000</b> cal</p>
            </div>
            <div style={{ fontSize: 12, marginTop: -5 }}>
              <p>{percentage}% of Goal</p>
            </div>
          </CircularProgressbarWithChildren>
        </Example>
      </Col>
      <Col>
        <Example label="Macronutrients Goals" >
          <CircularProgressbarWithChildren
              value={80}
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
                  value={75}
                  strokeWidth={5}
                  counterClockwise
                  styles={buildStyles({
                    pathColor: "#80dfff",
                    strokeLinecap: "round"
                  })}
              >
                <div style={{ width: "78%" }}>
                  <CircularProgressbarWithChildren
                      value={60}
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
      value: "2,390",
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
      value: "182",
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
      value: "8,147",
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
