import './App.css';
import React from 'react'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Home from './pages'
import SigninPage from './pages/signin';
import SignupPage from './pages/signup';
import DashboardPage from './pages/dashboard'
import Overview from './pages/Overview'
import UserProfilePage from './pages/UserPersonalInfo';
import {Reports, ReportsOne, ReportsThree, ReportsTwo} from './pages/Reports';
import Logging from './pages/logging';
import { ProtectedRoute } from "./protected.route";
import Admin from "./pages/admin";
import Update from "./pages/update"
import ExcelLoad from './pages/ExcelPage';
import diet from './pages/diet';

function App() {
  return (
    <Router>
      <Switch>
        <Route path='/' component = {Home} exact/>
        <Route path='/signin' component = {SigninPage} exact/>
        <Route path='/signup' component = {SignupPage} exact/>
        <Route path='/userPersonalInfo' component = {UserProfilePage} exact/>
        <Route path='/dashboard' component = {DashboardPage} exact/>
        <ProtectedRoute path='/overview' component = {Overview} exact/>
        <Route path='/reports' exact component={Reports} />
        <Route path='/reports/reports1' exact component={ReportsOne} />
        <Route path='/reports/reports2' exact component={ReportsTwo} />
        <Route path='/reports/reports3' exact component={ReportsThree} />
        <Route path='/logging' exact component={Logging} />
        <Route path='/update' exact component={Update} />
        <Route path='/admin' exact component={Admin}/>
        <Route path='/excel' exact component={ExcelLoad}/>
        <Route path='/diet' exact component={diet}/>
      </Switch>
    </Router>
  );
}

export default App;
