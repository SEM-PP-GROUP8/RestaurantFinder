package com.group8.model;

public class Restaurant {

    private int id;
    private int ownerID;
    private String name;
    private RestaurantType type;
    private String street;
    private String area;
    private String city;
    private int zipCode;
    private String imageURL;
    private int telephone;
    private String description;
    private int minPrice;
    private int maxPrice;
    private RestaurantSchedule schedule;
    private boolean temporary;
    
    
    public Restaurant(int id, int ownerID, String name, RestaurantType type, String street, String area, String city, int zipCode, String imageURL, int telephone, String description, int minPrice, int maxPrice, RestaurantSchedule schedule) {
        this.id = id;
        this.ownerID = ownerID;
        this.name = name;
        this.type = type;
        this.street = street;
        this.area = area;
        this.city = city;
        this.zipCode = zipCode;
        this.imageURL = imageURL;
        this.telephone = telephone;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.schedule = schedule;
        this.temporary = false;
    }
    
    public Restaurant(int id, int ownerID, String name, RestaurantType type, String street, String area, String city, int zipCode, String imageURL, int telephone, String description, int minPrice, int maxPrice, RestaurantSchedule schedule, boolean temporary) {
        this.id = id;
        this.ownerID = ownerID;
        this.name = name;
        this.type = type;
        this.street = street;
        this.area = area;
        this.city = city;
        this.zipCode = zipCode;
        this.imageURL = imageURL;
        this.telephone = telephone;
        this.description = description;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.schedule = schedule;
        this.temporary = temporary;
    }
  
    @Override
    public String toString(){
       if(isTemporary())
           return "Unsaved Restaurant";
       else
           return this.name;
       
    }
    

    public int getId() {
        return id;
    }
    

    public void setId(int id) {
        this.id = id;
    }
    

    public int getOwnerID() {
        return ownerID;
    }
    

    public void setOwnerID(int ownerID) {
        this.ownerID = ownerID;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public RestaurantType getType() {
        return type;
    }


    public void setType(RestaurantType type) {
        this.type = type;
    }


    public String getStreet() {
        return street;
    }


    public void setStreet(String street) {
        this.street = street;
    }


    public String getArea() {
        return area;
    }


    public void setArea(String area) {
        this.area = area;
    }


    public String getCity() {
        return city;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public int getZipCode() {
        return zipCode;
    }


    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }


    public String getImageURL() {
        return imageURL;
    }


    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    public int getTelephone() {
        return telephone;
    }


    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(int minPrice) {
        this.minPrice = minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(int maxPrice) {
        this.maxPrice = maxPrice;
    }

    public RestaurantSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(RestaurantSchedule schedule) {
        this.schedule = schedule;
    }

    /**
     * @return the temporary
     */
    public boolean isTemporary() {
        return temporary;
    }

    /**
     * @param temporary the temporary to set
     */
    public void setTemporary(boolean temporary) {
        this.temporary = temporary;
    }
    
}
