package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.Main;
import com.Woo3Kim.graduation.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainController {
    private MainService mainService;
    private Main main;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    //서비스 소개 및 개발자 소개 저장
    @PostMapping("/save")
    public void save(Main main) {
        mainService.save(main.getServiceIndroduction(), main.getCreatorIndroduction());
    }

    //메인페이지의 Main객체(서비스 소개 및 개발자 소개) 리턴
    @GetMapping("/")
    public Main mainPage() {
        main = mainService.getIntroduction().get();
        
        return main;
    }
}
