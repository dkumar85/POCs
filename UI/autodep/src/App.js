import React from 'react';
import { BrowserRouter as Router, Route } from "react-router-dom";
import Home from "./components/Home";
import About from "./components/About";
import Signup from "./components/Signup";
import Signin from "./components/Signin";

function App() {
  return (
    <Router>
      <div>
        <Route exact path="/" component={Home}/>
        <Route  path="/about" component={About}/>
        <Route  path="/signin" component={Signin}/>
        <Route  path="/signup" component={Signup}/>
      </div>
    </Router>
  );
}

export default App;
