package com.group8.controller;

import com.group8.model.RegisteredOwner;
import com.group8.model.Restaurant;
import com.group8.model.RegisteredUser;
import com.group8.model.Review;
import java.util.List;

public interface ControllerListener 
{
    //Login Handlers
    public void loginButtonClicked();
    public void exitLoginView();
    public void authorizeLogin();
    
    //EditRestaurant Handlers
    public void restaurantsButtonClicked();
    public void exitEditRestaurantsView();

    //Query View
    public void initiliazeQueryView();
    public void reloadQueryView();
    public List<Restaurant> fetchRestaurantByFilters(String typeOfFood,int intPriceMin,int intPriceMax,String location,String time,String dayName, String searchTxt);

    // Register View
    public void exitRegisterView();
    public void registerButtonClicked();
    
    //KIKE _ USER
    public RegisteredUser fetchUserDetails(int id);
    public void userButtonClicked();
    public void exitUserView();
    public void updateUserDetails(RegisteredUser user);
    public List<Review> getReviewsByUserID(int id);
   
    
    //KIKE _ Both User and Owner
    public void updatePassword(int id, String password, String table);
    
    
    
    
    //Kike _ OWNER

    public void exitOwnerView();

    public RegisteredOwner fetchOwnerDetails(int id);

    public void updateOwnerDetails(RegisteredOwner owner);

    public void ownerButtonClicked();

    
    /*NEW - Hampus*/
    // ViewRestaurant View
    public void viewButtonClicked(Restaurant selectedRestaurant);
    public void exitViewRestaurantView();
    public void reviewItemChanged(int reviewList);
    public void addReview();
    public void reviewDeleteButtonPressed(int index);
    public void reviewUpdateButtonPressed();
    public boolean canAddReview();

    public List<RegisteredUser> getAllUsers();

    public List<RegisteredOwner> getAllOwners();

}
