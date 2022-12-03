package com.Woo3Kim.graduation.controller;

import com.Woo3Kim.graduation.dto.Main;
import com.Woo3Kim.graduation.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class MainController {
    private MainService mainService;
    private Main main;

    @Autowired
    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    //서비스 소개 및 개발자 소개 저장 페이지
    @GetMapping("/save")
    public String save() {

        return "save";
    }

    //서비스 소개 및 개발자 소개 저장 페이지 - 저장 버튼을 눌렀을 때
    @PostMapping("/save")
    public String save(@RequestParam("serviceInfo") String serviceInfo, @RequestParam("creatorInfo") String creatorInfo) {
        mainService.save(serviceInfo, creatorInfo);

        return "save";      //저장한 이후 이동할 페이지
    }

    //메인 페이지
    @GetMapping("/")
    public String mainPage(Model model) {
        main = mainService.getIntroduction().get();

        String serviceInfo = main.getServiceIndroduction();
        String creatorInfo = main.getCreatorIndroduction();

        model.addAttribute("serviceInfo", serviceInfo);
        model.addAttribute("creatorInfo", creatorInfo);

        return "mainPage";      //메인 페이지
    }
}
