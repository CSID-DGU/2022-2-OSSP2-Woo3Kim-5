import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Root } from './styled';

const Header = () => {

    const navigate = useNavigate();

    const onClickMenu = (type) => () => {
        if(type === 'CHECK'){
            navigate('/check');
            return;
        }
        if(type === 'TEST'){
            navigate('/test');
            return;
        }
        if(type === 'RECOMMEND'){
            navigate('/recommend');
            return;
        }
        if(type === 'MAINPAGE'){
            navigate('/mainpage');
            return;
        }
    }

    return <Root>
        로고
        <ul>
            <li onClick={onClickMenu('CHECK')} >이수과목체크</li>
            <li onClick={onClickMenu('TEST')} >졸업요건검사</li>
            <li onClick={onClickMenu('RECOMMEND')} >수강과목추천</li>
            <li onClick={onClickMenu('MAINPAGE')} >비밀번호 변경</li>
        </ul></Root>
}

export default Header;