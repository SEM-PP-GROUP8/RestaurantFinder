package com.group8.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO 
{
    //                      *****************************
    //                      ********** Updates **********
    //                      *****************************
    
    // Adds a review to the database
    public static void addReview (Review review)
    {
        String sql = SQLTranslator.translateAddReview(review);
        DBHandler.update(sql);
    }
    
    // Deletes a review from the database depending on the userID and restID
    public static void deleteReview (int restID, int userID)
    {
        String sql = SQLTranslator.translateDeleteReview(restID, userID);
        DBHandler.update(sql);
    }
    
    public static void updateReview(Review review) {
        
        String sql = SQLTranslator.translateUpdateReview(review);
        DBHandler.update(sql);
        
    }
    
    //                      *****************************
    //                      ********** Queries **********
    //                      *****************************
    
    // Boolean response on whether or not a review has been made from that user to that restaurant
    public static boolean alreadyReviewed (int restID, int userID)
    {
        String sql = SQLTranslator.translateAlreadyReviewed(restID, userID);
        ResultSet rs = DBHandler.query(sql);
        try
        {
            if (rs.next())
            {
                return true;
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        DBHandler.terminateDB();
        return false;
    }
    
    // Method that returns a review List that belong to a specific user.
    public static List<Review> fetchUserReviews (int userID)
    {
        String sql = SQLTranslator.translateFetchUserReview(userID);
        ResultSet rs = DBHandler.query(sql);
        List<Review> list = new ArrayList<>();
        RsToRL (rs, list);
        
        //Add the restaurant name.
        int index = list.size();
        for (int x=0; x<index;x++)
        {
            list.get(x).setRestName(findRestaurantName(list.get(x).getRestID()));
        }
        
        return list;
    }
    
    
    
    // Method that returns a review List that belong to a specific restaurant.
    public static List<Review> fetchRestReviews (int restID)
    {
        String sql = SQLTranslator.translateFetchRestReview(restID);
        ResultSet rs = DBHandler.query(sql);
        List<Review> list = new ArrayList<>();
        RsToRL (rs, list);
        
        //Add name of the user.
        int index = list.size();
        for (int x=0; x<index;x++)
        {
            list.get(x).setUserName(findUserName(list.get(x).getUserID()));
        }
        
        return list;
    }
    
    //                      *****************************
    //                      ********** Helpers **********
    //                      *****************************    
    
    // Helper method that transforms a resultSet into a review List.
    private static void RsToRL(ResultSet rs, List<Review> reviews)
    {
        try
        {
            while (rs.next())
            {
                int rest = rs.getInt ("Restaurant");
                int user = rs.getInt("User");
                String review = rs.getString("Review");
                int grade = rs.getInt("Grade");
                String date = rs.getString("Date");
                reviews.add(new Review(rest, user, review, grade, date));
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
    }

    // Method that returns the name of a specific restaurant. This is to add it to the review List-
    // When a user views what restaurants he has reviewed it is better if he can see the restaurant name.
    private static String findRestaurantName(int restID)
    {
        String name = "";
        String sql = SQLTranslator.translateFindRestaurantByID (restID);
        ResultSet rs = DBHandler.query(sql);
        try
        {
            if (rs.next())
            {
                name = rs.getString("Name");
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return name;
    }
    
    // Method that returns the username of a specific user. This is to add it to the review List-
    // When a user views what reviews a restaurant has it is better if he can see the users username.
    private static String findUserName(int userID) 
    {
        String name = "";
        String sql = SQLTranslator.translateFindUserByID (userID);
        ResultSet rs = DBHandler.query(sql);
        try
        {
            if (rs.next())
            {
                name = rs.getString("Username");
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return name;
    }
}
