package com.group8.model;

import java.sql.Date;
import java.sql.Time;
import java.util.TimeZone;

public abstract class SQLTranslator 
{
	/**
	 * Create a result variable for reuse in all queries;
	 */
	private static String sqlQuery = "";
	
	/**
	 * This function shall return the SQL statement for looking through a 
	 * specific table for a username and a password.
	 * 
	 * @param username
	 * @param password
	 * @param table
	 * @return
	 */
	public static String translateCredentials (String username, String password, String table) {
		
		sqlQuery ="SELECT * FROM "+ table +" WHERE Username='"+ username +"' AND Password='"+password+"';";
		return sqlQuery;
	}
	
	
	/**
	 * This function shall return the SQL statement to find a specific restaurant given a set of filters. 
	 * Important to take into account that the statement shall depend on the status of 3 of the 
	 * values (typeOfFood, location, time)which can be the default �All�. 
	 * Given that these variables contain "All" then jump over them
	 * 
	 * @param typeOfFood
	 * @param intPriceMin
	 * @param intPriceMax
	 * @param location
	 * @param time
         * @param searchTxt
	 * @return
	 */
	public static String translateFindRestaurantByFilters (String typeOfFood,int intPriceMin,int intPriceMax,String location,String time, String searchTxt) {
		sqlQuery = "SELECT distinct * FROM Restaurant WHERE concat_ws(' ', Name, Type, Area) like '%";
		//if(searchTxt.equals(" ")){
                        //sqlQuery += 99999 + "%' and ";
                //}else{
                        sqlQuery += searchTxt + "%' and ";
                //}
                
                if(typeOfFood.equalsIgnoreCase("All")){
			// do nothing
		}else{
			sqlQuery += "Type='"+typeOfFood +"' AND ";
		}
		
		if(location.equalsIgnoreCase("ALL")){
			// do nothing
		}else{
			sqlQuery += "Area='"+location +"' AND ";
		}
		
		/*if(time.equalsIgnoreCase("ALL")){
			// do nothing
		}else{
			sqlQuery += "Time='"+ time +"' AND ";
		}*/
		
		sqlQuery += "MinPrice>="+ intPriceMin +" AND MaxPrice<="+ intPriceMax +";";
		
                System.out.println ("changed: " + sqlQuery);
		return sqlQuery;
	}
	
	
	/**
	 * This function shall return the SQL statement to find all restaurants. 
	 * 
	 * @return
	 */
	public static String translateAllRestaurants () {
		sqlQuery = "SELECT * FROM Restaurant;";
		return sqlQuery;
	}
 /**
	 * This function shall return the SQL statement to find out if a restaurant exists given the values. 
         * 
         * @Param Restaurant rest
         * @return
	 */
	public static String translateRestaurantExists (Restaurant rest) 
        {
		sqlQuery = "SELECT * FROM Restaurant WHERE ";
		
		sqlQuery += "Name='"+ rest.getName() +"' AND ";
		
		sqlQuery += "Street='"+ rest.getStreet() +"' AND ";
		
		sqlQuery += "Area='"+ rest.getArea() +"' AND ";
		
		sqlQuery += "Zipcode="+ rest.getZipCode() +" AND ";
		
		sqlQuery += "City='"+ rest.getCity() +"' AND ";
		
		sqlQuery += "Type='"+ rest.getType() +"' ;";
		
		return sqlQuery;
	}
        
        /**
         * 
         * Added by Sergiu
	 * This function shall return the SQL statement to find out if a restaurant name exists given the string name. 
         * 
         * @Param Restaurant rest
         * @return
	 */
	public static String translateRestaurantNameExists (String name) 
        {
		sqlQuery = "SELECT COUNT(*) FROM `Restaurant` WHERE `Name` = '" + name + "'";
		return sqlQuery;
	}
	
