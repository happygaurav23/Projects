import React from "react";
import logo from './logo.svg';

export default function Navbar(){
    return (
        <nav>
            <img src={logo} className="App-logo" alt="logo" />
            <h3 className="logo-text">React Facts</h3>
            <h4 className="nav-title">React Course - Project 1</h4>
        </nav>
    )
}