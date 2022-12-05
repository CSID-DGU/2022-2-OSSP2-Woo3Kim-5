import React from 'react'
import { useNavigate } from 'react-router-dom';
import { Root, LogoImg } from './styled';
import logo from '../../assets/images/logo.png';


const Header = () => {

    const navigate = useNavigate();

    const onClickMenu = (type) => () => {
        if(type === 'LOGO'){
            navigate('/main');
            return;
        }
        if(type === 'CHECK'){
            navigate('/subject-check');
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
        if(type === 'MYPAGE'){
            navigate('/mypage');
            return;
        }
    }

    return <Root>
        <LogoImg src={logo} onClick={onClickMenu('LOGO')}/>
            <div onClick={onClickMenu('CHECK')} >이수과목체크</div>
            <div onClick={onClickMenu('TEST')} >졸업요건검사</div>
            <div onClick={onClickMenu('RECOMMEND')} >수강과목추천</div>
            <div onClick={onClickMenu('MYPAGE')} >마이페이지</div>
        </Root>
}

export default Header;