	// Modified by Sergiu
        public static String translateUpdateRestaurant (Restaurant r) {
            
            sqlQuery = "";

            int id = r.getId();
            int ownerID = r.getOwnerID();
            String name = r.getName();
            String type = r.getType().toString();
            String street = r.getStreet();
            String area = r.getArea();
            String city = r.getCity();
            int zipCode = r.getZipCode();
            int telephone = r.getTelephone();
            String imageURL = r.getImageURL();
            String description = r.getDescription();
            int maxPrice = r.getMaxPrice();
            int minPrice = r.getMinPrice();

            sqlQuery = String.format("UPDATE `Restaurant` SET "
                    + "`Owner` = '%d',"
                    + " `Name` = '%s',"
                    + " `Type` = '%s',"
                    + " `Street` = '%s',"
                    + " `Area` = '%s',"
                    + " `City` = '%s',"
                    + " `Zipcode` = '%d',"
                    + " `ImageURL` = '%s',"
                    + " `Telephone` = '%d',"
                    + " `Description` = '%s',"
                    + " `MinPrice` = '%d',"
                    + " `MaxPrice` = '%d'"
                    + " WHERE "
                    + "`Restaurant`.`ID` = %d;",
                    ownerID, name, type, street, area, city, zipCode, imageURL, telephone, description, minPrice, maxPrice, id);

            return sqlQuery;
	}
	
	
	
	/**
	 * This function shall return the SQL statement to delete a specific record from the DB.
	 *  
	 * @param id
         * @param table
	 * @return
	 */
	// I added table becuase it is needed 
	public static String translateDeleteRecord (int id, String table){
		
		sqlQuery ="DELETE FROM "+ table +" WHERE ID='"+ id +"';";
		return sqlQuery;
	}
	
        // Modified by Sergiu
	public static String translateAddRestaurant(Restaurant r){
            sqlQuery = "";
            
            int ownerID = r.getOwnerID();
            String name = r.getName();
            String type = r.getType().toString();
            String street = r.getStreet();
            String area = r.getArea();
            String city = r.getCity();
            int zipCode = r.getZipCode();
            int telephone = r.getTelephone();
            String imageURL = r.getImageURL();
            String description = r.getDescription();
            int maxPrice = r.getMaxPrice();
            int minPrice = r.getMinPrice();


            sqlQuery = String.format("INSERT INTO `Restaurant` "
                    + "(`Owner`, `Name`, `Type`, `Street`, `Area`, "
                    + "`City`, `Zipcode`, `ImageURL`, `Telephone`, `Description`, "
                    + "`MinPrice`, `MaxPrice`) "
                    + "VALUES "
                    + "('%d', '%s', '%s', '%s', '%s',"
                    + " '%s', '%d', '%s', '%d', '%s',"
                    + " '%d', '%d');",
                    ownerID , name , type , street ,
                    area , city , zipCode , imageURL , telephone , description, 
                    minPrice , maxPrice);

            return sqlQuery;
	}

        public static String translateFindRestaurantByLogin (int UserId)
        {
            String answer = "SELECT * FROM Restaurant where Owner = " + UserId + ";";
            return answer;
        }
        
        /**
         * Added By Sergiu
         * 
         * @param ownerID The owner ID
         * @param name the Name of the restaurant
         * @return The SQL string
         */
        public static String translateRecentlyAddedRestaurantID(int ownerID, String name)
        {
            String answer = "SELECT `ID` FROM `Restaurant` WHERE `Owner` = '" + ownerID + "' AND `Name` = '" + name + "' LIMIT 0,1;";
            return answer;
        }
        
        /*Start NEW*/
        public static String translateAddUser (String username, String password)
        {
            
            sqlQuery = "INSERT INTO Users (username, password) VALUES";
            
            sqlQuery += "('" + username + "', '" + password + "') ;";
            
            return sqlQuery;
        }
        
        public static String translateCheckUsername(String username) 
        {
            
            sqlQuery ="SELECT * FROM Users WHERE Username='"+ username +"';";
            return sqlQuery;
	}
        /*END NEW*/

        
        
        //KIKE _ USER
        
    //This method returns the SQL statement to find a specific user depending on the userID.
    static String translateFindUserByID(int userID) 
    {
        sqlQuery = "Select * From Users WHERE ID=" + userID + ";";
        System.out.println ("sql finduserbyid: " + sqlQuery);
        return sqlQuery;
    }

