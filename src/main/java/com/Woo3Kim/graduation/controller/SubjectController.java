package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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

    //DB에 과목 저장 페이지
    @GetMapping("/saveSubject")
    public String saveSubject() {

        return "saveSubject";   //과목을 저장하는 페이지
    }

    //DB에 과목 저장
    @PostMapping("/saveSubject")
    public String saveSubject(@RequestParam("subjectName") String subjectName, @RequestParam("kind") String kind, @RequestParam("description") String description, @RequestParam("grade") int grade) {
        subject.setSubjectName(subjectName);
        subject.setKind(kind);
        subject.setDescription(description);
        subject.setGrade(grade);

        subjectService.saveSubject(subject);

        return "savedSubject";      //과목을 저장한 이후 이동할 페이지
    }

    //사용자 이수과목 업로드 페이지
    @GetMapping("/upload")
    public String uploadUserSubject() {

        return "upload";        //이수과목을 업로드하는 페이지
    }

    //사용자 이수과목 업로드
    @PostMapping("/upload")
    public String uploadUserSubject(@RequestParam("userId") String userId, @RequestParam("list") List<String> subjectNames) {
        List<Subject> subjects = new ArrayList<Subject>();
        for (int i = 0; i < subjectNames.size(); i++) {
            subject = subjectService.getSubjectBySubjectName(subjectNames.get(i));
            subjects.add(subject);
        }

        for (int i = 0; i < subjectNames.size(); i++) {
            subjectService.uploadUserSubject(userId, subjects);
        }

        return "upload";        //업로드 이후 이동할 페이지
    }

    //모든 과목 조회
    @GetMapping("/allSubjects")
    public String allSubjects(Model model) {
        List<Subject> list = subjectService.getAllSubject();
        model.addAttribute("list", list);

        return "allSubjects";       //모든 과목을 조회하는 페이지
    }

    //달성률을 조회하는 페이지
    @GetMapping("/achievementRate")
    public String achievementRate(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();

        String userId = (String)session.getAttribute("userId");

        int majorRate = subjectService.majorAchievementRate(userId);
        int GERate = subjectService.GEAchievementRate(userId);
        int basicRate = subjectService.basicAchievementRate(userId);

        model.addAttribute("majorRate", majorRate);         //전공 달성률
        model.addAttribute("GERate", GERate);               //교양 달성률
        model.addAttribute("basicRate", basicRate);         //기본소양 달성률

        return "achievementRate";
    }
}