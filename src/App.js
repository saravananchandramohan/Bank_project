import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Login from "./Login";
import MainMenu from "./MainMenu";
const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/main_menu" element={<MainMenu />} />
      </Routes>
    </Router>
  );
};

export default App;
