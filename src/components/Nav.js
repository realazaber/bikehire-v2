import React from "react";
import Logo from "../images/siteImages/logo.png";

function Nav() {
    return (
        <nav>

            
            <a rel="noopener" href="#home">
                <img src={Logo} alt="Bike logo" />
            </a>
            <a rel="noopener" href="#home">
                Home
            </a>
            <a rel="noopener" href="#gallery">
                Gallery
            </a>
            <a rel="noopener" href="#features">
                Features
            </a>
            <a rel="noopener" href="#download">
                Download
            </a>
            <a rel="noopener" href="#contact">
                Contact
            </a>
        </nav>
    )
}

export default Nav;