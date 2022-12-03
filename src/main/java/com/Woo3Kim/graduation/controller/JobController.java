package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.service.JobService;
import com.Woo3Kim.graduation.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/job")
public class JobController {
    private JobService jobService;
    private SubjectService subjectService;
    private Job job;

    @Autowired
    public JobController(JobService jobService, SubjectService subjectService) {
        this.jobService = jobService;
        this.subjectService = subjectService;
    }

    //희망직무 조회 페이지
    @PostMapping("/jobInfo")
    public String jobInfo(Model model, @RequestParam("jobName") String jobName) {
        List<Subject> subjectList = subjectService.subjectByJob(jobName);
        model.addAttribute("subjectList", subjectList);         //subjectList라는 이름으로 희망 직무에 따른 과목들 리턴

        return "jobInfo";   //희망직무를 조회하는 페이지
    }

    //DB에 직무를 저장하는 페이지 - 저장하는 페이지로 이동만 하는 경우
    @GetMapping("/saveJob")
    public String saveJob(Model model) {
        List<Job> jobList = jobService.getAllJob();
        model.addAttribute("jobList", jobList);

        return "saveJob";       //직무를 저장하는 페이지
    }

    //DB에 직무를 저장하는 페이지 - 저장하는 페이지에서 직무를 선택하여 저장하고자 하는 경우
    @PostMapping("/saveJob")
    public String saveJob(@RequestParam("jobName") String jobName) {
        jobService.saveJob(jobName);

        return "saveJob";       //직무를 저장한 이후 이동할 페이지
    }
}
