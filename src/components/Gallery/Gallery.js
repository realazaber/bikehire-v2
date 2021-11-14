import React from 'react';
import GalleryData from './screenshots.json';
function Gallery() {
    return(
        <div id="gallery">
            <h1>
                Gallery
            </h1>

            <div id="galleryImages">
                {GalleryData.map((GalleryDetail, index)=>{
                    return (
                        <div className="galleryImage">
                            <a href={GalleryDetail.img} target="_blank">
                                <img src={GalleryDetail.img} alt={GalleryDetail.title} />   
                            </a>
                            <p>
                                {GalleryDetail.title}
                            </p>
                        </div>
                    )
                })}
            </div>
        </div>
    );
}

export default Gallery;