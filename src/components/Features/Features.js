import React from 'react';
import FeaturesData from './features.json';

import Slide from 'react-reveal/Slide';

function Features() {
    return(
        <div>
        <div id="features">
            
            <h1 id="featuresTitle">
                Features
            </h1>

            {FeaturesData.map((FeatureDetail, index)=>{


                //Desktop
                if (screen.width >= 1024) {
                    if (index % 2 === 0) {
                        return  (                    
                        <div className="feature">
                            <Slide left>
                                <img src={FeatureDetail.img} alt={FeatureDetail.title} />
                            </Slide>
                            
                            <Slide right>
                                <div className="featureText featureTextLeft">
                                    <h1>
                                        {FeatureDetail.title}
                                    </h1>
                                    <p>
                                        {FeatureDetail.description}
                                    </p>
                                </div>
                            </Slide>

                            
                        </div>
                    )
                    }
                    else {
                        return  (                    
                            <div className="feature">
                                
                                <Slide left>
                                    <div className="featureText featureTextRight">
                                        <h1>
                                            {FeatureDetail.title}
                                        </h1>
                                        <p>
                                            {FeatureDetail.description}
                                        </p>
                                    </div>
                                </Slide>

                                <Slide right>
                                    <img src={FeatureDetail.img} alt={FeatureDetail.title}/>
                                </Slide>
                                
                            </div>
                        )
                    }
                }
                //Mobile
                else {
                    return  (                    
                        <div className="feature">
                            <Slide bottom>
                                <div className="featureText">
                                    <h1>
                                        {FeatureDetail.title}
                                    </h1>
                                    <p>
                                        {FeatureDetail.description}
                                    </p>
                                </div>
                            </Slide>
                            <Slide bottom>
                                <img src={FeatureDetail.img} alt={FeatureDetail.title} />
                            </Slide>
                            
                        </div>
                        )
                    }
                
            })}
        </div>
        </div>
    );
}

export default Features;