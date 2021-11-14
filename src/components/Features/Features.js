import React from 'react';
import FeaturesData from './features.json';

function Features() {
    return(
        <div>
        <div id="features">
            
            <h1 id="featuresTitle">
                Features
            </h1>

            {FeaturesData.map((FeatureDetail, index)=>{

                if (index % 2 === 0) {
                        return  (                    
                        <div className="feature">
                            <img src={FeatureDetail.img} alt={FeatureDetail.title} />
                            
                            
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

                            <img src={FeatureDetail.img} alt={FeatureDetail.title}/>

                            
                        </div>
                    )
                }
            })}
        </div>
        </div>
    );
}

export default Features;