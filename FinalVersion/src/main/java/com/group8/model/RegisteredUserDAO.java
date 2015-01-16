package com.group8.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//Factory for the Registered User
public abstract class RegisteredUserDAO 
{
    //                      *****************************
    //                      ********** Queries **********
    //                      *****************************
    
    /**
     * Fetches the information from a user given the userID from the DB. Returns the information
     * collected in a RegisteredUser class.
     * @param userID
     * @return Returns a RegisteredUser type.
     */
    public static RegisteredUser fetchUserByID (int userID)
    {
        ResultSet rs = null;
        String sql = SQLTranslator.translateFindUserByID (userID);
        rs = DBHandler.query( sql);

        RegisteredUser currentUser = RsToRu(rs);
        return currentUser;
    }
    
    /**
     * This method fetches all the users from the database.
     * @return a list of RegisteredUsers containing all the users in the DB.
     */
    public static List<RegisteredUser> getAllUsers() 
    {
        ResultSet rs = null;
        String sql = SQLTranslator.fetchAllUsers();
        rs = DBHandler.query( sql);

        List<RegisteredUser> allUsers = RsToRuL(rs);
        return allUsers;
    }

    //                      *****************************
    //                      ********** Updates **********
    //                      *****************************    
    
    /**
     * Receives the information through a Registered User.
     * The method will update the user information in the DB with the received information.
     * @param user Type RegisteredUser.
     */
    public static void updateUserDetails(RegisteredUser user) 
    {
        String sqlUpdate = SQLTranslator.translateUpdateUserDetails (user);
        DBHandler.update(sqlUpdate);
    }

    /**
     * Receives the userID the password and the table where the changes will happen.
     * The method updates the password to a new password.
     * @param id
     * @param password
     * @param table 
     */
    public static void updatePassword(int id, String password, String table) 
    {
        String sqlUpdate = SQLTranslator.translateUpdatePassword (id, password, table);
        DBHandler.update(sqlUpdate);
    }
    
    /**
     * This method deletes a specific user from the database.
     * @param userID 
     */
    public static void deleteUser (int userID)
    {
        String sql = SQLTranslator.translateDeleteUser(userID);
        DBHandler.update(sql);
    }
    
    //                      *****************************
    //                      ********** Helpers **********
    //                      *****************************
    
    /**
     * This is a helper method. It transfers the information on the resultSet received from the DB query
     * to a registered user. It checks if the variables are null (variables are not demanded) then it 
     * sets them to a default value.
     * @param rs ResultSet to go through and transform into a RegisteredUser type.
     * @return a RegisterUser type.
     */
    private static RegisteredUser RsToRu(ResultSet rs) 
    {
        RegisteredUser currentUser = null;
        try
        {
            if (rs.next())
            {
                int id = rs.getInt("ID");
                String userName = rs.getString("Username");
                String surname = rs.getString("Surname");
                if (rs.wasNull())
                    surname = "";
                String familyName = rs.getString("Famname");
                if (rs.wasNull())
                    familyName = "";
                String email = rs.getString("Email");
                if (rs.wasNull())
                    email = "";
                String phone = rs.getString("Phone");
                if (rs.wasNull())
                    phone = "";
                String area = rs.getString("Area");
                if (rs.wasNull())
                    area = "";
                String city = rs.getString("City");
                if (rs.wasNull())
                    city = "";
                currentUser = new RegisteredUser (id, userName, surname, familyName, email, phone, area, city);
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return currentUser;
    }
    
    /**
     * This is a helper method. It transfers the information on the resultSet received from the DB query
     * to a registered user list. It checks if the variables are null (variables are not demanded) then it 
     * sets them to a default value.
     * @param rs
     * @return 
     */
    private static List <RegisteredUser> RsToRuL(ResultSet rs) 
    {
        List <RegisteredUser> allUsers = new ArrayList<RegisteredUser>();
        try
        {
            while (rs.next())
            {
                int id = rs.getInt("ID");
                String userName = rs.getString("Username");
                String surname = rs.getString("Surname");
                if (rs.wasNull())
                    surname = "";
                String familyName = rs.getString("Famname");
                if (rs.wasNull())
                    familyName = "";
                String email = rs.getString("Email");
                if (rs.wasNull())
                    email = "";
                String phone = rs.getString("Phone");
                if (rs.wasNull())
                    phone = "";
                String area = rs.getString("Area");
                if (rs.wasNull())
                    area = "";
                String city = rs.getString("City");
                if (rs.wasNull())
                    city = "";
                RegisteredUser newUser = new RegisteredUser (id, userName, surname, familyName, email, phone, area, city);
                allUsers.add(newUser);
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return allUsers;
    }
}
