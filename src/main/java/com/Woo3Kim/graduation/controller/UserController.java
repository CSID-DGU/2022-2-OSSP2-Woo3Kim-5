package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        String result = null;

        String userId = user.getUserId();
        String pwd = user.getPwd();
        String job = user.getJob();
        String email = user.getEmail();
        String studentId = user.getStudentId();
        String admissionYear = user.getAdmissionYear();
        String engLv = user.getEngLv();
        int engScore = user.getEngScore();
        String minor = user.getMinor();

        User temp = userService.getUserById(userId).get();

        //사용자 정보가 이미 존재하는지
        if (temp == null) {
            userService.saveUserData(userId, pwd, job, email, studentId, admissionYear, engLv, engScore, minor);
            return "회원가입이 완료되었습니다.";
        } else {
            return "회원 정보가 이미 존재합니다.";
        }
    }
}
