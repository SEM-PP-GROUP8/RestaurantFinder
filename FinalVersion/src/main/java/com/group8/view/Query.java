/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.group8.view;
import com.group8.controller.ControllerListener;
import javax.swing.DefaultListModel;
import javax.swing.DefaultComboBoxModel;
import com.group8.model.Model;
import com.group8.model.Restaurant;
import com.group8.model.Session;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author enriquecordero
 */
public class Query extends javax.swing.JFrame 
{
    private boolean dropDownInitiation = false;
    private ControllerListener controllerListener;
    private List<Restaurant> filteredRestaurants;

    public Query() 
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

        typeOfFoodGroup = new javax.swing.ButtonGroup();
        loginButton = new javax.swing.JButton();
        logoutButton = new javax.swing.JButton();
        orLabel = new javax.swing.JLabel();
        registerButton = new javax.swing.JButton();
        searchButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();
        searchbarLabel = new javax.swing.JLabel();
        locationModel = new DefaultComboBoxModel ();
        drop_filter_location = new javax.swing.JComboBox();
        tofModel = new DefaultComboBoxModel ();
        drop_filter_typeOfFood = new javax.swing.JComboBox();
        timeModel = new DefaultComboBoxModel ();
        drop_filter_openingHours = new javax.swing.JComboBox();
        drop_filter_dayOfWeek = new javax.swing.JComboBox();
        typeOfFoodLabel = new javax.swing.JLabel();
        prizeRangeLabel = new javax.swing.JLabel();
        locationLabel = new javax.swing.JLabel();
        openAtTimeLabel = new javax.swing.JLabel();
        openAtDayLabel = new javax.swing.JLabel();
        restaurantButton = new javax.swing.JButton();
        userButton = new javax.swing.JButton();
        ownerButton = new javax.swing.JButton();
        viewButton = new javax.swing.JButton();
        rangeSlider1 = new com.group8.view.RangeSlider();
        logoLabel = new javax.swing.JLabel();
        openAtLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        restaurantTable = new javax.swing.JTable();
        backgroundLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome to RestSearch");
        setBounds(new java.awt.Rectangle(200, 50, 800, 620));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/loginbutton.png"))); // NOI18N
        loginButton.setBorderPainted(false);
        loginButton.setContentAreaFilled(false);
        loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginButton.setName(""); // NOI18N
        loginButton.setPreferredSize(new java.awt.Dimension(120, 40));
        loginButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/loginbutton_clicked.png"))); // NOI18N
        loginButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/loginbutton_rollover.png"))); // NOI18N
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        getContentPane().add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 20, 90, 30));

        logoutButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        logoutButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logoutbutton.png"))); // NOI18N
        logoutButton.setBorderPainted(false);
        logoutButton.setContentAreaFilled(false);
        logoutButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        logoutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutButton.setName(""); // NOI18N
        logoutButton.setPreferredSize(new java.awt.Dimension(120, 40));
        logoutButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logoutbutton_clicked.png"))); // NOI18N
        logoutButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logoutbutton_rollover.png"))); // NOI18N
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });
        getContentPane().add(logoutButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 20, 90, 30));

        orLabel.setFont(new java.awt.Font("Verdana", 1, 11)); // NOI18N
        orLabel.setForeground(new java.awt.Color(102, 102, 102));
        orLabel.setText("or");
        orLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(orLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(725, 55, 30, -1));

        registerButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        registerButton.setForeground(new java.awt.Color(102, 102, 102));
        registerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/registerbutton.png"))); // NOI18N
        registerButton.setBorderPainted(false);
        registerButton.setContentAreaFilled(false);
        registerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        registerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        registerButton.setName(""); // NOI18N
        registerButton.setPreferredSize(new java.awt.Dimension(120, 40));
        registerButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/registerbutton_rollover.png"))); // NOI18N
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 70, 95, 30));

        searchButton.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        searchButton.setForeground(new java.awt.Color(102, 102, 102));
        searchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/searchbutton.png"))); // NOI18N
        searchButton.setToolTipText("");
        searchButton.setBorderPainted(false);
        searchButton.setContentAreaFilled(false);
        searchButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchButton.setIconTextGap(0);
        searchButton.setMaximumSize(new java.awt.Dimension(130, 35));
        searchButton.setMinimumSize(new java.awt.Dimension(130, 35));
        searchButton.setName(""); // NOI18N
        searchButton.setPreferredSize(new java.awt.Dimension(130, 35));
        searchButton.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/searchbutton_clicked.png"))); // NOI18N
        searchButton.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/searchbutton_rollover.png"))); // NOI18N
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });
        getContentPane().add(searchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 50, 50));

        searchTextField.setFont(new java.awt.Font("Verdana", 0, 15)); // NOI18N
        searchTextField.setForeground(new java.awt.Color(153, 153, 153));
        searchTextField.setText("Search by name, type or area");
        searchTextField.setBorder(null);
        searchTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                searchTextFieldFocusGained(evt);
            }
        });
        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchTextFieldKeyPressed(evt);
            }
        });
        getContentPane().add(searchTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(215, 62, 320, 26));
        searchTextField.getAccessibleContext().setAccessibleName("");

        searchbarLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/searchbar.png"))); // NOI18N
        getContentPane().add(searchbarLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, 50));

        drop_filter_location.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        drop_filter_location.setModel(locationModel);
        drop_filter_location.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drop_filter_locationItemStateChanged(evt);
            }
        });
        getContentPane().add(drop_filter_location, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 120, 25));

        drop_filter_typeOfFood.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        drop_filter_typeOfFood.setModel(tofModel);
        drop_filter_typeOfFood.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drop_filter_typeOfFoodItemStateChanged(evt);
            }
        });
        getContentPane().add(drop_filter_typeOfFood, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 120, 25));

        drop_filter_openingHours.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        drop_filter_openingHours.setModel(timeModel);
        drop_filter_openingHours.setPreferredSize(new java.awt.Dimension(120, 25));
        drop_filter_openingHours.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drop_filter_openingHoursItemStateChanged(evt);
            }
        });
        getContentPane().add(drop_filter_openingHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 175, 120, 25));

        drop_filter_dayOfWeek.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        drop_filter_dayOfWeek.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Any", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday" }));
        drop_filter_dayOfWeek.setPreferredSize(new java.awt.Dimension(120, 25));
        drop_filter_dayOfWeek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                drop_filter_dayOfWeekItemStateChanged(evt);
            }
        });
        getContentPane().add(drop_filter_dayOfWeek, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 175, 120, 25));

        typeOfFoodLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        typeOfFoodLabel.setForeground(new java.awt.Color(102, 102, 102));
        typeOfFoodLabel.setText("Cuisine type");
        typeOfFoodLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(typeOfFoodLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 100, 35));

        prizeRangeLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        prizeRangeLabel.setForeground(new java.awt.Color(102, 102, 102));
        prizeRangeLabel.setText("Price range");
        prizeRangeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(prizeRangeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 100, 35));

        locationLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        locationLabel.setForeground(new java.awt.Color(102, 102, 102));
        locationLabel.setText("Area");
        locationLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(locationLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 100, 35));

        openAtTimeLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        openAtTimeLabel.setForeground(new java.awt.Color(102, 102, 102));
        openAtTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openAtTimeLabel.setText("Time");
        openAtTimeLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        openAtTimeLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        getContentPane().add(openAtTimeLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 190, -1, -1));

        openAtDayLabel.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        openAtDayLabel.setForeground(new java.awt.Color(102, 102, 102));
        openAtDayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        openAtDayLabel.setText("Weekday");
        openAtDayLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        openAtDayLabel.setPreferredSize(new java.awt.Dimension(120, 25));
        getContentPane().add(openAtDayLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        restaurantButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        restaurantButton.setText("Restaurants");
        restaurantButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        restaurantButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        restaurantButton.setName(""); // NOI18N
        restaurantButton.setPreferredSize(new java.awt.Dimension(140, 30));
        restaurantButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restaurantButtonActionPerformed(evt);
            }
        });
        getContentPane().add(restaurantButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 290, 140, 30));

        userButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        userButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        userButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        userButton.setLabel("My profile");
        userButton.setName(""); // NOI18N
        userButton.setPreferredSize(new java.awt.Dimension(140, 30));
        userButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userButtonActionPerformed(evt);
            }
        });
        getContentPane().add(userButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 140, 30));

        ownerButton.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        ownerButton.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ownerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ownerButton.setLabel("My profile");
        ownerButton.setMaximumSize(new java.awt.Dimension(123, 39));
        ownerButton.setMinimumSize(new java.awt.Dimension(123, 39));
        ownerButton.setName(""); // NOI18N
        ownerButton.setPreferredSize(new java.awt.Dimension(140, 30));
        ownerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownerButtonActionPerformed(evt);
            }
        });
        getContentPane().add(ownerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 140, 30));

        viewButton.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        viewButton.setText("View");
        viewButton.setName("searchButton"); // NOI18N
        viewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewButtonActionPerformed(evt);
            }
        });
        getContentPane().add(viewButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 430, 180, 60));

        rangeSlider1.setMajorTickSpacing(100);
        rangeSlider1.setMaximum(500);
        rangeSlider1.setMinorTickSpacing(25);
        rangeSlider1.setPaintLabels(true);
        rangeSlider1.setPaintTicks(true);
        rangeSlider1.setSnapToTicks(true);
        rangeSlider1.setValue(0);
        rangeSlider1.setOpaque(false);
        rangeSlider1.setUpperValue(500);
        rangeSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                rangeSlider1MouseReleased(evt);
            }
        });
        getContentPane().add(rangeSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 330, -1));

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/logo.jpg"))); // NOI18N
        getContentPane().add(logoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 510, 100, -1));

        openAtLabel1.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        openAtLabel1.setForeground(new java.awt.Color(102, 102, 102));
        openAtLabel1.setText("Open at");
        openAtLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(openAtLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 100, 35));

        restaurantTable.setFont(new java.awt.Font("Lucida Sans", 0, 14)); // NOI18N
        restaurantTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type", "Area"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        restaurantTable.setName(""); // NOI18N
        restaurantTable.setOpaque(false);
        restaurantNewModel = (DefaultTableModel) restaurantTable.getModel();
        jScrollPane1.setViewportView(restaurantTable);
        restaurantTable.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 500, 130));

        backgroundLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/retina_wood_@2X.png"))); // NOI18N
        getContentPane().add(backgroundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void viewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewButtonActionPerformed
        /*NEW - Hampus*/
        if (controllerListener!=null && restaurantTable.getSelectedRow()>=0)
        {
            Restaurant selectedRestaurant = filteredRestaurants.get(restaurantTable.getSelectedRow());
            controllerListener.viewButtonClicked(selectedRestaurant);
        } 
    }//GEN-LAST:event_viewButtonActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        /*NEW*/
        if (controllerListener!=null)
        {
            controllerListener.registerButtonClicked();
        }
        /*END NEW*/
    }//GEN-LAST:event_registerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if (controllerListener!=null)
        {
            controllerListener.loginButtonClicked();
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        //Checks if the user wants to logout. If yes it logs out and sets the appropriate variables to their
        //default state. Otherwise it does nothing.
        Object[] options = {"No", "Yes"};
        int userOption = JOptionPane.showOptionDialog(this, "You sure you want to logout?", "Logout?", 
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        if (userOption==1)
        //User chose yes
        {
            Session.logout();
            loadView();
        }
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void userButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userButtonActionPerformed
        controllerListener.userButtonClicked();
    }//GEN-LAST:event_userButtonActionPerformed

    private void restaurantButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restaurantButtonActionPerformed
        controllerListener.restaurantsButtonClicked();

    }//GEN-LAST:event_restaurantButtonActionPerformed
