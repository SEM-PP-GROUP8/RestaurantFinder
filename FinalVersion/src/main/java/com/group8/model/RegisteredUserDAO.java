package com.group8.model;

import java.sql.ResultSet;

//Factory for the Registered User
public abstract class RegisteredUserDAO 
{
    //                      *****************************
    //                      ********** Queries **********
    //                      *****************************
    
    //Fetches the information from a user given the userID from the DB. Returns the information
    // collected in a RegisteredUser class.
    public static RegisteredUser fetchUserByID (int userID)
    {
        ResultSet rs = null;
        String sql = SQLTranslator.translateFindUserByID (userID);
        rs = DBHandler.query( sql);

        RegisteredUser currentUser = RsToRu(rs);
        //DBHandler.terminateDB();
        return currentUser;
    }

    //                      *****************************
    //                      ********** Updates **********
    //                      *****************************    
    
    //Recieves the information through a Registered User.
    //The method will update the user information in the DB with the recieved information.
    public static void updateUserDetails(RegisteredUser user) 
    {
        String sqlUpdate = SQLTranslator.translateUpdateUserDetails (user);
        DBHandler.update(sqlUpdate);
    }

    //Receives the userID the password and the table where the changes will happen.
    //The method updates the passowrd to a new password.
    public static void updatePassword(int id, String password, String table) 
    {
        String sqlUpdate = SQLTranslator.translateUpdatePassword (id, password, table);
        DBHandler.update(sqlUpdate);
    }
    
    //                      *****************************
    //                      ********** Helpers **********
    //                      *****************************
    
    //This is a helper method. It transfers the information on the resultSet recieved from the DB query
    // to a registered user. It checks if the variables are null (variables are not demanded) then it 
    // sets them to a default value.
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
}
