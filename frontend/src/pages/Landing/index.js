import React from "react";
import './index.css';

const Landing = () => {
  return (
    <div className="Landingpage">
      <div className="side">
        <div className="login">
          <a href="/" className="logo">
            <img src="/testlogo.png" alt="로고"></img>
          </a>
          <a href="/Signin" className="button login">로그인</a>
          <a href="/RegisterPage" className="button register">회원가입</a>
          <p className="find">
            <a href="/password-change">아이디/비밀번호 찾기</a>
          </p>
        </div>
      </div>
    </div>
  );
}

export default Landing;