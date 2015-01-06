/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group8.tests;


import com.group8.model.Restaurant;
import com.group8.model.RestaurantDAO;
import java.sql.ResultSet;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author enriquecordero
 */
public class DBAllRestTest {
    
    public DBAllRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() 
    {
    }
    
    @AfterClass
    public static void tearDownClass() 
    {
    }
    
    @Before
    public void setUp() 
    {
    }
    
    @After
    public void tearDown() 
    {
    }

    @Test 
    public void fetchAllRestaurants() 
    {
        List<Restaurant> result = RestaurantDAO.fetchAllRestaurants();
        
        try
        {
            for (Restaurant current : result)
            {
                System.out.println ("Name:" + current.getName());
            }
            
        }
        catch (Exception e)
        {
            System.out.println ("Error");
        }
    }
}
