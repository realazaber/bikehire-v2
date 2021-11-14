import "./css/main.css";

import React from "react";

import Nav from "./components/Nav";
import Home from "./components/Home";
import Features from "./components/Features/Features";
import Gallery from "./components/Gallery/Gallery";
import Download from "./components/Download";
import Contact from "./components/Contact";


function App() {
  return (
    <div>
      <Nav />
      <Home />
      <Gallery />
      <Features />
      
      <Download />
      <Contact />
    </div>
  );
}

export default App;
