package com.group8.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public abstract class DBHandler 
{
    //The important information about the database to make the connection.
    private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private final static String DB_USERNAME = "sql457184";
    private final static String DB_URL = "jdbc:mysql://sql4.freesqldatabase.com/" + DB_USERNAME;
    private final static String DB_PASSWORD = "kV1%xI3*";
    //The prepared statement and the connection used to do querys updates and connection to the DB.
    private static PreparedStatement stmt;
    private static Connection connection = null;

    //                  *****************************
    //                  ** Session Query Functions **
    //                  *****************************
    
    /**
     * The method checks if a specific username and password match in a specific table.
     * @param username
     * @param password
     * @param table
     * @return True or false depending if the username and password exists in the table.
     */
    public static boolean checkCredentials(String username, String password, String table) 
    {
        String queryString = SQLTranslator.translateCredentials (username, password, table);
        ResultSet rs = query(queryString);		
        try 
        {
            if(rs.next())
            {
                return true;
            }
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    /**
     * The method retrieves the Id of a specific user with a specific password from a specific table.
     * @param username
     * @param password
     * @param table
     * @return the id of the specific user.
     */
    public static int getCredentialsID(String username,String password, String table) 
    {
        String queryString = SQLTranslator.translateCredentials (username, password, table);
	ResultSet rs = query(queryString);
        int id = 0;
        try {
                if (rs.next()){
                        id = rs.getInt("ID");
                }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        return id;
    }
    
    /**
     * Adds a user to the DB.
     * @param username
     * @param password 
     */
    public static void addUser (String username, String password)
    {
        String sql = SQLTranslator.translateAddUser(username, password);
        update(sql);
    }
    
    /**
     * Adds an owner to the DB.
     * @param username
     * @param password 
     */
    public static void addOwner (String username, String password)
    {
        String sql = SQLTranslator.translateAddOwner(username, password);
        update(sql);
    }
    
    /**
     * Method checks if a specific username is already in use in a specific table.
     * @param username
     * @param table
     * @return true or false depending if a username exists in that table.
     */
    public static boolean checkUsername(String username, String table) 
    {
        
        String queryString = SQLTranslator.translateCheckUsername (username, table);
        ResultSet rs = query(queryString);
        
        try 
        {
            if(rs.next())
            {
                return true;
            }
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return false;
        
    }

    //                  ***************************
    //                  **      DB Functions     **
    //                  ***************************
    
    /**
     * Initializes the connection to the Database.
     */
    public static void initializeDB()
    {
        try 
        {
            Class.forName(JDBC_DRIVER);		

        } 
        catch (ClassNotFoundException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        // Connect to a database
        try 
        {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try 
        {
            connection.setAutoCommit(false);
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
    /**
     * Terminates the connection to the Database.
     */
    public static void terminateDB()
    {
        try 
        {
            connection.close();
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
    /**
     * Commits a specific event stored in the connection.
     */
    private static void commit()
    {
        try 
        {
            connection.commit();
        } 
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Does the update of a specific SQL statement.
     * @param updateString
     */
    protected static void update(String updateString)
    {
	try 
        {
            stmt = connection.prepareStatement(updateString);
		
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}	
	try 
        {
            stmt.executeUpdate();
	} 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        commit();   
    }
    
    /**
     * Does a query with the provided sql statement.
     * @param queryString
     * @return the resultSet product of the query in the database.
     */
    protected static ResultSet query(String queryString)
    {	
	ResultSet rs = null;
	try 
        {
            stmt = connection.prepareStatement(queryString);
        } 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}	
	try 
        {
            rs = stmt.executeQuery();
	} 
        catch (SQLException e) 
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
	}
        commit();  
	return rs;
    }
    
    /**
     * Get a username based on the logged in users id
     * @param userId
     * @return the username
     */
    public static String getUsername(int userId) {
        
        String sql = SQLTranslator.translateGetUsername(userId);
        ResultSet rs = query(sql);
        String userName = "";
        
        try {
           
            while(rs.next())
                userName = rs.getString("Username"); 
        
        } catch(SQLException ex) {
            
            ex.printStackTrace();
        }
        return userName;     
    }
}
