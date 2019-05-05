package com.sara.myproject2;

public class Comment {

    private int id;
    private int teacherID;
    private int userId;
    private String userName;
    private float rating;
    private String description;
    private String persianDate;

    public Comment(int id, int teacherID, int userId, String userName, float rating, String description,String persianDate) {
        this.id = id;
        this.teacherID = teacherID;
        this.userId = userId;
        this.userName = userName;
        this.rating = rating;
        this.description = description;
        this.persianDate = persianDate;
    }

    public String getPersianDate() {
        return persianDate;
    }

    public void setPersianDate(String persianDate) {
        this.persianDate = persianDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
