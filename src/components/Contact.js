import React from 'react';

import javaSwingImg from '../images/siteImages/javaSwing.jpg';

function Contact() {
    return(
        <div id="contactContainer">
            <div id="contactHeading">
                <h1>
                    Contact me
                </h1>
                <h2>
                    Have any questions, feedback or just want to 
                    get in touch? 
                </h2>
            </div>
            <div id="contact">
                <form action="https://formspree.io/f/mpzkvdkp" method="post">

                    <div id="contactStart">
                        <div>
                            <label for="name">Name: <b>*</b></label>
                            <br />
                            <input id="name" name="Name:" type="text" required></input>    
                        </div>
                        
                        <div>                                                    
                            <label for="email">Email: <b>*</b></label>
                            <br />
                            <input id="email" name="Email:" type="email" required></input>
                        </div>
                    </div>

                    <br />
                    <label for="message">Message: <b>*</b></label>
                    <textarea id="message" name="Message:" cols="43" rows="10"></textarea>

                    <br />
                    <button type="submit">Submit</button>
                </form>
                <div id="programDetails">
                    <h2>
                        Made with Java Swing library
                    </h2>
                    <img height="350px" width="450px" src={javaSwingImg} alt="Java swing"/>
                </div>
            </div>
        </div>
    );
}

export default Contact;