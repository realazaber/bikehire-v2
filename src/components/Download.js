import React from 'react';

function Download() {
    return(
        
        <div>
            <svg className="wave" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#1888BF" fillOpacity="1" d="M0,192L1440,320L1440,320L0,320Z"></path></svg>

            <div id="download">
                <h1>
                    Download
                </h1>
                <h3>
                    You can either download the jar file of the program or
                    the source code.
                </h3>
                <div id="downloadLinks">
                    <a href="https://github.com/therealcoolpup/bikehire-v2/releases/tag/major-release" target="_blank">
                        Jar file
                    </a>
                    <a href="https://github.com/therealcoolpup/bikehire-v2" target="_blank">
                        Source code
                    </a>
                </div>

            </div>

            <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320"><path fill="#1888BF" fillOpacity="1" d="M0,192L1440,32L1440,0L0,0Z"></path></svg>
        </div>
    );
}

export default Download;