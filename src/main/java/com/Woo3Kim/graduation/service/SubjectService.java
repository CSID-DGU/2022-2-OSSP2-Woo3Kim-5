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
    public void saveSubject(Subject subject) {
        subject.setSubjectName(subject.getSubjectName());
        subject.setKind(subject.getKind());
        subject.setDescription(subject.getDescription());
        subject.setGrade(subject.getGrade());

        subjectRepository.save(subject);
    }

    //DB에서 과목 이름에 해당하는 Subject 객체 조회
    public Subject getSubjectBySubjectName(String subjectName) {
        return subjectRepository.getSubjectBySubjectName(subjectName).get();
    }

    //사용자 이수과목 업로드 - 기존 사용자의 이수과목을 모두 삭제하고 새로 저장
    public void uploadUserSubject(String userId, List<Subject> subjects) {
        user = userRepository.getUserById(userId).get();
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

        user = userRepository.getUserById(userId).get();      //userId를 통해 user객체 가져오기

        totalCount = subjectRepository.getAllSubject().size();
        userCount = subjectRepository.getAllSubjectOfUser(user).size();

        return userCount / totalCount;
    }

    //교양과목 달성률 조회
    public int GEAchievementRate(String userId) {
        int totalCount;
        int userCount;

        user = userRepository.getUserById(userId).get();

        totalCount = subjectRepository.getAllSubject().size();
        userCount = subjectRepository.getGEOfUser(user).size();

        return userCount / totalCount;
    }

    //기본소양 과목 달성률 조회
    public int basicAchievementRate(String userId) {
        int totalCount;
        int userCount;

        user = userRepository.getUserById(userId).get();

        totalCount = subjectRepository.getAllSubject().size();
        userCount = subjectRepository.getBasicOfUser(user).size();

        return userCount / totalCount;
    }

    //희망직무에 따른 과목들 조회 - 과목들과 각 과목의 관련영역들 출력
    public List<Subject> subjectByJob(String jobName) {
        job = jobRepository.getJobByJobName(jobName).get();

        return subjectRepository.getSubjectByJob(job);
    }

    //사용자의 남은 과목 모두 조회
    public List<Subject> getRestSubject(String userId) {
        user = userRepository.getUserById(userId).get();

        return subjectRepository.getRestSubject(user);
    }
}
