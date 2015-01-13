package com.group8.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public abstract class DBHandler 
{
    private final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    private final static String DB_USERNAME = "sql457184";
    private final static String DB_URL = "jdbc:mysql://sql4.freesqldatabase.com/" + DB_USERNAME;
    private final static String DB_PASSWORD = "kV1%xI3*";
    private static PreparedStatement stmt;
    private static Connection connection = null;

    //                  *****************************
    //                  ** Session Query Functions **
    //                  *****************************
    
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
        terminateDB();
        return false;
    }

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
        terminateDB();
        return id;
    }
    
    /*New*/
    public static void addUser (String username, String password)
    {
        String sql = SQLTranslator.translateAddUser(username, password);
        update(sql);
    }
    
    public static boolean checkUsername(String username) 
    {
        
        String queryString = SQLTranslator.translateCheckUsername (username);
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
        terminateDB();
        return false;
        
    }

    //                  ***************************
    //                  **      DB Functions     **
    //                  ***************************
    
    private static void initializeDB()
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

    protected static ResultSet update(String updateString)
    {
        initializeDB();	
	ResultSet rs = null;
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
        terminateDB();     
	return rs;
    }
    
    protected static ResultSet query(String queryString)
    {
        initializeDB();	
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
    
    /*NEW - Hampus*/
    // Get a username based on the logged in users id
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
        terminateDB();
        return userName;
        
    }
}
