package com.group8.model;

import java.sql.ResultSet;

//Factory for registered owner
public class RegisteredOwnerDAO 
{
    
    //                      *****************************
    //                      ********** Queries **********
    //                      *****************************
    
    /**
     * Fetches the data for a specific owner based on his ownerID. It calls the method to convert
     * the resultSet into a RegisteredOwner.
     * @param ownerID
     * @return a RegisterOwner type.
     */
    public static RegisteredOwner fetchOwnerByID (int ownerID)
    {
        ResultSet rs = null;
        String sql = SQLTranslator.translateFindOwnerByID (ownerID);
        rs = DBHandler.query( sql);
        RegisteredOwner currentOwner = RsToRo (rs);
        return currentOwner;
    }

    //                      *****************************
    //                      ********** Updates **********
    //                      *****************************  

    /**
     * Updates the owner personal information based on the information given by the owner in the 
     * program. It receives the information packaged in a RegisteredOwner class.
     * @param owner A RegisteredOwner type.
     */
    public static void updateOwnerDetails(RegisteredOwner owner) 
    {
        String sqlUpdate = SQLTranslator.translateUpdateOwnerDetails (owner);
        System.out.println ("SQL update: " + sqlUpdate);
        DBHandler.update(sqlUpdate);
    }

    /**
     * Updates the password of an owner based on his ID. It receives the ownerID the new
     * password and the table to insert it into.
     * @param id
     * @param password
     * @param table 
     */
    public static void updatePassword(int id, String password, String table) 
    {
        String sqlUpdate = SQLTranslator.translateUpdatePassword (id, password, table);
        System.out.println ("SQL update: " + sqlUpdate);
        DBHandler.update(sqlUpdate);
    }
    
    //                      *****************************
    //                      ********** Helpers **********
    //                      *****************************
    
    /**
     * This is a helper method. It transfers the information on the resultSet recieved from the DB query
     * to a registered owner. It checks if the variables are null (variables are not demanded) then it 
     * sets them to a default value.
     * @param rs The resultSet to go through and transform to a RegisteredOwner type.
     * @return the RegisteredOwner.
     */
     private static RegisteredOwner RsToRo(ResultSet rs) 
    {
        RegisteredOwner currentOwner = null;
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
                currentOwner = new RegisteredOwner (id, userName, surname, familyName, email, phone);
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return currentOwner;
    }
}
