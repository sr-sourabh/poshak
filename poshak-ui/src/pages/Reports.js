import React from 'react';
import DashboardSidebar from '../components/dashboardSideBar'
import Chart from "../components/Charts/chart"
import Report1 from './report1';
import Report2 from './report2';
import Report3 from './report3';

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
     <div className='reports'>
        <Report1 />
      </div>
    </>
    
  );
};

export const ReportsTwo = () => {
  return (
    <>
     <DashboardSidebar />  
     <div className='reports'>
        <Report2 />
      </div>
    </>
    
  );
};

export const ReportsThree = () => {
  return (
    <>
     <DashboardSidebar />  
     <div className='reports'>
        <Report3 />
      </div>
    </>
    
  );
};