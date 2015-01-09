/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.group8.model;

import com.group8.view.editRestaurant.RestaurantEditView;
import java.awt.Component;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;
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
public class RestaurantEditViewDataValidator {

    private ArrayList errorMessages = new ArrayList<String>();
    private boolean valid = false;
    
    private int id;
    private int ownerID;
    private String name;
    private RestaurantType type;
    private String street;
    private String area;
    private String city;
    private int zipCode;
    private String imageURL;
    private int telephone;
    private String description;
    private int minPrice;
    private int maxPrice;
    private RestaurantSchedule schedule;
    
    HashMap<String,Component> detailsMap;
    
    Restaurant toBeSavedRestaurant;
    
    RestaurantEditView restaurantEditView;
    
    Border defaultTextFieldBorder;
    
    String initialName = "";
    
    public void validateRestaurantEditViewData(RestaurantEditView restaurantEditView, String operation){
        
        this.restaurantEditView = restaurantEditView;
        
        // Store the default style of the textfield so we can return to it
        this.defaultTextFieldBorder = restaurantEditView.getRestaurantDetails2().getNameTextField().getBorder();
        
        // Store the initial name of the restaurant from the persistent data
        if(((Restaurant) restaurantEditView.getRestaurantSearchableList().getRestaurantList().getSelectedValue()).getName() != null)
            this.initialName = ((Restaurant) restaurantEditView.getRestaurantSearchableList().getRestaurantList().getSelectedValue()).getName().trim();
                
        detailsMap = mapDetails(restaurantEditView);

//Constructor order:
// Component c, String valueType, int minVal, int maxVal, int length, boolean emptyAllowed, boolean isImageURL, boolean isRestaurantName, boolean isOwnerID, int lowerLimitRangeValue
        
        // If we are saving a new restaurant, we need to validate the name and check if name is taken
        if(operation.equalsIgnoreCase("save")){
            addErrorMessage(new ComponentValidator(detailsMap.get("name"),      "alphanumeric", -1, -1, 200, false, false, true, false, defaultTextFieldBorder));
        }            
        // If we are updating and the initial name is not the same with the final one, we need to check if name is taken
        else if(operation.equalsIgnoreCase("update") && ! ((JTextField) detailsMap.get("name")).getText().equalsIgnoreCase(this.initialName))
            addErrorMessage(new ComponentValidator(detailsMap.get("name"),      "alphanumeric", -1, -1, 200, false, false, true, false, defaultTextFieldBorder));
        
        // No need to validate if updating and keeping the same name. The name should be validated ;)        
        
        addErrorMessage(new ComponentValidator(detailsMap.get("ownerID"),   "integer",          0,     100000,     -1,     false, false, false,  true,  defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("type"),      "alphanumeric",    -1,     -1,         200,    false, false, false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("street"),    "alphanumeric",    -1,     -1,         200,    false, false, false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("area"),     "alphanumeric",     -1,     -1,         200,    false, false, false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("city"),     "alphanumeric",     -1,     -1,         200,    false, false, false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("zipCode"),  "integer",           0,     100000000,  -1,     false, false, false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("imageURL"), "alphanumeric",     -1,     -1,         65500,  false, true,  false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("telephone"), "integer",          0,     1000000000, -1,     false, false, false, false, defaultTextFieldBorder  ));
        addErrorMessage(new ComponentValidator(detailsMap.get("description"), "alphanumeric",  -1,     -1,         65500,  false, false, false, false, defaultTextFieldBorder  ));

        // Validate min and max price fields
        addErrorMessage(new ComponentValidator(detailsMap.get("minPrice"),detailsMap.get("maxPrice"), 1, 1000000, defaultTextFieldBorder ));
        
        // Validate the schedule data
        addErrorMessage(new ComponentValidator(restaurantEditView.getRestaurantSchedule1()));
        
        if(!noMessage())
            this.valid = false;
        else{
            this.valid = true;
            buildToBeSaveRestaurant();
        }

    }
    
    private boolean noMessage(){
        return errorMessages.isEmpty();
    }
    
