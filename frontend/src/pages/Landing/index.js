import React from "react";
import Header from "../../systems/Header";
import './index.css';

const Landing = () => {
  return (
    <div className="Landingpage">
      <Header />
      <div className="side">
        <div className="login">
          <a href="/" className="logo">
            <img src="/testlogo.png" alt="로고"></img>
          </a>
          <a href="/Signin" className="button login">로그인</a>
          <a href="/RegisterPage" className="button register">회원가입</a>
          <p className="find">
            <a href="/passwordchange">아이디/비밀번호 찾기</a>
          </p>
        </div>
      </div>
    </div>
  );
}

export default Landing;