package com.Woo3Kim.graduation.service;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.repository.JobRepository;
import com.Woo3Kim.graduation.repository.SubjectRepository;
import com.Woo3Kim.graduation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserRepository userRepository;
    private final JobRepository jobRepository;
    private User user;
    private Job job;
    private Subject subject;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository, UserRepository userRepository, JobRepository jobRepository) {
        this.subjectRepository = subjectRepository;
        this.userRepository = userRepository;
        this.jobRepository = jobRepository;
    }

    //DB에 과목 저장
    public void saveSubject(String subjectName, String kind, String description, int grade) {
        subject.setSubjectName(subjectName);
        subject.setKind(kind);
        subject.setDescription(description);
        subject.setGrade(grade);

        subjectRepository.save(subject);
    }

    //사용자 이수과목 업로드 - 기존 사용자의 이수과목을 모두 삭제하고 새로 저장
    public void uploadUserSubject(String userId, List<Subject> subjects) {
        user = userRepository.getUser(userId).get();
        subjectRepository.deleteUserSubject(user);
        for (int i = 0; i < subjects.size(); i++) {
            subjectRepository.saveUserSubject(user, subjects.get(i));
        }
    }

    //모든 과목 조회
    public List<Subject> getAllSubject() {
        return subjectRepository.getAllSubject();
    }

    //전공과목 달성률 조회
    public int majorAchievementRate(String userId) {
        int totalCount;
        int userCount;

        user = userRepository.getUser(userId).get();      //userId를 통해 user객체 가져오기

        totalCount = subjectRepository.getAllSubject().size();
        userCount = subjectRepository.getAllSubjectOfUser(user).size();

        return userCount / totalCount;
    }

    //교양과목 달성률 조회
    public int GEAchievementRate(String userId) {
        int totalCount;
        int userCount;

        user = userRepository.getUser(userId).get();

        totalCount = subjectRepository.getAllSubject().size();
        userCount = subjectRepository.getGEOfUser(user).size();

        return userCount / totalCount;
    }

    //기본소양 과목 달성률 조회
    public int basicAchievementRate(String userId) {
        int totalCount;
        int userCount;

        user = userRepository.getUser(userId).get();

        totalCount = subjectRepository.getAllSubject().size();
        userCount = subjectRepository.getBasicOfUser(user).size();

        return userCount / totalCount;
    }

    //희망직무에 따른 과목들 조회 - 과목들과 각 과목의 관련영역들 출력
    public List<Subject> subjectByJob(String jobName) {
        job = jobRepository.getJobByJobName(jobName).get();

        return subjectRepository.getSubjectByJob(job);
    }
}
