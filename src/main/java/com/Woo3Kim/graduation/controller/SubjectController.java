package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private SubjectService subjectService;
    private Subject subject;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //DB에 과목 저장
    @PostMapping("/save")
    public void saveSubject(Subject subject) {
        subjectService.saveSubject(subject);
    }

    //사용자 이수과목 업로드 - 사용자 아이디와 이수한 과목들의 이름 리스트를 입력하면 사용자가 이수한 과목으로 DB에 저장
    @PostMapping("/upload")
    public void uploadUserSubject(@RequestParam("userId") String userId, @RequestParam("subjectNames") List<String> subjectNames) {
        List<Subject> subjects = new ArrayList<Subject>();
        for (int i = 0; i < subjectNames.size(); i++) {
            subject = subjectService.getSubjectBySubjectName(subjectNames.get(i));
            subjects.add(subject);
        }

        for (int i = 0; i < subjectNames.size(); i++) {
            subjectService.uploadUserSubject(userId, subjects);
        }
    }

    //모든 과목 조회
    @GetMapping("/allSubjects")
    public List<Subject> allSubjects() {
        List<Subject> list = subjectService.getAllSubject();

        return list;
    }

    //달성률을 리턴 - 전공, 교양, 과목
    @GetMapping("/achievementRate")
    public List<Integer> achievementRate(User user) {
        String userId = user.getUserId();

        int majorRate = subjectService.majorAchievementRate(userId);
        int GERate = subjectService.GEAchievementRate(userId);
        int basicRate = subjectService.basicAchievementRate(userId);

        List<Integer> rateList = new ArrayList<>();
        rateList.add(majorRate);
        rateList.add(GERate);
        rateList.add(basicRate);

        return rateList;
    }
}