package com.group8.model;


public class Restaurant 
{
    private int id;
    private String name;
    private String street;
    private String area;
    private int zipcode;
    private String city;
    private String type;
    private int minPrice;
    private int maxPrice;
    private int owner;

    //Constructor
    public Restaurant(int id, String name, String street, String area, int zipcode, String city, String type, int minPrice, int maxPrice, int owner) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.area = area;
        this.zipcode = zipcode;
        this.city = city;
        this.type = type;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.owner = owner;
    }

    //                  ***********************
    //                          Getters
    //                  ***********************
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getArea() {
        return area;
    }

    public int getZipcode() {
        return zipcode;
    }

    public String getCity() {
        return city;
    }

    public String getType() {
        return type;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public int getOwner() {
        return owner;
    }
    
    //                  ***********************
    //                          Setters
    //                  ***********************
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