    //This method returns the SQL statement to update user details with the information given 
    // by the user.
    static String translateUpdateUserDetails(RegisteredUser user) 
    {
        sqlQuery = "UPDATE Users SET ";
        sqlQuery += "Surname = '" + user.getSurname() + "', ";
        sqlQuery += "Famname = '" + user.getFamilyName() + "', ";
        sqlQuery += "Email = '" + user.getEmail() + "', ";
        sqlQuery += "Phone = '" + user.getPhone() + "', ";
        sqlQuery += "Area = '" + user.getArea() + "', ";
        sqlQuery += "City = '" + user.getCity() + "' ";
        sqlQuery += "WHERE ID="+ user.getId() +";";
        return sqlQuery;
    }

    //This method returns the SQL statement to update the password of a user or owner depending on the
    //ID provided and the table provided.
    static String translateUpdatePassword(int id, String password, String table) 
    {
        sqlQuery = "UPDATE " + table + " SET ";
        sqlQuery += "Password = '" + password + "' ";
        sqlQuery += "WHERE ID = " + id + ";"; 
        return sqlQuery;
    }

    
    //KIKE _ OWNER
    
    //This method returns the sql statement to find a specific owner given an ID.
    static String translateFindOwnerByID(int ownerID) 
    {
        sqlQuery = "Select * From Owners WHERE ID=" + ownerID + ";";
        System.out.println ("sql findownerbyid: " + sqlQuery);
        return sqlQuery;
    }

    //This method returns the sql statement to update the personal details of an owner depending
    // on the information provided by the owner through the program.
    static String translateUpdateOwnerDetails(RegisteredOwner owner) 
    {
        sqlQuery = "UPDATE Owners SET ";
        sqlQuery += "Surname = '" + owner.getSurname() + "', ";
        sqlQuery += "Famname = '" + owner.getFamilyName() + "', ";
        sqlQuery += "Email = '" + owner.getEmail() + "', ";
        sqlQuery += "Phone = '" + owner.getPhone() + "' ";
        sqlQuery += "WHERE ID="+ owner.getId() +";";
        return sqlQuery;
    }

    
    //KIKE _ REVIEW
    
    //This method returns the SQL statement to find out whether or not a review has already
    // been made on a restauarant by a user depending on the restID and the userID.
    static String translateAlreadyReviewed(int restID, int userID) 
    {
        sqlQuery = "Select * from Reviews where Restaurant= " + restID + " and User= " + userID + ";";
        return sqlQuery;
    }

    //This method returns the SQL statement to find all the reviews 
    // made by a user based on his UserID.
    static String translateFetchUserReview(int userID) 
    {
        sqlQuery = "Select * from Reviews where User= " + userID + ";";
        return sqlQuery;
    }

    //This method returns the SQL statemnt to find all the reviews made to a restaurant 
    // based on the restID.
    static String translateFetchRestReview(int restID) 
    {
        sqlQuery = "Select * from Reviews where Restaurant= " + restID + ";";
        return sqlQuery;
    }

    //This method returns the SQL statement to delete a specific review based on the 
    // restID and the userID.
    static String translateDeleteReview(int restID, int userID) 
    {
        sqlQuery = "Delete from Reviews where Restaurant= " + restID + " and User= " + userID + ";";
        System.out.println ("review delete: " + sqlQuery);
        return sqlQuery;
    }

    //This method returns the SQL statement to add a review to the DB based on the information
    // provided by the user through the program.Recieves the information packaged as a Review class.
    static String translateAddReview(Review review) 
    {
        sqlQuery = "INSERT INTO Reviews (Restaurant, User, Review, Grade) VALUES";
        sqlQuery += "('" + review.restID + "', '" + review.getUserID() + "', '" + review.getReview() + "', '" + review.getGrade() + "') ;";
        return sqlQuery;
    }
    
    //This method returns the SQL statement to find a specific restaurant in the DB based
    // on the restaurantID.
    static String translateFindRestaurantByID (int restID)
    {
        sqlQuery = "Select * from Restaurant where ID = " + restID + ";";
        return sqlQuery;
    }
    
