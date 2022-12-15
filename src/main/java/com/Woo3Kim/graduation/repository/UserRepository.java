package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.dto.User;

import java.util.Optional;

public interface UserRepository {
    //User 관련
    void saveUser(User user);                            //회원 정보 저장
    Optional<User> getUserById(String userId);           //이름으로 회원 정보 가져오기
    void updateUserJob(User user, Job job);              //회원의 희망직무 업데이트
}