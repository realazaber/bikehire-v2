import React from 'react';
import GalleryData from './screenshots.json';
import Slide from 'react-reveal/Slide';

function Gallery() {
    return(
        <div id="gallery">
            <h1>
                Gallery
            </h1>

            <div id="galleryImages">
                {GalleryData.map((GalleryDetail, index)=>{
                    return (
                        <Slide bottom>
                            <div className="galleryImage">
                                <a rel="noopener" href={GalleryDetail.img} target="_blank">
                                    <img src={GalleryDetail.img} alt={GalleryDetail.title} />   
                                </a>
                                <p>
                                    {GalleryDetail.title}
                                </p>
                            </div>
                        </Slide>
                    )
                })}
            </div>
        </div>
    );
}

export default Gallery;