package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //마이페이지
    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";    //마이페이지 위치
    }

    //회원가입 페이지
    @GetMapping("/join")
    public String join() {
        return "join";
    }

    //회원가입 등록페이지
    @PostMapping("/join")
    public String join(@RequestParam("userId") String userId, @RequestParam("pwd") String pwd, @RequestParam("job") String job,
                       @RequestParam("email") String email, @RequestParam("studentId") String studentId,
                       @RequestParam("admissionYear") String admissionYear, @RequestParam("engLv") String engLv,
                       @RequestParam("engScore") int engScore, @RequestParam("minor") String minor) {

        userService.saveUserData(userId, pwd, job, email, studentId, admissionYear, engLv, engScore, minor);

        //성공시와 실패 시
        return "join";
    }
}
