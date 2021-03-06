package com.group8.view;

import com.group8.controller.ControllerListener;
import com.group8.model.Restaurant;
import com.group8.model.Review;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ViewRestaurant extends javax.swing.JFrame {

    private ControllerListener controllerListener;
    private List<Review> reviews;
    private Restaurant currentRestaurant;
    
    public ViewRestaurant() {
        
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        descriptionValueExpand = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        commentTextArea = new javax.swing.JTextArea();
        gradeModel = new DefaultComboBoxModel();
        gradeDropdown = new javax.swing.JComboBox();
        sendButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        fullReviewLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        fullReviewArea = new javax.swing.JTextArea();
        reviewsLabel = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        reviewTable = new javax.swing.JTable();
        nameLabel = new javax.swing.JLabel();
        nameValue = new javax.swing.JTextArea();
        typeLabel = new javax.swing.JLabel();
        typeValue = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        cityValue = new javax.swing.JLabel();
        areaLabel = new javax.swing.JLabel();
        areaValue = new javax.swing.JLabel();
        zipcodeLabel = new javax.swing.JLabel();
        zipcodeValue = new javax.swing.JLabel();
        streetLabel = new javax.swing.JLabel();
        streetValue = new javax.swing.JLabel();
        day7 = new javax.swing.JLabel();
        day6 = new javax.swing.JLabel();
        day5 = new javax.swing.JLabel();
        day4 = new javax.swing.JLabel();
        day3 = new javax.swing.JLabel();
        day2 = new javax.swing.JLabel();
        day1 = new javax.swing.JLabel();
        day7Value = new javax.swing.JLabel();
        day6Value = new javax.swing.JLabel();
        day5Value = new javax.swing.JLabel();
        day4Value = new javax.swing.JLabel();
        day3Value = new javax.swing.JLabel();
        day2Value = new javax.swing.JLabel();
        day1Value = new javax.swing.JLabel();
        priceMinLabel = new javax.swing.JLabel();
        priceMinValue = new javax.swing.JLabel();
        priceMaxLabel = new javax.swing.JLabel();
        priceMaxValue = new javax.swing.JLabel();
        telephoneLabel = new javax.swing.JLabel();
        telephoneValue = new javax.swing.JLabel();
        descriptionLabel = new javax.swing.JLabel();
        descriptionValue = new javax.swing.JTextArea();
        detailsLabel = new javax.swing.JLabel();
        restaurantDetailsBackground = new javax.swing.JLabel();
        restaurantPicture = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();
        detailsLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(160, 110));

        descriptionValueExpand.setEditable(false);
        descriptionValueExpand.setColumns(20);
        descriptionValueExpand.setLineWrap(true);
        descriptionValueExpand.setWrapStyleWord(true);
        descriptionValueExpand.setAutoscrolls(false);
        jScrollPane4.setViewportView(descriptionValueExpand);

        getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 160, 110));

        commentTextArea.setBackground(new java.awt.Color(235, 235, 235));
        commentTextArea.setColumns(20);
        commentTextArea.setLineWrap(true);
        commentTextArea.setRows(5);
        commentTextArea.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                commentTextAreaFocusGained(evt);
            }
        });
        commentTextArea.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                commentTextAreaMouseEntered(evt);
            }
        });
        commentTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                commentTextAreaKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(commentTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, 350, 140));

        gradeDropdown.setModel(gradeModel);
        getContentPane().add(gradeDropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 90, 30));

        sendButton.setText("Send");
        sendButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });
        getContentPane().add(sendButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 480, 90, 110));

        deleteButton.setText("Delete review");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 353, 140, 48));

        updateButton.setText("Update review");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 353, 140, 48));

        fullReviewLabel.setText(" Comment");
        fullReviewLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        fullReviewLabel.setOpaque(true);
        getContentPane().add(fullReviewLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 31, 280, 22));

        fullReviewArea.setEditable(false);
        fullReviewArea.setBackground(new java.awt.Color(235, 235, 235));
        fullReviewArea.setColumns(20);
        fullReviewArea.setLineWrap(true);
        fullReviewArea.setRows(5);
        fullReviewArea.setWrapStyleWord(true);
        jScrollPane2.setViewportView(fullReviewArea);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 53, 280, 300));

        reviewsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reviewsLabel.setText("Reviews");
        getContentPane().add(reviewsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, -1, -1));

        reviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "User", "Grade", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reviewTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(reviewTable);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 280, 370));

        nameLabel.setForeground(new java.awt.Color(102, 102, 102));
        nameLabel.setText("Name");
        nameLabel.setToolTipText("");
        nameLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        nameLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        getContentPane().add(nameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 100, 30));

        nameValue.setColumns(20);
        nameValue.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nameValue.setLineWrap(true);
        nameValue.setRows(5);
        nameValue.setText("...");
        nameValue.setToolTipText("");
        nameValue.setWrapStyleWord(true);
        getContentPane().add(nameValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 181, 99, 30));

        typeLabel.setForeground(new java.awt.Color(102, 102, 102));
        typeLabel.setText("Type");
        typeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(typeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 100, 20));

        typeValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        typeValue.setText("...");
        typeValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(typeValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 99, 20));

        cityLabel.setForeground(new java.awt.Color(102, 102, 102));
        cityLabel.setText("City");
        cityLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 100, 20));

        cityValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cityValue.setText("...");
        cityValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(cityValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 99, 20));

        areaLabel.setForeground(new java.awt.Color(102, 102, 102));
        areaLabel.setText("Area");
        areaLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(areaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 100, 20));

        areaValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        areaValue.setText("...");
        areaValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(areaValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, 99, 20));

        zipcodeLabel.setForeground(new java.awt.Color(102, 102, 102));
        zipcodeLabel.setText("Zip Code");
        zipcodeLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(zipcodeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 100, 20));

        zipcodeValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        zipcodeValue.setText("...");
        zipcodeValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(zipcodeValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 270, 99, 20));

        streetLabel.setForeground(new java.awt.Color(102, 102, 102));
        streetLabel.setText("Street");
        streetLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(streetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 100, -1));

        streetValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        streetValue.setText("...");
        streetValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(streetValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 99, 20));

        day7.setForeground(new java.awt.Color(102, 102, 102));
        day7.setText("Sunday:");
        day7.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 100, -1));

        day6.setForeground(new java.awt.Color(102, 102, 102));
        day6.setText("Saturday:");
        day6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 100, -1));

        day5.setForeground(new java.awt.Color(102, 102, 102));
        day5.setText("Friday:");
        day5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 100, -1));

        day4.setForeground(new java.awt.Color(102, 102, 102));
        day4.setText("Thursday:");
        day4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 100, -1));

        day3.setForeground(new java.awt.Color(102, 102, 102));
        day3.setText("Wednesday:");
        day3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 100, -1));

        day2.setForeground(new java.awt.Color(102, 102, 102));
        day2.setText("Tuesday:");
        day2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 100, -1));

        day1.setForeground(new java.awt.Color(102, 102, 102));
        day1.setText("Monday:");
        day1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 100, -1));

        day7Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day7Value.setText("...");
        day7Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day7Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 99, -1));

        day6Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day6Value.setText("...");
        day6Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day6Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 99, -1));

        day5Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day5Value.setText("...");
        day5Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day5Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 99, -1));

        day4Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day4Value.setText("...");
        day4Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day4Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 99, -1));

        day3Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day3Value.setText("...");
        day3Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day3Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 99, -1));

        day2Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day2Value.setText("...");
        day2Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day2Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 99, -1));

        day1Value.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        day1Value.setText("...");
        day1Value.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(day1Value, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 99, -1));

        priceMinLabel.setForeground(new java.awt.Color(102, 102, 102));
        priceMinLabel.setText("Minimum price");
        priceMinLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(priceMinLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 100, 20));

        priceMinValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        priceMinValue.setText("...");
        priceMinValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(priceMinValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, 99, 20));

        priceMaxLabel.setForeground(new java.awt.Color(102, 102, 102));
        priceMaxLabel.setText("Maximum price");
        priceMaxLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(priceMaxLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 100, 20));

        priceMaxValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        priceMaxValue.setText("...");
        priceMaxValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(priceMaxValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 490, 99, -1));

        telephoneLabel.setForeground(new java.awt.Color(102, 102, 102));
        telephoneLabel.setText("Telephone");
        telephoneLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(telephoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 100, 20));

        telephoneValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        telephoneValue.setText("...");
        telephoneValue.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(telephoneValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 520, 99, 20));

        descriptionLabel.setForeground(new java.awt.Color(102, 102, 102));
        descriptionLabel.setText("Description");
        descriptionLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(descriptionLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 100, 50));

        descriptionValue.setEditable(false);
        descriptionValue.setColumns(20);
        descriptionValue.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descriptionValue.setLineWrap(true);
        descriptionValue.setRows(5);
        descriptionValue.setText("...");
        descriptionValue.setToolTipText("");
        descriptionValue.setWrapStyleWord(true);
        descriptionValue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                descriptionValueMouseEntered(evt);
            }
        });
        getContentPane().add(descriptionValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, 99, 49));

        detailsLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        detailsLabel.setText("Details");
        getContentPane().add(detailsLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        restaurantDetailsBackground.setBackground(new java.awt.Color(255, 255, 255));
        restaurantDetailsBackground.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        restaurantDetailsBackground.setOpaque(true);
        restaurantDetailsBackground.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                restaurantDetailsBackgroundMouseEntered(evt);
            }
        });
        getContentPane().add(restaurantDetailsBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 175, 210, 415));

        restaurantPicture.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        restaurantPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/profilepicture.png"))); // NOI18N
        restaurantPicture.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(restaurantPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 210, 140));

        backButton.setText("<- Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, 100, 50));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        backgroundLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backgroundLabelMouseEntered(evt);
            }
        });
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        detailsLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        detailsLabel1.setText("Details");
        getContentPane().add(detailsLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void commentTextAreaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_commentTextAreaKeyTyped

    }//GEN-LAST:event_commentTextAreaKeyTyped

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        controllerListener.exitViewRestaurantView();
    }//GEN-LAST:event_formWindowClosing

    private void sendButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        
        // If the current user is allowed to add a review
        if(controllerListener.canAddReview())
            controllerListener.addReview();
        
        // If the user is not allowed to add a review
        else
            JOptionPane.showMessageDialog(this, "You have already posted a review on this restaurant.", 
                                                "Error Message", JOptionPane.ERROR_MESSAGE);

    }//GEN-LAST:event_sendButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        controllerListener.reviewDeleteButtonPressed(reviewTable.getSelectedRow());
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        controllerListener.reviewUpdateButtonPressed();
    }//GEN-LAST:event_updateButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        controllerListener.exitViewRestaurantView();
    }//GEN-LAST:event_backButtonActionPerformed

    private void reviewTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reviewTableMouseClicked
        
        // If the selected review is valid(is in the list)
        if(reviewTable.getSelectedRow() >= 0)
            controllerListener.reviewItemChanged(reviewTable.getSelectedRow());

    }//GEN-LAST:event_reviewTableMouseClicked

    private void commentTextAreaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_commentTextAreaFocusGained
        commentTextArea.setText("");
    }//GEN-LAST:event_commentTextAreaFocusGained

    private void descriptionValueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_descriptionValueMouseEntered
        setDescriptionValueExpandVisible(true);
    }//GEN-LAST:event_descriptionValueMouseEntered

    private void restaurantDetailsBackgroundMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_restaurantDetailsBackgroundMouseEntered
        
        // When the mouse leaves descriptionValueExpand
        setDescriptionValueExpandVisible(false);
        
    }//GEN-LAST:event_restaurantDetailsBackgroundMouseEntered

    private void backgroundLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backgroundLabelMouseEntered
        
        // When the mouse leaves descriptionValueExpand
        setDescriptionValueExpandVisible(false);
        
    }//GEN-LAST:event_backgroundLabelMouseEntered

    private void commentTextAreaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_commentTextAreaMouseEntered
        
        // When the mouse leaves descriptionValueExpand
        setDescriptionValueExpandVisible(false);
        
    }//GEN-LAST:event_commentTextAreaMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel areaLabel;
    private javax.swing.JLabel areaValue;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JLabel cityValue;
    private javax.swing.JTextArea commentTextArea;
    private javax.swing.JLabel day1;
    private javax.swing.JLabel day1Value;
    private javax.swing.JLabel day2;
    private javax.swing.JLabel day2Value;
    private javax.swing.JLabel day3;
    private javax.swing.JLabel day3Value;
    private javax.swing.JLabel day4;
    private javax.swing.JLabel day4Value;
    private javax.swing.JLabel day5;
    private javax.swing.JLabel day5Value;
    private javax.swing.JLabel day6;
    private javax.swing.JLabel day6Value;
    private javax.swing.JLabel day7;
    private javax.swing.JLabel day7Value;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel descriptionLabel;
    private javax.swing.JTextArea descriptionValue;
    private javax.swing.JTextArea descriptionValueExpand;
    private javax.swing.JLabel detailsLabel;
    private javax.swing.JLabel detailsLabel1;
    private javax.swing.JTextArea fullReviewArea;
    private javax.swing.JLabel fullReviewLabel;
    private javax.swing.JComboBox gradeDropdown;
    private DefaultComboBoxModel gradeModel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextArea nameValue;
    private javax.swing.JLabel priceMaxLabel;
    private javax.swing.JLabel priceMaxValue;
    private javax.swing.JLabel priceMinLabel;
    private javax.swing.JLabel priceMinValue;
    private javax.swing.JLabel restaurantDetailsBackground;
    private javax.swing.JLabel restaurantPicture;
    private javax.swing.JTable reviewTable;
    private javax.swing.JLabel reviewsLabel;
    private javax.swing.JButton sendButton;
    private javax.swing.JLabel streetLabel;
    private javax.swing.JLabel streetValue;
    private javax.swing.JLabel telephoneLabel;
    private javax.swing.JLabel telephoneValue;
    private javax.swing.JLabel typeLabel;
    private javax.swing.JLabel typeValue;
    private javax.swing.JButton updateButton;
    private javax.swing.JLabel zipcodeLabel;
    private javax.swing.JLabel zipcodeValue;
    // End of variables declaration//GEN-END:variables

    
    
    /*SETTERS*/
    
    public void setAreaValue(String value) {
        this.areaValue.setText(value);
    }

    public void setCityValue(String value) {
        this.cityValue.setText(value);
    }
    
    public void setCommentTextArea(String value) {
        this.commentTextArea.setText(value);
    }

    public void setDescriptionValue(String value) {
        this.descriptionValue.setText(value);
    }

    public void setDescriptionValueExpand(String value) {
        this.descriptionValueExpand.setText(value);
    }
    
    public void setFullReviewArea(String value) {
        this.fullReviewArea.setText(value);
    }
    
    public void setNameValue(String value) {
        this.nameValue.setText(value);
    }

    public void setPriceMaxValue(String value) {
        this.priceMaxValue.setText(value);
    }

    public void setPriceMinValue(String value) {
        this.priceMinValue.setText(value);
    }
    
    public void setRestaurantPicture(ImageIcon image) {
        this.restaurantPicture.setIcon(image);
    }
    
    public void setReviews(List reviews) {    
        this.reviews = reviews;       
    }

    public void setStreetValue(String value) {
        this.streetValue.setText(value);
    }

    public void setTelephoneValue(String value) {
        this.telephoneValue.setText(value);
    }
    
    public void setTypeValue(String value) {
        this.typeValue.setText(value);
    }

    public void setZipcodeValue(String value) {
        this.zipcodeValue.setText(value);
    }
    
    

    /*GETTERS*/
    
    public DefaultComboBoxModel getGradeModel() {
        return gradeModel;
    }
    
    public JComboBox getGradeDropdown() {
        return gradeDropdown;
    }
    
    public String getComment() {
        return commentTextArea.getText();
    }
    
    public String getFullReviewAreaComment() {
        return fullReviewArea.getText();
    }

    public JLabel getRestaurantPicture() {
        return restaurantPicture;
    }
    
    public DefaultTableModel getReviewTable() {
        return (DefaultTableModel) reviewTable.getModel();
    }
    

    
    /*OTHER METHODS*/
    
    /**
     * @return An object representing the restaurant that is currently being viewed.
     */
    public Restaurant getCurrentRestaurant() {
        return currentRestaurant;
    }
    
    /**
     * @param index The index of the review.
     * 
     * @return The review at the specified index.
     */
    public Review getReview(int index) {
        return reviews.get(index);
    }
    
    /**
     * @param currentRestaurant The restaurant to set as current.
     */
    public void setCurrentRestaurant(Restaurant currentRestaurant) {
        this.currentRestaurant = currentRestaurant;
    }
    
    /**
     * Change the state of commentTextArea to editable or not editable. 
     * 
     * @param state The required state of commentTextArea, set true for editable and false for not editable.
     */
    public void setCommentTextAreaState(Boolean state) {
        this.commentTextArea.setEditable(state);
    }
    
    /**
     * Change the state of deleteButton to enabled or not enabled.
     * 
     * @param state The required state of commentTextArea, set true for enabled and false for not enabled.
     */
    public void setDeleteButtonState(Boolean state) {
        this.deleteButton.setEnabled(state);
    }
    
    
    /**
     * Change the visibility state of descriptionValueExpand;
     * 
     * @param visiblility The required visibility state of descriptionValueExpand, set true for visible and false for not visible.
     */
    public void setDescriptionValueExpandVisible(boolean visiblility) {
        this.jScrollPane4.setVisible(visiblility);
    }
    
    /**
     * Change the state of fullReviewArea to editable or not editable. 
     * 
     * @param state The required state of fullReviewArea, set true for editable and false for not editable.
     */
    public void setFullReviewAreaState(Boolean state) {
        this.fullReviewArea.setEditable(state);
    }
    
    /**
     * @return An array of JLabels which contains all the day#value labels for the controller to set values from the RestaurnatSchedule
     */
    public JLabel[] getScheduleValLabels(){
        JLabel[] jLabels = {day1Value,day2Value,day3Value,day4Value,day5Value,day6Value,day7Value};
        return jLabels;
    }
    
    /**
     * Change the state of sendButton to enabled or not enabled.
     * 
     * @param state The required state of sendButton, set true for enabled and false for not enabled.
     */
    public void setSendButtonState(Boolean state) {
        this.sendButton.setEnabled(state);
    }
    
    /**
     * Change the state of updateButton to enabled or not enabled.
     * 
     * @param state The required state of updateButton, set true for enabled and false for not enabled.
     */
    public void setUpdateButtonState(Boolean state) {
        this.updateButton.setEnabled(state);
    }
    
    /**
     * Pass in the controller in use.
     * 
     * @param controllerListener The controller to be used.
     */
    public void setControllerListener(ControllerListener controllerListener) {
        this.controllerListener = controllerListener;
    }

}