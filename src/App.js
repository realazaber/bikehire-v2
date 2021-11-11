import "./css/main.css";

import Nav from "./components/Nav";
import Home from "./components/Home";
import Features from "./components/Features/Features";
import Gallery from "./components/Gallery/Gallery";
import Download from "./components/Download";
import Contact from "./components/Contact";


function App() {
  return (
    <>
      <Nav />
      <Home />
      <Features />
      <Gallery />
      <Download />
      <Contact />

    </>
  );
}

export default App;
