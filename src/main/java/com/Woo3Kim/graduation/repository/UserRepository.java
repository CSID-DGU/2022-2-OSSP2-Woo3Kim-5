package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.domain.Subject;
import com.Woo3Kim.graduation.domain.User;
import com.Woo3Kim.graduation.domain.User_Subject;

import java.util.List;

public interface UserRepository {
    //User 관련
    void saveUser(User user);                                   //회원 정보 저장
    void updateUser(User user, String desiredJob);              //회원 희망직무 업데이트

    //User_Subject 관련
    void saveUserSubject(User user, User_Subject userSubject);  //사용자의 이수과목 저장
    List<Subject> getUserSubject(User user);                    //사용자의 이수과목 모두 조회

    List<Subject> getMajor(User user);                          //사용자가 이수한 과목 중 전공 과목 조회
    List<Subject> getGE(User user);                             //사용자가 이수한 과목 중 교양 과목 조회
    List<Subject> getBasic(User user);                          //사용자가 이수한 과목 중 기본소양 과목 조회
}