import React from 'react';
import Icon1 from '../../images/svg-2.svg';
import Icon2 from '../../images/svg-3.svg';
import Icon3 from '../../images/svg-4.svg';

import {
    ServicesContainer,
    ServicesH1,
    ServicesWrapper,
    ServicesCard,
    ServicesIcon,
    ServicesH2,
    ServicesP
} from './ServicesElements';

const Services = () => {
    return (
        <ServicesContainer id="services">
            <ServicesH1>Our Services</ServicesH1>
            <ServicesWrapper>
                <ServicesCard>
                    <ServicesIcon src={Icon1}/>
                    <ServicesH2>Reduce Calorie</ServicesH2>
                    <ServicesP> We help you in managing your calorie intake and help you in keeping a balanced diet </ServicesP>
                </ServicesCard>
                <ServicesCard>
                    <ServicesIcon src={Icon2}/>
                    <ServicesH2>Virtual</ServicesH2>
                    <ServicesP>Access our platform from anywhere, all you need is an internet connection </ServicesP>
                </ServicesCard>
                <ServicesCard>
                    <ServicesIcon src={Icon3}/>
                    <ServicesH2>Premium Benefits</ServicesH2>
                    <ServicesP> Generate reports and track all your calories along with both the macro & micro nutrients.</ServicesP>
                </ServicesCard>
            </ServicesWrapper>
        </ServicesContainer>
    )
}

export default Services;
