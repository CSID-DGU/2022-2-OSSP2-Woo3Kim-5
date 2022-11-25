import React from "react";
import './index.css';

function Login(props){
    return(
        <div className="login-form">
            <form>
                <input type="text" name="id" class="text-field" placeholder="아이디"/>
                <input type="text" name="pw" class="text-field" placeholder="비밀번호"/>
                <input type="submit" value="로그인" class="submit-btn"/>
            </form>
            <div class="links">
                <a href="#">아이디/비밀번호 찾기</a>
            </div>
        </div>
    );
}

export default Login;