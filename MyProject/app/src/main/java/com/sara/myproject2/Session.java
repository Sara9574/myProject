package com.sara.myproject2;

public class Session {

    private int id;
    private int userId;
    private int teacherId;
    private int duration;
    private int status;



    private String persianDate;
    private String teacherName;
    private String subject;
    private String grade;
    private String address;
    private String time;



    public Session(int id, int userId, int teacherId, int duration,int status, String persianDate, String subject, String grade, String address, String time, String teacherName) {

        this.id = id;
        this.userId = userId;
        this.teacherId = teacherId;
        this.duration = duration;
        this.persianDate = persianDate;
        this.subject = subject;
        this.grade = grade;
        this.address = address;
        this.time = time;
        this.teacherName = teacherName;
        this.status = status;

    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPersianDate() {
        return persianDate;
    }

    public void setPersianDate(String persianDate) {
        this.persianDate = persianDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }
}
