package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.*;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository {
    //Subject 관련
    void save(Subject subject);                                         //과목 데이터에 과목을 추가
    Optional<Subject> getSubjectBySubjectName(String subjectName);      //과목 이름에 해당하는 과목 조회
    List<Subject> getAllSubject();                                      //모든 과목 리스트 조회

    //SubjectRelatedArea 관련
    void saveSubjectRelatedArea(Subject subject, RelatedArea relatedArea);    //과목과 관련된 영역 저장
    List<Subject> getSubjectByRelatedArea(String areaName);           //희망 직무와 연관된 과목들을 조회

    //SubjectJob 관련
    void saveSubjectJob(Subject subject, Job job);                  //직무와 관련된 과목 정보 저장
    List<Subject> getSubjectByJob(Job job);                         //직무와 관련된 과목들 조회
    
    //UserSubject 관련
    void saveUserSubject(User user, Subject subject);                //사용자의 이수과목 저장
    void deleteUserSubject(User user);                               //사용자의 이수 과목 모두 삭제
    List<Subject> getAllSubjectOfUser(User user);                    //사용자의 이수과목 모두 조회
    List<Subject> getMajorOfUser(User user);                         //사용자가 이수한 과목 중 전공 과목 조회
    List<Subject> getGEOfUser(User user);                            //사용자가 이수한 과목 중 교양 과목 조회
    List<Subject> getBasicOfUser(User user);                         //사용자가 이수한 과목 중 기본소양 과목 조회
}
