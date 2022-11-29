package com.Woo3Kim.graduation.service;

import com.Woo3Kim.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
     * 회원가입
     */

    /*
     * 아이디 찾기
     */

    //비밀번호 찾기

    //로그인
}
