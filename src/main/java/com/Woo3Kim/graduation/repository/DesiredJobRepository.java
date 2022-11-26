package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.domain.DesiredJob;

import java.util.List;

public interface DesiredJobRepository {
    void save(DesiredJob desiredJob);                           //희망직무 저장
    List<DesiredJob> getAllDesiredJob();                        //모든 희망직무 조회
    List<DesiredJob> getDesiredJobByAreaName(String AreaName);  //희망직무와 관련된 영역 조회
}