package com.group8.model;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    
    /**
     * This method fetches all the owners from the database.
     * @return a list of RegisteredOwner containing all the owners in the DB.
     */
    public static List<RegisteredOwner> getAllOwners() 
    {
        ResultSet rs = null;
        String sql = SQLTranslator.fetchAllOwners();
        rs = DBHandler.query( sql);

        List<RegisteredOwner> allOwners = RsToRoL(rs);
        return allOwners;
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
    
    /**
     * This method deletes a specific owner from the database.
     * @param id 
     */
    public static void deleteOwner(int id) 
    {
        String sql = SQLTranslator.translateDeleteOwner(id);
        DBHandler.update(sql);
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

    /**
     * This is a helper method. It transfers the information on the resultSet recieved from the DB query
     * to a registered owner list. It checks if the variables are null (variables are not demanded) then it 
     * sets them to a default value.
     * @param rs The resultSet to go through and transform to a RegisteredOwner type.
     * @return the RegisteredOwner list.
     */
    private static List <RegisteredOwner> RsToRoL(ResultSet rs) 
    {
        List <RegisteredOwner> allOwners = new ArrayList<RegisteredOwner>();
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
                allOwners.add(new RegisteredOwner (id, userName, surname, familyName, email, phone));
            }
        }
        catch (Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        return allOwners;
    }
}
