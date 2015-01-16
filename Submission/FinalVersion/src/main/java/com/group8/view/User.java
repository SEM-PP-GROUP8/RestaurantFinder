package com.group8.view;

import com.group8.model.RegisteredUser;
import com.group8.controller.ControllerListener;
import com.group8.model.DBHandler;
import com.group8.model.Model;
import com.group8.model.RegisteredUserDAO;
import com.group8.model.Review;
import com.group8.model.ReviewDAO;
import com.group8.model.Session;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class User extends javax.swing.JFrame 
{
    //Variable that connects the view to the controller
    private ControllerListener controllerListener;  
    
    //List of review to view on the table. This variable updates itself everytime there is a change.
    List<Review> reviews;
    List<RegisteredUser> users;

    public User() 
    {
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

        surnameLabel = new javax.swing.JLabel();
        surnameText = new javax.swing.JTextField();
        familyNameLabel = new javax.swing.JLabel();
        familyNameText = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailText = new javax.swing.JTextField();
        phoneLabel = new javax.swing.JLabel();
        phoneText = new javax.swing.JTextField();
        areaModel = new DefaultComboBoxModel ();
        areaCombo = new javax.swing.JComboBox();
        areaLabel = new javax.swing.JLabel();
        cityLabel = new javax.swing.JLabel();
        cityText = new javax.swing.JTextField();
        updateInfoButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        userNameLabel = new javax.swing.JLabel();
        currentUserLabel = new javax.swing.JLabel();
        editPassButton = new javax.swing.JButton();
        cancelEditPassButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        reviewPane = new javax.swing.JScrollPane();
        reviewTable = new javax.swing.JTable();
        deleteReviewButton = new javax.swing.JButton();
        deleteUserButton = new javax.swing.JButton();
        currentPassLabel = new javax.swing.JLabel();
        currentPassText = new javax.swing.JPasswordField();
        newPassLabel = new javax.swing.JLabel();
        newPassText = new javax.swing.JPasswordField();
        repeatPassLabel = new javax.swing.JLabel();
        repeatPassText = new javax.swing.JPasswordField();
        savePassButton = new javax.swing.JButton();
        allUsersPane = new javax.swing.JScrollPane();
        allUsersTable = new javax.swing.JTable();
        logoLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Personal Information");
        setLocation(new java.awt.Point(200, 50));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 620));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 620));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        surnameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        surnameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        surnameLabel.setText("Surname");
        getContentPane().add(surnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 180, 40));

        surnameText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        surnameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        surnameText.setToolTipText("");
        getContentPane().add(surnameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 180, 40));

        familyNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        familyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        familyNameLabel.setText("Family Name");
        familyNameLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(familyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 180, 40));

        familyNameText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        familyNameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        familyNameText.setToolTipText("");
        getContentPane().add(familyNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 180, -1));

        emailLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");
        emailLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 180, 40));

        emailText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        emailText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailText.setToolTipText("");
        getContentPane().add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, 180, -1));

        phoneLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setText("Phone Number");
        phoneLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 180, 40));

        phoneText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        phoneText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneText.setToolTipText("");
        getContentPane().add(phoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 180, -1));

        areaCombo.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        areaCombo.setModel(areaModel);
        getContentPane().add(areaCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, 180, 40));

        areaLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        areaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        areaLabel.setText("Area");
        areaLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(areaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 200, 180, 40));

        cityLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cityLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cityLabel.setText("City");
        cityLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(cityLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 200, 180, 40));

        cityText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        cityText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cityText.setToolTipText("");
        getContentPane().add(cityText, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 240, 180, -1));

        updateInfoButton.setText("Update Info");
        updateInfoButton.setPreferredSize(new java.awt.Dimension(120, 40));
        updateInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInfoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 300, -1, 40));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, -1));

        userNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        userNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userNameLabel.setText("Username:");
        getContentPane().add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        currentUserLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        currentUserLabel.setPreferredSize(new java.awt.Dimension(140, 40));
        getContentPane().add(currentUserLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 440, 40));

        editPassButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        editPassButton.setText("Edit Password");
        editPassButton.setPreferredSize(new java.awt.Dimension(180, 40));
        editPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPassButtonActionPerformed(evt);
            }
        });
        getContentPane().add(editPassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        cancelEditPassButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        cancelEditPassButton.setText("Cancel Edit");
        cancelEditPassButton.setPreferredSize(new java.awt.Dimension(180, 40));
        cancelEditPassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelEditPassButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelEditPassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        backButton.setText("<- Back");
        backButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 100, -1));

        reviewPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        reviewTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Restaurant", "Grade", "Review"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reviewTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        reviewTable.setAutoscrolls(false);
        reviewModel = (DefaultTableModel) reviewTable.getModel();
        reviewPane.setViewportView(reviewTable);

        getContentPane().add(reviewPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 670, 190));

        deleteReviewButton.setText("Delete Review");
        deleteReviewButton.setPreferredSize(new java.awt.Dimension(100, 40));
        deleteReviewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteReviewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteReviewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 550, 100, -1));

        deleteUserButton.setText("Delete User");
        deleteUserButton.setPreferredSize(new java.awt.Dimension(100, 40));
        deleteUserButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteUserButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteUserButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 300, 100, -1));

        currentPassLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        currentPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        currentPassLabel.setText("Current Password");
        currentPassLabel.setPreferredSize(new java.awt.Dimension(140, 40));
        getContentPane().add(currentPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 210, 40));

        currentPassText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        currentPassText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        currentPassText.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(currentPassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 70, -1, -1));

        newPassLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        newPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        newPassLabel.setText("New Password");
        newPassLabel.setPreferredSize(new java.awt.Dimension(140, 40));
        getContentPane().add(newPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 170, 40));

        newPassText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        newPassText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        newPassText.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(newPassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, -1, -1));

        repeatPassLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        repeatPassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repeatPassLabel.setText("Repeat Password");
        repeatPassLabel.setPreferredSize(new java.awt.Dimension(140, 40));
        getContentPane().add(repeatPassLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 200, 40));

        repeatPassText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        repeatPassText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        repeatPassText.setPreferredSize(new java.awt.Dimension(180, 40));
        repeatPassText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                repeatPassTextKeyPressed(evt);
            }
        });
        getContentPane().add(repeatPassText, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, -1, -1));

        savePassButton.setText("Save");
        savePassButton.setPreferredSize(new java.awt.Dimension(80, 40));
        savePassButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePassButtonActionPerformed(evt);
            }
        });
        getContentPane().add(savePassButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 230, 80, -1));

        allUsersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username"
            }
        ));
        allUsersTable.setAutoscrolls(false);
        usersModel = (DefaultTableModel) allUsersTable.getModel();
        allUsersPane.setViewportView(allUsersTable);
        allUsersTable.getSelectionModel().addListSelectionListener
        (
            new ListSelectionListener()
            {
                public void valueChanged(ListSelectionEvent event)
                {
                    int viewRow = allUsersTable.getSelectedRow();
                    if (viewRow < 0)
                    {
                        //Selection got filtered away.
                        System.out.println ("Weird error");
                    }
                    else
                    {
                        updateTable(users.get(viewRow).getId());
                    }
                }
            }
        );

        getContentPane().add(allUsersPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 670, 220));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        backgroundLabel.setMinimumSize(new java.awt.Dimension(800, 600));
        backgroundLabel.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPassButtonActionPerformed
        //Changes the view to the changePasswordView
        changePasswordView(true);
    }//GEN-LAST:event_editPassButtonActionPerformed

    private void cancelEditPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditPassButtonActionPerformed
        //Removes the values from the texfields to change password and changes the view back to normal.
        setDefaultPassValues ();
        changePasswordView(false);
    }//GEN-LAST:event_cancelEditPassButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //For security it removes anything that could be on the change passord text boxes
        // and closes the view.
        setDefaultPassValues ();
        controllerListener.exitUserView ();
    }//GEN-LAST:event_backButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //For security it removes anything that could be on the change passord text boxes
        // and closes the view.
        setDefaultPassValues ();
        controllerListener.exitUserView ();
    }//GEN-LAST:event_formWindowClosing

    private void updateInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInfoButtonActionPerformed
        //Asks the user if he is sure he wants to update his details then if the user agrees
        // it calls the appropriate methods to achieve this.
        int answer = sendQuestionMSG ("Are you sure you want to update user details?", "Update?");
        if (answer == 0)
        {
            updateUser ();
        }
    }//GEN-LAST:event_updateInfoButtonActionPerformed

    private void savePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePassButtonActionPerformed
        //Checks that the passowrds provided comply with all the needed specifications
        // If true then it updates the passord in the DB and sends a success msg.
        if (checkPasswordChange())
        {
            String password = String.valueOf(newPassText.getPassword()).trim();
            controllerListener.updatePassword(Session.getId(), password, "Users");
            sendSuccesfulMSG ("Your password was succesfully changed.", "Success!");
            cancelEditPassButton.doClick();
        }
    }//GEN-LAST:event_savePassButtonActionPerformed

    private void repeatPassTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repeatPassTextKeyPressed
        //Checks if the user has pressed enter when reaching the last txt field. It emulates the 
        // click of the Save button.
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                savePassButton.doClick();
    }//GEN-LAST:event_repeatPassTextKeyPressed

    private void deleteReviewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteReviewButtonActionPerformed
        //Asks the user for verification on deleting the review. If user agrees then 
        //it deletes the review and sends a success msg. It also updates the table.
        
        int index = reviewTable.getSelectedRow();
        if (index >= 0)
        {
            int answer = sendQuestionMSG ("Are you sure you want to delete the review?", "Delete?");
            if (answer == 0)
            {
                Review current = reviews.get(index);
                ReviewDAO.deleteReview(current.getRestID(), current.getUserID());
                if (Session.isUser())
                    updateTable(Session.getId());
                else if (Session.isAdmin())
                    updateTable(users.get(allUsersTable.getSelectedRow()).getId());
                sendSuccesfulMSG ("The review was succesfully deleted.", "Success!");
            }
        }
        else
        {
            sendErrorMSG ("You have to select a Review First.","Error!");
        }
    }//GEN-LAST:event_deleteReviewButtonActionPerformed

    private void deleteUserButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteUserButtonActionPerformed
        //Asks the admin for verification on deleting the user. If admin agrees then 
        //it deletes the user and sends a success msg. It also updates the table.
        
        int index = allUsersTable.getSelectedRow();
        if (index >= 0)
        {
            int answer = sendQuestionMSG ("Are you sure you want to delete the User?", "Delete?");
            if (answer == 0)
            {
                RegisteredUser current = users.get(index);
                RegisteredUserDAO.deleteUser(current.getId());
                updateUserTable();
                sendSuccesfulMSG ("The User was succesfully deleted.", "Success!");
            }
        }
        else
        {
            sendErrorMSG ("You have to select a User First.","Error!");
        }
    }//GEN-LAST:event_deleteUserButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane allUsersPane;
    private javax.swing.JTable allUsersTable;
    DefaultTableModel usersModel;
    private javax.swing.JComboBox areaCombo;
    private DefaultComboBoxModel areaModel;
    private javax.swing.JLabel areaLabel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton cancelEditPassButton;
    private javax.swing.JLabel cityLabel;
    private javax.swing.JTextField cityText;
    private javax.swing.JLabel currentPassLabel;
    private javax.swing.JPasswordField currentPassText;
    private javax.swing.JLabel currentUserLabel;
    private javax.swing.JButton deleteReviewButton;
    private javax.swing.JButton deleteUserButton;
    private javax.swing.JButton editPassButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel familyNameLabel;
    private javax.swing.JTextField familyNameText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JPasswordField newPassText;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneText;
    private javax.swing.JLabel repeatPassLabel;
    private javax.swing.JPasswordField repeatPassText;
    private javax.swing.JScrollPane reviewPane;
    private javax.swing.JTable reviewTable;
    private DefaultTableModel reviewModel;
    private javax.swing.JButton savePassButton;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameText;
    private javax.swing.JButton updateInfoButton;
    private javax.swing.JLabel userNameLabel;
    // End of variables declaration//GEN-END:variables

    /**
     * Main method to load all the important things related to the view. It cleans everything from 
     * the view (sets default) and then it loads the view and fills the info for the view.
     */
    public void loadView ()
    {
        justifyColumns ("Reviews");
        if (Session.isUser())
        {
            setDefaultViewValues();
            setDefaultPassValues ();
            setValues ();
        }
        if (Session.isAdmin())
        {
            justifyColumns ("Users");
            currentUserLabel.setText("Administrator");
            updateUserTable();
        }
        changePasswordView(false);
    }
    
    /**
     * Method to handle whether the user wants the regular view or wants the change password view.
     * @param option 
     */
    private void changePasswordView(boolean option)
    {
        boolean normalView;
        boolean changePass;
        boolean isAdmin;
        if (Session.isUser())
        {
            changePass = option;
            normalView = !option;
            isAdmin = false;
        }
        else if (Session.isAdmin())
        {
            changePass = false;
            normalView = false;
            isAdmin = true;
        }
        else
        {
            changePass = false;
            normalView = false;
            isAdmin = false;
        }
            //If the option is to change password
            cancelEditPassButton.setVisible(changePass);
            currentPassLabel.setVisible(changePass);
            currentPassText.setVisible(changePass);
            newPassLabel.setVisible(changePass);
            newPassText.setVisible(changePass);
            repeatPassLabel.setVisible(changePass);
            repeatPassText.setVisible(changePass);
            savePassButton.setVisible(changePass);
            deleteReviewButton.setVisible(changePass);
            if (changePass)
                currentPassText.grabFocus();

            //if the option is to go to the normal view (not change password)
            editPassButton.setVisible(normalView);
            surnameLabel.setVisible(normalView);
            surnameText.setVisible(normalView);
            familyNameLabel.setVisible(normalView);
            familyNameText.setVisible(normalView);
            emailLabel.setVisible(normalView);
            emailText.setVisible(normalView);
            phoneLabel.setVisible(normalView);
            phoneText.setVisible(normalView);
            areaLabel.setVisible(normalView);
            areaCombo.setVisible(normalView);
            cityLabel.setVisible(normalView);
            cityText.setVisible(normalView);
            updateInfoButton.setVisible(normalView);
            
            reviewPane.setVisible(normalView || isAdmin);
            deleteReviewButton.setVisible(normalView || isAdmin);
            
            //If its an admin
            allUsersPane.setVisible(isAdmin);
            deleteUserButton.setVisible(isAdmin);
    }
    
    /**
     * This method fills all the appropriate fields with the personal information of the user.
     * It also calls the method to update the table with the right info.
     */
    private void setValues ()
    {
        if (Session.isUser())
        {
            RegisteredUser currentUser = controllerListener.fetchUserDetails (Session.getId());
            currentUserLabel.setText(currentUser.getUserName());
            surnameText.setText(currentUser.getSurname());
            familyNameText.setText(currentUser.getFamilyName());
            emailText.setText (currentUser.getEmail());
            phoneText.setText(currentUser.getPhone());
            populateAreaCombo(currentUser.getArea());
            cityText.setText(currentUser.getCity());
            updateTable (Session.getId());
        }
    }
    
    /**
     * Method updates the table with the appropriate reviews related to the user. It updates
     * the list related to the current form and then it loads from that list. It also calls a 
     * method to justify the columns the desired way.
     */
    private void updateTable (int userID)
    {
        reviews = controllerListener.getReviewsByUserID(userID);
        try
        {
            reviewModel.setRowCount(0);
            for (Review current : reviews) 
            {
                String restaurant = current.getRestName();
                int grade = current.getGrade();
                String review = current.getReview();
                String date = current.getDate();
                reviewModel.addRow(new Object[]{date,restaurant, grade, review});
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Reviews: Problem with the Database!", "Program error", JOptionPane.ERROR_MESSAGE);
        }
        justifyColumns("reviews");
    }
    
    /**
     * Method updates the table with all the users. It updates
     * the list related to the current form and then it loads from that list. It also calls a 
     * method to justify the columns the desired way.
     */
    private void updateUserTable ()
    {
        users = controllerListener.getAllUsers();
        try
        {
            usersModel.setRowCount(0);
            for (RegisteredUser current : users) 
            {
                int id = current.getId();
                String name = current.getUserName();
                usersModel.addRow(new Object[]{id, name});
            }
            justifyColumns("users");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Users: Problem with the Database!", "Program error", JOptionPane.ERROR_MESSAGE);
        }
        reviewModel.setRowCount(0);
    }
    
    /**
     * This method deals with the design of the JTable. How the columns will show their information
     * and what type of justification they will have when presenting the information.
     */
    private void justifyColumns(String table)
    {
        DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
        centerRender.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
        
        DefaultTableCellRenderer leadingRender = new DefaultTableCellRenderer();
        leadingRender.setHorizontalAlignment(DefaultTableCellRenderer.LEADING);
        if (table.equals("reviews"))
        {
            ((DefaultTableCellRenderer)reviewTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            reviewTable.getColumn("Date").setCellRenderer(centerRender);
            reviewTable.getColumn("Restaurant").setCellRenderer( centerRender );
            reviewTable.getColumn("Grade").setCellRenderer( centerRender );
            reviewTable.getColumn("Review").setCellRenderer( leadingRender );
            reviewTable.getColumnModel().getColumn(0).setPreferredWidth(100);
            reviewTable.getColumnModel().getColumn(1).setPreferredWidth(200);
            reviewTable.getColumnModel().getColumn(2).setPreferredWidth(50);
            reviewTable.getColumnModel().getColumn(3).setPreferredWidth(320);
        }
        if (table.equals("users"))
        {
            ((DefaultTableCellRenderer)allUsersTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            allUsersTable.getColumn("ID").setCellRenderer(centerRender);
            allUsersTable.getColumn("Username").setCellRenderer(centerRender);
        }
    }
    
    /**
     * Sets the default values (or null) on all the user fields.
     */
    private void setDefaultViewValues ()
    {
        currentUserLabel.setText("");
        surnameText.setText("");
        familyNameText.setText("");
        emailText.setText ("");
        phoneText.setText("");
        cityText.setText("");
        reviewModel.setRowCount(0);
    }
    
    /**
     * Sets the default values (or null) on all the password related fields.
     */
    private void setDefaultPassValues ()
    {
        currentPassText.setText("");
        newPassText.setText("");
        repeatPassText.setText("");
    }
    
    /**
     * This method populates the "Area" Dropdown with predesigned information.
     * @param area 
     */
    private void populateAreaCombo(String area) 
    {
        int areaPossibilities = Model.typeFoodArray.length;
        int selectedOption = 0;
        areaCombo.removeAllItems();
        areaModel.addElement("None");
        for (int x=1; x<areaPossibilities;x++)
        {
            areaModel.addElement(Model.locationArray[x]);
            if (area.equals(Model.locationArray[x]))
                selectedOption = x;
        }
        areaCombo.setSelectedIndex(selectedOption);
    }
    
    /**
     * Method to update the user information on the database with the information provided by the  
     * user on the fields.
     */
    private void updateUser ()
    {
        if (Session.isUser())
        {
            String username = currentUserLabel.getText().trim();
            String surname = surnameText.getText().trim();
            String familyName = familyNameText.getText().trim();
            String email = emailText.getText().trim();
            String phone = phoneText.getText().trim();
            String area = "";
            if (areaCombo.getSelectedIndex() != 0)
            {
                area = areaCombo.getSelectedItem().toString();
            }
            String city = cityText.getText().trim();
            RegisteredUser user = new RegisteredUser (Session.getId(), username, surname, familyName, email, phone, area, city);
            //Checks if the information provided meets the standards.
            if (personalValuesComply(user))
            {
                controllerListener.updateUserDetails(user);
                sendSuccesfulMSG ("Your details were succesfully updated.", "Success!");
            }
        }
    }
    
    /**
     * Method to verify if the user has provided the right password, and that the new password
     * provided also complies with the required info (size, and matches to the repeated password).
     * @return 
     */
    private boolean checkPasswordChange() 
    {
        if (DBHandler.checkCredentials(currentUserLabel.getText(), String.valueOf(currentPassText.getPassword()), "Users"))
        {
            String newPass = String.valueOf(newPassText.getPassword()).trim();
            String repeatPass = String.valueOf(repeatPassText.getPassword()).trim();
            if(passwordValuesComply(newPass))
            {
                if ((!newPass.equals("")) && (newPass.equals(repeatPass)))
                {
                    return true;
                }
                else
                {
                    //Error the user did not repeat the password correcty or gave a blank new password.
                    sendErrorMSG ("Please comfirm your new passowrd correctly.", "Error");
                    repeatPassText.setText("");
                    newPassText.selectAll();
                    newPassText.grabFocus();
                    return false;
                }
            }
            else
            {
                //Error user provided a new password with more than the allowed amount of characters.
                sendErrorMSG ("Password can have a maximum of 20 characters.","Error");
                return false;
            }
        }
        else
        {
            //User provided the wrong current password.
            sendErrorMSG ("Incorrect Password.", "Error");
            currentPassText.selectAll();
            currentPassText.grabFocus();
            return false;
        }
    }   
    
    /**
     * Method to check whether all the information provided complies with the required information
     * structure. Checks the length of all the fields provided and compares them with the max 
     * allowed length. Then it checks that the phone number is only integers. It makes a list of 
     * errors to show to the user.
     * @param user
     * @return 
     */
    private boolean personalValuesComply(RegisteredUser user) 
    {
        //The string of errors is done in HTML form to be able to do breaklines.
        String errorMsg = "<html>";
        if (user.getSurname().length() > user.getSurnameLength())
            errorMsg += "Surname can not be longer than " +  user.getSurnameLength() + " characters. <br>";
        if (user.getFamilyName().length() > user.getFamNameLength())
            errorMsg += "Family Name can not be longer than " +  user.getFamNameLength() + " characters. <br>";
        if (user.getPhone().length() > user.getPhoneLength())
            errorMsg += "Phone number can not be longer than " +  user.getPhoneLength() + " characters. <br>";
        if (user.getCity().length() > user.getCityLength())
            errorMsg += "City can not be longer than " +  user.getCityLength() + " characters. <br>";
        if (!user.getPhone().trim().equals(""))
        {
            try
            {
                Integer.parseInt(user.getPhone());
            }
            catch (Exception e)
            {
                errorMsg += "Phone number can only contain Integer Values! <br>";
            }
        }
        errorMsg += "</html>";
        if ("<html></html>".equals(errorMsg))
        {
            return true;
        }
        else
        {
            sendErrorMSG (errorMsg, "Error");
            return false;
        }
    }

    /**
     * Checks that the length of the password complies the structure required.
     * @param newPass
     * @return 
     */
    private boolean passwordValuesComply(String newPass) 
    {
        return newPass.length() <= 20;
    }
    
    /**
     * Sends an error message with a specific message and a specific title.
     * @param msg
     * @param title 
     */
    private void sendErrorMSG (String msg, String title)
    {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * Sends a questions message with a specific message and a specific title.
     * @param msg
     * @param title
     * @return 
     */
    private int  sendQuestionMSG (String msg, String title)
    {
        Object[] options = { "Yes", "No" };
        int answer = JOptionPane.showOptionDialog(null, msg, title,
        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return answer;
    }
    
    /**
     * Sends a success message with a specific message and a specific title.
     * @param msg
     * @param title 
     */
    private void sendSuccesfulMSG (String msg, String title)
    {
        JOptionPane.showMessageDialog(null, msg, title, JOptionPane.INFORMATION_MESSAGE);
    }   
    
    /**
     * Sets the control listener required to communicate the view to the controller.
     * @param controllerListener 
     */
    public void setControllerListener(ControllerListener controllerListener) 
    {
        this.controllerListener = controllerListener;
    }
}