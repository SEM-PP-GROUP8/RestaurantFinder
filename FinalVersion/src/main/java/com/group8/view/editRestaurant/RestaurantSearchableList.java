/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.group8.view.editRestaurant;

import com.group8.controller.RestaurantEditController;
import com.group8.model.Restaurant;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class RestaurantSearchableList extends javax.swing.JPanel {

    private RestaurantEditController controller;
    
    RestaurantSearchableList(final RestaurantEditController controller) {
        this.controller = controller;
        initComponents();
        
        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void changedUpdate(DocumentEvent e) {
              update();
            }
            @Override
            public void removeUpdate(DocumentEvent e) {
              update();
            }
            @Override
            public void insertUpdate(DocumentEvent e) {
              update();
            }

            public void update() {
               controller.updateRestaurantList();
            }
        });
    }

    public RestaurantSearchableList() {
        initComponents();
    }

    public JList getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(JList restaurantList) {
        this.restaurantList = restaurantList;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        restaurantList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        searchField.setPreferredSize(new java.awt.Dimension(240, 20));
        add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 20, 240, -1));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(234, 300));

        restaurantList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                restaurantListMouseClicked(evt);
            }
        });
        restaurantList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                restaurantListKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(restaurantList);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 50, -1, -1));

        jLabel1.setText("Search Restaurants:");
        jLabel1.setPreferredSize(new java.awt.Dimension(125, 20));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void restaurantListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantListMouseClicked
        // Make sure it's a double click and after make sure the list is not empty
        if( (evt.getClickCount() == 1) && ( ((JList) evt.getSource()).getModel().getSize() > 0) ){
            Restaurant r = (Restaurant) ( (JList) evt.getSource() ).getSelectedValue();
            controller.loadDetailsAndSchedule(r);
        }
    }//GEN-LAST:event_restaurantListMouseClicked

    private void restaurantListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_restaurantListKeyPressed

        if((evt.getKeyCode() == KeyEvent.VK_ENTER) && ( ((JList) evt.getSource()).getModel().getSize() > 0) ){
            Restaurant r = (Restaurant) ( (JList) evt.getSource() ).getSelectedValue();
            controller.loadDetailsAndSchedule(r);
        }
        
    }//GEN-LAST:event_restaurantListKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList restaurantList;
    private javax.swing.JTextField searchField;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(javax.swing.JTextField searchField) {
        this.searchField = searchField;
    }
}
