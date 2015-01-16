package com.group8.view;

import com.group8.controller.ControllerListener;
import com.group8.model.DBHandler;
import com.group8.model.RegisteredOwner;
import com.group8.model.RegisteredOwnerDAO;
import com.group8.model.Session;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Owner extends javax.swing.JFrame 
{
    //Variable that connects the view to the controller
    private ControllerListener controllerListener;
    List <RegisteredOwner> owners;

    public Owner() 
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
        jSeparator1 = new javax.swing.JSeparator();
        ownerNameLabel = new javax.swing.JLabel();
        currentOwnerLabel = new javax.swing.JLabel();
        editPassButton = new javax.swing.JButton();
        cancelEditPassButton = new javax.swing.JButton();
        updateInfoButton = new javax.swing.JButton();
        currentPassLabel = new javax.swing.JLabel();
        currentPassText = new javax.swing.JPasswordField();
        newPassLabel = new javax.swing.JLabel();
        newPassText = new javax.swing.JPasswordField();
        repeatPassLabel = new javax.swing.JLabel();
        repeatPassText = new javax.swing.JPasswordField();
        savePassButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        allOwnersPane = new javax.swing.JScrollPane();
        allOwnersTable = new javax.swing.JTable();
        deleteOwnerButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Personal Information");
        setLocation(new java.awt.Point(200, 50));
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
        getContentPane().add(surnameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 180, 40));

        surnameText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        surnameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        surnameText.setToolTipText("");
        getContentPane().add(surnameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 180, 40));

        familyNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        familyNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        familyNameLabel.setText("Family Name");
        familyNameLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(familyNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 180, 40));

        familyNameText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        familyNameText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        familyNameText.setToolTipText("");
        getContentPane().add(familyNameText, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 180, 180, -1));

        emailLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        emailLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        emailLabel.setText("Email");
        emailLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 270, 180, 40));

        emailText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        emailText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        emailText.setToolTipText("");
        getContentPane().add(emailText, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 180, -1));

        phoneLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        phoneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        phoneLabel.setText("Phone Number");
        phoneLabel.setPreferredSize(new java.awt.Dimension(180, 40));
        getContentPane().add(phoneLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 180, 40));

        phoneText.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        phoneText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phoneText.setToolTipText("");
        getContentPane().add(phoneText, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 180, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 800, -1));

        ownerNameLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        ownerNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ownerNameLabel.setText("Username:");
        getContentPane().add(ownerNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 140, 40));

        currentOwnerLabel.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        currentOwnerLabel.setPreferredSize(new java.awt.Dimension(140, 40));
        getContentPane().add(currentOwnerLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 440, 40));

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

        updateInfoButton.setText("Update Info");
        updateInfoButton.setPreferredSize(new java.awt.Dimension(110, 40));
        updateInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateInfoButtonActionPerformed(evt);
            }
        });
        getContentPane().add(updateInfoButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 410, -1, 40));

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

        backButton.setText("<- Back");
        backButton.setPreferredSize(new java.awt.Dimension(100, 40));
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 100, -1));

        allOwnersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Username"
            }
        ));
        allOwnersTable.setAutoscrolls(false);
        ownersModel = (DefaultTableModel) allOwnersTable.getModel();
        allOwnersPane.setViewportView(allOwnersTable);

        getContentPane().add(allOwnersPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 660, 430));

        deleteOwnerButton.setText("Delete");
        deleteOwnerButton.setPreferredSize(new java.awt.Dimension(110, 40));
        deleteOwnerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteOwnerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(deleteOwnerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 510, -1, 40));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void editPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPassButtonActionPerformed
        //Changes the view to the changePasswordView
        changePasswordView (true);
    }//GEN-LAST:event_editPassButtonActionPerformed

    private void cancelEditPassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelEditPassButtonActionPerformed
        //Removes the values from the texfields to change password and changes the view back to normal.
        setDefaultPassValues ();
        changePasswordView (false);
    }//GEN-LAST:event_cancelEditPassButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        //For security it removes anything that could be on the change passord text boxes
        // and closes the view.
        setDefaultPassValues ();
        controllerListener.exitOwnerView();
    }//GEN-LAST:event_backButtonActionPerformed

    private void repeatPassTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repeatPassTextKeyPressed
        //Checks if the owner has pressed enter when reaching the last txt field. It emulates the 
        // click of the Save button.
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        savePassButton.doClick();
    }//GEN-LAST:event_repeatPassTextKeyPressed

    private void updateInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateInfoButtonActionPerformed
        //Asks the owner if he is sure he wants to update his details then if the owner agrees
        // it calls the appropriate methods to achieve this.
        int answer = sendQuestionMSG ("Are you sure you want to update owner details?", "Update?");
        if (answer == 0)
        {
            updateOwner ();
        }
    }//GEN-LAST:event_updateInfoButtonActionPerformed

    private void savePassButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePassButtonActionPerformed
        //Checks that the passowrds provided comply with all the needed specifications
        // If true then it updates the passord in the DB and sends a success msg.
        if (checkPasswordChange())
        {
            String password = String.valueOf(newPassText.getPassword()).trim();
            controllerListener.updatePassword(Session.getId(), password, "Owners");
            sendSuccesfulMSG ("Your password was succesfully changed.", "Success!");
            cancelEditPassButton.doClick();
        }
    }//GEN-LAST:event_savePassButtonActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //For security it removes anything that could be on the change passord text boxes
        // and closes the view.
        setDefaultPassValues ();
        controllerListener.exitOwnerView();
    }//GEN-LAST:event_formWindowClosing

    private void deleteOwnerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteOwnerButtonActionPerformed
        //Asks the admin for verification on deleting the user. If admin agrees then 
        //it deletes the user and sends a success msg. It also updates the table.
        
        int index = allOwnersTable.getSelectedRow();
        if (index >= 0)
        {
            int answer = sendQuestionMSG ("Are you sure you want to delete the Owner?", "Delete?");
            if (answer == 0)
            {
                RegisteredOwner current = owners.get(index);
                RegisteredOwnerDAO.deleteOwner(current.getId());
                updateOwnersTable();
                sendSuccesfulMSG ("The Owner was succesfully deleted.", "Success!");
            }
        }
        else
        {
            sendErrorMSG ("You have to select an Owner First.","Error!");
        }
    }//GEN-LAST:event_deleteOwnerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane allOwnersPane;
    private javax.swing.JTable allOwnersTable;
    DefaultTableModel ownersModel;
    private javax.swing.JButton backButton;
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton cancelEditPassButton;
    private javax.swing.JLabel currentOwnerLabel;
    private javax.swing.JLabel currentPassLabel;
    private javax.swing.JPasswordField currentPassText;
    private javax.swing.JButton deleteOwnerButton;
    private javax.swing.JButton editPassButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel familyNameLabel;
    private javax.swing.JTextField familyNameText;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel newPassLabel;
    private javax.swing.JPasswordField newPassText;
    private javax.swing.JLabel ownerNameLabel;
    private javax.swing.JLabel phoneLabel;
    private javax.swing.JTextField phoneText;
    private javax.swing.JLabel repeatPassLabel;
    private javax.swing.JPasswordField repeatPassText;
    private javax.swing.JButton savePassButton;
    private javax.swing.JLabel surnameLabel;
    private javax.swing.JTextField surnameText;
    private javax.swing.JButton updateInfoButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Main method to load all the important things related to the view. It cleans everything from 
     * the view (sets default) and then it loads the view and fills the info for the view.
     */
    public void loadView ()
    {
        if (Session.isOwner())
        {
            setDefaultViewValues();
            setDefaultPassValues ();
            setValues();
        }
        if (Session.isAdmin())
        {
            currentOwnerLabel.setText("Administrator");
            justifyColumns ("Owners");
            updateOwnersTable();
        }
        changePasswordView(false);
        
    }
    
    /**
     * Method to handle whether the owner wants the regular view or wants the change password view.
     * @param option
     */
    private void changePasswordView(boolean option)
    {
        boolean normalView;
        boolean changePass;
        boolean isAdmin;
        if (Session.isOwner())
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
        cancelEditPassButton.setVisible(changePass);
        currentPassLabel.setVisible(changePass);
        currentPassText.setVisible(changePass);
        newPassLabel.setVisible(changePass);
        newPassText.setVisible(changePass);
        repeatPassLabel.setVisible(changePass);
        repeatPassText.setVisible(changePass);
        savePassButton.setVisible(changePass);
        if (changePass)
            currentPassText.grabFocus();
        
        editPassButton.setVisible(normalView);
        surnameLabel.setVisible(normalView);
        surnameText.setVisible(normalView);
        familyNameLabel.setVisible(normalView);
        familyNameText.setVisible(normalView);
        emailLabel.setVisible(normalView);
        emailText.setVisible(normalView);
        phoneLabel.setVisible(normalView);
        phoneText.setVisible(normalView);
        updateInfoButton.setVisible(normalView);
        
        allOwnersPane.setVisible(isAdmin);
        deleteOwnerButton.setVisible(isAdmin);
    }

    /**
     * This method fills all the appropriate fields with the personal information of the owner.
     * It also calls the method to update the table with the right info.
     */
    private void setValues ()
    {
        if (Session.isOwner())
        {
            RegisteredOwner currentOwner = controllerListener.fetchOwnerDetails (Session.getId());
            currentOwnerLabel.setText(currentOwner.getUserName());
            surnameText.setText(currentOwner.getSurname());
            familyNameText.setText(currentOwner.getFamilyName());
            emailText.setText (currentOwner.getEmail());
            phoneText.setText(currentOwner.getPhone());
        }
    }
    
    /**
     * Method to update the owner information on the database with the information provided by the  
     * owner on the fields.
     */
    private void updateOwner ()
    {
        if (Session.isOwner())
        {
            String username = currentOwnerLabel.getText().trim();
            String surname = surnameText.getText().trim();
            String familyName = familyNameText.getText().trim();
            String email = emailText.getText().trim();
            String phone = phoneText.getText().trim();
            RegisteredOwner owner = new RegisteredOwner (Session.getId(), username, surname, familyName, email, phone);
            //Checks if the information provided meets the standards.
            if (personalValuesComply(owner))
            {
                controllerListener.updateOwnerDetails(owner);
                sendSuccesfulMSG ("Your details were succesfully updated.", "Success!");
            }
        }
    }
    
    /**
     * Sets the default values (or null) on all the owner fields.
     */
    private void setDefaultViewValues ()
    {
        currentOwnerLabel.setText("");
        surnameText.setText("");
        familyNameText.setText("");
        emailText.setText ("");
        phoneText.setText("");
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
     * Method to verify if the owner has provided the right password, and that the new password
     * provided also complies with the required info (size, and matches to the repeated password).
     * @return 
     */
    private boolean checkPasswordChange() 
    {
        if (DBHandler.checkCredentials(currentOwnerLabel.getText(), String.valueOf(currentPassText.getPassword()).trim(), "Owners"))
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
                    sendErrorMSG ("Please comfirm your new passowrd correctly.", "Error");
                    repeatPassText.setText("");
                    newPassText.selectAll();
                    newPassText.grabFocus();
                    return false;
                }
            }
            else
            {
                sendErrorMSG ("Password can have a maximum of 20 characters.","Error");
                return false;
            }
        }
        else
        {
            sendErrorMSG ("Incorrect Password.", "Error");
            currentPassText.selectAll();
            currentPassText.grabFocus();
            return false;
        }
    }   
    
    private void updateOwnersTable ()
    {
        owners = controllerListener.getAllOwners();
        try
        {
            ownersModel.setRowCount(0);
            for (RegisteredOwner current : owners) 
            {
                int id = current.getId();
                String name = current.getUserName();
                ownersModel.addRow(new Object[]{id, name});
            }
            justifyColumns("users");
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Owners: Problem with the Database!", "Program error", JOptionPane.ERROR_MESSAGE);
        }
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
        if (table.equals("Owners"))
        {
            ((DefaultTableCellRenderer)allOwnersTable.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
            allOwnersTable.getColumn("ID").setCellRenderer(centerRender);
            allOwnersTable.getColumn("Username").setCellRenderer( centerRender );
        }
    }
    
    /**
     * Method to check whether all the information provided complies with the required information
     * structure. Checks the length of all the fields provided and compares them with the max 
     * allowed length. Then it checks that the phone number is only integers. It makes a list of 
     * errors to show to the owner.
     * @param owner
     */
    private boolean personalValuesComply(RegisteredOwner owner) 
    {
        //The string of errors is done in HTML form to be able to do breaklines.
        String errorMsg = "<html>";
        if (owner.getSurname().length() > owner.getSurnameLength())
            errorMsg += "Surname can not be longer than " +  owner.getSurnameLength() + " characters. <br>";
        if (owner.getFamilyName().length() > owner.getFamNameLength())
            errorMsg += "Family Name can not be longer than " +  owner.getFamNameLength() + " characters. <br>";
        if (owner.getPhone().length() > owner.getPhoneLength())
            errorMsg += "Phone number can not be longer than " +  owner.getPhoneLength() + " characters. <br>";
        if (!owner.getPhone().trim().equals(""))
        {
            try
            {
                Integer.parseInt(owner.getPhone());
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
     * Sends an error message with a specific message and a specific title
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
     * Sends a success msg with a specific msg and a specific title.
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
