/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group8.model;

/**
 *
 * @author enriquecordero
 */
public class RegisteredOwner 
{
    // These variables represent the maximum character length allowed to each variable.
    private final int userNameLength = 20;
    private final  int passwordLength = 20;
    private final  int surnameLength = 30;
    private final  int famNameLength = 30;
    private final  int phoneLength = 20;
    
    //Variables a registered user can have.
    //Required Variables
    int id;
    String userName;
    //Non required variables
    String surname;
    String familyName;
    String email;
    String phone;

    //Constructor. It takes in all the variables since the program sets them to default values in case
    // the owner has not specified them.
    public RegisteredOwner(int id, String userName, String surname, String familyName, String email, String phone) {
        this.id = id;
        this.userName = userName;
        this.surname = surname;
        this.familyName = familyName;
        this.email = email;
        this.phone = phone;
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
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
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

}
