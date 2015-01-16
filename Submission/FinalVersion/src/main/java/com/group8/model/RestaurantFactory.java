package com.group8.model;

public class RestaurantFactory {
   
    /**
     * Get information of a restaurant.
     * @param restaurantObjectType
     * @param id
     * @param ownerID
     * @param name
     * @param type
     * @param street
     * @param area
     * @param city
     * @param zipCode
     * @param imageURL
     * @param telephone
     * @param description
     * @param minPrice
     * @param maxPrice
     * @param schedule
     * @return 
     */
    public Restaurant getRestaurant(String restaurantObjectType, int id, int ownerID, String name, RestaurantType type, String street, String area, String city, int zipCode, String imageURL, int telephone, String description, int minPrice, int maxPrice, RestaurantSchedule schedule){
        if("Existing".equalsIgnoreCase(restaurantObjectType) || "ToBeSaved".equalsIgnoreCase(restaurantObjectType) )
            return new Restaurant(id, ownerID, name, type, street, area, city, zipCode, imageURL, telephone, description, minPrice, maxPrice,  schedule);
        else if ("Temporary".equalsIgnoreCase(restaurantObjectType))
            return new Restaurant(id, ownerID, name, type, street, area, city, zipCode, imageURL, telephone, description, minPrice, maxPrice,  schedule, true);
        else
            return null;
    }
    
    /**
     * Get a restaurant without information.
     * @param restaurantObjectType
     * @return 
     */
    public Restaurant getEmptyRestaurant(String restaurantObjectType){
        return this.getRestaurant(restaurantObjectType, -1, -1, null, RestaurantType.INDIAN, null, Model.locationArray[1], null, 0, null, 0, null, 0, 0, new RestaurantSchedule());
    }
}
