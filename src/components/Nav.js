import React from "react";
import Logo from "../images/siteImages/logo.png";

function Nav() {
    return (
        <nav>

            
            <a href="#home">
                <img src={Logo} alt="Bike logo" />
            </a>
            <a href="#home">
                Home
            </a>
            <a href="#features">
                Features
            </a>
            <a href="#gallery">
                Gallery
            </a>
            <a href="#download">
                Download
            </a>
            <a href="#contact">
                Contact
            </a>
        </nav>
    )
}

export default Nav;