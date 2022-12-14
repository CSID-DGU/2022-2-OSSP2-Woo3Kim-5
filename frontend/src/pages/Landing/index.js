import React from "react";
import './index.css';
import logo1 from '../../assets/images/logo.png';

const Landing = () => {

  return (
    <div className="side">
      <div className="login">
        <a href="/" className="logo">
          <img src={logo1} alt="로고"></img>
        </a>
        <a href="/login" className="button login">로그인</a>
        <a href="/signup" className="button register">회원가입</a>
        <p className="find">
          <a href="/password-change">아이디/비밀번호 찾기</a>
        </p>
      </div>
    </div>
  );
}

export default Landing;