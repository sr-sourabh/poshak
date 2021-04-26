import React from "react";
// import "./styles.css";

import GaugeChart from "react-gauge-chart";

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

export default function Bmi() {
  const [bmi, setBmi] = React.useState(parseInt(sessionStorage.getItem("BMI")));

  const handleChangeBmi = event => setBmi(10);

  const gageCalc = bmi => {
    var result = 0;
    if (bmi >= 16 && bmi <= 18.5) {
      result = getPercentage(bmi, 16, 18.5, 0);
    } else if (bmi > 18.5 && bmi < 25) {
      result = getPercentage(bmi, 18.5, 25, 0.33);
    } else if (bmi >= 25 && bmi <= 30) {
      result = getPercentage(bmi, 25, 30, 0.66);
    }
    return result;
  };

  function getPercentage(bmi, lowerBound, upperBound, segmentAdjustment) {
    return (
      (bmi - lowerBound) / (upperBound - lowerBound) / 3 + segmentAdjustment
    );
  }

  return (
    <div>
        <Example label="BMI" description={bmi}>
        </Example>
      <GaugeChart
        id="gauge-chart"
        percent={gageCalc(bmi)}
        nrOfLevels={3}
        colors={["#FFFF00", "#228B22", "#FF0000"]}
      />
    </div>
  );
}