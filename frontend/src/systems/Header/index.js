import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Root } from './styled';

const Header = () => {

    const navigate = useNavigate();

    const onClickMenu = (type) => () => {
        if(type === 'MAIN'){
            navigate('/main');
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
            <li onClick={onClickMenu('MAIN')} >이수과목체크</li>
            <li onClick={onClickMenu('SIGNUP')} >졸업요건검사</li>
            <li onClick={onClickMenu('LOGIN')} >수강과목추천</li>
            <li onClick={onClickMenu('PASSWORD_CHANGE')} >비밀번호 변경</li>
        </ul></Root>
}

export default Header;