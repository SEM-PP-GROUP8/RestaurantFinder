package com.group8.controller;

import com.group8.model.DBHandler;
import com.group8.model.Model;
import com.group8.model.RegisteredOwner;
import com.group8.model.RegisteredOwnerDAO;
import com.group8.model.Restaurant;
import com.group8.model.RestaurantDAO;
import com.group8.view.Login;
import com.group8.view.Query;
import com.group8.view.Register;
import com.group8.model.RegisteredUser;
import com.group8.model.RegisteredUserDAO;
import com.group8.model.Review;
import com.group8.model.ReviewDAO;
import com.group8.model.Session;
import com.group8.view.Owner;
import com.group8.view.User;
import com.group8.view.ViewRestaurant;
import java.awt.Image;
import java.net.URL;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Controller implements ControllerListener
{
    public Login loginView;
    public Query queryView;
    public Model model;
    public Register registerView;
    public ViewRestaurant viewRestaurantView;
    public User userView;
    public Owner ownerView;
    public RestaurantEditController reController;

    //Constructor - Makes the dependency with the views and the model.
    public Controller(Login loginView, Query queryView, Register registerView, ViewRestaurant viewRestaurantView, User userView, Owner ownerView, Model model) 
    {
        this.loginView = loginView;
        this.queryView = queryView;
        this.model = model;
        this.registerView = registerView;
        this.viewRestaurantView = viewRestaurantView;
        this.userView = userView;
        this.ownerView = ownerView;
        
        //
        DBHandler.initializeDB();
    }
    
    //                  ***************************
    //                  **        Controls       **
    //                  ***************************

    // Query Related Controls
    public void openQueryView ()
    {
        queryView.reloadView();
        /*NEW*/
        queryView.setLocationRelativeTo(null);
        queryView.setVisible(true);
    }
    public void closeQueryView ()
    {
        queryView.setVisible(false);
    }
    // Login Related Controls
    public void openLoginView ()
    {
        /*NEW*/
        loginView.setLocationRelativeTo(null);
        loginView.setVisible(true);
    }
    public void closeLoginView ()
    {
        loginView.setVisible(false);
    }
    
    // RestaurantView Related Controls
    public void openEditRestaurantsView()
    {
        reController = new RestaurantEditController(this);
        reController.loadView();
    }
    public void closeEditRestaurantsView ()
    {
        reController.closeView();
    }

    
    //                  ***************************
    //                  **  Controller Listeners **
    //                  ***************************
    
    //Query View Listeners
    @Override
    public void loginButtonClicked() 
    {
        closeQueryView();
        openLoginView();
    }
    
    @Override
    public void restaurantsButtonClicked() 
    {
        closeQueryView();
        openEditRestaurantsView();
    }
    
    @Override
    public void reloadQueryView() 
    {
        /*NEW*/
        queryView.setLocationRelativeTo(null);
        queryView.reloadView();
    } 

    @Override
    public List<Restaurant> fetchRestaurantByFilters(String typeOfFood,int intPriceMin,int intPriceMax,String location,String time,String dayName, String searchTxt)
    {
        List<Restaurant> filteredRestaurants = RestaurantDAO.fetchRestaurantByFilters(typeOfFood, intPriceMin, intPriceMax, location, time, dayName, searchTxt);
        return filteredRestaurants;
    }
    
    // Login View Listeners
    @Override
    public void exitLoginView() 
    {
        closeLoginView();
        openQueryView();
    }
    
    @Override
    public void authorizeLogin() 
    {
        exitLoginView();
        reloadQueryView();
    }  
    
    //EditRestaurantsViewListeners
    @Override
    public void exitEditRestaurantsView() 
    {
        closeEditRestaurantsView();
        openQueryView();
    }
    
    @Override
    public void exitRegisterView() 
    { 
        closeRegisterView();
        openQueryView();
    }
  
    @Override
    public void registerButtonClicked() 
    {
        closeQueryView();
        openRegisterView();
    }
    
    public void openRegisterView ()
    {
        registerView.setLocationRelativeTo(null);
        registerView.setVisible(true);
    }
    
    public void closeRegisterView ()
    {
        
        registerView.setVisible(false);
    
    } 
    
    
    
    //KIKE _ USER
    @Override
    // Controller link between the UserView and the Registered user factory to fetch
    // the specific user containing that id. Returns a ResiteredUser type.
    public RegisteredUser fetchUserDetails(int id) 
    {
        return RegisteredUserDAO.fetchUserByID(id);
    }
    
    @Override
    //Controller link between the queryView and the userView. Closes the queryView and opens
    // the userView.
    public void userButtonClicked() 
    {
        closeQueryView();
        openUserView();
    }
    
    // Controller link to open the user view with all the necessary procedures like loadView.
    public void openUserView ()
    {
        userView.setLocationRelativeTo(null);
        userView.loadView();
        userView.setVisible(true);
    }
    
    //Controller link to close the userView.
    public void closeUserView ()
    {
        
        userView.setVisible(false);
    
    }
    
    @Override
    //Controller link to close the current userView and open the queryView.
    public void exitUserView() 
    {
        closeUserView();
        openQueryView();
    }

    @Override
    //Controller link between the userView and the RegisteredUser factory to update the details
    // of a specific user. All the information is packaged in a Registered User class.
    public void updateUserDetails(RegisteredUser user) 
    {
        RegisteredUserDAO.updateUserDetails(user);
    }
 
    @Override
    //Controller link between the userView and the RegisteredUser factory to update the password
    // of a specific user. It passes along the userID, new password and the table to do it to.
    public void updatePassword(int id, String password, String table) 
    {
        RegisteredUserDAO.updatePassword (id, password, table);
    }

    @Override
    //Controller link to close the current ownerView and open the queryView.
    public void exitOwnerView() 
    {
        closeOwnerView();
        openQueryView();
    }

    @Override
    // Controller link between the ownerView and the Registered owner factory to fetch
    // the specific owner containing that id. Returns a RegisteredOwner type.
    public RegisteredOwner fetchOwnerDetails(int id) 
    {
        return RegisteredOwnerDAO.fetchOwnerByID(id);
    }

    @Override
    //Controller link between the ownerView and the RegisteredOwner factory to update the details
    // of a specific owner. All the information is packaged in a Registered Owner class.
    public void updateOwnerDetails(RegisteredOwner owner) 
    {
        RegisteredOwnerDAO.updateOwnerDetails(owner);
    }

    @Override
    //Controller link between the queryView and the ownerView. Closes the queryView and opens
    // the ownerView.
    public void ownerButtonClicked() 
    {
        closeQueryView();
        openOwnerView();
    }

    // Controller link to open the owner view with all the necessary procedures like loadView.
    private void openOwnerView() 
    {
        ownerView.setLocationRelativeTo(null);
        ownerView.loadView();
        ownerView.setVisible(true);
    }
    
    //Controller link to close the ownerView.
    public void closeOwnerView ()
    {
        ownerView.setVisible(false);
    }

    @Override
    //Controller link to fetch the list of reviews from the DB depending on a specific userID.
    public List<Review> getReviewsByUserID(int id) 
    {
        return ReviewDAO.fetchUserReviews(id);
    }
    
    // Method being called when a restaurant is to be viewed --- viewRestaurantView
    @Override
    public void viewButtonClicked(Restaurant selectedRestaurant) {
        
        // Set the restaurant icon
        try {
            
            int maxWidth = viewRestaurantView.getRestaurantPicture().getWidth();
            int maxHeight = viewRestaurantView.getRestaurantPicture().getHeight();
            
            URL url = new URL(selectedRestaurant.getImageURL());
            Image image = ImageIO.read(url);

            if(image.getWidth(null) > maxWidth)
                image = image.getScaledInstance(maxWidth, image.getHeight(null), Image.SCALE_DEFAULT);
            
            if(image.getHeight(null) > maxHeight)
                image = image.getScaledInstance(image.getWidth(null) ,maxHeight, Image.SCALE_DEFAULT);

            ImageIcon icon = new ImageIcon(image);
            viewRestaurantView.setRestaurantPicture(icon);
            
        } catch(Exception ex) {
            
            viewRestaurantView.setRestaurantPicture(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/profilepicture.png")));
        
        }
        
        try {
            
            viewRestaurantView.setDescriptionValue(selectedRestaurant.getDescription().substring(0, 10) + "...");  
        
        } catch (StringIndexOutOfBoundsException ex) {
            
            viewRestaurantView.setDescriptionValue(selectedRestaurant.getDescription());  
        
        }
        
        // Set the UI content for the viewRestaurantView
        viewRestaurantView.setFullReviewArea("");
        viewRestaurantView.setCurrentRestaurant(selectedRestaurant);
        viewRestaurantView.setAreaValue(selectedRestaurant.getArea());
        viewRestaurantView.setCityValue(selectedRestaurant.getCity());
        viewRestaurantView.setNameValue(selectedRestaurant.getName());
        viewRestaurantView.setPriceMaxValue("" + selectedRestaurant.getMaxPrice() + "kr");
        viewRestaurantView.setPriceMinValue("" + selectedRestaurant.getMinPrice() + "kr");
        viewRestaurantView.setStreetValue(selectedRestaurant.getStreet());
        viewRestaurantView.setTypeValue(selectedRestaurant.getType().toString());
        viewRestaurantView.setZipcodeValue("" + selectedRestaurant.getZipCode());      
        viewRestaurantView.setTelephoneValue("" + selectedRestaurant.getTelephone());
        viewRestaurantView.setDescriptionValueExpand(selectedRestaurant.getDescription());
        viewRestaurantView.setDescriptionValueExpandVisible(false);
        
        // Fill the schedule day#value labels with data
        loadScheduleData(viewRestaurantView,selectedRestaurant);
        
        setReviews(selectedRestaurant);
        
        // Set the grade dropdown
        viewRestaurantView.getGradeModel().removeAllElements();
        for(int i = 0; i < 6; i++)
            viewRestaurantView.getGradeModel().addElement(i);
        
        // Set the selected grade to 0
        viewRestaurantView.getGradeDropdown().setSelectedIndex(0);
        
        setCanEdit(false);
        
        // Determine if the user should be allowed to add a review
        if(Session.isUser() && canAddReview())
            setCanAdd(true);  
       
        else
            setCanAdd(false);
        
        // Close the queryView and display the viewRestaurantView
        closeQueryView();
        viewRestaurantView.setLocationRelativeTo(null);
        viewRestaurantView.setVisible(true);
        
    }
    
    // Closes the viewRestaurantView and returns to the queryView --- viewRestaurantView
    @Override
    public void exitViewRestaurantView() {
        
        openQueryView();
        viewRestaurantView.setLocationRelativeTo(null);
        viewRestaurantView.setVisible(false);
        
    }
    
    // Prints the selected comment on a review in the fullReviewArea(JTextArea) --- viewRestaurantView
    @Override
    public void reviewItemChanged(int index) {
 
        // Get the specific review and print the comment in the fullReviewArea
        Review review = viewRestaurantView.getReview(index);
        viewRestaurantView.setFullReviewArea("" + review.getReview());
        
        // Determine if the user should be allowed to edit the selected review
        if(Session.isUser() && review.getUserID() == Session.getId()) {
            setCanEdit(true);
        } else {
            setCanEdit(false);
        }
        
    }
    
    // Adds a review in the database with the entered details --- viewRestaurantView
    @Override
    public void addReview() {
        
        // Get the details
        int restaurantId = viewRestaurantView.getCurrentRestaurant().getId();
        int userId = Session.getId();
        String comment = viewRestaurantView.getComment();
        int grade = viewRestaurantView.getGradeDropdown().getSelectedIndex();
        
        // Get the current date
        Calendar cal = Calendar.getInstance();
        long dateInMilliseconds = cal.getTimeInMillis();
        Date date = new Date(dateInMilliseconds);
        
        Review review = new Review(restaurantId, userId, comment, grade, date.toString());
        
        // Add the review to the database
        ReviewDAO.addReview(review);
        
        // Update the UI
        viewRestaurantView.setCommentTextArea("Write your comment here...");
        viewRestaurantView.getGradeDropdown().setSelectedIndex(0);
        setReviews(viewRestaurantView.getCurrentRestaurant());
        
        // Determine if the user can not add a review(if the review has been added successfully)
        if(!canAddReview())
            setCanAdd(false);
        
    }
    
    // Deletes a selected review from the database --- viewRestaurantView
    @Override
    public void reviewDeleteButtonPressed(int index) {
        
        // Get the restaurants and users id's(primary key)
        int restaurantId = viewRestaurantView.getReview(index).getRestID();
        int userId = viewRestaurantView.getReview(index).getUserID();
        
        // Delete the selected review
        ReviewDAO.deleteReview(restaurantId, userId);
        
        // Update the UI
        viewRestaurantView.setFullReviewArea("");
        setReviews(viewRestaurantView.getCurrentRestaurant());
        
        // Determine if the user can add a review(if the review has been deleted successfully)
        if(canAddReview()) {
            setCanEdit(false);
            setCanAdd(true);
        }
        
    }
    
    // Updates a review --- viewRestaurantView
    @Override
    public void reviewUpdateButtonPressed() {
        
        // Get the current date
        Calendar cal = Calendar.getInstance();
        long dateInMilliseconds = cal.getTimeInMillis();
        Date date = new Date(dateInMilliseconds);
        
        // Get the details for review
        int restaurantId = viewRestaurantView.getCurrentRestaurant().getId();
        int userId = Session.getId();
        String comment = viewRestaurantView.getFullReviewAreaComment();
        int grade = viewRestaurantView.getGradeDropdown().getSelectedIndex();
        
        // Update review
        Review review = new Review(restaurantId, userId, comment, grade, date.toString());
        ReviewDAO.updateReview(review);
        
        // Update reviewlist
        setReviews(viewRestaurantView.getCurrentRestaurant());
        
    }
    
    // Determines if a review can be added by the current user on the selected restaurant --- viewRestaurantView
    @Override
    public boolean canAddReview() {
        
        int restaurantId = viewRestaurantView.getCurrentRestaurant().getId();
        int userId = Session.getId();
        
        return !ReviewDAO.alreadyReviewed(restaurantId, userId);
        
    }
    
    // Enable or disable editing of review --- viewRestaurantView
    private void setCanEdit(boolean ableToEdit) {
        
        viewRestaurantView.setFullReviewAreaState(ableToEdit);
        viewRestaurantView.setDeleteButtonState(ableToEdit);
        viewRestaurantView.setUpdateButtonState(ableToEdit);
        viewRestaurantView.getGradeDropdown().setEnabled(ableToEdit);
        
        if(Session.isUser() && canAddReview()) {
            setCanAdd(true);  
        }
    
    }
    
    // Enable or disable adding of review in the --- viewRestaurantView
    private void setCanAdd(boolean ableToAdd) {
        
        viewRestaurantView.setCommentTextAreaState(ableToAdd);
        viewRestaurantView.setSendButtonState(ableToAdd);
        viewRestaurantView.getGradeDropdown().setEnabled(ableToAdd);
        
        if(ableToAdd)
            viewRestaurantView.setCommentTextArea("Write your comment here...");
        else
            viewRestaurantView.setCommentTextArea("");
        
    }
    
    // Updates the reviewlist --- viewRestaurantView
    private void setReviews(Restaurant selectedRestaurant) {
        
        viewRestaurantView.setReviews(ReviewDAO.fetchRestReviews(selectedRestaurant.getId()));
        viewRestaurantView.getReviewTable().setRowCount(0);

        // Loop through all reviews for the selected restaurant and add them to the list of reviews in th UI --- viewRestaurantView
        for(Review reviews: ReviewDAO.fetchRestReviews(selectedRestaurant.getId())) {
            
            int grade = reviews.getGrade();
            String userName = DBHandler.getUsername(reviews.getUserID());
            String date = reviews.getDate().substring(0, 11);
            
            viewRestaurantView.getReviewTable().addRow(new Object[]{userName, grade, date});
        
        }
        
    }

    /**
     * Loads schedule data to the view
     * @param viewRestaurantView The ViewRestaurant View
     * @param selectedRestaurant The selected Restaurant
     */    
    private void loadScheduleData(ViewRestaurant view, Restaurant r) {
        JLabel[] scheduleValueLabels = view.getScheduleValLabels();
        
        for(int i = 0; i < scheduleValueLabels.length ; i++){
            String output = "";
            
            if(r.getSchedule().isClosed(i))
                output = "Closed";
            else if(r.getSchedule().isEndless(i))
                output = "All day";
            else 
                output = r.getSchedule().getFormatedTime(i, 0) + " - " + r.getSchedule().getFormatedTime(i, 1);
            
            scheduleValueLabels[i].setText(output);
        }        
    }

    @Override
    public void initiliazeQueryView() {
        queryView.loadView();
        queryView.setLocationRelativeTo(null);
        queryView.setVisible(true);
    }

    @Override
    public List<RegisteredUser> getAllUsers() 
    {
        List<RegisteredUser> allUsers = RegisteredUserDAO.getAllUsers();
        return allUsers;
    }

    @Override
    public List<RegisteredOwner> getAllOwners() 
    {
        List<RegisteredOwner> allOwners = RegisteredOwnerDAO.getAllOwners();
        return allOwners;
    }
    
}