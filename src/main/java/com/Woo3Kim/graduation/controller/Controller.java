package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.service.JobService;
import com.Woo3Kim.graduation.service.MainService;
import com.Woo3Kim.graduation.service.SubjectService;
import com.Woo3Kim.graduation.service.UserService;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private JobService jobService;
    private MainService mainService;
    private SubjectService subjectService;
    private UserService userService;

    @Autowired
    public Controller(JobService jobService, MainService mainService, SubjectService subjectService, UserService userService) {
        this.jobService = jobService;
        this.mainService = mainService;
        this.subjectService = subjectService;
        this.userService = userService;
    }

    //메인 페이지
    @GetMapping("/")
    public String main() {
        return "main";  //메인 페이지 위치
    }

    //이수과목 체크
    @GetMapping("/subjectRegist")
    public String check() {
        return "check";     //이수과목 체크 페이지 위치
    }

    /*
        넘겨 받은 이수과목들을 등록 - 등록이 완료되면 팝업창으로 완료를 알리고 페이지 이동 or 완료 또는 실패를 알리는 페이지로 이동
     */
    @PostMapping("/doSubjectRegist")
    public String check(List<Object> subjectList) {

        return "check";     //이수과목 체크 완료 후 이동할 페이지 주소
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
