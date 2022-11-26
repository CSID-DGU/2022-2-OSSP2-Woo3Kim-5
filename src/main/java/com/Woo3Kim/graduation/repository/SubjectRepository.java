package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.domain.DesiredJob;
import com.Woo3Kim.graduation.domain.Subject;
import com.Woo3Kim.graduation.domain.Subject_RelatedArea;
import java.util.List;

public interface SubjectRepository {
    //Subject 관련
    void saveSubject(Subject subject);      //과목 데이터에 과목을 추가
    List<Subject> getAllSubject();          //모든 과목 리스트 조회

    //Subject_RelatedArea 관련
    void saveSubjectRelatedArea(Subject_RelatedArea subjectRelatedArea);    //과목의 관련영역 저장
    List<Subject> getSubjectByRelatedArea(DesiredJob desiredJob);           //희망 직무와 연관된 과목들을 조회
}
