package com.group8.model;

abstract public class Session 
{
    private static final String defaultType = "guest";
    private static String type = defaultType; // Default value
    private static String username = ""; // Default value
    private static int userid = -1;

    public static void logout() {
        // Go back to default values
        Session.type = defaultType; 
        Session.username = "";
        Session.userid = -1;
    }

    //Getters
    
    public static String getType() {
        return Session.type;
    }
    
    public static int getId() {
        return Session.userid;
    }

    public static boolean isUser() {
        return "Users".equals(Session.type);
    }
    
    public static boolean isGuest() {
        return "guest".equals(Session.type);
    }
    
    public static boolean isOwner() {
        return "Owners".equals(Session.type);
    }

    public static boolean isAdmin() {
        return "Admins".equals(Session.type);
    }
    
    /**
     * authorize
     * @param username
     * @param password
     * @return 
     */
    public static boolean authorize(String username, String password)
    {
        // Check username and password for each type. If true, change session type from user to matched the one;
        if(checkCredentials(username, password, "Users"))
            Session.type = "Users";
        else if (checkCredentials(username, password, "Owners"))
            Session.type = "Owners";
        else if (checkCredentials(username, password, "Admins"))
            Session.type = "Admins";
        
        // If type is still guest, then authorization failed. If it's not guest, set the session username.
        if(Session.type == defaultType)
            return false;
        else {
            Session.username = username;
            Session.userid = Session.fetchUserid(username, password, Session.type);
            return true;
        }
    }
    
    /**
     * Fetch user ID.
     * @param username
     * @param password
     * @param type
     * @return 
     */
    private static int fetchUserid(String username, String password, String type)
    {
        if(!Session.isGuest()){
            return DBHandler.getCredentialsID(username, password, type);
        }
        return -1;
    }
    
    /**
     * Check credentials.
     * @param username
     * @param password
     * @param type
     * @return 
     */
    private static boolean checkCredentials(String username, String password, String type)
    {
        return DBHandler.checkCredentials(username, password, type);
    }
    
}