/**/
    private void drop_filter_locationItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drop_filter_locationItemStateChanged
        //Every time the dropdown filters get changed then it should modify the list.
        //First it checks that its the actual choice event (drop downs have two events: one
        // to deselct the currently selected and another one to select a new item) so that it
        // does not execute twice. Then it checks its not initializing the values. Then it calls
        // the appropriate methods.
        if (evt.getStateChange()==1)
        {
            if (!dropDownInitiation)
            {
                restaurantsToView();
            }
        }
    }//GEN-LAST:event_drop_filter_locationItemStateChanged

    private void drop_filter_openingHoursItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drop_filter_openingHoursItemStateChanged
        //Every time the dropdown filters get changed then it should modify the list.
        //First it checks that its the actual choice event (drop downs have two events: one
        // to deselct the currently selected and another one to select a new item) so that it
        // does not execute twice. Then it checks its not initializing the values. Then it calls
        // the appropriate methods.
        if (evt.getStateChange()==1)
        {
            if (!dropDownInitiation)
            {
                restaurantsToView();
            }
        }
    }//GEN-LAST:event_drop_filter_openingHoursItemStateChanged

    //kevin
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        restaurantsToView ();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void searchTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_searchTextFieldFocusGained
        searchTextField.setText("");
        restaurantsToView ();
    }//GEN-LAST:event_searchTextFieldFocusGained
   
    private void drop_filter_typeOfFoodItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drop_filter_typeOfFoodItemStateChanged
        //Every time the dropdown filters get changed then it should modify the list.
        //First it checks that its the actual choice event (drop downs have two events: one
        // to deselct the currently selected and another one to select a new item) so that it
        // does not execute twice. Then it checks its not initializing the values. Then it calls
        // the appropriate methods.
        if (evt.getStateChange()==1)
        {
            if (!dropDownInitiation)
            {
                restaurantsToView();
            }
        }
    }//GEN-LAST:event_drop_filter_typeOfFoodItemStateChanged

    private void ownerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownerButtonActionPerformed
        controllerListener.ownerButtonClicked();
    }//GEN-LAST:event_ownerButtonActionPerformed

    private void searchTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldKeyPressed
        if(searchTextField.getText()!=""){
            if(evt.getKeyCode() == KeyEvent.VK_ENTER)
                restaurantsToView();
        }
    }//GEN-LAST:event_searchTextFieldKeyPressed

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void rangeSlider1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rangeSlider1MouseReleased
         restaurantNewModel.setRowCount(0);
         restaurantsToView();
    }//GEN-LAST:event_rangeSlider1MouseReleased

    private void drop_filter_dayOfWeekItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_drop_filter_dayOfWeekItemStateChanged
        //Every time the dropdown filters get changed then it should modify the list.
        //First it checks that its the actual choice event (drop downs have two events: one
        // to deselct the currently selected and another one to select a new item) so that it
        // does not execute twice. Then it checks its not initializing the values. Then it calls
        // the appropriate methods.
        if (evt.getStateChange()==1)
        {
            if (!dropDownInitiation)
            {
                restaurantsToView();
            }
        }
    }//GEN-LAST:event_drop_filter_dayOfWeekItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundLabel;
    private javax.swing.JComboBox drop_filter_dayOfWeek;
    private javax.swing.JComboBox drop_filter_location;
    private DefaultComboBoxModel locationModel;
    private javax.swing.JComboBox drop_filter_openingHours;
    private DefaultComboBoxModel timeModel;
    private javax.swing.JComboBox drop_filter_typeOfFood;
    private DefaultComboBoxModel tofModel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel locationLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton logoutButton;
    private javax.swing.JLabel openAtDayLabel;
    private javax.swing.JLabel openAtLabel1;
    private javax.swing.JLabel openAtTimeLabel;
    private javax.swing.JLabel orLabel;
    private javax.swing.JButton ownerButton;
    private javax.swing.JLabel prizeRangeLabel;
    private com.group8.view.RangeSlider rangeSlider1;
    private javax.swing.JButton registerButton;
    private javax.swing.JButton restaurantButton;
    private javax.swing.JTable restaurantTable;
    DefaultTableModel restaurantNewModel;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel searchbarLabel;
    private javax.swing.ButtonGroup typeOfFoodGroup;
    private javax.swing.JLabel typeOfFoodLabel;
    private javax.swing.JButton userButton;
    private javax.swing.JButton viewButton;
    // End of variables declaration//GEN-END:variables

    
    public void loadView ()
    {
        //Loads the view with all the appropriate buttons and the appropriate menu and the restaurants.
        dropDownInitiation = true;
        defaultMenuItems();
        populateSessionButtons();
        populateDropDowns();
        restaurantsToView();
    }
    
    public void reloadView()
    {
        populateSessionButtons();
        restaurantsToView();
    }
    
    /*private void menuItemHandler (int option) 
    {   
        //If any of the menu items is clicked then it tries to switch between the view in the menu.
        defaultMenuItems();
        switch (option)
        {
            case 1:
                typeOfFoodButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/menuitem_clicked.png")));
                menuArrow1.setVisible(true);
                drop_filter_typeOfFood.setVisible(true);
                break;
            case 2:
                prizeRangeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/menuitem_clicked.png")));
                menuArrow2.setVisible(true);
                drop_filter_priceRangeMin.setVisible(true);
                drop_filter_priceRangeMax.setVisible(true);
                label_filter_to.setVisible(true); 
                break;
            case 3:
                locationButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/menuitem_clicked.png")));
                menuArrow3.setVisible(true);
                drop_filter_location.setVisible(true);
                break;
            case 4:
                openAtButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/group8/view/images/menuitem_clicked.png")));
                menuArrow4.setVisible(true);
                drop_filter_openingHours.setVisible(true);
                
                drop_filter_openingHours.setSelectedIndex(Model.setCurrentOpeningHour());
                break;
        }
    }*/


    private void defaultMenuItems ()
    {
        drop_filter_typeOfFood.setVisible(true);
        //drop_filter_priceRangeMin.setVisible(true);
        //drop_filter_priceRangeMax.setVisible(true);
        //label_filter_to.setVisible(true); 
        drop_filter_location.setVisible(true);
        drop_filter_openingHours.setVisible(true);
    }
    
    private void populateSessionButtons ()
    {
        //Populates the buttons according to the right session.
        ownerButton.setVisible(false);
        userButton.setVisible(false);
        restaurantButton.setVisible(false);             
        loginButton.setVisible(false);
        orLabel.setVisible(false);
        registerButton.setVisible(false);
        logoutButton.setVisible(false);
        switch (Session.getType())
        {
            case "Admins":
                ownerButton.setVisible(true);
                userButton.setVisible(true);
                restaurantButton.setVisible(true);
                logoutButton.setVisible(true);
                break;
            case "Users":
                userButton.setVisible(true);
                logoutButton.setVisible(true);
                break;
            case "Owners":
                restaurantButton.setVisible(true); 
                ownerButton.setVisible(true);
                logoutButton.setVisible(true);
                break;
            default:
                loginButton.setVisible(true);
                orLabel.setVisible(true);
                registerButton.setVisible(true);
                break;
        }
    }

    private void populateDropDowns ()
    //Populates all the dropdowns in the view.
    {
        //Populates the Type of Food DropDown
        int typeFoodPossibilities = Model.typeFoodArray.length;
        drop_filter_typeOfFood.removeAllItems();
        for (int x=0; x<typeFoodPossibilities;x++)
        {
            tofModel.addElement(Model.typeFoodArray[x]);
        }
        drop_filter_typeOfFood.setSelectedIndex(0);
       
        //Populates the location DropDown
        int locationPossibilities = Model.locationArray.length;
        drop_filter_location.removeAllItems();
        for (int x=0; x<locationPossibilities;x++)
        {
            locationModel.addElement(Model.locationArray[x]);
        }
        drop_filter_location.setSelectedIndex(0);
       
        //Populates the OpenTime DropDown
        int timePossibilities = Model.timeArray.length;
        drop_filter_openingHours.removeAllItems();
        for (int x=0; x<timePossibilities;x++)
        {
            timeModel.addElement(Model.timeArray[x]);
        }
        drop_filter_openingHours.setSelectedIndex(0);
        dropDownInitiation = false;
        
        //populateMinDropDown (0);
        //dropDownInitiation = true;
        //populateMaxDropDown (0);
    }
    /*
    private void populateMinDropDown (int indexChosen)
    //Populates the minPrice dropdown depending on the chosen max.
    {
        int currentIndex = 0;
        int totalNumberPossibilities = Model.priceRangeMinArray.length - indexChosen;
        
        if (!dropDownInitiation)
        {
            currentIndex = drop_filter_priceRangeMin.getSelectedIndex();
            dropDownInitiation = true;
        }
        
        //Populates the minimum price DropDown
        drop_filter_priceRangeMin.removeAllItems();
        for (int x=0; x<totalNumberPossibilities;x++)
        {
            minPriceModel.addElement(Model.priceRangeMinArray[x]);
        }
        //Selects the item that was previously selected.
        drop_filter_priceRangeMin.setSelectedIndex(currentIndex);
        dropDownInitiation = false;
    }
    
    private void populateMaxDropDown (int indexChosen)
    //Populates the maxPrice dropdown depending on the chosen min.
    {
        int currentIndex = 0;
        int totalNumberPossibilities = Model.priceRangeMaxArray.length - indexChosen;
        if (!dropDownInitiation)
        {
            currentIndex = drop_filter_priceRangeMax.getSelectedIndex();
            dropDownInitiation = true;
        }
        //Populates the minimum price DropDown
        drop_filter_priceRangeMax.removeAllItems();
        for (int x=0; x<totalNumberPossibilities;x++)
        {
            maxPriceModel.addElement(Model.priceRangeMaxArray[x]);
        }
        //Selects the item that was previously selected.
        drop_filter_priceRangeMax.setSelectedIndex(currentIndex);
        dropDownInitiation = false;
    }
    */
    
    private void loadRestaurantList ()
    {
        //Loads the appropriate restaurant list into the variable.
        String typeOfFood = drop_filter_typeOfFood.getSelectedItem().toString();
        String priceMin = "" + rangeSlider1.getValue();
        String priceMax = "" + rangeSlider1.getUpperValue();
        String location = drop_filter_location.getSelectedItem().toString();
        String time = drop_filter_openingHours.getSelectedItem().toString();
        String dayName = drop_filter_dayOfWeek.getSelectedItem().toString();
        String searchTxt = searchTextField.getText().trim();
        if (searchTxt.equals("Search by name, type or area"))
                searchTxt = "";
        
        int intPriceMin = Integer.parseInt(priceMin);
        int intPriceMax = Integer.parseInt(priceMax);
        
        System.out.println ("so far printed: " + dayName);
        
        filteredRestaurants = controllerListener.fetchRestaurantByFilters(typeOfFood, intPriceMin, intPriceMax, location, time, dayName, searchTxt);
    }
    /*
    private void populateRestaurantList ()
    {
        //populates the restaurant list with the list in the variable.
        try
        {
            restaurantModel.clear();
            for (Restaurant current : filteredRestaurants) 
            {
                String restaurant = current.getName();
                restaurant = restaurant + " - " + current.getArea();
                restaurantModel.addElement(restaurant);
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Problem with the Database!", "Program error", JOptionPane.ERROR_MESSAGE);
        }
        if (restaurantModel.isEmpty())
        {
            restaurantModel.addElement("No Matches.");
        }
    }
    */
    private void populateRestaurantTable()
    {
        //populates the restaurant table with the list in the variable
        try
        {
            restaurantNewModel.setRowCount(0);
            for (Restaurant current : filteredRestaurants)  
            {
                String restaurant = current.getName();
                String area = current.getArea();
                String type = current.getType().toString();
                restaurantNewModel.addRow(new Object[]{restaurant, type, area});
            }
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(this, "Problem with the Database!", "Program error", JOptionPane.ERROR_MESSAGE);
        }
        if (filteredRestaurants.isEmpty())
        {
            restaurantNewModel.addRow(new Object[]{"No","Restaurant", "Matches."});
        }
    }
    
    public void restaurantsToView ()
    {
        //Loads the restaurants to view.
        loadRestaurantList();
        populateRestaurantTable();
    }
    
    public void setControllerListener(ControllerListener controllerListener) {
        this.controllerListener = controllerListener;
    }
}
