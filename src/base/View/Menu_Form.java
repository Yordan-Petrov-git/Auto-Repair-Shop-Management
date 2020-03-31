package base.View;

import base.LogInAs;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import menu.MenuItem;

/**
 * The main menu of the program
 *
 * @author 0896
 */
public class Menu_Form extends javax.swing.JFrame {

    //Coordinats for jform mouse draging feature 
    int xMouse;
    int yMouse;

    /**
     * Creates new form Menu_Form
     */
    public Menu_Form() {
        initComponents();

         seticon();//Sets icon
        
        //Makes the background of the form transparent
        this.setBackground(new Color(0, 0, 0, 0));

        clock();//Realtime clock 
        jLblUsernameName.setText(" Welcome user : " + LogInAs.empName);//Welcome user message
        jLabel3.setText(" You are logged in as : " + LogInAs.empIdusr);//Welcome username message
        executeMenu();//Loads  menu in the menu panel
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlBackMain = new javax.swing.JPanel();
        menus = new javax.swing.JPanel();
        menus1 = new javax.swing.JPanel();
        menus2 = new javax.swing.JPanel();
        jPnlTop = new javax.swing.JPanel();
        jLabel_minimizeMainM = new javax.swing.JLabel();
        jLabel_closeMainM = new javax.swing.JLabel();
        jLblTopMainM = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPnlBot = new javax.swing.JPanel();
        jLblDateTimeBot = new javax.swing.JLabel();
        jLblUsernameName = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPnlBackMain.setBackground(new java.awt.Color(255, 255, 255));
        jPnlBackMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menus.setBackground(new java.awt.Color(102, 102, 102));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));

        menus1.setBackground(new java.awt.Color(255, 255, 255));
        menus1.setLayout(new javax.swing.BoxLayout(menus1, javax.swing.BoxLayout.Y_AXIS));
        menus.add(menus1);

        menus2.setBackground(new java.awt.Color(255, 255, 255));
        menus2.setLayout(new javax.swing.BoxLayout(menus2, javax.swing.BoxLayout.Y_AXIS));
        menus.add(menus2);

        jPnlBackMain.add(menus, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 240, 520));

        jPnlTop.setBackground(new java.awt.Color(62, 62, 62));
        jPnlTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_minimizeMainM.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_minimizeMainM.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_minimizeMainM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_minimizeMainM.setText("  -");
        jLabel_minimizeMainM.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_minimizeMainM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimizeMainM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMainMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMainMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeMainMMouseExited(evt);
            }
        });
        jPnlTop.add(jLabel_minimizeMainM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 30, 30));

        jLabel_closeMainM.setBackground(new java.awt.Color(255, 0, 51));
        jLabel_closeMainM.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_closeMainM.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_closeMainM.setText("  x");
        jLabel_closeMainM.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_closeMainM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_closeMainM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeMainMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeMainMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeMainMMouseExited(evt);
            }
        });
        jLabel_closeMainM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jLabel_closeMainMKeyTyped(evt);
            }
        });
        jPnlTop.add(jLabel_closeMainM, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 30, 30));

        jLblTopMainM.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLblTopMainMMouseDragged(evt);
            }
        });
        jLblTopMainM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblTopMainMMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLblTopMainMMousePressed(evt);
            }
        });
        jPnlTop.add(jLblTopMainM, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 30));

        jPnlBackMain.add(jPnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1070, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/GrayCarMainMenupsd.png"))); // NOI18N
        jPnlBackMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, -1, 540));

        jPnlBot.setBackground(new java.awt.Color(62, 62, 62));
        jPnlBot.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLblDateTimeBot.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLblDateTimeBot.setForeground(new java.awt.Color(255, 255, 255));
        jLblDateTimeBot.setText("<Time date :>");
        jLblDateTimeBot.setToolTipText("");
        jPnlBot.add(jLblDateTimeBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 0, 220, 30));

        jLblUsernameName.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLblUsernameName.setForeground(new java.awt.Color(255, 255, 255));
        jLblUsernameName.setText("Welcome : <User>");
        jLblUsernameName.setToolTipText("");
        jPnlBot.add(jLblUsernameName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("You are loged in as : <Username>");
        jPnlBot.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, 410, 30));

        jPnlBackMain.add(jPnlBot, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 550, 1070, 30));

        getContentPane().add(jPnlBackMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        setSize(new java.awt.Dimension(1150, 635));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void executeMenu() {
    //Menu add items and submenus

       //Add pictures for the menu items 
        ImageIcon iconClients = new ImageIcon(getClass().getResource("/menu/group_1.png"));//Picture for clients
        ImageIcon iconService = new ImageIcon(getClass().getResource("/menu/gear.png"));//Picture for Services
        ImageIcon iconUser = new ImageIcon(getClass().getResource("/menu/man.png"));//Picture for user profile management
        ImageIcon iconParts = new ImageIcon(getClass().getResource("/menu/thecnical_wrench.png"));//Picture for add parts
        ImageIcon iconSubMenu = new ImageIcon(getClass().getResource("/menu/subMenu.png"));//Picture of arrow for subenu

        MenuItem menuClientManegement1 = new MenuItem(iconSubMenu, "Client add", new ActionListener() {
           //First menu elemnt for cars and clients management 
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes  client managemement 
                JFrameClientManagement rf = new JFrameClientManagement();//Creates new form  for client management 
                rf.setVisible(true);//Sets the new form for client management to visisble
            }
        });

        MenuItem menuClientManegement2 = new MenuItem(iconSubMenu, "Car add", new ActionListener() {
           //Menu element for adding cars
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes car add new car 
                JFrameClientCars cm = new JFrameClientCars();//Creates new form for adding new car
                cm.setVisible(true);//Sets the form for  car adding to visisble
            }
        });

        MenuItem menuSetting1 = new MenuItem(iconSubMenu, "Add new service", new ActionListener() {
           //Menu element for adding services
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes add new service
                JFrame_Repairs_Maintenance Serv = new JFrame_Repairs_Maintenance();//Creates new form to add new services
                Serv.setVisible(true);//Sets the new for for addign services to visible
            }
        });

        MenuItem menuSetting2 = new MenuItem(iconSubMenu, "Service History ", new ActionListener() {
           //Menu element to check the selected car service history
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes form for car service history
                JFrame_Scrv_Car_History History = new JFrame_Scrv_Car_History();//New form for car service history
                History.setVisible(true);//Set the form for car service history to visible
            }
        });

        MenuItem menuParts1 = new MenuItem(iconSubMenu, "Add parts/items ", new ActionListener() {
           //Menu element to add parts for the repair/service 
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes  add new product 
                JFrame_Add_Product productManage = new JFrame_Add_Product();//Add new product new form
                productManage.setVisible(true);//Add new product form set to visible
            }
        });

        MenuItem menuUsrs1 = new MenuItem(iconSubMenu, "Add new user  ", new ActionListener() {
           //Menu item for adding new user 
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes Register  form
                Register_Form rf = new Register_Form(); // New register form
                rf.setVisible(true);//Set form for add new user to be visible
                rf.pack();
                rf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//Disposes of the register form on close
            }
        });

        MenuItem menuUsrs2 = new MenuItem(iconSubMenu, "Menage account  ", new ActionListener() {
          //Menu element for managing user accaunt
            @Override
            public void actionPerformed(ActionEvent ae) {
               //Initalizes user ACC managememnt 
                JFrame_Acc_Manage_Login cm = new JFrame_Acc_Manage_Login();//User accoutn management 
                cm.setVisible(true);//Sets user account to be visible
            }
        });

        MenuItem menuUsrs3 = new MenuItem(iconSubMenu, "Logout  ", new ActionListener() {
          //Menu element for logout 
            @Override
            public void actionPerformed(ActionEvent ae) {
           //Initalizes logout form
            System.exit(0); 
            }
        });
        
   //Define menu elemnts 

     //menu icon maneu name and menu elements
        MenuItem menuClientManegement = new MenuItem(iconClients, "Client manegement", null, menuClientManegement1, menuClientManegement2);
        MenuItem menuSetting = new MenuItem(iconService, "Services/Repairs", null, menuSetting1, menuSetting2);
        MenuItem menuService = new MenuItem(iconParts, "Parts/Items", null, menuParts1);
        MenuItem menuUsrs = new MenuItem(iconUser, "User management", null, menuUsrs1, menuUsrs2, menuUsrs3);

      //Add menu elements to the menu 
        addMenu(menuClientManegement, menuSetting, menuService, menuUsrs);
    }

    private void addMenu(MenuItem... menu) {
       //Progresive length menu
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }


    private void jLabel_minimizeMainMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMainMMouseClicked
       //Minimizes the form for menu
        this.setState(JFrame_Add_Product.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeMainMMouseClicked

    private void jLabel_minimizeMainMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMainMMouseEntered
     // Minimize client management window mouse entered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_minimizeMainM.setBorder(label_border);
        jLabel_minimizeMainM.setForeground(Color.gray);
        jLabel_minimizeMainM.setOpaque(true);
    }//GEN-LAST:event_jLabel_minimizeMainMMouseEntered

    private void jLabel_minimizeMainMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeMainMMouseExited
       // Minimize client management window mouse exited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimizeMainM.setBorder(label_border);
        jLabel_minimizeMainM.setForeground(Color.white);
        jLabel_minimizeMainM.setOpaque(false);
    }//GEN-LAST:event_jLabel_minimizeMainMMouseExited

    private void jLabel_closeMainMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMainMMouseClicked
       //Shuts down the program
     
        //On exit
        int result;
        //Dialog window 
        result = JOptionPane.showConfirmDialog(this, "Do you really want to exit ?",
                "Exit", 2);
        System.out.println(result);
        // yes -> 0
        // no ->  1
        // cancel  -> 2
        if (result == 0) {   
            try {
            this.finalize();
            System.exit(0);
        } catch (Throwable ex) {
            Logger.getLogger(JFrameClientCars.class.getName()).log(Level.SEVERE, null, ex);
        }
        } else {
            this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }   
    }//GEN-LAST:event_jLabel_closeMainMMouseClicked

    private void jLabel_closeMainMMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMainMMouseEntered
       //Mouse entered close 
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_closeMainM.setBorder(label_border);
        jLabel_closeMainM.setForeground(Color.gray);
        jLabel_closeMainM.setOpaque(true);

    }//GEN-LAST:event_jLabel_closeMainMMouseEntered

    private void jLabel_closeMainMMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeMainMMouseExited
       //Mouse exited close 
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_closeMainM.setBorder(label_border);
        jLabel_closeMainM.setForeground(Color.white);
        jLabel_closeMainM.setOpaque(false);
    }//GEN-LAST:event_jLabel_closeMainMMouseExited

    private void jLblTopMainMMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopMainMMouseDragged
       //Drag functionality for the top bar 
        int coordX = evt.getXOnScreen();
        int coordY = evt.getYOnScreen();
        this.setLocation(coordX - xMouse, coordY - yMouse);

    }//GEN-LAST:event_jLblTopMainMMouseDragged

    private void jLblTopMainMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopMainMMouseClicked
       // 2 Clicks centr Form
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            //System.out.println("double clicked");
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jLblTopMainMMouseClicked

    private void jLblTopMainMMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopMainMMousePressed
       // Gey mouse x y
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLblTopMainMMousePressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       //On exit 
        try {
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(JFrameClientCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jLabel_closeMainMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel_closeMainMKeyTyped
        
    }//GEN-LAST:event_jLabel_closeMainMKeyTyped

    public void clock() {//Method for the clock
       //  Clock 
        Thread clock = new Thread() {//Creates new thread

            public void run() {//Run method

                for (;;) {//Loop for the clock

                    Calendar cal = new GregorianCalendar();
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    jLblDateTimeBot.setText(dtf.format(now));

                    try {
                        sleep(1000);//Timer 1 sec
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Menu_Form.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        clock.start();//Starts the clock
    }
    private void seticon() {
        //Sets form icon
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/wrench.png")));
    }

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Menu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Menu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Menu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Menu_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new Menu_Form().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel_closeMainM;
    private javax.swing.JLabel jLabel_minimizeMainM;
    private javax.swing.JLabel jLblDateTimeBot;
    private javax.swing.JLabel jLblTopMainM;
    private javax.swing.JLabel jLblUsernameName;
    private javax.swing.JPanel jPnlBackMain;
    private javax.swing.JPanel jPnlBot;
    private javax.swing.JPanel jPnlTop;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel menus1;
    private javax.swing.JPanel menus2;
    // End of variables declaration//GEN-END:variables
}