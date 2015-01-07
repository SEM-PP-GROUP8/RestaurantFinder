package com.group8.model;
import java.sql.Time;

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
}
