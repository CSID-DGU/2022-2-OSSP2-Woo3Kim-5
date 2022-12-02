package com.Woo3Kim.graduation.dto;

public class Main {
    private int id;                         //DB 식별키
    private String serviceIndroduction;     //서비스 소개
    private String creatorIndroduction;     //개발자 소개

    public String getServiceIndroduction() {
        return serviceIndroduction;
    }

    public void setServiceIndroduction(String serviceIndroduction) {
        this.serviceIndroduction = serviceIndroduction;
    }

    public String getCreatorIndroduction() {
        return creatorIndroduction;
    }

    public void setCreatorIndroduction(String creatorIndroduction) {
        this.creatorIndroduction = creatorIndroduction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
