package com.Woo3Kim.graduation.service;

import com.Woo3Kim.graduation.dto.Main;
import com.Woo3Kim.graduation.repository.MainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MainService {
    private final MainRepository mainRepository;
    private Main main;

    @Autowired
    public MainService(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }

    //서비스 및 만든사람 소개 저장
    public void save(String serviceIntroduction, String creatorIntroduction) {
        main.setServiceIndroduction(serviceIntroduction);
        main.setCreatorIndroduction(creatorIntroduction);

        mainRepository.save(main);
    }

    //서비스와 개발자 소개 불러오기
    public Optional<Main> getIntroduction() {
        return mainRepository.getMain();
    }
}
