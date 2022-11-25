import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Header from "../../systems/Header";
import './index.css';

const Login = () => {
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const navigate = useNavigate();

  const onSubmit = () => {
    // axios
    // axios.post('/login', {id, password}).then((res) => {
    //   navigate('/')
    // })
    navigate('/');
  }

  return (
    <div className="login-form">
      <Header />
      <input value={id} onChange={(e) => setId(e.target.value)} type="text" class="text-field" placeholder="아이디" />
      <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" class="text-field" placeholder="비밀번호" />
      <input onClick={onSubmit} type="submit" value="로그인" class="submit-btn" />
      <div class="links">
        <a href="#">아이디/비밀번호 찾기</a>
      </div>
    </div>
  );
}

export default Login;