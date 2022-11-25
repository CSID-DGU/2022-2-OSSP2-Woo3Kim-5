import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Root } from './styled';

const Header = () => {

    const navigate = useNavigate();

    const onClickMenu = (type) => () => {
        if(type === 'MAIN'){
            navigate('/');
            return;
        }
        if(type === 'SIGNUP'){
            navigate('/signup');
            return;
        }
        if(type === 'LOGIN'){
            navigate('/login');
            return;
        }
        if(type === 'PASSWORD_CHANGE'){
            navigate('/password-change');
            return;
        }
    }

    return <Root>
        로고
        <ul>
            <li onClick={onClickMenu('MAIN')} >메인</li>
            <li onClick={onClickMenu('SIGNUP')} >회원가입</li>
            <li onClick={onClickMenu('LOGIN')} >로그인</li>
            <li onClick={onClickMenu('PASSWORD_CHANGE')} >비밀번호 변경</li>
        </ul></Root>
}

export default Header;