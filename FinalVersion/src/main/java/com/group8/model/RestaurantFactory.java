package com.group8.model;

import com.group8.view.editRestaurant.RestaurantEditView;

public class RestaurantFactory {
   
    public Restaurant getRestaurant(String restaurantObjectType, int id, int ownerID, String name, RestaurantType type, String street, String area, String city, int zipCode, String imageURL, int telephone, String description, int minPrice, int maxPrice, RestaurantSchedule schedule){
        if("Existing".equalsIgnoreCase(restaurantObjectType) || "ToBeSaved".equalsIgnoreCase(restaurantObjectType) )
            return new Restaurant(id, ownerID, name, type, street, area, city, zipCode, imageURL, telephone, description, minPrice, maxPrice,  schedule);
        else if ("Temporary".equalsIgnoreCase(restaurantObjectType))
            return new Restaurant(id, ownerID, name, type, street, area, city, zipCode, imageURL, telephone, description, minPrice, maxPrice,  schedule, true);
        else
            return null;
    }
    
    public Restaurant getEmptyRestaurant(String restaurantObjectType){
        return this.getRestaurant(restaurantObjectType, -1, -1, null, RestaurantType.INDIAN, null, null, null, 0, null, 0, null, 0, 0, new RestaurantSchedule());
    }
}
