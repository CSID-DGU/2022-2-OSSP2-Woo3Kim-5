package com.Woo3Kim.graduation.dto;


import javax.persistence.Entity;

public class Subject {
    private String subjectName; //과목 이름
    private int grade;          //이수 대상
    private String kind;        //전공, 교양 종류 - "major", "GE", "basic" 으로 구분
    private String description; //과목 설명
    private int unit;           //과목 학점

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }
}
