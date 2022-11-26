package com.Woo3Kim.graduation.domain;

public class User {
    private String UserId;
    private String pwd;
    private DesiredJob desiredJob;

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public DesiredJob getDesiredJob() {
        return desiredJob;
    }

    public void setDesiredJob(DesiredJob desiredJob) {
        this.desiredJob = desiredJob;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
