package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //회원가입
    @PostMapping("/join")
    public String join(User user) {
        String result;

        //사용자 정보가 이미 존재하는지 결과 문자열을 리턴
        try {
            User temp = userService.getUserById(user.getUserId()).get();
            return "회원 정보가 이미 존재합니다.";
        } catch (Exception e) {
            userService.saveUserData(user);
            return "회원가입이 완료되었습니다.";
        }
    }

    //로그인
    @PostMapping("/login")
    public String login(User user, HttpSession session) {
        try {
            User temp = userService.getUserById(user.getUserId()).get();
            if (user.getUserId().equals(temp.getUserId()) && user.getPwd().equals(temp.getPwd())) {
                session.setAttribute("userId", user.getUserId());
                return "로그인 되었습니다.";
            }
            return "아이디 또는 비밀번호가 일치하지 않습니다.";
        } catch (Exception e) {
            return "아이디가 존재하지 않습니다.";
        }
    }
}
