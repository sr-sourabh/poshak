import React, { Component } from 'react';
import Chart from '../components/Charts/chart';

class Report2 extends Component {
    constructor(){
      super();
      this.state = {
        chartData:{}
      }
    }
  
    componentWillMount(){
     // this.getchartData(); // this should be this.getChartData();
      this.getChartData();
    }
  
    getChartData(){
      // Ajax calls here
      this.setState({
        chartData:{
          labels: ['Calorie', 'Protien', 'fat', 'satFat', 'fibre', 'carbs'],
          datasets:[
            {
              label:'Macronutrients',
              data:[
                2000,
                1500,
                500,
                100,
                700,
                250
              ],
              backgroundColor:[
                'rgba(255, 99, 132, 0.6)',
                'rgba(54, 162, 235, 0.6)',
                'rgba(255, 206, 86, 0.6)',
                'rgba(75, 192, 192, 0.6)',
                'rgba(153, 102, 255, 0.6)',
                'rgba(255, 159, 64, 0.6)',
                'rgba(255, 99, 132, 0.6)'
              ]
            }
          ]
        }
      });
    }
  
    render() {
      return (
        <div >
          <Chart chartData={this.state.chartData} location="weekly" legendPosition="bottom"/>
        </div>
      );
    }
  }
  
  export default Report2;