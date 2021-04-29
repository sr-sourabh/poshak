import React from 'react';
import DashboardSidebar from '../components/dashboardSideBar';
import Diet from '../components/Diet';
import TrainerDashboardSidebar from '../components/TrainerdashboardSideBar';

const Trainerdiet = () => {
  return (
    <div  >
      <TrainerDashboardSidebar />
      <Diet />
      
    </div>
  );
};

export default Trainerdiet;