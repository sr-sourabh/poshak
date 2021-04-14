import React from 'react';
import DashboardSidebar from '../components/dashboardSideBar'
import Chart from "../components/Charts/chart"

export const Reports = () => {
  return (
      <>
        <DashboardSidebar />
        <div className='reports'>
            <h1>Reports</h1>
        </div>
      </>
    
  );
};

export const ReportsOne = () => {
  return (
    <>
     <DashboardSidebar />
     <Chart />     
     <div className='reports'>
        <h1>Reports/reports1</h1>
      </div>
    </>
    
  );
};

export const ReportsTwo = () => {
  return (
    <>
      <DashboardSidebar />
    <div className='reports'>
      <h1>Reports/reports2</h1>
    </div>
    </>
    
  );
};

export const ReportsThree = () => {
  return (
    <>
      <DashboardSidebar />
      <div className='reports'>
        <h1>Reports/reports3</h1>
      </div>

    </>
    
  );
};