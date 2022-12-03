package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/subject")
public class SubjectController {
    private SubjectService subjectService;
    private Subject subject;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    //DB에 과목 저장
    @GetMapping("/saveSubject")
    public String saveSubject(@RequestParam("subjectName") String subjectName, @RequestParam("kind") String kind, @RequestParam("description") String description, @RequestParam("grade") int grade) {
        subject.setSubjectName(subjectName);
        subject.setKind(kind);
        subject.setDescription(description);
        subject.setGrade(grade);

        subjectService.saveSubject(subject);

        return "savedSubject";
    }

    //사용자 이수과목 업로드
    @GetMapping("/upload")
    public String uploadUserSubject(@RequestParam("userId") String userId, @RequestParam("list") List<String> subjectNames) {
        for (int i = 0; i < subjectNames.size(); i++) {

        }


    }
}