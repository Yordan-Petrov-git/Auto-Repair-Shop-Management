package base.View;

import base.Connection.MyCNX;
import base.LogInAs;
import base.Utils.PasswordUtils.VerifyPassUtil;
import base.Utils.PasswordUtils.PasswordUtils;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 *Form for password change on received email 
 * @author 0896
 */
public class JFrame_Acc_Redeem extends javax.swing.JFrame {
    
  //Coordinats for jform mouse draging
    int xMouse;
    int yMouse;
//Connection to SQL DB
    Connection connct = MyCNX.getConnection();

    /**
     * Creates new form JFrame_Acc_Manage_Login
     */
    public JFrame_Acc_Redeem() { 
        initComponents();
        
         seticon();//Sets icon
         
        //Disables copy pasete functionality 
        jPasswordField_1.setTransferHandler(null);
        jPasswordField_2.setTransferHandler(null);
        jTxtFldPasPhrs.setTransferHandler(null);     
        
        //Centers the form
        this.setLocationRelativeTo(null); 
        
        //Transparent background
        this.setBackground(new Color(0, 0, 0, 0));
        jToggleButton1.setBackground(new Color(0, 0, 0, 0));
        jToggleButton1.setForeground(new Color(0, 0, 0, 0));
        
        //Sets loged in as username
        jLblUstNm.setText("User account name : " + LogInAs.empIdusr);
        
        //Caps lock on off functionality
        jLblCapsLock.setVisible(false);    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlMain = new javax.swing.JPanel();
        jLblCapsLock = new javax.swing.JLabel();
        jBtnChangePasswrd = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jTxtFldPasPhrs = new javax.swing.JTextField();
        jPasswordField_1 = new javax.swing.JPasswordField();
        jPasswordField_2 = new javax.swing.JPasswordField();
        jLblUrrPassConf = new javax.swing.JLabel();
        jLblPassphrs = new javax.swing.JLabel();
        jLblUrrPass = new javax.swing.JLabel();
        jPnlTopRegister = new javax.swing.JPanel();
        jLabel_minimizeAccUP = new javax.swing.JLabel();
        jLabel_closeAccUP = new javax.swing.JLabel();
        jLablTopAccUpd = new javax.swing.JLabel();
        jLblUstNm = new javax.swing.JLabel();
        jLblPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPnlMain.setBackground(new java.awt.Color(0, 84, 140));
        jPnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLblCapsLock.setBackground(new java.awt.Color(102, 102, 102));
        jLblCapsLock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPnlMain.add(jLblCapsLock, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 200, 40));

