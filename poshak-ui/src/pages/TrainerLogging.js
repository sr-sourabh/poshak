import React from 'react';
import DashboardSidebar from '../components/dashboardSideBar';
import SearchComp from '../components/searchcomponent';
import TrainerDashboardSidebar from '../components/TrainerdashboardSideBar';

const TrainerLogging = () => {
  return (
    <div  >
      <TrainerDashboardSidebar />
      <SearchComp />
      
    </div>
  );
};

export default TrainerLogging;