package com.sara.myproject2;

import java.util.ArrayList;

public class Teacher {
    private int id;
    private String firstName;
    private String lastName;
    private String degree;
    private float rating;
    private int image;
    private int price;
    private String description;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public Teacher(int id, String firstName, String lastName, String degree, float rating, int image,int price,String description) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.rating = rating;
        this.image = image;
        this.price = price;
        this.description = description;
    }
}