        jBtnChangePasswrd.setBackground(new java.awt.Color(0, 84, 140));
        jBtnChangePasswrd.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jBtnChangePasswrd.setForeground(new java.awt.Color(255, 255, 255));
        jBtnChangePasswrd.setText("Chage password ");
        jBtnChangePasswrd.setToolTipText("");
        jBtnChangePasswrd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnChangePasswrdActionPerformed(evt);
            }
        });
        jPnlMain.add(jBtnChangePasswrd, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 190, 50));

        jToggleButton1.setBackground(new java.awt.Color(0, 0, 0));
        jToggleButton1.setForeground(new java.awt.Color(0, 0, 0));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        jPnlMain.add(jToggleButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 130, 30, 20));
        jToggleButton1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pass off.png")).getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH)));

        jTxtFldPasPhrs.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFldPasPhrs.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTxtFldPasPhrs.setForeground(new java.awt.Color(255, 255, 255));
        jPnlMain.add(jTxtFldPasPhrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 220, 270, 40));

        jPasswordField_1.setBackground(new java.awt.Color(62, 62, 62));
        jPasswordField_1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPasswordField_1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_1.setToolTipText("Password should be at least 8 charecters Contains upper and lower case letter number and at least one special charecter [ @#$%^&+= ]");
        jPasswordField_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField_1ActionPerformed(evt);
            }
        });
        jPasswordField_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordField_1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField_1KeyTyped(evt);
            }
        });
        jPnlMain.add(jPasswordField_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 270, 40));

        jPasswordField_2.setBackground(new java.awt.Color(62, 62, 62));
        jPasswordField_2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jPasswordField_2.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField_2.setToolTipText("Retype password");
        jPasswordField_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField_2KeyTyped(evt);
            }
        });
        jPnlMain.add(jPasswordField_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 270, 40));

        jLblUrrPassConf.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLblUrrPassConf.setForeground(new java.awt.Color(255, 255, 255));
        jLblUrrPassConf.setText("Confirm Password :");
        jPnlMain.add(jLblUrrPassConf, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 170, 40));

        jLblPassphrs.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLblPassphrs.setForeground(new java.awt.Color(255, 255, 255));
        jLblPassphrs.setText("New Passwprase :");
        jPnlMain.add(jLblPassphrs, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, -1, 40));

        jLblUrrPass.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLblUrrPass.setForeground(new java.awt.Color(255, 255, 255));
        jLblUrrPass.setText(" New Password :");
        jPnlMain.add(jLblUrrPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, -1, 40));

        jPnlTopRegister.setBackground(new java.awt.Color(51, 51, 51));
        jPnlTopRegister.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_minimizeAccUP.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_minimizeAccUP.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_minimizeAccUP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_minimizeAccUP.setText("  -");
        jLabel_minimizeAccUP.setToolTipText("");
        jLabel_minimizeAccUP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_minimizeAccUP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimizeAccUP.setPreferredSize(new java.awt.Dimension(16, 24));
        jLabel_minimizeAccUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeAccUPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeAccUPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeAccUPMouseExited(evt);
            }
        });
        jPnlTopRegister.add(jLabel_minimizeAccUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 30, 30));

        jLabel_closeAccUP.setBackground(new java.awt.Color(255, 0, 51));
        jLabel_closeAccUP.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_closeAccUP.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_closeAccUP.setText("  X");
        jLabel_closeAccUP.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_closeAccUP.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_closeAccUP.setPreferredSize(new java.awt.Dimension(16, 24));
        jLabel_closeAccUP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeAccUPMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeAccUPMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeAccUPMouseExited(evt);
            }
        });
        jPnlTopRegister.add(jLabel_closeAccUP, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 0, 30, 30));

        jLablTopAccUpd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLablTopAccUpdMouseDragged(evt);
            }
        });
        jLablTopAccUpd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLablTopAccUpdMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLablTopAccUpdMousePressed(evt);
            }
        });
        jPnlTopRegister.add(jLablTopAccUpd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 30));

        jPnlMain.add(jPnlTopRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 621, -1));

        jLblUstNm.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLblUstNm.setForeground(new java.awt.Color(255, 255, 255));
        jLblUstNm.setText("User account name : <Username>");
        jPnlMain.add(jLblUstNm, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 310, 50));

        jLblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/AccEditVerMain.png"))); // NOI18N
        jPnlMain.add(jLblPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 600, 310));

        getContentPane().add(jPnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 620, 360));

        setSize(new java.awt.Dimension(625, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jPasswordField_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField_1ActionPerformed
      
    }//GEN-LAST:event_jPasswordField_1ActionPerformed

    private void jPasswordField_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_1KeyPressed

    }//GEN-LAST:event_jPasswordField_1KeyPressed

    private void jPasswordField_1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_1KeyTyped
         //Password lenght filter + caps lock detection
        String pass1 = String.valueOf(jPasswordField_1.getPassword());
        if ((pass1 + evt.getKeyChar()).length() > 64) {
            evt.consume();
        }
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {
            jLblCapsLock.setText("     Caps Lock is ON  !  ");
            jLblCapsLock.setVisible(true);
            jLblCapsLock.setOpaque(true);
        } else {
            jLblCapsLock.setText("");
            jLblCapsLock.setVisible(false);
            jLblCapsLock.setOpaque(false);
        }
    }//GEN-LAST:event_jPasswordField_1KeyTyped

    private void jPasswordField_2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_2KeyTyped
       //Password lenght filter + caps lock detection
        String pass2 = String.valueOf(jPasswordField_2.getPassword());
        if ((pass2 + evt.getKeyChar()).length() > 64) {
            evt.consume();
        }
        //Caps lock detect feature
        if (Toolkit.getDefaultToolkit().getLockingKeyState(KeyEvent.VK_CAPS_LOCK)) {//Caps lock on
            jLblCapsLock.setText("     Caps Lock is ON  !  ");
            jLblCapsLock.setVisible(true);
            jLblCapsLock.setOpaque(true);
        } else {//Caps lock off
            jLblCapsLock.setText("");
            jLblCapsLock.setVisible(false);
            jLblCapsLock.setOpaque(false);
        }
    }//GEN-LAST:event_jPasswordField_2KeyTyped

    private void jLabel_minimizeAccUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeAccUPMouseClicked
       //Minimizes the jform
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeAccUPMouseClicked

    private void jLabel_minimizeAccUPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeAccUPMouseEntered
       // Minimize client management window mouse entered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_minimizeAccUP.setBorder(label_border);
        jLabel_minimizeAccUP.setForeground(Color.gray);
        jLabel_minimizeAccUP.setOpaque(true);
        jLabel_closeAccUP.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_jLabel_minimizeAccUPMouseEntered

    private void jLabel_minimizeAccUPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeAccUPMouseExited
       // Minimize client management window mouse exited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimizeAccUP.setBorder(label_border);
        jLabel_minimizeAccUP.setForeground(Color.white);
        jLabel_minimizeAccUP.setOpaque(false);
    }//GEN-LAST:event_jLabel_minimizeAccUPMouseExited

    private void jLabel_closeAccUPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeAccUPMouseClicked
        //On exit 
        this.dispose();
    }//GEN-LAST:event_jLabel_closeAccUPMouseClicked

    private void jLabel_closeAccUPMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeAccUPMouseEntered
     //  Label close mouse entered  set new color
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_closeAccUP.setBorder(label_border);
        jLabel_closeAccUP.setForeground(Color.gray);
        jLabel_closeAccUP.setOpaque(true);
        jLabel_closeAccUP.setBackground(Color.RED);
    }//GEN-LAST:event_jLabel_closeAccUPMouseEntered

    private void jLabel_closeAccUPMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeAccUPMouseExited
      // Label mouse exited set defaut color
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_closeAccUP.setBorder(label_border);
        jLabel_closeAccUP.setForeground(Color.white);
        jLabel_closeAccUP.setOpaque(false);
    }//GEN-LAST:event_jLabel_closeAccUPMouseExited

    private void jLablTopAccUpdMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLablTopAccUpdMouseDragged
      //Form top bar drag functionality
        int coordX = evt.getXOnScreen();
        int coordY = evt.getYOnScreen();
        this.setLocation(coordX - xMouse, coordY - yMouse);
    }//GEN-LAST:event_jLablTopAccUpdMouseDragged

    private void jLablTopAccUpdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLablTopAccUpdMouseClicked
       // 2 Clicks centr Form
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
           //System.out.println("double clicked");
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jLablTopAccUpdMouseClicked

    private void jLablTopAccUpdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLablTopAccUpdMousePressed
