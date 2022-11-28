package com.Woo3Kim.graduation.repository;

import com.Woo3Kim.graduation.dto.Main;

import java.util.Optional;

public interface MainRepository {
    void save(Main main);       //Main의 서비스 소개와 개발자 정보 저장
    Optional<Main> getMain();   //Main의 서비스 소개와 개발자 정보 조회
}