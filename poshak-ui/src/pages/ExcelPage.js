import React from 'react';
import DashboardSidebar from '../components/dashboardSideBar';
import Excel from '../components/ExcelRead';
import TrainerDashboardSidebar from '../components/TrainerdashboardSideBar';

const ExcelLoad = () => {
  return (
    <div  >
    <TrainerDashboardSidebar/>
      <Excel />
      
    </div>
  );
};

export default ExcelLoad;