//Gets mouse position 
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLablTopAccUpdMousePressed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
     //Show hide password functionality
        if (jToggleButton1.isSelected()) {//Show password if button is clicked
            //Set button icon
            jToggleButton1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Pass onn.png")).getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH)));
            jPasswordField_1.setEchoChar((char) 0);//Show password symbols
        } else {
            //Resets defaut button icon
            jPasswordField_1.setEchoChar('*');//hide password symbols
            jToggleButton1.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/pass off.png")).getImage().getScaledInstance(25, 30, Image.SCALE_SMOOTH)));
        }
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jBtnChangePasswrdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnChangePasswrdActionPerformed
      //Change password button on password reset with redeem key
        jLblUstNm.setText("User account name : " + LogInAs.empIdusr);//Sets redeem pass for the user
        String salt = PasswordUtils.generateSalt(512).get();//Generates random secure salt
        String password = String.valueOf(jPasswordField_1.getPassword());//Gets string value of the password 
        String key = PasswordUtils.hashPassword(password, salt).get();//Generates hashed and salted password 
        String pasPhr = jTxtFldPasPhrs.getText();//Gets special phrase for added security

        if (verifyFields()) {//Verify that the fields are not empty 
            if (VerifyPassUtil.validation_Password(password)) {//Validates the password

                PreparedStatement ps = null;
                //Query SQL DB
                String registerUserQuery = "UPDATE `users` SET  `password` = ?, `secretKey`  = ?, `salt` = ? WHERE `users`.`username`  = ?;";
                try {
                    //Prepared Statement SQL DB
                    ps = connct.prepareStatement(registerUserQuery);
                    ps.setString(1, key);
                    ps.setString(2, pasPhr);
                    ps.setString(3, salt);
                    ps.setString(4, LogInAs.empIdusr);

                    if (ps.executeUpdate() != 0) {
                        JOptionPane.showMessageDialog(null, "Your Password Has Been Updated");
                        
                     //Load new login form
                        this.dispose();  //Disposes of the acc redeem form
                        Login_Form lf = new Login_Form();//Opens new login form
                        lf.setVisible(true);//Sets login form to visible 
                        lf.pack();
                        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    } else {//Wrong login credentials
                        JOptionPane.showMessageDialog(null, "Error: Check Your Information");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(JFrame_Acc_Redeem.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                }
            } else {//if password is not in  the correct format
                JOptionPane.showMessageDialog(null, "Password not correct format it should be at least 8 charecters Contains upper and lower case letter number and at least one special charecter [ @#$%^&+= ]", "Email error !", 2);
            }
        }//Verify that the fields are not empty 
    }//GEN-LAST:event_jBtnChangePasswrdActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //On exit close thje connection to the SQL DB
        try {
            connct.close();
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(JFrameClientCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    public boolean verifyFields() {
        //Verifi no empty textfields
        String pass1 = String.valueOf(jPasswordField_1.getPassword());
        String pass2 = String.valueOf(jPasswordField_2.getPassword());
        String pasphrase = jTxtFldPasPhrs.getText();
        // check empty fields
        if (pass1.trim().equals("") || pass2.trim().equals("") || pasphrase.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "One Or More Fields Are Empty", "Empty Fields", 2);
            return false;
        } // check if the two password are equals
        else if (!pass1.equals(pass2)) {
            JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Confirm Password", 2);
            return false;
        } // if everything is ok
        else {
            return true;
        }
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
//            java.util.logging.Logger.getLogger(JFrame_Acc_Redeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrame_Acc_Redeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrame_Acc_Redeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrame_Acc_Redeem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new JFrame_Acc_Redeem().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnChangePasswrd;
    private javax.swing.JLabel jLabel_closeAccUP;
    private javax.swing.JLabel jLabel_minimizeAccUP;
    private javax.swing.JLabel jLablTopAccUpd;
    private javax.swing.JLabel jLblCapsLock;
    private javax.swing.JLabel jLblPassphrs;
    private javax.swing.JLabel jLblPic;
    private javax.swing.JLabel jLblUrrPass;
    private javax.swing.JLabel jLblUrrPassConf;
    private javax.swing.JLabel jLblUstNm;
    private javax.swing.JPasswordField jPasswordField_1;
    private javax.swing.JPasswordField jPasswordField_2;
    private javax.swing.JPanel jPnlMain;
    private javax.swing.JPanel jPnlTopRegister;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField jTxtFldPasPhrs;
    // End of variables declaration//GEN-END:variables
}
