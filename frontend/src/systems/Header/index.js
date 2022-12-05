/*mport React from 'react'
import { useNavigate } from 'react-router-dom';
import { Root, LogoImg } from './styled';
import logo from '../../assets/images/logo.png';


const Header = () => {

    const navigate = useNavigate();

    const onClickMenu = (type) => () => {
        if(type === 'LOGO'){
            navigate('/main');
            return;
        }
        if(type === 'CHECK'){
            navigate('/subject-check');
            return;
        }
        if(type === 'TEST'){
            navigate('/test');
            return;
        }
        if(type === 'RECOMMEND'){
            navigate('/recommend');
            return;
        }
        if(type === 'MYPAGE'){
            navigate('/mypage');
            return;
        }
    }

    return <Root>
        <LogoImg src={logo} onClick={onClickMenu('LOGO')}/>
            <div onClick={onClickMenu('CHECK')} >이수과목체크</div>
            <div onClick={onClickMenu('TEST')} >졸업요건검사</div>
            <div onClick={onClickMenu('RECOMMEND')} >수강과목추천</div>
            <div onClick={onClickMenu('MYPAGE')} >마이페이지</div>
        </Root>
}

export default Header;*/

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
                    <button>로그인/회원가입</button>
                </ul>
            </nav>
        );
    }
}

export default Navbar;
