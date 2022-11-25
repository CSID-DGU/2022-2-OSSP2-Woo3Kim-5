import React from 'react';
import './index.css';

const Signup = () => {
  return (
    <div className="Signup-form">
      <form>
        <input type="text" name="email" className="text-field" placeholder="이메일" onChange={() => this._changeEmailSelect()} /> @ {" "}
        <select name="email_select" className="select">
          <option value='gmail.com'> gmail.com </option>
          <option value='naver.com'> naver.com </option>
          <option value='daum.net'> daum.net </option>
          <option value='hotmail.com'> hotmail.com </option>
          <option value='nate.com'> nate.com </option>
          <option value='dgu.ac.kr'> dgu.ac.kr </option>
          <option value='write'> 직접 입력 </option>
        </select>
        <input type="submit" value="중복확인" className="submit-btn" /><br />
        <input type="password" name="pw" className="text-field" placeholder="비밀번호" /><br />
        <input type="password" name="confirmpw" className="text-field" placeholder="비밀번호 확인" /><br />
        <input type="text" name="id" className="text-field" margin-left="20px" placeholder="학번" /> {" "}
        <input type="text" name="admissionyear" className="text-field" placeholder="입학년도" /><br />
        <p>수강영어레벨</p>
        <select name="englv" className="select">
          <option key="basic">선택</option>
          <option key="s0">S0</option>
          <option key="s1">S1</option>
          <option key="s2">S2</option>
          <option key="s3">S3</option>
          <option key="s4">S4</option>
        </select>
        <br /><br />
        <input type="text" name="eng" className="text-field" placeholder="외국어성적(토익)" />
        <p>복수전공여부</p>
        <select name="minor" className="select">
          <option key="basic">선택</option>
          <option key="minory">예</option>
          <option key="minorn">아니오</option>
        </select>
        <br /><br /><br />
        <input type="submit" value="회원가입" className="submit-btn" />
      </form>
    </div>
  )
}

export default Signup;