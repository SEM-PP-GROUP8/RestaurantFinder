package com.group8.model;


public class Review 
{
    //Variables required. These variables imply the basic information every review must have.
    int restID;
    int userID;
    String review;
    String date;
    int grade;
    
    //Variables not required when constructing an instance of this class. These variables are used
    // when presenting the information to a registered user or an owner.
    String restName;
    String userName;

    //Constructor when creating a new review on a specific restaurant the username and the restaurant 
    //name are not necessary.
    public Review(int restID, int userID, String review, int grade, String date) 
    {
        this.restID = restID;
        this.userID = userID;
        this.review = review;
        this.date = date;
        this.grade = grade;
        this.restName = "";
        this.userName = "";
    }  

    // SETTERS
    public void setRestID(int restID) {
        this.restID = restID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setRestName(String restName) {
        this.restName = restName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
    
    public void setDate(String date) {
        this.date = date;
    }

    // GETTERS
    public int getRestID() {
        return restID;
    }

    public int getUserID() {
        return userID;
    }

    public String getRestName() {
        return restName;
    }

    public String getUserName() {
        return userName;
    }

    public String getReview() {
        return review;
    }

    public int getGrade() {
        return grade;
    }
    
    public String getDate()
    {
        return date;
    }
    
}
