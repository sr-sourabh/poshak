import React, { useState } from 'react';
import styled from 'styled-components';
import { Link } from 'react-router-dom';
import * as FaIcons from 'react-icons/fa';
import * as AiIcons from 'react-icons/ai';
import {SidebarData} from './dashboardSidebarData'
import SubMenu from './dashboardSubMenu'
import { IconContext } from 'react-icons/lib';
import {Link as LinkR} from 'react-router-dom'


const Nav = styled.div`
  background: #15171c;
  height: 80px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;

const NavIcon = styled(Link)`
  margin-left: 2rem;
  font-size: 2rem;
  height: 80px;
  display: flex;
  justify-content: flex-start;
  align-items: center;
`;

const SidebarNav = styled.nav`
  background: #15171c;
  width: 250px;
  height: 100vh;
  display: flex;
  justify-content: center;
  position: fixed;
  top: 0;
  left: ${({ sidebar }) => (sidebar ? '0' : '-100%')};
  transition: 350ms;
  z-index: 10;
`;

const SidebarWrap = styled.div`
  width: 100%;
`;

const NavBtn =styled.nav`

display: flex;

align-items: center;

@media screen and (max-width: 768px) {
    display: none;
}
`;

const NavBtnLink = styled(LinkR)`
border-radius: 50px;
background: #01bf71;
white-space: nowrap;
padding: 10px 22px;
color: #010606;
font-size: 16px;
outline: none;
cursor: pointer;
transition: all 0.2s ease-in-out;
text-decoration: none;
position: fixed;
right: 7rem;

&:hover {
    transition: all 0.2s ease-in-out;
    background: #fff;
    color: #010606;
}

`;


const TrainerDashboardSidebar = () => {

    const [sidebar, setSidebar] = useState(false);
    const showSidebar = () => setSidebar(!sidebar);

    async function handleSubmit(e) {
      e.preventDefault();
      sessionStorage.setItem("isLoggedIn", "false");
          document.location = `/`;


  }

    return (
        <>
      <IconContext.Provider value={{ color: '#fff' }}>
        <Nav>
          <NavIcon to='#'>
            <FaIcons.FaBars onClick={showSidebar} />
            
          </NavIcon>
          <NavBtn>
                  <NavBtnLink onClick={handleSubmit}>Sign Out</NavBtnLink>
        </NavBtn>
          
        </Nav>
        
        <SidebarNav sidebar={sidebar}>
          <SidebarWrap>
            <NavIcon to='#'>
              <AiIcons.AiOutlineClose onClick={showSidebar} />
            </NavIcon>
            {SidebarData.map((item, index) => {
              return <SubMenu item={item} key={index} />;
            })}
          </SidebarWrap>
          
        </SidebarNav>
        
      </IconContext.Provider>
    </>
    )
}

export default TrainerDashboardSidebar ;