    private void buildToBeSaveRestaurant(){
        
        if(isValid()){

            String ownerID = ((JTextField) detailsMap.get("ownerID")).getText();
            String name = ((JTextField) detailsMap.get("name")).getText();
            String type = ((JComboBox) detailsMap.get("type")).getSelectedItem().toString();
            String area = ((JTextField) detailsMap.get("area")).getText();
            String city = ((JTextField) detailsMap.get("city")).getText();
            String street = ((JTextField) detailsMap.get("street")).getText();
            String zipCode = ((JTextField) detailsMap.get("zipCode")).getText();
            String imageURL = ((JTextField) detailsMap.get("imageURL")).getText();
            String telephone = ((JTextField) detailsMap.get("telephone")).getText();
            String description = ((JTextArea) detailsMap.get("description")).getText();
            String minPrice = ((JTextField) detailsMap.get("minPrice")).getText();
            String maxPrice = ((JTextField) detailsMap.get("maxPrice")).getText();
            
            RestaurantSchedule schedule = new RestaurantSchedule();
            
            Component[] f = (restaurantEditView.getRestaurantSchedule1()).getComponents();
            
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
                        
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
                        Date date;

                        int startMilliseconds = 0;
                        int stopMilliseconds = 0;
                        
                        try {
                            date = sdf.parse("1970-01-01 " + start);
                            startMilliseconds = (int) date.getTime();
                            date = sdf.parse("1970-01-01 " + stop);
                            stopMilliseconds = (int) date.getTime();                                
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        
                        System.out.println("REDVD. Build. Day + " + i + " Start: " + startMilliseconds + " Stop: " + stopMilliseconds);
                        
                        schedule.setSeconds(startMilliseconds, i, 0);
                        schedule.setSeconds(stopMilliseconds, i, 1);
                        schedule.setClosed(i, closed);
                        schedule.setNonStop(i, endless);            
                        }
                    }                    
                }
            
            // We need to get the ID from the list. It is not in the fields.
            this.id = ((Restaurant) restaurantEditView.getRestaurantSearchableList().getRestaurantList().getSelectedValue()).getId();
            this.ownerID = Integer.parseInt(ownerID);
            this.name = name;
            this.type = RestaurantType.findConstantByValue(type);
            this.area = area;
            this.city = city;
            this.street = street;
            this.zipCode = Integer.parseInt(zipCode);
            this.imageURL = imageURL;
            this.telephone = Integer.parseInt(telephone);
            this.description = description;
            this.minPrice = Integer.parseInt(minPrice);
            this.maxPrice = Integer.parseInt(maxPrice);
            this.schedule = schedule;
            
            RestaurantFactory rFactory = new RestaurantFactory();
            toBeSavedRestaurant = rFactory.getRestaurant("ToBeSaved", id, this.ownerID, this.name, this.type, this.street, this.area, this.city, this.zipCode, this.imageURL, this.telephone, this.description, this.minPrice, this.maxPrice, this.schedule);
        }
    }
    
    public Restaurant getToBeSavedRestaurant(){
        return this.toBeSavedRestaurant;
    }
    
    public ArrayList<String> getErrorMessages() {
        return errorMessages;
    }
    
    public void resetValidator(){
        this.setValid(false);
        this.errorMessages = new ArrayList<String>();
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private HashMap<String, Component> mapDetails(RestaurantEditView restaurantEditView) {
        HashMap<String, Component> map = new HashMap<String, Component>();
        
        Component ownerID = restaurantEditView.getRestaurantDetails2().getOwnerIDTextField();
        Component name = restaurantEditView.getRestaurantDetails2().getNameTextField();
        Component type = restaurantEditView.getRestaurantDetails2().getTypeComboBox();
        Component area = restaurantEditView.getRestaurantDetails2().getAreaTextField();
        Component city = restaurantEditView.getRestaurantDetails2().getCityTextField();
        Component street = restaurantEditView.getRestaurantDetails2().getStreetTextField();
        Component zipCode = restaurantEditView.getRestaurantDetails2().getZipCodeTextField();
        Component imageURL = restaurantEditView.getRestaurantDetails2().getImageURLTextField();
        Component telephone = restaurantEditView.getRestaurantDetails2().getTelephoneTextField();
        Component description = restaurantEditView.getRestaurantDetails2().getDescriptionTextArea();
        Component minPrice = restaurantEditView.getRestaurantDetails2().getMinPriceTextField();
        Component maxPrice = restaurantEditView.getRestaurantDetails2().getMaxPriceTextField();

        
        
        map.put(ownerID.getName(), ownerID);
        map.put(name.getName(), name);
        map.put(type.getName(), type);
        map.put(area.getName(), area);
        map.put(city.getName(), city);
        map.put(street.getName(), street);
        map.put(zipCode.getName(), zipCode);
        map.put(imageURL.getName(), imageURL);
        map.put(telephone.getName(), telephone);
        map.put(description.getName(), description);
        map.put(minPrice.getName(), minPrice);
        map.put(maxPrice.getName(), maxPrice);
        
        return map;
    }

    private void addErrorMessage(ComponentValidator cv) {
        if( ! cv.getError().trim().equalsIgnoreCase(""))
            this.errorMessages.add(cv.getError());    
    }
 

}
