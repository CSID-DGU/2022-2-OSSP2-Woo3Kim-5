package com.Woo3Kim.graduation.controller;

import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    //메인 페이지
    @GetMapping("/")
    public String main() {
        return "main";  //메인 페이지 위치
    }

    //마이페이지
    @GetMapping("/mypage")
    public String myPage() {
        return "mypage";    //마이페이지 위치
    }

    //이수과목 체크
    @GetMapping("/subjectRegist")
    public String check(@PathVariable() String search ) {
        return "check";     //이수과목 체크 페이지 위치
    }
    @PostMapping("/doSubjectRegist")
    public String check(List<Object> subjectList) {
        return "check";     //이수과목 체크 페이지 위치
    }


    //수강과목 추천
    @GetMapping("/recommendation")
    public String recommendation() {
        return "recommendation";    //수강과목 추천 페이지 위치
    }

    //졸업 요건 검사
    @GetMapping("/checkCondition")
    public String checkCondition() {
        return "checkCondition";    //졸업 요건 검사 페이지
    }
}
