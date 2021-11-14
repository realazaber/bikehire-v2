import React from 'react';
import GalleryData from './screenshots.json';
import Slide from 'react-reveal/Slide';
import Fade from 'react-reveal/Fade';

function Gallery() {
    return(
        <div id="gallery">
            <h1>
                Gallery
            </h1>

            <div id="galleryImages">
                {GalleryData.map((GalleryDetail, index)=>{

                    //Desktop
                    if (screen.width >= 1024) {
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
                    }
                    //Mobile
                    else {
                        return (
                            <Fade bottom>
                                <div className="galleryImage">
                                    <a rel="noopener" href={GalleryDetail.img} target="_blank">
                                        <img src={GalleryDetail.img} alt={GalleryDetail.title} />   
                                    </a>
                                    <p>
                                        {GalleryDetail.title}
                                    </p>
                                </div>
                            </Fade>
                        )
                    }




                })}
            </div>
        </div>
    );
}

export default Gallery;