package com.group8.model;
import java.sql.Time;
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
        
        System.out.println("The time string is" + time);
        
        try {
            date = sdf.parse("1970-01-01 " + time);
            seconds = (int) date.getTime() / 1000;
        } catch (Exception e) {
            System.out.println("At this moment, he knew, he'd fucked up. parseTimeStringToSeconds(String time) Parsing failed");
        }
        
        return seconds; 
    }

    boolean isOpen(int day, int seconds) {
        System.out.println("The day is " + day + " and the seconds are: " + seconds + ". Returning flase by default.");
        return false;
        
        /*
        if(isEndless(day))
            return true;
        
        if(isPreviousDayExtending(day))
            // Verifica daca este intre 00:00 si STOPUL din ziua prvious
            
        if(isClosed(day))
            return false;
        
        int start = getSeconds(day, 0);
        int stop = getSeconds(day, 1);
        
        if(seconds > start && seconds < stop)
            return true;
        else
            return false;
        */
    }
    
    private boolean isPreviousDayExtending(int currentDay){
        
        currentDay = currentDay == 0 ? dayOfWeekString.length - 1 : currentDay - 1;
        
        int start = getSeconds(currentDay, 0);
        int stop = getSeconds(currentDay, 1);
        return (start > stop);
    }
}
