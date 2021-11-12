import React from 'react';
import FeaturesData from './features.json';



function Features() {
    return(
        <div id="features">
            {FeaturesData.map((FeatureDetail, index)=>{

                if (index % 2 == 0) {
                        return  (                    
                        <div className="feature">
                            <img src={FeatureDetail.img} />
                            
                            <div className="featureText featureTextLeft">
                                <h1>
                                    {FeatureDetail.title}
                                </h1>
                                <p>
                                    {FeatureDetail.description}
                                </p>
                            </div>

                            
                        </div>
                    )
                }
                else {
                    return  (                    
                        <div className="feature">
                            
                            
                            <div className="featureText featureTextRight">
                                <h1>
                                    {FeatureDetail.title}
                                </h1>
                                <p>
                                    {FeatureDetail.description}
                                </p>
                            </div>

                            <img src={FeatureDetail.img} />

                            
                        </div>
                    )
                }
                


                
                
            })}
        </div>
    );
}

export default Features;