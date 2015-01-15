package com.group8.model;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class RestaurantSchedule {
    
    private final String[] dayOfWeekString = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    private int scheduleArray[][];
    
    
    RestaurantSchedule(){
        this.scheduleArray = new int[7][4];
        
        for(int[] i : scheduleArray){
            i[0] = 0;
            i[1] = 0;
            i[2] = 0;
            i[3] = 0;
        }
    }
    
    public int getSeconds(int dayOfWeek, int bound){
        return this.scheduleArray[dayOfWeek][bound];
    }
    
    public void setSeconds(int value, int dayOfWeek, int bound){
        this.scheduleArray[dayOfWeek][bound] = value;
    }
    
    public String getFormatedTime(int dayOfWeek, int bounds){
                    
        int seconds = getSeconds(dayOfWeek, bounds);

        int minutes = ((seconds /  60) % 60);
        int hours = (seconds / 3600) % 24;
        
        return String.format("%02d:%02d", hours, minutes);
    }
    
    public boolean isClosed(int dayOfWeek){
        if(this.scheduleArray[dayOfWeek][2] == 1)
            return true;
        else
            return false;
    }
    
    public boolean isEndless(int dayOfWeek){
        if(this.scheduleArray[dayOfWeek][3] == 1)
            return true;
        else
            return false;
    }
    
    public void setClosed(int dayOfWeek, boolean b){
        this.scheduleArray[dayOfWeek][2] = b ? 1 : 0;
    }
    public void setClosed(int dayOfWeek, int value){
        this.scheduleArray[dayOfWeek][2] = value;
    }
    public void setNonStop(int dayOfWeek, boolean b){
        this.scheduleArray[dayOfWeek][3] = b ? 1 : 0;
    }
    public void setNonStop(int dayOfWeek, int value){
        this.scheduleArray[dayOfWeek][3] = value;
    }
    
    public int getClosed(int dayOfWeek){
        return this.scheduleArray[dayOfWeek][2];
    }
    public int getNonStop(int dayOfWeek){
        return this.scheduleArray[dayOfWeek][3];
    }
    
    @Override
    public String toString() {
        
        String output = "";
        
        for(int i = 0; i < 7; i++){            
            output += dayOfWeekString[i] + ": " + scheduleArray[i][0] + " - " + scheduleArray[i][1] + System.getProperty("line.separator");            
        }
        
        return output;
    }

    int parseDayStringToInt(String dayOfWeek) {
        
        for(int i = 0; i < dayOfWeekString.length ; i++){
            if(dayOfWeekString[i].equalsIgnoreCase(dayOfWeek))
                return i;
        }
        
        return -1;
    }

    int parseTimeStringToSeconds(String time) {
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date date;

        int seconds = -1;
        
        try {
            date = sdf.parse("1970-01-01 " + time);
            seconds = (int) date.getTime() / 1000;
        } catch (Exception e) {
            return -1;
        }
        
        return seconds; 
    }

    boolean isOpen(int day, int seconds) {
        
        // If both are any return true
        if(day == seconds && day == -1){
            return true;
        }
            
        
        // If day is any, we check all days.
        if(day == -1){
            for(int i = 0; i < 7 ; i++){
                if(isOpen(i, seconds)){
                    return true;
                }
                    
            }
            return false; // None of the days are open at that time
        }
        
        // Day is selected to specific value, but time is Any. So if it's not closed, then it's open. If it's closed, see if previous day is extending and it's not closed ;)
        if(seconds == -1){
            if(!isClosed(day)){
                return true; // True cus the day is not closed
            }
            else if(isPreviousDayClosed(day)){
                return false; // False if the day and previous day are both closed
            }
            else if (isPreviousDayExtending(day)){
                return true; // True if the day is closed but the previous day is extending
            }
            else{
                return false; // Just false
            }
                
        }
        
        // If we pass this point, it means we have a positive value for day and seconds
        
        if(isEndless(day)){
            return true; // If it's non stop then it's open all day
        }
            
        // Check if we are in extending period (between 00:00 and previous day stop)
        if(isPreviousDayExtending(day)){
            int previousDay = day == 0 ? dayOfWeekString.length - 1 : day - 1;
            int previousDayStop = getSeconds(previousDay, 1);
            
            if(seconds < previousDayStop){
                return true;
            }
        }

        if(isClosed(day)){
            return false;
        }
        
        int start = getSeconds(day, 0);
        int stop = getSeconds(day, 1);
        
        if(seconds >= start && seconds < stop){
            return true;
        }

        else if ((start>=stop)&&(seconds >= start)) {
            return true;
        }
        else {
            return false;
        }
    }
    
    private boolean isPreviousDayExtending(int currentDay){
        
        int previousDay = currentDay == 0 ? dayOfWeekString.length - 1 : currentDay - 1;
        
        int start = getSeconds(previousDay, 0);
        int stop = getSeconds(previousDay, 1);
        return (start >= stop);
    }

    private boolean isPreviousDayClosed(int currentDay) {
        int previousDay = currentDay == 0 ? dayOfWeekString.length - 1 : currentDay - 1;
        return isClosed(previousDay);
    }
}
