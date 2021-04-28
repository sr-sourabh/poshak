import React from 'react';
import DashboardSidebar from '../components/dashboardSideBar';
import SearchComp from '../components/searchcomponent';
import TrainerDashboardSidebar from '../components/TrainerdashboardSideBar';
import UpdateData from '../components/Update'

const TrainerUpdate = () => {
  return (
    <div  >
      <TrainerDashboardSidebar />
      <UpdateData />
      
    </div>
  );
};

export default TrainerUpdate;