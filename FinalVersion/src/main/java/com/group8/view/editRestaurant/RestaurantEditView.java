/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.group8.view.editRestaurant;

import com.group8.controller.RestaurantEditController;
import javax.swing.JButton;

/**
 *
 * @author john
 */
public class RestaurantEditView extends javax.swing.JFrame {
    
    private RestaurantEditController controller = null;
    
    
    /**
     * Creates new form SergiuEditRestaurant2
     */
    public RestaurantEditView() {
        initComponents();
    }

    public RestaurantEditView(RestaurantEditController controller) {
        this.controller = controller;
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        restaurantDetails2 = new RestaurantDetails(controller);
        restaurantButtons = new RestaurantButtons(controller);
        restaurantSchedule1 = new RestaurantSchedule(controller);
        restaurantSearchableList = new RestaurantSearchableList(controller);
        returnButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(restaurantDetails2, new org.netbeans.lib.awtextra.AbsoluteConstraints(284, 30, -1, -1));
        getContentPane().add(restaurantButtons, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 423, -1, -1));

        restaurantSchedule1.setMaximumSize(new java.awt.Dimension(32767, 32767));
        restaurantSchedule1.setOpaque(false);
        getContentPane().add(restaurantSchedule1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, -1, -1));
        getContentPane().add(restaurantSearchableList, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, -1, -1));

        returnButton.setText("Close");
        returnButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                returnButtonActionPerformed(evt);
            }
        });
        getContentPane().add(returnButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 434, -1, -1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        jLabel1.setLabelFor(this);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void returnButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_returnButtonActionPerformed
        controller.closeView();
    }//GEN-LAST:event_returnButtonActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private com.group8.view.editRestaurant.RestaurantButtons restaurantButtons;
    private com.group8.view.editRestaurant.RestaurantDetails restaurantDetails2;
    private com.group8.view.editRestaurant.RestaurantSchedule restaurantSchedule1;
    private com.group8.view.editRestaurant.RestaurantSearchableList restaurantSearchableList;
    private javax.swing.JButton returnButton;
    // End of variables declaration//GEN-END:variables

    public RestaurantButtons getRestaurantButtons() {
        return restaurantButtons;
    }

    public RestaurantDetails getRestaurantDetails2() {
        return restaurantDetails2;
    }

    public RestaurantSearchableList getRestaurantSearchableList() {
        return restaurantSearchableList;
    }

    public RestaurantSchedule getRestaurantSchedule1() {
        return restaurantSchedule1;
    }

    public JButton getReturnButton() {
        return returnButton;
    }

}