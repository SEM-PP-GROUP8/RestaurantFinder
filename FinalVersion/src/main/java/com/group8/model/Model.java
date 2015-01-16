
package com.group8.model;

public class Model 
{
    //                  ***************************
    //                  **   Arrays for Combos   **
    //                  ***************************
    
     //Array of possibilities for the type of food (Drop downs load from here)
    public static final String [] typeFoodArray = new String[]{"Any", "Indian", "Thai", "Italian", "Pizza", "Fast Food", "Kebab"};
    //Array of possibilities for the different locations (Drop downs load from here)
    public static final String [] locationArray = new String[] {"Any", "Center", "Haga", "Lindholmen", "Johanneberg", "Gamlestan", "Oldskroken", "Stampen"}; 
    //Array of possibilities for the time array. (Drop downs load from here)
    public static final String [] timeArray = new String [] {"Any", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", 
                                        "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00",
                                        "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}; 

    public static String[] getTypeFoodArray() {
        return typeFoodArray;
    }

    public static String[] getLocationArray() {
        return locationArray;
    }

    public static String[] getTimeArray() {
        return timeArray;
    }

}