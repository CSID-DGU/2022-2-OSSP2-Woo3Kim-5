import React, { Component } from "react";
import { HeaderCategory } from "./HeaderCategory";
import "./HeaderStyle.css";

class Navbar extends Component {
    state = { clicked: false };
    handleClick = () => {
        this.setState({ clicked: !this.state.clicked });
    };

    render() {
        return (
            <nav className="HeaderCategory">
                <h1 className="Header-logo">
                    Woo3Kim <i className="fab fa-logo"></i>
                </h1>
                <ul
                    className={this.state.clicked ? "header-menu active" : "header-menu"}
                >
                    {HeaderCategory.map((item, index) => {
                        return (
                            <li key={index}>
                                <a className={item.cName} href={item.url}>
                                    {item.title}
                                </a>
                            </li>
                        );
                    })}
                    <button>로그아웃</button>
                </ul>
            </nav>
        );
    }
}

export default Navbar;
