import React from 'react';
import Header from '../../systems/Header';
import './index.css';

function PasswordChange(props){
    return(
        <div className="register-form">
          <Header />
          <form>
            <h2>아이디/비밀번호 찾기</h2><br/>
            <h3><b>아이디 찾기</b></h3>
            학번<br/>
              <input type="text" name="id" className="text-field" margin-left="100px"/> {" "}
              <input type="submit" value="제출" className="submit-btn"/>

            <h3><b>비밀번호 찾기</b></h3>
            이메일<br/>
              <input type="text" name="email" className="text-field" onChange={() => this._changeEmailSelect()} /> {" "}
              <input type="submit" value="코드전송" className="submit-btn"/><br/>
            코드<br/>
              <input type="text" name="code" className="text-field"/> {" "}
              <input type="submit" value="확인" className="submit-btn"/> {" "}
              <input type="submit" value="재전송" className="submit-btn"/><br/>
            새비밀번호<br/>
              <input type="password" name="pw" className="text-field"/><br/>
            비밀번호확인<br/>
              <input type="password" name="confirmpw" className="text-field"/> {" "}
              <input type="submit" value="변경" className="submit-btn"/>
        </form>
      </div>
      )
}

export default PasswordChange;