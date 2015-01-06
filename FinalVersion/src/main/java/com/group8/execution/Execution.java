package com.group8.execution;


import com.group8.controller.Controller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class Execution 
{
     public static void main(String[] args)
    {
        ApplicationContext appContext = new FileSystemXmlApplicationContext ("classpath:/beans.xml");
        
        Controller controller = (Controller) appContext.getBean("controller");
        controller.queryView.setControllerListener(controller);
        controller.loginView.setControllerListener(controller);
        controller.registerView.setControllerListener(controller);
        
        //KIKE _ USER
        controller.userView.setControllerListener(controller);
        
        //KIKE _ OWNER
        controller.ownerView.setControllerListener(controller);
        
        /*NEW - Hampus*/
        controller.viewRestaurantView.setControllerListener(controller);
        
        controller.reloadQueryView();
        controller.openQueryView();
    }
}
