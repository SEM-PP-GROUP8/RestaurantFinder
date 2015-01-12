
package com.group8.model;

import java.util.Calendar;


public class Model 
{
    //                  ***************************
    //                  **   Arrays for Combos   **
    //                  ***************************
    
    public static final String [] priceRangeMinArray = new String []{"0", "50", "100", "150", "200", "250"}; //Array of possibilities for the min price range (Drop downs load from here)
    public static final String [] priceRangeMaxArray = new String[]{"1000", "250", "200", "150", "100", "50"}; //Array of possibilities for the max price range (Drop downs load from here)
    public static final String [] typeFoodArray = new String[]{"Any", "Indian", "Thai", "Italian", "Pizza", "Fast Food", "Kebab"};; //Array of possibilities for the type of food (Drop downs load from here)
    public static final String [] locationArray = new String[] {"Any", "Center", "Haga", "Lindholmen", "Johanneberg", "Gamlestan", "Oldskroken", "Stampen"}; //Array of possibilities for the different locations (Drop downs load from here)
    public static final String [] timeArray = new String [] {"Any", "00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", 
                                        "07:00", "08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00",
                                        "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00", "23:00"}; //Array of possibilities for the time array. (Drop downs load from here)

    public static String[] getPriceRangeMinArray() {
        return priceRangeMinArray;
    }

    public static String[] getPriceRangeMaxArray() {
        return priceRangeMaxArray;
    }

    public static String[] getTypeFoodArray() {
        return typeFoodArray;
    }

    public static String[] getLocationArray() {
        return locationArray;
    }

    public static String[] getTimeArray() {
        return timeArray;
    }
    
    /*NEW*/
    public static int setCurrentOpeningHour() {
        
        // Get the current time and convert it to hours
        Calendar cal = Calendar.getInstance();
        String thisHour = "" + cal.get(Calendar.HOUR_OF_DAY) + ":00";
        
        // Loop through the timeArray
        for(int i = 0; i < timeArray.length; i++) {
            
            // If the item in the timearray matches the current hour
            if(timeArray[i].equalsIgnoreCase(thisHour))
                return i;
        
        }
        
        // If the current hour does not match any of the hours in the array
        return 0;
        
    }
    /*END NEW*/
    
}
