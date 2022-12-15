package com.Woo3Kim.graduation.dto;

public class User {
    private String userId;          //사용자 아이디
    private String pwd;             //사용자 비밀번호
    private String job;             //사용자 희망직무
    private String email;           //이메일
    private String studentId;       //학번
    private String admissionYear;   //입학년도
    private String engLv;           //영어레벨
    private int engScore;           //외국어성적
    private String minor;           //복수전공
    private int unit;               //수강 학점



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(String admissionYear) {
        this.admissionYear = admissionYear;
    }

    public String getEngLv() {
        return engLv;
    }

    public void setEngLv(String engLv) {
        this.engLv = engLv;
    }

    public int getEngScore() {
        return engScore;
    }

    public void setEngScore(int engScore) {
        this.engScore = engScore;
    }

    public String getMinor() {
        return minor;
    }

    public void setMinor(String minor) {
        this.minor = minor;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
