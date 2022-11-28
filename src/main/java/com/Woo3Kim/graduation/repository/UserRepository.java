package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.Job;
import com.Woo3Kim.graduation.dto.Subject;
import com.Woo3Kim.graduation.dto.User;
import com.Woo3Kim.graduation.dto.UserSubject;

import java.util.List;

public interface UserRepository {
    //User 관련
    void saveUser(User user);                            //회원 정보 저장
    void updateUserJob(User user, Job job);              //회원의 희망직무 업데이트
}