import React from 'react'
import BlogOverview from '../components/Dashboard/index'
import DashboardSidebar from '../components/dashboardSideBar'

import "bootstrap/dist/css/bootstrap.min.css";
import "../components/Dashboard/shards-dashboard/styles/shards-dashboards.1.1.0.min.css";
import "../css/overview.css";

const Overview = () => {
    return (
        <>
            <DashboardSidebar />
            <div className="nav-expanded">
                <BlogOverview />
            </div>
        </>
        
    )
}

export default Overview;

