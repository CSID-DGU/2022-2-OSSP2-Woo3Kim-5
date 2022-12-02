package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.Job;

import java.util.List;
import java.util.Optional;

public interface JobRepository {
    void save(Job job);                           //희망직무 저장
    List<Job> getAllJob();                        //모든 희망직무 조회
    Optional<Job> getJobByJobName(String JobName);                   //직무 이름으로 객체 조회
    //List<Job> getJobByAreaName(String AreaName);  //희망직무와 관련된 영역 조회
}