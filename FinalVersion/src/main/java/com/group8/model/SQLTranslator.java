package com.group8.model;

import java.sql.Date;

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
	 * @return
	 */
	public static String translateFindRestaurantByFilters (String typeOfFood,int intPriceMin,int intPriceMax,String location,String time) {
		sqlQuery = "SELECT * FROM Restaurant WHERE ";
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
		
		sqlQuery += "Zipcode="+ rest.getZipcode() +" AND ";
		
		sqlQuery += "City='"+ rest.getCity() +"' AND ";
		
		sqlQuery += "Type='"+ rest.getType() +"' ;";
		
		return sqlQuery;
	}
	
	
	/**
	 * This function shall return the SQL statement to update the database. 
	 * It is similar to the add function in term of variables received (all the variables).
	 *  Where to set it depends always on the ID.
         * 
         * @Param Restaurant rest
         * @return
	 */
	public static String translateUpdateRestaurant (Restaurant rest) {
		
		sqlQuery = "UPDATE Restaurant SET ";
		
		sqlQuery += "Name='"+ rest.getName() +"', ";
                
                sqlQuery += "Street='"+ rest.getStreet() +"', ";
		
		sqlQuery += "Area='"+ rest.getArea() +"', ";
                
                sqlQuery += "Zipcode="+ rest.getZipcode()+", ";
		
		sqlQuery += "City='"+ rest.getCity() +"', ";
		
		sqlQuery += "Type='"+ rest.getType() +"', ";
		
		sqlQuery += "MinPrice="+ rest.getMinPrice() +", ";
		
		sqlQuery += "MaxPrice="+ rest.getMaxPrice() +", ";
		
		sqlQuery += "Owner="+ rest.getOwner() +"";
		
		sqlQuery += " WHERE ID="+ rest.getId() +";";
		
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
	
	/**
	 * This function shall return the SQL statement to Insert the values into the Restaurant table.
	 *  Where the values will be the variables received. Please take into account the Structure of the table 
	 *  and the variable types of each value. For example Name is a string and shall be respresented as �Name�. 
	 *  Also take into account that the ID is not needed to include in the statement given that the ID is autoincrement in the DB.
         * 
         * @Param Restaurant rest
         * @return
	 */
	public static String translateAddRestaurant (Restaurant rest)
        {
		
		sqlQuery = "INSERT INTO Restaurant (Name, Street, Area, Zipcode, City, Type, "
                        + "                         MinPrice, MaxPrice, Owner) VALUES ";
		
		sqlQuery += "('"+ rest.getName() +"', '"+ rest.getStreet() +"', '"+ rest.getArea() +"', '"
                                + rest.getZipcode() +"', '"+ rest.getCity() + "', '"+ rest.getType() + "'";
		
		sqlQuery += ", '"+ rest.getMinPrice() +"', '"+ rest.getMaxPrice() +"', '"+ rest.getOwner() +"') ;";
		
                System.out.println ("query to add: " + sqlQuery);
		return sqlQuery;
	}

        public static String translateFindRestaurantByLogin (int UserId)
        {
            String answer = "SELECT * FROM Restaurant where Owner = " + UserId + ";";
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

}