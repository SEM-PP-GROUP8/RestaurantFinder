package com.group8.execution;


import com.group8.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class Execution 
{
     public static void main(String[] args)
    {
        ApplicationContext appContext = new FileSystemXmlApplicationContext ("classpath:/beans.xml");
        /*
        Initializes the controller from the bean factory. It has a reference in the constructor in the bean
        factory to all the views that use it.
        */
        Controller controller = (Controller) appContext.getBean("controller");
        //Set the controller for the queryView.
        controller.queryView.setControllerListener(controller);
        //Set the controller for the loginView
        controller.loginView.setControllerListener(controller);
        //Set the controller for the registerView
        controller.registerView.setControllerListener(controller);
        //Set the controller for the userView
        controller.userView.setControllerListener(controller);
        //Set the controller for the ownerView
        controller.ownerView.setControllerListener(controller);
        //Set the controller for the ViewRestaurant
        controller.viewRestaurantView.setControllerListener(controller);
        //Initializes the main window.
        controller.initiliazeQueryView();
    }
}
