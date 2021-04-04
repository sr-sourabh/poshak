import React from 'react'
import { FaFacebook, FaInstagram, FaLinkedin, FaTwitter, FaYoutube } from 'react-icons/fa';
import {animateScroll as scroll} from 'react-scroll'

import {
    FooterContainer,
    FooterWrap,
    FooterLinksContainer,
    FooterLinksWrappper,
    FooterLinkItems,
    FooterLinkTitle,
    FooterLink,
    SocialMedia,
    SocialMediaWrap,
    SocialLogo,
    WebsiteRights,
    SocialIcons,
    SocialIconLink
} from './FooterElements';



const Footer = () => {

    const toggleHome = () => {
        scroll.scrollToTop();
      }

    return (
        <FooterContainer>
            <FooterWrap>
                <FooterLinksContainer>
                    <FooterLinksWrappper>
                        <FooterLinkItems>
                            <FooterLinkTitle>   About us   </FooterLinkTitle>
                            <FooterLink to="/signin"> How it works </FooterLink>
                            <FooterLink to="/signin"> Testimonials </FooterLink>
                            <FooterLink to="/signin"> Career </FooterLink>
                            <FooterLink to="/signin"> Investors </FooterLink>
                            <FooterLink to="/signin"> Terms of Service </FooterLink>
                        </FooterLinkItems>
                        <FooterLinkItems>
                            <FooterLinkTitle>   Contact us   </FooterLinkTitle>
                            <FooterLink to="/signin"> How it works </FooterLink>
                            <FooterLink to="/signin"> Testimonials </FooterLink>
                            <FooterLink to="/signin"> Career </FooterLink>
                            <FooterLink to="/signin"> Investors </FooterLink>
                            <FooterLink to="/signin"> Terms of Service </FooterLink>
                        </FooterLinkItems>
                    </FooterLinksWrappper>

                    <FooterLinksWrappper>
                        <FooterLinkItems>
                            <FooterLinkTitle>   Videos  </FooterLinkTitle>
                            <FooterLink to="/signin"> How it works </FooterLink>
                            <FooterLink to="/signin"> Testimonials </FooterLink>
                            <FooterLink to="/signin"> Career </FooterLink>
                            <FooterLink to="/signin"> Investors </FooterLink>
                            <FooterLink to="/signin"> Terms of Service </FooterLink>
                        </FooterLinkItems>
                        <FooterLinkItems>
                            <FooterLinkTitle> Social Media </FooterLinkTitle>
                            <FooterLink to="/signin"> FaceBook</FooterLink>
                            <FooterLink to="/signin"> Instagram </FooterLink>
                            <FooterLink to="/signin"> Youtube </FooterLink>
                            <FooterLink to="/signin"> Twitter </FooterLink>
                            <FooterLink to="/signin"> Terms of Service </FooterLink>
                        </FooterLinkItems>
                    </FooterLinksWrappper>
                </FooterLinksContainer>
                <SocialMedia>
                    <SocialMediaWrap>
                        <SocialLogo to='/' onClick={toggleHome}>
                            Poshak
                        </SocialLogo>
                        <WebsiteRights> poshak © {new Date().getFullYear()} All rights reserved.</WebsiteRights>
                        <SocialIcons>
                            <SocialIconLink href="/" target="_black" aria-label="Facebook">
                                <FaFacebook />
                            </SocialIconLink>
                            <SocialIconLink href="/" target="_black" aria-label="Instagram">
                                <FaInstagram />
                            </SocialIconLink>
                            <SocialIconLink href="/" target="_black" aria-label="Linkedin">
                                <FaLinkedin />
                            </SocialIconLink>
                            <SocialIconLink href="/" target="_black" aria-label="Youtube">
                                <FaYoutube />
                            </SocialIconLink>
                            <SocialIconLink href="/" target="_black" aria-label="Twitter">
                                <FaTwitter />
                            </SocialIconLink>
                        </SocialIcons>

                    </SocialMediaWrap>
                </SocialMedia>
            </FooterWrap>
        </FooterContainer>
    )
}

export default Footer;
