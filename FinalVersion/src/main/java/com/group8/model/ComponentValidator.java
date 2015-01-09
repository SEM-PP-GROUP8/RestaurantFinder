/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.group8.model;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author john
 */
public class ComponentValidator {

    private String error = "";

    private boolean valid = true;
    private String userInputValue = "";
    private int userInputValueAsInt;
    private boolean alphaNumeric;
    private boolean integer;
    
    private static Border defaultTextFieldBorder = null;
    
    private Component c;
    private String valueType; // integer, alphanumeric, null (for any)
    private int minVal;
    private int maxVal;
    private int length;
    private boolean emptyAllowed;
    private boolean isImageURL;
    private boolean isRestaurantName;
    private boolean isOwnerID;
    private int lowerLimitRangeValue;
    private int higherLimitRangeValue;
    
  public ComponentValidator(Component scheduleContent){

      Component[] f = ((JPanel) scheduleContent).getComponents();
      
        for ( Component c : f){
            
          if(c.getName() != null && c.getName().equalsIgnoreCase("scheduleContent")){

                Component[] days = ( (JPanel) c ).getComponents();
                // Loop through each day panel
                for(int i = 0; i < days.length ; i++){

                    Component[] elements = ((JPanel) days[i]).getComponents();
                    
                    String start = ((JTextField) elements[1]).getText();
                    String stop = ((JTextField) elements[2]).getText();
                    boolean closed = ((JCheckBox) elements[3]).isSelected();
                    boolean endless = ((JCheckBox) elements[4]).isSelected();

                    // Use regex to match for the HH:mm format
                    Pattern pattern;
                    Matcher m1, m2;

                    pattern = Pattern.compile("(([0-1][0-9])|2[0-3]):[0-5][0-9]");
                    m1 = pattern.matcher(start);
                    m2 = pattern.matcher(stop);

                    if( ! m1.matches() ){
                        highlightComponent(((JTextField) elements[1]));
                        error = "There is a problem with the day format. Please use this format: HH:mm";
                    }
                    if( ! m2.matches() ){
                        highlightComponent(((JTextField) elements[2]));
                        error = "There is a problem with the day format. Please use this format: HH:mm";
                    }

                    // Only go further if there is no error (format is valid). Otherwise parsing will cause an exception.
                    // This part checks if the start is strictly smaller than stop
                    if(error.equalsIgnoreCase("")){
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                        Date date;

                        try {
                        date = sdf.parse("1970-01-01 " + start);
                        int startSeconds = (int) date.getTime();
                        date = sdf.parse("1970-01-01 " + stop);
                        int stopSeconds = (int) date.getTime();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                 
                }
                
            }       
        }
    }  
    
    public ComponentValidator(Component minPrice, Component maxPrice, int minVal, int maxVal, Border defaultBorder){
        
        // Validate both minPrice and maxPrice. They will get highlighted.
        // We only need to store the error message once. If the first field validated, check if the next one has problems
        ComponentValidator cpvMin = new ComponentValidator(minPrice, "integer", 1,     1000000,    5,      false, false, false, false, defaultTextFieldBorder  );
        ComponentValidator cpvMax = new ComponentValidator(maxPrice, "integer", minVal,     maxVal,    5,      false, false, false, false, defaultTextFieldBorder  );
        
        this.error = cpvMin.getError();
        // If first component validator has no error string
        if(this.error.equalsIgnoreCase(""))
            this.error = cpvMax.getError();
        
        // If none of the two have an error string, proceed in comparing the values to each other
        if(this.error.equalsIgnoreCase("")){
            int minPriceVal = Integer.parseInt(((JTextField) minPrice).getText());
            int maxPriceVal = Integer.parseInt(((JTextField) maxPrice).getText());
            
            if(minPriceVal > maxPriceVal){
                this.error = "The minimum price has to be strictly smaller than maximum";
                if(minPriceVal == minVal){
                    highlightComponent(maxPrice);
                }
                else
                    highlightComponent(minPrice);
            }
        }

    }
  
    public ComponentValidator(Component c, String valueType, int minVal, int maxVal, int length, boolean emptyAllowed, boolean isImageURL, boolean isRestaurantName, boolean isOwnerID, Border defaultTextFieldBorder) {
        this.c = c;
        this.valueType = valueType;
        this.minVal = minVal;
        this.maxVal = maxVal;
        this.length = length;
        this.emptyAllowed = emptyAllowed;
        this.isImageURL = isImageURL;
        this.isRestaurantName = isRestaurantName;
        this.isOwnerID = isOwnerID;
        this.lowerLimitRangeValue = lowerLimitRangeValue;
        this.higherLimitRangeValue = higherLimitRangeValue;
        
        if(defaultTextFieldBorder == null)
            this.defaultTextFieldBorder = defaultTextFieldBorder;
        
        if(c instanceof JTextField){
            this.userInputValue = ((JTextField) c).getText();
        }
        else if (c instanceof JComboBox){
            this.userInputValue = ((JComboBox) c).getSelectedItem().toString();
        }
        else if (c instanceof JTextArea){
            this.userInputValue = ((JTextArea) c).getText();
        }
        
        this.userInputValue = this.userInputValue.trim();
        
        this.valid = validateDetails();
    }
    
    private boolean validateDetails(){
        
        if(error == "" && !emptyAllowed && userInputValue.equals("")){
            error = c.getName() + " is empty. You need to insert a value here";
        }
        
        if(error == "" && valueType.equalsIgnoreCase("integer")){
            try {
                userInputValueAsInt = Integer.parseInt(userInputValue);    
            } catch (Exception e) {
                error = c.getName() + " can only have numbers!";
            }
            
            integer = true;
            alphaNumeric = false;
        }
        
        if(valueType.equalsIgnoreCase("alphanumeric")){
            alphaNumeric = true;
            integer = false;
        }
        
        if(error == "" && (isInteger() && minVal > -1 && (userInputValueAsInt < minVal))){
            error = c.getName() + "can not be smaller than " + minVal;
        }
        
        if(error == "" && (isInteger() && maxVal > -1 && (userInputValueAsInt > maxVal))){
            error = c.getName() + "can not be greater than " + maxVal;
        }
        
        if(error == "" && (isAlphaNumeric() && length > -1 && (userInputValue.length() > length))){
            error = c.getName() + "\'s length can not be longer than" + length + ". The current length is: " + userInputValue.length() + ".";
        }

        if(error == "" && isImageURL){
            if(!testImage(userInputValue))
                error = "The Image URL can not be accessed";
            // NEED EDIT CHANGE UPDATE LATER
        }
        
        if(error == "" && (isRestaurantName && RestaurantDAO.restaurantNameExists(userInputValue))){
            error = "Restaurant name is taken!";
        }

        
        if(error == "" && isOwnerID){
            // check if owner id exists
        }
        
        if(error == ""){
            return true;
        }
        else{
            highlightComponent(c);
            return false;
        }
            
    }

    public boolean isValid() {
        return valid;
    }    
    
    public boolean isAlphaNumeric() {
        return alphaNumeric;
    }

    public boolean isInteger() {
        return integer;
    }

    private void highlightComponent(Component c) {
        
        if(c instanceof JTextField){
            JTextField jtf = (JTextField) c;
            
            jtf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

            jtf.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        ((JTextField) evt.getSource()).setBorder(defaultTextFieldBorder);
                    }
            });
            
            jtf.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent evt){
                    ((JTextField) evt.getSource()).setBorder(defaultTextFieldBorder);
                }
            });
        }
        
        if(c instanceof JTextArea){
            JTextArea jta = (JTextArea) c;
            
            jta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 2));

            jta.addKeyListener(new java.awt.event.KeyAdapter() {
                    public void keyTyped(java.awt.event.KeyEvent evt) {
                        ((JTextArea) evt.getSource()).setBorder(defaultTextFieldBorder);
                    }
            });
            
            jta.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseClicked(MouseEvent evt){
                    ((JTextArea) evt.getSource()).setBorder(defaultTextFieldBorder);
                }
            });

        }
        
    }
    
    public String getError() {
        return error;
    }

    public Boolean testImage(String url){  
        try {  
            BufferedImage image = ImageIO.read(new URL(url));  
            if(image != null){  
                return true;
            } else {
                error = "The target URL is valid and accesable, but does not contain an image";
                return false;
            }
        } catch (MalformedURLException e) {  
            error = "The target URL is invalid. Code 010";
            return false;
        } catch (IOException e) {  
            error = "The target URL is invalid. Code 020";
            return false;  
        }
    }
    
}
