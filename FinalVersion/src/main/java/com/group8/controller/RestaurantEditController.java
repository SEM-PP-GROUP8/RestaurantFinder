package com.group8.controller;

import com.group8.model.Restaurant;
import com.group8.model.RestaurantDAO;
import com.group8.model.RestaurantEditViewDataValidator;
import com.group8.model.RestaurantFactory;
import com.group8.model.RestaurantType;
import com.group8.model.Session;
import com.group8.view.editRestaurant.RestaurantEditView;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RestaurantEditController {
    
    private final Controller mainController;
    private List<Restaurant> existingRestaurants = new ArrayList<Restaurant>(); // used to store restaurants that exist in the DB
    private Restaurant temporaryRestaurant; // used to store information about a restaurant the user is trying to add
    private RestaurantEditView restaurantEditView; // This is the view
    private RestaurantFactory rFactory = new RestaurantFactory(); // used to create restaurant objects

    public RestaurantEditController(Controller mainController) {
        this.mainController = mainController;
        buildPersistentData();
        // Nothing happens after this. The main controller has to call the loadView() method.
    }
    
    /**
     * Builds persistent data with all the restaurants that current session has access to.
     * Use the List existingRestaurants attribute to access the data.
     */
    private void buildPersistentData(){
        // Load all restaurants the current user has
        if (Session.isAdmin()){
            existingRestaurants = RestaurantDAO.fetchAllRestaurants();
        }
        else if(Session.isOwner()){
            existingRestaurants = RestaurantDAO.fetchRestaurantsByLogin(Session.getId());
        }
    }
    
    /** 
     * Used by the main controller to load the view
     */
    public void loadView(){
        restaurantEditView = new RestaurantEditView(this);
        initialView();
        restaurantEditView.setVisible(true);
    }
    
    /**
     * Loads the initial view with its details fields not enabled.
     */
    public void initialView(){
        setRestaurantDetailsEnabled(false);
        // Create a model to be used by the JList and populate it with Restaurants. Restaurants have a toString() method that returns the Restaurant's title
        updateRestaurantList();
        // Set the default visibility of the buttons
        updateButtons("none");
    }
    
    /**
     * Enables or disables the restaurant details and schedule components. If we disable them, we also clear out written information inside the fields
     */
    public void setRestaurantDetailsEnabled(boolean enabled){
        // clear the details if we disable the fields
        if(!enabled){
            clearRestaurantDetails();
        }
        // If session is Owner, the ownerID field is always disabled
        if(Session.isAdmin())
            restaurantEditView.getRestaurantDetails2().getOwnerIDTextField().setEnabled(enabled);
        else
            restaurantEditView.getRestaurantDetails2().getOwnerIDTextField().setEnabled(false);
        
        restaurantEditView.getRestaurantDetails2().getNameTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getTypeComboBox().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getAreaTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getCityTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getStreetTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getZipCodeTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getImageURLTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getTelephoneTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getDescriptionTextArea().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getMinPriceTextField().setEnabled(enabled);
        restaurantEditView.getRestaurantDetails2().getMaxPriceTextField().setEnabled(enabled);
        
        // This part enables or disables the schedule fields and check boxes for each day panel
        Component[] days = getDaysComponents();
        
        if (days != null){
            for(int i = 0; i < days.length ; i++){
                Component[] elements = ((JPanel) days[i]).getComponents();
                
                for(Component c : elements){
                    if (c instanceof JTextField)
                        ((JTextField) c).setEnabled(enabled);
                    else if (c instanceof JCheckBox)
                        ((JCheckBox) c).setEnabled(enabled);
                }
            }
        }
        
    }
    
    /**
     * Clears the written values inside the restaurant details and schedule fields
     */
    public void clearRestaurantDetails(){
        
        restaurantEditView.getRestaurantDetails2().getOwnerIDTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getNameTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getAreaTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getCityTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getStreetTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getZipCodeTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getImageURLTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getTelephoneTextField().setText("");
        restaurantEditView.getRestaurantDetails2().getDescriptionTextArea().setText("");
        
        // Start setting the schedule fields to blank and uncheck the check boxes :)
        Component[] days = getDaysComponents();
        
        if (days != null){
            for(int i = 0; i < days.length ; i++){
                Component[] elements = ((JPanel) days[i]).getComponents();
                
                for(Component c : elements){
                    if (c instanceof JTextField)
                        ((JTextField) c).setText("");
                    else if (c instanceof JCheckBox)
                        ((JCheckBox) c).setSelected(false);
                }
            }
        }
        
    }
    
    /**
     * @return Returns an array of components of each day. The size should be 7. This is tightly coupled with the structure of the RestaurantSchedule
     */
    private Component[] getDaysComponents(){
        Component[] f = restaurantEditView.getRestaurantSchedule1().getComponents();
        
        for ( Component c : f){
            if(c.getName() != null && c.getName().equalsIgnoreCase("scheduleContent")){
                return ( (JPanel) c ).getComponents();
            }
        }
        return null;
    }
    
    
    /**
     * Updates the restaurant JList. Takes into account the string contained in the search box.
     */
    public void updateRestaurantList(){
        
        String listSearchKey = restaurantEditView.getRestaurantSearchableList().getSearchField().getText();
                
        DefaultListModel model;
        
        // If the list is empty, then generate it. Should be empty when we first load the view
        if (restaurantEditView.getRestaurantSearchableList().getRestaurantList().getModel().getSize() == 0){

            model = new DefaultListModel();
            if(temporaryRestaurant != null)
                model.addElement(temporaryRestaurant);

            if(existingRestaurants != null){
                for(Restaurant r : existingRestaurants){
                    if(listSearchKey == "")
                        model.addElement(r);
                    else if(r.getName().toLowerCase().contains(listSearchKey.toLowerCase()))
                        model.addElement(r);
                }
            }
            
            restaurantEditView.getRestaurantSearchableList().getRestaurantList().setModel(model);
        }
        else { // it already has a model, so let's refresh it. Remove all items and add them again
            // This will remove all elements from the model that the jlist has.
            model = (DefaultListModel) ( restaurantEditView.getRestaurantSearchableList().getRestaurantList().getModel() ) ;
            model.removeAllElements();
            // Lets start adding fresh ones:
            // Add the temporary one first!
            if(temporaryRestaurant != null)
                model.addElement(temporaryRestaurant);
            
            // Now let's add the others and keep track of the search key
            for(Restaurant r : existingRestaurants){
                if(listSearchKey == "")
                    model.addElement(r);
                else if(r.getName().toLowerCase().contains(listSearchKey.toLowerCase()))
                    model.addElement(r);
            }
            // Apparently when don't have to re-ad the model, it just syncs by itself.
            
        }
    }
    
    /**
     * @param s Scenario
     * "Existing" is when we select a restaurant that exists in the DB
     * "Temporary" when we're trying to create a new one, but doesn't exist in the database yet (needs saving)
     * "None" means when we haven't selected any restaurant
     */
    public void updateButtons(String s){
        if(s.equalsIgnoreCase("Existing")){
            restaurantEditView.getRestaurantButtons().getCreateButton().setVisible(true);
            restaurantEditView.getRestaurantButtons().getSaveButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getUpdateButton().setVisible(true);
            restaurantEditView.getRestaurantButtons().getDeleteButton().setVisible(true);
            restaurantEditView.getRestaurantButtons().getDiscardButton().setVisible(false);
        }
        if(s.equalsIgnoreCase("Temporary")){
            restaurantEditView.getRestaurantButtons().getCreateButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getSaveButton().setVisible(true);
            restaurantEditView.getRestaurantButtons().getUpdateButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getDeleteButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getDiscardButton().setVisible(true);
        }
        if(s.equalsIgnoreCase("None")){
            restaurantEditView.getRestaurantButtons().getCreateButton().setVisible(true);
            restaurantEditView.getRestaurantButtons().getSaveButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getUpdateButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getDeleteButton().setVisible(false);
            restaurantEditView.getRestaurantButtons().getDiscardButton().setVisible(false);
        }
    }

    
    /**
     * Called when clicking the update button
     */
    public void updateRestaurant() {
        
        RestaurantEditViewDataValidator validator = new RestaurantEditViewDataValidator();
        validator.validateRestaurantEditViewData(restaurantEditView, "update");
        
        if( ! validator.isValid()){
            loadMessage(validator.getErrorMessages());
            validator.resetValidator();
        } else {
            Restaurant toBeSaved = validator.getToBeSavedRestaurant(); // get the restaurant modified with user data that has been valdiated            
            RestaurantDAO.updateRestaurant(toBeSaved); // Save the restaurant
            buildPersistentData(); // We need to rebuild the data
            initialView(); // load the initial view    
        }
    }
    
    /**
     * Displays a message dialog from an ArrayList of string
     * @param messages The error messages
     */
    public void loadMessage(ArrayList<String> messages){
        
        String output = "";
        
        for (String msg : messages){
      
            output += msg + "\n";
        }
        
        JOptionPane.showMessageDialog(restaurantEditView, output);
    }
    /**
     * Displays a message dialog from a String
     * @param msg The error message
     */
    public void loadMessage(String msg){
        JOptionPane.showMessageDialog(restaurantEditView, msg);
    }

    /**
     * Called when clicking the delete button. After deletion, the persistent data is rebuilt and the initial view is called
     */
    public void deleteRestaurant() {
        Restaurant r = (Restaurant) restaurantEditView.getRestaurantSearchableList().getRestaurantList().getSelectedValue();
        RestaurantDAO.deleteRestaurant(r);
        loadMessage("Restaurant " + r.getName() + " has been deleted");
        buildPersistentData();
        initialView();
    }

    
    public void createTemporaryRestaurant(){
        if(temporaryRestaurant == null){
            temporaryRestaurant = rFactory.getEmptyRestaurant("Temporary");
            
            if(Session.isOwner())
                temporaryRestaurant.setOwnerID(Session.getId());
            
            updateRestaurantList();
            loadDetailsAndSchedule(temporaryRestaurant);
            selectTemporaryRestaurant();   
        } else {
            selectTemporaryRestaurant();   
            loadDetailsAndSchedule(temporaryRestaurant);
        }
    }
    
    /**
     *  This method automatically selects the "Unsaved restaurant" item in the list as long as:
        1. Restaurant has isTemporary()
        2. We indeed have it in the list
     */
    public void selectTemporaryRestaurant(){

        if(temporaryRestaurant != null){
            int index = -1;
            
            DefaultListModel model = (DefaultListModel) restaurantEditView.getRestaurantSearchableList().getRestaurantList().getModel();
            for(int i = 0; i < model.getSize(); i++){
                if (((Restaurant) model.get(i)).isTemporary()){
                    index = i;
                    i = model.getSize() + 9999; // break out the loop
                }
            }
            
            if(index != -1)
                restaurantEditView.getRestaurantSearchableList().getRestaurantList().setSelectedIndex(index);
        }
    }

    /**
     * Called by the save button
     * We instantiate the validator and ask it to valdiate the restaurant edit view (the whole JFrame, yes, it's tightly coupled :/ )
     * If the data is invalid, we load the error message and reset the validator
     * If the data is valid, we save the restaurant in the DB, rebuild persistent data and reload the initial view
     */
    public void saveNewRestaurant(){
        
        RestaurantEditViewDataValidator validator = new RestaurantEditViewDataValidator();
        validator.validateRestaurantEditViewData(restaurantEditView,"save");
        
        if( ! validator.isValid()){
            loadMessage(validator.getErrorMessages());
            validator.resetValidator();
        } else {
            Restaurant toBeSaved = validator.getToBeSavedRestaurant(); // get the restaurant modified with user data that has been valdiated
            RestaurantDAO.addRestaurant(toBeSaved); // Save the restaurant
            loadMessage("Restaurant " + toBeSaved.getName() + " has been saved in the database!");
            buildPersistentData(); // We need to rebuild the data
            initialView(); // load the initial view    
        }
    }

    /**
     * Called when clicking a restaurant in the list or when clicking the new button
     * @param r The restaurant object that we need to output its details
     */
    public void loadDetailsAndSchedule(Restaurant r){
        
        if(!Session.isAdmin())
            restaurantEditView.getRestaurantDetails2().getOwnerIDTextField().setEnabled(false);
        
        // Make sure detail textfields become editable
        setRestaurantDetailsEnabled(true);
        
        // Make sure it is selected. SHOULD I REMOVE THIS? NEEDS CHANGE EDIT DELETE WHATEVER LATER
        //restaurantEditView.getRestaurantSearchableList().getRestaurantList().setSelectedValue(r, true);
        
        // Update buttons accordingly
        if ( r.isTemporary())
            updateButtons("Temporary");
        else
            updateButtons("Existing");
            
        
        // Update details panel
        restaurantEditView.getRestaurantDetails2().getOwnerIDTextField().setText(String.valueOf(r.getOwnerID()));
        restaurantEditView.getRestaurantDetails2().getNameTextField().setText(r.getName());
        
        // Populate the Restaurant Type ComboBox and select the restaurant's type
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        
        for(RestaurantType rt : RestaurantType.values()){
            model.addElement(rt);
        }
        restaurantEditView.getRestaurantDetails2().getTypeComboBox().setModel(model);
        restaurantEditView.getRestaurantDetails2().getTypeComboBox().setSelectedItem(r.getType());
        
        restaurantEditView.getRestaurantDetails2().getAreaTextField().setText(r.getArea());
        restaurantEditView.getRestaurantDetails2().getCityTextField().setText(r.getCity());
        restaurantEditView.getRestaurantDetails2().getStreetTextField().setText(r.getStreet());
        restaurantEditView.getRestaurantDetails2().getZipCodeTextField().setText(String.valueOf(r.getZipCode()));
        restaurantEditView.getRestaurantDetails2().getImageURLTextField().setText(r.getImageURL());
        restaurantEditView.getRestaurantDetails2().getTelephoneTextField().setText(String.valueOf(r.getTelephone()));
        restaurantEditView.getRestaurantDetails2().getDescriptionTextArea().setText(r.getDescription());
        restaurantEditView.getRestaurantDetails2().getMinPriceTextField().setText(String.valueOf(r.getMinPrice()));
        restaurantEditView.getRestaurantDetails2().getMaxPriceTextField().setText(String.valueOf(r.getMaxPrice()));
        
        // If the restaurant is temporary (we clicked the new button)
        // Hack: Since we are casting empty integers to strings, the value in the textfield will be zero. We should remove these zeros
        // We should set the fields to empty only if the values stored in the Restaurant object are 0 for those respective proprieties
        if (r.isTemporary()){
                if(r.getZipCode() == 0)
                restaurantEditView.getRestaurantDetails2().getZipCodeTextField().setText("");
                if(r.getTelephone() == 0)
                restaurantEditView.getRestaurantDetails2().getTelephoneTextField().setText("");
                if(r.getMinPrice() == 0)
                restaurantEditView.getRestaurantDetails2().getMinPriceTextField().setText("");
                if(r.getMaxPrice() == 0)
                restaurantEditView.getRestaurantDetails2().getMaxPriceTextField().setText("");
        }
        
        // Get the components in the schedule panel. Fill them up with data :)
        Component[] days = getDaysComponents();
        
        if (days != null){
            for(int i = 0; i < days.length ; i++){
                Component[] elements = ((JPanel) days[i]).getComponents();

                String start = r.getSchedule().getFormatedTime(i, 0);
                String stop = r.getSchedule().getFormatedTime(i, 1);

                ((JTextField) elements[1]).setText(start);
                ((JTextField) elements[2]).setText(stop);

                ((JCheckBox) elements[3]).setSelected(r.getSchedule().isClosed(i)); 
                ((JCheckBox) elements[4]).setSelected(r.getSchedule().isEndless(i));
                
                addResetActionListener(elements[3]);
                addResetActionListener(elements[4]);
            }
        }
        resetAllScheduleFieldState();
    }
    
    
    public void addResetActionListener(Component cb){
        ((JCheckBox) cb).addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetAllScheduleFieldState();
            }
        });
    }
    
    /**
     * Go through all the checkboxes of the schedule component
     * There can be only one selected checkbox.
     * If both checkboxes that correspond to a day panel are selected, deselect them.
     */
    public void resetAllScheduleFieldState(){
        Component[] days = getDaysComponents();
        for(int i = 0 ; i < days.length ; i++){
            Component[] elements = ((JPanel) days[i]).getComponents();
            
            if(((JCheckBox) elements[3]).isSelected() && ((JCheckBox) elements[4]).isSelected()){
                ((JCheckBox) elements[3]).setSelected(false);
                ((JCheckBox) elements[4]).setSelected(false);
                resetAllScheduleFieldState();
            }
            else if(((JCheckBox) elements[3]).isSelected()){
                elements[1].setEnabled(false);
                elements[2].setEnabled(false);
            }
            else if(((JCheckBox) elements[4]).isSelected()){
                elements[1].setEnabled(false);
                elements[2].setEnabled(false);
            }
            else{
                for(Component c : elements){
                    c.setEnabled(true);
                }
            }
        }
    }

    public void closeView(){
        this.restaurantEditView.setVisible(false);
        mainController.queryView.loadView();
        mainController.queryView.setVisible(true);
    }

    /**
     * Called when clicking the discard button
     */
    public void removeTemporaryRestaurant(){
            temporaryRestaurant = null;
            initialView();
    }
    
}