    /*NEW - Hampus*/
    public static String translateGetUsername(int userId) {
            
        sqlQuery = "SELECT * FROM Users WHERE ID='" + userId + "';";
        return sqlQuery;
            
    }
    
    public static String translateUpdateReview(Review review) {
            
        sqlQuery = "UPDATE Reviews SET ";
        sqlQuery += "Review='" + review.getReview() + "', ";
        sqlQuery += "Grade='" + review.getGrade() + "', ";
        sqlQuery += "Date='" + review.getDate() + "' ";
        sqlQuery += "WHERE Restaurant ='" + review.getRestID() + "' AND User='" + review.getUserID() + "';";
            
        return sqlQuery;
            
    }
    /**
     * Added by Sergiu
     * Generates the SQL string for getting the restaurant schedule given the restaurant ID
     * @param restaurantID The restaurant's id
     * @return returns the SQL string 
     */
    static String translateGetRestaurantSchedule(int restaurantID) {
        sqlQuery = "SELECT * FROM `RestaurantSchedules` WHERE `restaurantID` = " + restaurantID + " ORDER BY `dayOfWeekID` ASC LIMIT 0 , 7;";
        return sqlQuery;
    }
    
    /**
     * Added by Sergiu
     * Adds restaurant schedule
     * @param r Restaurant object that contains the schedule
     * @return The SQL string
     */
    public static String translateAddRestaurantSchedule(Restaurant r) {

        sqlQuery = "";
        
        sqlQuery = "INSERT INTO `RestaurantSchedules` "
                + "(`restaurantID`, `dayOfWeekID`, `start`, `stop`, `closed`, `nonstop`) "
                + "VALUES ";
        
        int dayOfWeek;
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Time start = new Time(0);
        Time stop = new Time(0);
        int closed;
        int nonStop;
        
        
        for(int i = 0; i < 7; i++){
            dayOfWeek = i;
            
            start.setTime(r.getSchedule().getSeconds(i, 0) * 1000);
            stop.setTime(r.getSchedule().getSeconds(i, 1) * 1000);
            
            closed = r.getSchedule().getClosed(dayOfWeek);
            nonStop = r.getSchedule().getNonStop(dayOfWeek);
            
            sqlQuery += "('" + r.getId() + "', '" + dayOfWeek + "', '" + start + "', '"+ stop + "', '"+ closed + "', '"+ nonStop + "')";
            
            if(i == 6)
                sqlQuery += ";";
            else
                sqlQuery += ",";
        }

        return sqlQuery;
    }
    
    /**
     * Added by Sergiu
     * Updates the Restaurant Schedule
     * @param r Restaurant object with Schedule
     * @return Returns the SQL string
     */
    public static String[] translateUpdateRestaurantSchedule(Restaurant r) {
        sqlQuery = "";
        String[] sqlArr = new String[7];
        
        int dayOfWeek;
        TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
        Time start = new Time(0);
        Time stop = new Time(0);
        
        for(int i = 0; i < 7; i++){
            
            dayOfWeek = i;
            start.setTime(r.getSchedule().getSeconds(i, 0) * 1000 );
            stop.setTime(r.getSchedule().getSeconds(i, 1) * 1000 );
            
            int closed = r.getSchedule().getClosed(dayOfWeek);
            int nonStop = r.getSchedule().getNonStop(dayOfWeek);
            
            sqlArr[i] = "UPDATE `RestaurantSchedules`"
                + " SET `start` = '"+ start +"', `stop` = '" + stop + "', "
                + "`closed` = '" + closed + "', `nonstop` = '" + nonStop + "'"
                + "WHERE `restaurantID` = " + r.getId() + " AND `dayOfWeekID` = " + dayOfWeek + ";";
        }
        return sqlArr;
    }
    
    /**
     * Added by Sergiu
     * @param rest
     * @return 
     */
    public static String translateRestaurantWithIDExists (Restaurant rest) 
    {
            sqlQuery = "SELECT `ID` FROM Restaurant WHERE ";		
            sqlQuery += "`Name` ='"+ rest.getName() +"' ;";

            return sqlQuery;
    }

}