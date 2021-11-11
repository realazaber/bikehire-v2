import React from 'react';
import FeaturesData from './features.json';

function Features() {
    return(
        <div id="features">
            {FeaturesData.map((FeatureDetail, index)=>{
                return  (
                    <div className="feature">
                        <h1>
                            {FeatureDetail.title}
                        </h1>
                        <p>
                            {FeatureDetail.description}
                        </p>
                    </div>
                )
            })}
        </div>
    );
}

export default Features;