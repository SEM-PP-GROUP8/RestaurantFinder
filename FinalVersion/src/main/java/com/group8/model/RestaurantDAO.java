/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group8.model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enriquecordero
 */
public abstract class RestaurantDAO 
{
    //                  ***************************
    //                  **    Query Functions    **
    //                  ***************************
    
    public static List<Restaurant> fetchRestaurantByFilters (String typeOfFood,int intPriceMin,int intPriceMax,String location,String time)
    {
        ResultSet rs = null;
        String sql = SQLTranslator.translateFindRestaurantByFilters (typeOfFood, intPriceMin, intPriceMax, location, time);
        rs = DBHandler.query( sql);
        List<Restaurant> restaurants = new ArrayList<>();
        RsToRL(rs, restaurants);
        DBHandler.terminateDB();
        return restaurants;
    }

    public static List<Restaurant> fetchAllRestaurants ()
    {
        ResultSet rs = null;
        String sql = SQLTranslator.translateAllRestaurants();
        rs = DBHandler.query(sql);
        List<Restaurant> restaurants = new ArrayList<>();
        RsToRL(rs, restaurants);
        DBHandler.terminateDB();
        return restaurants;
    }

    public static boolean restaurantExists (Restaurant rest)
    {
        String sql = SQLTranslator.translateRestaurantExists (rest);
        System.out.println ("Sql exist : " + sql);
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
        DBHandler.terminateDB();
        return false;
    }
    
    public static List<Restaurant> fetchRestaurantsByLogin(int UserId)
    {
        ResultSet rs = null;
        String sql = SQLTranslator.translateFindRestaurantByLogin(UserId);
        rs = DBHandler.query(sql);
        List<Restaurant> restaurants = new ArrayList<>();
        RsToRL(rs, restaurants);
        DBHandler.terminateDB();
        return restaurants;
    }
    
    //                  ***************************
    //                  **    Update Functions   **
    //                  ***************************
    
    public static void addRestaurant (Restaurant rest)
    {
        String sql = SQLTranslator.translateAddRestaurant(rest);
        DBHandler.update(sql);
    }
    
    public static void updateRestaurant (Restaurant rest)
    {
        String sqlUpdate = SQLTranslator.translateUpdateRestaurant(rest);
        System.out.println ("SQL update: " + sqlUpdate);
        DBHandler.update(sqlUpdate);
    }

    public static void deleteRestaurant (int id, String table)
    {
        String sql = SQLTranslator.translateDeleteRecord(id, table);
        DBHandler.update(sql);
    }
    
    //It transforms the restaurant resultSet to a list of Restaurants.
    //@Param ResultSet rs
    //@Param List<Restaurant> restaurants
    //The restaurants will be then included in the list given.
    private static void RsToRL(ResultSet rs, List<Restaurant> restaurants)
    {
        try
        {
            while (rs.next())
            {
                int id = rs.getInt ("ID");
                String name = rs.getString("Name");
                String street = rs.getString("Street");
                String area = rs.getString("Area");
                int zipcode = rs.getInt("Zipcode");
                String city = rs.getString("City");
                String type = rs.getString("Type");
                int minPrice = rs.getInt("MinPrice");
                int maxPrice = rs.getInt("MaxPrice");
                int owner = rs.getInt("Owner");

                restaurants.add(new Restaurant(id, name, street, area, zipcode, city, type, minPrice, maxPrice, owner));
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }
}
