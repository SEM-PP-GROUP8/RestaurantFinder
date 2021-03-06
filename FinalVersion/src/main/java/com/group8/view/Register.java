package com.group8.view;

import com.group8.controller.ControllerListener;
import com.group8.model.DBHandler;
import com.group8.model.Session;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Register extends javax.swing.JFrame {

    private ControllerListener controllerListener;   
    
    public Register() 
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

        userLabel = new javax.swing.JLabel();
        userText = new javax.swing.JTextField();
        passwordLabel = new javax.swing.JLabel();
        passwordText = new javax.swing.JPasswordField();
        passwordRepeatLabel = new javax.swing.JLabel();
        repeatLabel = new javax.swing.JLabel();
        passwordRepeatText = new javax.swing.JPasswordField();
        cancelButton = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        ownerCheckbox = new javax.swing.JCheckBox();
        logoLabel = new javax.swing.JLabel();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Login as a User, Restaurant Owner or an Administrator");
        setBounds(new java.awt.Rectangle(200, 50, 800, 620));
        setMinimumSize(new java.awt.Dimension(800, 620));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                onWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userLabel.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        userLabel.setForeground(new java.awt.Color(102, 102, 102));
        userLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userLabel.setText("Username");
        userLabel.setName("userLabel"); // NOI18N
        getContentPane().add(userLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 240, 80));

        userText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        userText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        userText.setName("userText"); // NOI18N
        getContentPane().add(userText, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 360, 80));

        passwordLabel.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText("Password");
        passwordLabel.setName("passwordLabel"); // NOI18N
        getContentPane().add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 240, 80));

        passwordText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        passwordText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextKeyPressed(evt);
            }
        });
        getContentPane().add(passwordText, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 360, 80));

        passwordRepeatLabel.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        passwordRepeatLabel.setForeground(new java.awt.Color(102, 102, 102));
        passwordRepeatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordRepeatLabel.setText("Password");
        passwordRepeatLabel.setName("passwordLabel"); // NOI18N
        getContentPane().add(passwordRepeatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 240, 80));

        repeatLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        repeatLabel.setForeground(new java.awt.Color(102, 102, 102));
        repeatLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        repeatLabel.setText("(repeat)");
        repeatLabel.setName("passwordLabel"); // NOI18N
        getContentPane().add(repeatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 360, 240, 30));

        passwordRepeatText.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        passwordRepeatText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordRepeatText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordRepeatTextActionPerformed(evt);
            }
        });
        passwordRepeatText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordRepeatTextKeyPressed(evt);
            }
        });
        getContentPane().add(passwordRepeatText, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 360, 80));

        cancelButton.setFont(new java.awt.Font("Lucida Grande", 0, 48)); // NOI18N
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/cancelbutton.png"))); // NOI18N
        cancelButton.setBorderPainted(false);
        cancelButton.setContentAreaFilled(false);
        cancelButton.setName("cancelButton"); // NOI18N
        cancelButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/cancelbutton_rollover.png"))); // NOI18N
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 390, 95, 30));

        registerButton.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/registerbutton_big.png"))); // NOI18N
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.setName("registerButton"); // NOI18N
        registerButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/registerbutton_big_clicked.png"))); // NOI18N
        registerButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/registerbutton_big_rollover.png"))); // NOI18N
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 90, 30));

        ownerCheckbox.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ownerCheckbox.setForeground(new java.awt.Color(102, 102, 102));
        ownerCheckbox.setText("Restaurant Owner");
        ownerCheckbox.setContentAreaFilled(false);
        ownerCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerCheckboxActionPerformed(evt);
            }
        });
        getContentPane().add(ownerCheckbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, -1, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowClosing
        controllerListener.exitRegisterView();
    }//GEN-LAST:event_onWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controllerListener.exitRegisterView();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        
        // If the fields are not empty
        if(!userText.getText().equals("") && !String.valueOf(passwordText.getPassword()).equals(""))
            registerAction();
        
        // If fields are empty
        else
            JOptionPane.showMessageDialog(this, "Please enter a username and a password.", 
                                                    "Error Message", JOptionPane.ERROR_MESSAGE);
        
    }//GEN-LAST:event_registerButtonActionPerformed

    private void passwordTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextKeyPressed

    }//GEN-LAST:event_passwordTextKeyPressed

    private void passwordRepeatTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordRepeatTextKeyPressed
        
        // If the enterbutton was pressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            
            // If the fields are not empty
            if(!userText.getText().equals("") && !String.valueOf(passwordText.getPassword()).equals(""))
                registerAction();
            
            // If the fields are empty
            else
            JOptionPane.showMessageDialog(this, "Please enter a username and a password.", 
                                                    "Error Message", JOptionPane.ERROR_MESSAGE);
        
        }

    }//GEN-LAST:event_passwordRepeatTextKeyPressed

    private void passwordRepeatTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordRepeatTextActionPerformed

    }//GEN-LAST:event_passwordRepeatTextActionPerformed

    private void ownerCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerCheckboxActionPerformed

    }//GEN-LAST:event_ownerCheckboxActionPerformed
 
    private void registerAction()
    {
        
        // Initialize variables
        String username = userText.getText();
        String password = String.valueOf(passwordText.getPassword());
        String passwordRepeat = String.valueOf(passwordRepeatText.getPassword());
        
        // If the username does not exists in the database
        if(!DBHandler.checkUsername(username, "Users") && !DBHandler.checkUsername(username, "Owners")) 
        {
            
            // If the entered passwords match
            if(password.equals(passwordRepeat))
            {
                
                // Add owner
                if(ownerCheckbox.isSelected())
                    DBHandler.addOwner(username, password);

                
                // Add user
                else
                    DBHandler.addUser(username, password);
                
                
                // Prompt message to user
                JOptionPane.showMessageDialog(this, "You are now registered. Click ok to continue.", 
                                                "Information Message", JOptionPane.INFORMATION_MESSAGE);
            
            }
            
            // If the passwords does not match
            else 
            {
                
                // Prompt error message to the user and reset the password fields
                JOptionPane.showMessageDialog(this, "Passwords does not match.", 
                                                    "Error Message", JOptionPane.ERROR_MESSAGE);
                passwordText.setText("");
                passwordRepeatText.setText("");
            
            }
                
            // Autorize(login) the registered user
            if(Session.authorize(username, password)) {
              
                // Reset the textfields, exit the register view and reload the query view
                userText.setText("");
                passwordText.setText("");
                passwordRepeatText.setText("");
                controllerListener.exitRegisterView();
                controllerListener.reloadQueryView();
            
            }
            
        }
        
        // If the selected username already exists in the database
        else 
        {
            
            // Prompt an error message to the user and reset text fields
            JOptionPane.showMessageDialog(this, "Username already exists. Enter a new username.", 
                                                "Error Message", JOptionPane.ERROR_MESSAGE);   
            userText.setText("");
            passwordText.setText("");
            passwordRepeatText.setText("");
            
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JCheckBox ownerCheckbox;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel passwordRepeatLabel;
    private javax.swing.JPasswordField passwordRepeatText;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel repeatLabel;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables

    public void setControllerListener(ControllerListener controllerListener) {
        this.controllerListener = controllerListener;
    }

}