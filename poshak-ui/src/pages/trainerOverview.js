import React from 'react'
import BlogOverview from '../components/Dashboard/index'

import "bootstrap/dist/css/bootstrap.min.css";
import "../components/Dashboard/shards-dashboard/styles/shards-dashboards.1.1.0.min.css";
import "../css/overview.css";
import TrainerDashboardSidebar from '../components/TrainerdashboardSideBar';

const TrainerOverview = () => {
    return (
        <>
            <TrainerDashboardSidebar />
            <div className="nav-expanded">
                <BlogOverview />
            </div>
        </>
        
    )
}

export default TrainerOverview;

