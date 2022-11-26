package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.domain.User;
import com.Woo3Kim.graduation.domain.User_Subject;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);                       //회원 정보 저장
    void updateUser(User user, String desiredJob);  //회원 희망직무 업데이트

    void saveUserSubject(User_Subject userSubject); //사용자의 이수과목 저장
    List<User_Subject> getUserSubject(User user);   //사용자의 이수과목 모두 조회
}
