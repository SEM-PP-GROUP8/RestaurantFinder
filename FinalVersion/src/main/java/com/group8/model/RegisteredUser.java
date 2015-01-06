package com.group8.model;

public class RegisteredUser 
{
    // These variables represent the maximum character length allowed to each variable.
    private final int userNameLength = 20;
    private final  int passwordLength = 20;
    private final  int surnameLength = 30;
    private final  int famNameLength = 30;
    private final  int phoneLength = 20;
    private final  int areaLength = 20;
    private final  int cityLength = 20;
    
    //Variables a registered user can have.
    //Required Variables
    private int id;
    private String userName;
    
    //Non required variables
    private String surname;
    private String familyName;
    private String email;
    private String phone;
    private String area;
    private String city;

    //Constructor. It takes in all the variables since the program sets them to default values in case
    // the user has not specified them.
    public RegisteredUser(int id, String userName, String surname, String familyName, String emial, String phone, String area, String city) {
        this.id = id;
        this.userName = userName;
        this.surname = surname;
        this.familyName = familyName;
        this.email = emial;
        this.phone = phone;
        this.area = area;
        this.city = city;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setEmial(String emial) {
        this.email = emial;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setCity(String city) {
        this.city = city;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getSurname() {
        return surname;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getArea() {
        return area;
    }

    public String getCity() {
        return city;
    }

    public int getUserNameLength() {
        return userNameLength;
    }

    public int getPasswordLength() {
        return passwordLength;
    }

    public int getSurnameLength() {
        return surnameLength;
    }

    public int getFamNameLength() {
        return famNameLength;
    }

    public int getPhoneLength() {
        return phoneLength;
    }

    public int getAreaLength() {
        return areaLength;
    }

    public int getCityLength() {
        return cityLength;
    }
    
    
}
