package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.RelatedArea;

import java.util.Optional;

public interface RelatedAreaRepository {
    void save(RelatedArea relatedArea);                     //관련 영역 추가
    Optional<RelatedArea> getRelatedAreaByAreaName(String AreaName);  //영역 이름에 해당하는 객체 리턴
}
