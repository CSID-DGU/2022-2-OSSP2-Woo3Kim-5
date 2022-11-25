import React from 'react';
import './index.css';

const Signup = () => {
  const [email, setEmail] = useState('');
  const [id, setId] = useState('');
  const [password, setPassword] = useState('');
  const [admissionyear, setAdmissionyear] = useState('');
  const [englv, setEnglv] = useState('');
  const [engscore, setEngscore] = useState('');
  const navigate = useNavigate();

  const onSubmit = () => {
    // axios
    // axios.post('/login', {id, password}).then((res) => {
    //   navigate('/')
    // })
    navigate('/');
  }

  return (
    <div className="Signup-form">
      <form>
        <input value={email} onChange={(e) => setEmail(e.target.value)} type="text" className="text-field" placeholder="이메일" /> @ {" "}
        <select name="email_select" className="select">
          <option value='gmail.com'> gmail.com </option>
          <option value='naver.com'> naver.com </option>
          <option value='daum.net'> daum.net </option>
          <option value='hotmail.com'> hotmail.com </option>
          <option value='nate.com'> nate.com </option>
          <option value='dgu.ac.kr'> dgu.ac.kr </option>
          <option value='write'> 직접 입력 </option>
        </select>
        <input onClick={onSubmit} type="submit" value="중복확인" className="submit-btn" /><br />
        <input value={password} onChange={(e) => setPassword(e.target.value)} type="password" className="text-field" placeholder="비밀번호" /><br />
        <input type="password" name="confirmpw" className="text-field" placeholder="비밀번호 확인" /><br />
        <input value={id} onChange={(e) => setId(e.target.value)} type="text" className="text-field" margin-left="20px" placeholder="학번" /> {" "}
        <input value={admissionyear} onChange={(e) => setAdmissionyear(e.target.value)} type="text"className="text-field" placeholder="입학년도" /><br />
        <p>수강영어레벨</p>
        <select value={Englv} onChange={(e) => setEnglv(e.target.value)} className="select">
          <option key="basic">선택</option>
          <option key="s0">S0</option>
          <option key="s1">S1</option>
          <option key="s2">S2</option>
          <option key="s3">S3</option>
          <option key="s4">S4</option>
        </select>
        <br /><br />
        <input value={engscore} onChange={(e) => setEngscore(e.target.value)} type="text" className="text-field" placeholder="외국어성적(토익)" />
        <p>복수전공여부</p>
        <select name="minor" className="select">
          <option key="basic">선택</option>
          <option key="minory">예</option>
          <option key="minorn">아니오</option>
        </select>
        <br /><br /><br />
        <input onClick={onSubmit} type="submit" value="회원가입" className="submit-btn" />
      </form>
    </div>
  )
}

export default Signup;