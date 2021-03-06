package com.group8.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public abstract class RestaurantDAO 
{
    //                  ***************************
    //                  **    Query Functions    **
    //                  ***************************

    /**
     * Method to create a list of restaurants depending on the given filters.
     * @param typeOfFood
     * @param intPriceMin
     * @param intPriceMax
     * @param location
     * @param time
     * @param dayName
     * @param searchTxt
     * @return 
     */
    public static List<Restaurant> fetchRestaurantByFilters (String typeOfFood,int intPriceMin,int intPriceMax,String location,String time, String dayName, String searchTxt)
    {
        String sql = SQLTranslator.translateFindRestaurantByFilters (typeOfFood, intPriceMin, intPriceMax, location, time, searchTxt);
        ResultSet rs = DBHandler.query( sql);
        List<Restaurant> restaurants = RsToRL(rs);
        List <Restaurant> filteredRestaurants = filterRestaurantsByTimeDay(restaurants, time, dayName);       
        return filteredRestaurants;
    }

    /**
     * Method to fetch all the restaurants in the database.
     * @return 
     */
    public static List<Restaurant> fetchAllRestaurants ()
    {        
        String sql = SQLTranslator.translateAllRestaurants();
        ResultSet rs = DBHandler.query(sql);
        List<Restaurant> restaurants = RsToRL(rs);
        return restaurants;
    }

    /**
     * Checks whether the restaurant name is taken or not by another restaurant.
     * Searches the DB for the key name.
     * Match not found -> returns false
     * Match found and ids the same -> returns false
     * Match found and ID mismatch -> return true
     * 
     * @param rest Restaurant object as key
     * @return True if name is taken by another restaurant
     */
    public static boolean restaurantNameWithIDExists (Restaurant rest)
    {
        String sql = SQLTranslator.translateRestaurantWithIDExists (rest);
        ResultSet rs = DBHandler.query(sql);
        int savedID = -1; 
        try
        {
            if(rs.next())
            {
                savedID = rs.getInt("ID");
            }    
        } 
        catch ( SQLException e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        if(savedID == -1)
            return false;
        // If the same, then we are updating so no problem
        if(rest.getId() == savedID)
            return false;
        
        return true;
    }
    
    /**
     * Checks whether or not a specific restaurant already exists.
     * @param rest
     * @return 
     */
    public static boolean restaurantExists (Restaurant rest)
    {
        String sql = SQLTranslator.translateRestaurantExists (rest);
        ResultSet rs = DBHandler.query(sql);
        try
        {
            if(rs.next())
            {
                return true;
            }    
        } 
        catch ( SQLException e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return false;
    }
    
    /**
     * @param name The name of the restaurant to check if it exists
     * @return true if it exists
     */
    public static boolean restaurantNameExists (String name)
    {
        String sql = SQLTranslator.translateRestaurantNameExists(name);
        ResultSet rs = DBHandler.query(sql);
        
        int count = 0;
        
        try
        {
            if(rs.next())
            {
                count = rs.getInt(1);
            }    
        } 
        catch ( SQLException e ) 
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return (count != 0);
    }
    
    /**
     * Fetch all the restaurants from a sepcific owner.
     * @param UserId The id of the specific owner.
     * @return List of restaurants belonging to that owner.
     */
    public static List<Restaurant> fetchRestaurantsByLogin(int UserId)
    {
        String sql = SQLTranslator.translateFindRestaurantByLogin(UserId);
        ResultSet rs = DBHandler.query(sql);
        List<Restaurant> restaurants = RsToRL(rs);
        return restaurants;
    }
    
    //                  ***************************
    //                  **    Update Functions   **
    //                  ***************************

    /**
     * Adds a specific restaurant to the database.
     * @param rest 
     */
    public static void addRestaurant (Restaurant rest)
    {
        String sql = SQLTranslator.translateAddRestaurant(rest);
        DBHandler.update(sql);
        addRestaurantSchedule(rest);
    }
    
    /**
     * Updates a specific restaurant in the database.
     * @param rest The restaurant to update.
     */
    public static void updateRestaurant (Restaurant rest)
    {
        String sqlUpdate = SQLTranslator.translateUpdateRestaurant(rest);
        DBHandler.update(sqlUpdate);
        updateRestaurantSchedule(rest);
    }

    /**
     * Deletes a specific restaurant from the database.
     * @param rest Restaurant to delete.
     */
    public static void deleteRestaurant (Restaurant rest)
    {
        String sql = SQLTranslator.translateDeleteRecord(rest.getId(), "Restaurant");
        DBHandler.update(sql);
    }
    
    /**
     * Add a restaurant to the database.
     * @param rest Restaurant to add
     */
    public static void addRestaurantSchedule (Restaurant rest){
        
        int autoIncrementedID = fetchRecentlyAddedRestaurantID(rest.getOwnerID(),rest.getName());
        
        rest.setId(autoIncrementedID);
        
        String sql = SQLTranslator.translateAddRestaurantSchedule(rest);
        DBHandler.update(sql);
    }
    
    /**
     * Update a specific restaurant to the database
     * @param rest Restaurant to update
     */
    public static void updateRestaurantSchedule (Restaurant rest){
        
        String[] sqlArr = SQLTranslator.translateUpdateRestaurantSchedule(rest);
        
        int counter = 0;
        for(String sql : sqlArr){
            DBHandler.update(sql);
        }
    }

    private static RestaurantSchedule getRestaurantSchedule(int restaurantID){        

        RestaurantSchedule schedule = new RestaurantSchedule();
        
        ResultSet rs = null;
        String sql = SQLTranslator.translateGetRestaurantSchedule(restaurantID);
        
        rs = DBHandler.query(sql);
        
        try 
        {
            while(rs.next()){
                
                int i = rs.getInt("dayOfWeekID");
                int start = rs.getTime("start").toLocalTime().toSecondOfDay();
                int stop = rs.getTime("stop").toLocalTime().toSecondOfDay();
                int closed = rs.getInt("closed");
                int nonstop = rs.getInt("nonstop");
                
                schedule.setSeconds(start, i, 0);
                schedule.setSeconds(stop, i, 1);
                schedule.setClosed(i, closed);
                schedule.setNonStop(i, nonstop);
            }
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
        return schedule;
    }
    
    /**
     * Given a list of restaurants, for each restaurant we get the ID. For each id we get the schedule from the DB. 
     * For each schedule taken from DB we update the Restaurant object's schedule.
     * We return back a list of restaurants with updated schedules.
     * @param restaurants A List of restaurants
     * @return A list of restaurants with updated schedule information
     */
    private static List<Restaurant> setScheduleForMultipleRestaurants(List<Restaurant> restaurants){        

        ResultSet rs = null;
        
        for(Restaurant r : restaurants){

            String sql = SQLTranslator.translateGetRestaurantSchedule(r.getId());
            rs = DBHandler.query(sql);
            
            try 
            {
                while(rs.next()){
                    
                    int i = rs.getInt("dayOfWeekID");
                    
                    Time startTime = rs.getTime("start");
                    Time stopTime = rs.getTime("stop");
                    int closed = rs.getInt("closed");
                    int nonstop = rs.getInt("nonstop");
                    
                    // Needs to be GMT+1 because the DB is on swedish time.
                    TimeZone.setDefault(TimeZone.getTimeZone("GMT+1"));
                    
                    int start = startTime.toLocalTime().toSecondOfDay();
                    int stop = stopTime.toLocalTime().toSecondOfDay();

                    r.getSchedule().setSeconds(start, i, 0);
                    r.getSchedule().setSeconds(stop, i, 1);
                    r.getSchedule().setClosed(i, closed);
                    r.getSchedule().setNonStop(i, nonstop);
                    
                }
            } catch (Exception e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                return null;
            }
        }
        return restaurants;
    }
    
    /**
     * Should be used when adding the schedule of a newly created restaurant
     * @param ownerID Owner ID
     * @param name Restaurant Name
     * @return the Restaurant ID of the last auto-incremented Restaurant ID
     */
    public static int fetchRecentlyAddedRestaurantID(int ownerID, String name){
        int restaurantID = 0;
        String sql = SQLTranslator.translateRecentlyAddedRestaurantID(ownerID, name);
        ResultSet rs = DBHandler.query(sql);
        
        try{
            if(rs.next()){
                restaurantID = rs.getInt("ID");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return restaurantID;
    }
    
    /**
     * It transforms the restaurant resultSet to a list of Restaurants. The restaurants will be then included in the list given.
     * @param rs ResultSet
     * @return 
     */
    private static List<Restaurant> RsToRL(ResultSet rs)
    {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        RestaurantFactory rFactory = new RestaurantFactory();
        
        try
        {
            while (rs.next())
            {
                int id = rs.getInt ("ID");
                int ownerID = rs.getInt("Owner");
                String name = rs.getString("Name");
                // Make sure it matches the CONSTANT VALUE inside RestaurantType. It should be uppercase as valueOf(String) checks for the constant names, not the values behind the constant names. So if we wnated indian we must use INDIAN as that's how it is defined in the enum
                RestaurantType type = RestaurantType.findConstantByValue(rs.getString("Type"));
                String street = rs.getString("Street");
                String area = rs.getString("Area");
                String city = rs.getString("City");
                int zipCode = rs.getInt("Zipcode");
                String imageURL = rs.getString("ImageURL");
                int telephone = rs.getInt("Telephone");
                String description = rs.getString("Description");
                int minPrice = rs.getInt("MinPrice");
                int maxPrice = rs.getInt("MaxPrice");
                
                // Create and add a new restaurant with the data. The schedule is empty for now. Data for the schedule is added after this loop.
                restaurants.add(rFactory.getRestaurant("Existing", id, ownerID, name, type, street, area, city, zipCode, imageURL, telephone, description, minPrice, maxPrice, new RestaurantSchedule()));
            } // end of while
            
            // Update each of the restaurant's schedule
            List<Restaurant> finalRestaurants = setScheduleForMultipleRestaurants(restaurants);
            
            return finalRestaurants;
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            return null;
        }
    }

    /**
     * Filter restaurants by time day.
     * @param restaurants
     * @param time
     * @param dayOfWeek
     * @return 
     */
    private static List<Restaurant> filterRestaurantsByTimeDay(List<Restaurant> restaurants, String time, String dayOfWeek) {
        
        List<Restaurant> filteredRestaurants = new ArrayList<Restaurant>();
        
        for(Restaurant r : restaurants ){
            if(isRestaurantOpen(r,time,dayOfWeek))
                filteredRestaurants.add(r);
        }
        
        return filteredRestaurants;
    }

    /**
     * check if a restaurant is open at a specific day of a week
     * @param r Restaurant
     * @param time
     * @param dayOfWeek
     * @return 
     */
    private static boolean isRestaurantOpen(Restaurant r, String time, String dayOfWeek) {
        int day = r.getSchedule().parseDayStringToInt(dayOfWeek);
        int seconds = r.getSchedule().parseTimeStringToSeconds(time);
        return r.getSchedule().isOpen(day,seconds);
    }
}
