package com.Woo3Kim.graduation.dto;

public class User {
    private String UserId;      //사용자 아이디
    private String pwd;         //사용자 비밀번호
    private String job;            //사용자 희망직무

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
