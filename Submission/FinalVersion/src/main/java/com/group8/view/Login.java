package com.group8.view;

import com.group8.controller.ControllerListener;
import com.group8.model.Session;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

public class Login extends javax.swing.JFrame {

    private ControllerListener controllerListener;   
    
    public Login() 
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
        cancelButton = new javax.swing.JButton();
        loginButton = new javax.swing.JButton();
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
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 310, 95, 30));

        loginButton.setFont(new java.awt.Font("Arial", 0, 48)); // NOI18N
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/loginbutton.png"))); // NOI18N
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginButton.setName("loginButton"); // NOI18N
        loginButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/loginbutton_clicked.png"))); // NOI18N
        loginButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/loginbutton_rollover.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 310, 90, 30));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, -1));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void onWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_onWindowClosing
        controllerListener.exitLoginView();
    }//GEN-LAST:event_onWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        //Set the query window visible
    }//GEN-LAST:event_formWindowClosed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        controllerListener.exitLoginView();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        loginAction();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void passwordTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextKeyPressed
        if(userText.getText()!=""){
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                loginAction();
        }
    }//GEN-LAST:event_passwordTextKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    private javax.swing.JLabel userLabel;
    private javax.swing.JTextField userText;
    // End of variables declaration//GEN-END:variables

    public void setControllerListener(ControllerListener controllerListener) {
        this.controllerListener = controllerListener;
    }

    private void loginAction()
    {
        String username = userText.getText();
        String password = String.valueOf(passwordText.getPassword());
        
        if (Session.authorize(username, password))
        {
            userText.setText("");
            passwordText.setText("");
            controllerListener.authorizeLogin();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Invalid Username or Password. Try again.", 
                                                "Error Message", JOptionPane.ERROR_MESSAGE);
            userText.selectAll();
        }
        userText.grabFocus();
    }
}