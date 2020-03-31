package base.View;

import base.Connection.MyCNX;
import base.Parts_serv;
import base.TableUtils.ResizeForJTables;
import com.model.table.PartsTableModel;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

/**
 * Form for parts and materials entry
 *
 * @author 0896
 */
public class JFrame_Add_Product extends javax.swing.JFrame {
    
   //Coordinats for jform mouse draging
    int xMouse;
    int yMouse;
  //Connection to database
    Connection connct = MyCNX.getConnection();
  //Table Model for products
    PartsTableModel partsTableModel;//
 //SQL Prepared Statement
    private PreparedStatement preparedStatement;
  //Pagination controls
    Integer page = 1;//
    Integer rowCountPerPage = 5;
    Integer totalPage = 1;//
    Integer totalData = 0;//
  //Photo for parts
    String photopath = null;

    /**
     * Creates new form JFrame_Add_Product
     */
    public JFrame_Add_Product() {
        initComponents();

         seticon();//Sets icon
        
        //Disables copy pasete functionality 
        jTxtFld_Origin.setTransferHandler(null);//Part origin
        jTxtFld_Make.setTransferHandler(null);//Part for make
        jTxtFld_Model.setTransferHandler(null);//Part for model
        jTxtFld_PartMake.setTransferHandler(null);//Part make
        jTxtFld_Suplr.setTransferHandler(null);//Part supplier
        jTxtFld_Cst.setTransferHandler(null);//Part cost
        jTxtFld_Cnt.setTransferHandler(null);//Part coutn
        jTxtFld_Weight.setTransferHandler(null);//Part weight
        jTxtFld_VAT.setTransferHandler(null);//Part tax
        jTxtFld_ForSys.setTransferHandler(null);//Part for system
        jTxtArea_Desc.setTransferHandler(null);//Part description

        //Sets background as transparent
        this.setBackground(new Color(0, 0, 0, 0));

        //Add values to combobox for pagination
        jComboBoxPage.addItem("10");
        jComboBoxPage.addItem("20");
        jComboBoxPage.addItem("30");
        jComboBoxPage.addItem("40");
        jComboBoxPage.addItem("50");
        jComboBoxPage.addItem("60");
        jComboBoxPage.addItem("70");
        jComboBoxPage.addItem("80");
        jComboBoxPage.addItem("90");
        jComboBoxPage.addItem("100");

        jComboBoxPage.addItemListener(new ItemListener() {
         // Change data in jtable on combobox change 
            public void itemStateChanged(ItemEvent e) {
                initPagination();//Shows specific amaunt of rows in the jtable on combobox selection
            }
        });
        initPagination();//Shows first paged rows in the jtable 
    }

    private void initPagination() {
    //Initializes Pagination
      // Gets the count of rows for the table
        totalData = count();
       //For testing
        System.out.println(totalData);
       //Sets the row count shown in Jtable form the combobox
        rowCountPerPage = Integer.valueOf(jComboBoxPage.getSelectedItem().toString());
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
        totalPage = totalPageD.intValue();
      //Buttons for paging
       //Buttons First Previous
        if (page.equals(1)) {
            jButtonFirst.setEnabled(false);
            jButtonPrevious.setEnabled(false);
        } else {
            jButtonFirst.setEnabled(true);
            jButtonPrevious.setEnabled(true);
        }
       //Buttons Lasst Next
        if (page.equals(totalPage)) {
            jButtonLast.setEnabled(false);
            jButtonNext.setEnabled(false);
        } else {
            jButtonLast.setEnabled(true);
            jButtonNext.setEnabled(true);
        }

        if (page > totalPage) {
            page = 1;
        }
       //Gets  new instance of table model for pats model
        partsTableModel = new PartsTableModel();
        partsTableModel.setList(findAll(page, rowCountPerPage));
        jTb_Parts.setModel(partsTableModel);//Set table model
       //Page number
        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);
        jLabelTotalData.setText(("Row count " + totalData));//Table rows count 
        //Auto resizes table columns
        ResizeForJTables.autoResizeColumn(jTb_Parts);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPnlTop = new javax.swing.JPanel();
        jLabel_minimizeProduct = new javax.swing.JLabel();
        jLabel_closeProduct = new javax.swing.JLabel();
        jLblTopProduct = new javax.swing.JLabel();
        jPnlMain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButtonLast = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jComboBoxPage = new javax.swing.JComboBox();
        jButtonPrevious = new javax.swing.JButton();
        jButtonFirst = new javax.swing.JButton();
        jLabelStatusHalaman = new javax.swing.JLabel();
        jLabelTotalData = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTb_Parts = new javax.swing.JTable();
        jLbl_Oem_show = new javax.swing.JLabel();
        jLbl_OriginC = new javax.swing.JLabel();
        jLbl_ForMake = new javax.swing.JLabel();
        jLbl_ForMod = new javax.swing.JLabel();
        jLbl_ForNumM = new javax.swing.JLabel();
        jLbl_Splr = new javax.swing.JLabel();
        jLbl_Cost = new javax.swing.JLabel();
        jLbl_Count = new javax.swing.JLabel();
        jLbl_Weight = new javax.swing.JLabel();
        jLbl_Tax = new javax.swing.JLabel();
        jLbl_For_Sys = new javax.swing.JLabel();
        jLbl_Description = new javax.swing.JLabel();
        label_photo = new javax.swing.JLabel();
        jLbl_Srch = new javax.swing.JLabel();
        jLbl_Oem_Now = new javax.swing.JLabel();
        jLblTaxPerc = new javax.swing.JLabel();
        jLblKg = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLblCostItem = new javax.swing.JLabel();
        jTxtFld_Origin = new javax.swing.JTextField();
        jTxtFld_Make = new javax.swing.JTextField();
        jTxtFld_Model = new javax.swing.JTextField();
        jTxtFld_PartMake = new javax.swing.JTextField();
        jTxtFld_Suplr = new javax.swing.JTextField();
        jTxtFld_Cst = new javax.swing.JTextField();
        jTxtFld_Cnt = new javax.swing.JTextField();
        jTxtFld_Weight = new javax.swing.JTextField();
        jTxtFld_VAT = new javax.swing.JTextField();
        jTxtFld_ForSys = new javax.swing.JTextField();
        jCmbBox_SrtOrdr = new javax.swing.JComboBox<>();
        jCmbBox_Search = new javax.swing.JComboBox<>();
        jTxtFld_Srch = new javax.swing.JTextField();
        jBtn_AddNewPart = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jBtn_Del = new javax.swing.JButton();
        jBtn_AddPic = new javax.swing.JButton();
        jBtn_ClerarTbl = new javax.swing.JButton();
        jBtn_B = new javax.swing.JButton();
        jLbl_PicPath = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTxtArea_Desc = new javax.swing.JTextArea();
        jLblPicture = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Products manage");
        setUndecorated(true);
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPnlTop.setBackground(new java.awt.Color(51, 51, 51));
        jPnlTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_minimizeProduct.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_minimizeProduct.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_minimizeProduct.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_minimizeProduct.setText("  -");
        jLabel_minimizeProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_minimizeProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimizeProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeProductMouseExited(evt);
            }
        });
        jPnlTop.add(jLabel_minimizeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 0, 30, 30));

        jLabel_closeProduct.setBackground(new java.awt.Color(255, 0, 51));
        jLabel_closeProduct.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_closeProduct.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_closeProduct.setText("  X");
        jLabel_closeProduct.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_closeProduct.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_closeProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeProductMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeProductMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeProductMouseExited(evt);
            }
        });
        jPnlTop.add(jLabel_closeProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 0, 30, 30));

        jLblTopProduct.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLblTopProductMouseDragged(evt);
            }
        });
        jLblTopProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblTopProductMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLblTopProductMousePressed(evt);
            }
        });
        jPnlTop.add(jLblTopProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, 30));

        getContentPane().add(jPnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1450, -1));

        jPnlMain.setBackground(new java.awt.Color(0, 84, 140));
        jPnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(62, 62, 62));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonLast.setBackground(new java.awt.Color(0, 84, 140));
        jButtonLast.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonLast.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLast.setText("Last");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 90, -1));

        jButtonNext.setBackground(new java.awt.Color(0, 84, 140));
        jButtonNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonNext.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 70, -1));

        jComboBoxPage.setBackground(new java.awt.Color(62, 62, 62));
        jComboBoxPage.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBoxPage.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jComboBoxPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 80, 30));

        jButtonPrevious.setBackground(new java.awt.Color(0, 84, 140));
        jButtonPrevious.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonPrevious.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrevious.setText("Previous");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        jButtonFirst.setBackground(new java.awt.Color(0, 84, 140));
        jButtonFirst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonFirst.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFirst.setText("First");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 90, -1));

        jLabelStatusHalaman.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelStatusHalaman.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jLabelStatusHalaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 240, 40));

        jLabelTotalData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelTotalData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel2.add(jLabelTotalData, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 200, 40));

        jPnlMain.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 710, 1090, 40));

        jTb_Parts.getTableHeader().setResizingAllowed(false);
        jTb_Parts.getTableHeader().setReorderingAllowed(false);
        jTb_Parts.setBackground(new java.awt.Color(62, 62, 62));
        jTb_Parts.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTb_Parts.setForeground(new java.awt.Color(255, 255, 255));
        jTb_Parts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OEM", "Origin", "For Make", "For Model", "Part make", "Supplier", "Cost", "Count", "Weight", "For system", "Description", "VAT", "Date added"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true, true, true, true, true, true, true, true, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTb_Parts.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTb_Parts.setSelectionForeground(new java.awt.Color(204, 204, 204));
        jTb_Parts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTb_PartsMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jTb_PartsMouseReleased(evt);
            }
        });
        jTb_Parts.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTb_PartsKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTb_Parts);

        jPnlMain.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 60, 1090, 650));

        jLbl_Oem_show.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Oem_show.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Oem_show.setText("OEM :");
        jPnlMain.add(jLbl_Oem_show, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 48, -1));

        jLbl_OriginC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_OriginC.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_OriginC.setText("Origin country :");
        jPnlMain.add(jLbl_OriginC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 110, -1));

        jLbl_ForMake.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_ForMake.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_ForMake.setText("For make :");
        jPnlMain.add(jLbl_ForMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 101, -1));

        jLbl_ForMod.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_ForMod.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_ForMod.setText("For model :");
        jPnlMain.add(jLbl_ForMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 101, -1));

        jLbl_ForNumM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_ForNumM.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_ForNumM.setText("Part  make :");
        jPnlMain.add(jLbl_ForNumM, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 120, -1));

        jLbl_Splr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Splr.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Splr.setText("Supplier :");
        jPnlMain.add(jLbl_Splr, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 101, -1));

        jLbl_Cost.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Cost.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Cost.setText("Cost :");
        jPnlMain.add(jLbl_Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 101, -1));

        jLbl_Count.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Count.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Count.setText("Count : ");
        jPnlMain.add(jLbl_Count, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 101, -1));

        jLbl_Weight.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Weight.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Weight.setText("Weight :");
        jPnlMain.add(jLbl_Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 101, -1));

        jLbl_Tax.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Tax.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Tax.setText("Tax :");
        jLbl_Tax.setToolTipText("");
        jPnlMain.add(jLbl_Tax, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 101, 20));

        jLbl_For_Sys.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_For_Sys.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_For_Sys.setText("For sysyem :");
        jPnlMain.add(jLbl_For_Sys, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 101, -1));

        jLbl_Description.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Description.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Description.setText("Description :");
        jPnlMain.add(jLbl_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 101, -1));

        label_photo.setBackground(new java.awt.Color(51, 153, 255));
        label_photo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        label_photo.setForeground(new java.awt.Color(51, 153, 255));
        label_photo.setToolTipText("");
        label_photo.setOpaque(true);
        jPnlMain.add(label_photo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 110, 100));
        label_photo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No Camera.png")).getImage().getScaledInstance(101, 91, Image.SCALE_SMOOTH)));

        jLbl_Srch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_Srch.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Srch.setText("Search by:");
        jPnlMain.add(jLbl_Srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, -1, -1));

        jLbl_Oem_Now.setBackground(new java.awt.Color(51, 153, 255));
        jLbl_Oem_Now.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLbl_Oem_Now.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_Oem_Now.setOpaque(true);
        jPnlMain.add(jLbl_Oem_Now, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 50, 148, 22));

        jLblTaxPerc.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLblTaxPerc.setForeground(new java.awt.Color(255, 255, 255));
        jLblTaxPerc.setText("%");
        jPnlMain.add(jLblTaxPerc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, -1, -1));

        jLblKg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLblKg.setForeground(new java.awt.Color(255, 255, 255));
        jLblKg.setText("kg");
        jPnlMain.add(jLblKg, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, -1, 30));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Items");
        jPnlMain.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 310, -1, 30));

        jLblCostItem.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLblCostItem.setForeground(new java.awt.Color(255, 255, 255));
        jLblCostItem.setText("BGN");
        jPnlMain.add(jLblCostItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, 20));

        jTxtFld_Origin.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Origin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Origin.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Origin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFld_OriginActionPerformed(evt);
            }
        });
        jTxtFld_Origin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_OriginKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Origin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 148, 30));

        jTxtFld_Make.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Make.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Make.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Make.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFld_MakeActionPerformed(evt);
            }
        });
        jTxtFld_Make.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_MakeKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Make, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 148, 30));

        jTxtFld_Model.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Model.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Model.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Model.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ModelKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Model, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 148, 30));

        jTxtFld_PartMake.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_PartMake.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_PartMake.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_PartMake.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_PartMakeKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_PartMake, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 148, 30));

        jTxtFld_Suplr.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Suplr.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Suplr.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Suplr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_SuplrKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Suplr, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 240, 148, 30));

        jTxtFld_Cst.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Cst.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Cst.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Cst.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_CstKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Cst, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 90, -1));

        jTxtFld_Cnt.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Cnt.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Cnt.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Cnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_CntKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Cnt, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 90, -1));

        jTxtFld_Weight.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Weight.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Weight.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Weight.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_WeightKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Weight, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 90, -1));

        jTxtFld_VAT.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_VAT.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_VAT.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_VAT.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtFld_VATKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_VATKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_VAT, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 90, -1));

        jTxtFld_ForSys.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ForSys.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ForSys.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ForSys.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ForSysKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_ForSys, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 400, 148, -1));

        jCmbBox_SrtOrdr.setBackground(new java.awt.Color(62, 62, 62));
        jCmbBox_SrtOrdr.setForeground(new java.awt.Color(255, 255, 255));
        jCmbBox_SrtOrdr.setMaximumRowCount(2);
        jCmbBox_SrtOrdr.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ascending", "Descending" }));
        jPnlMain.add(jCmbBox_SrtOrdr, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 100, -1));

        jCmbBox_Search.setBackground(new java.awt.Color(62, 62, 62));
        jCmbBox_Search.setForeground(new java.awt.Color(255, 255, 255));
        jCmbBox_Search.setMaximumRowCount(11);
        jCmbBox_Search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OEM number    ", "Origin country                           ", "For make              ", "For model              ", "Part num make         ", "Supplier      ", "Cost  ", "Count      ", "Weight         ", "For system  ", "Date added  " }));
        jCmbBox_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmbBox_SearchActionPerformed(evt);
            }
        });
        jPnlMain.add(jCmbBox_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 570, 120, -1));

        jTxtFld_Srch.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_Srch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_Srch.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_Srch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTxtFld_SrchFocusLost(evt);
            }
        });
        jTxtFld_Srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtFld_SrchKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_SrchKeyTyped(evt);
            }
        });
        jPnlMain.add(jTxtFld_Srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 600, 250, -1));

        jBtn_AddNewPart.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_AddNewPart.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBtn_AddNewPart.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_AddNewPart.setText("Add  part");
        jBtn_AddNewPart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AddNewPartActionPerformed(evt);
            }
        });
        jPnlMain.add(jBtn_AddNewPart, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 630, 120, -1));

        jButton_update.setBackground(new java.awt.Color(0, 84, 140));
        jButton_update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton_update.setForeground(new java.awt.Color(255, 255, 255));
        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        jPnlMain.add(jButton_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 630, -1, -1));

        jBtn_Del.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_Del.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBtn_Del.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Del.setText("Delete");
        jBtn_Del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_DelActionPerformed(evt);
            }
        });
        jPnlMain.add(jBtn_Del, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 630, -1, -1));

        jBtn_AddPic.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_AddPic.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBtn_AddPic.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_AddPic.setText("Add picture");
        jBtn_AddPic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_AddPicActionPerformed(evt);
            }
        });
        jPnlMain.add(jBtn_AddPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 670, -1, -1));

        jBtn_ClerarTbl.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_ClerarTbl.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBtn_ClerarTbl.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_ClerarTbl.setText("Clear ");
        jBtn_ClerarTbl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_ClerarTblActionPerformed(evt);
            }
        });
        jPnlMain.add(jBtn_ClerarTbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 740, 110, -1));

        jBtn_B.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_B.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jBtn_B.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_B.setText("Back");
        jBtn_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_BActionPerformed(evt);
            }
        });
        jPnlMain.add(jBtn_B, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 740, -1, -1));

        jLbl_PicPath.setBackground(new java.awt.Color(51, 153, 255));
        jLbl_PicPath.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLbl_PicPath.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_PicPath.setToolTipText("");
        jLbl_PicPath.setOpaque(true);
        jPnlMain.add(jLbl_PicPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 710, 280, 30));

        jTxtArea_Desc.setBackground(new java.awt.Color(62, 62, 62));
        jTxtArea_Desc.setColumns(20);
        jTxtArea_Desc.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtArea_Desc.setForeground(new java.awt.Color(255, 255, 255));
        jTxtArea_Desc.setRows(5);
        jTxtArea_Desc.setBorder(null);
        jTxtArea_Desc.setCaretColor(new java.awt.Color(51, 51, 51));
        jTxtArea_Desc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jTxtArea_Desc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtArea_DescKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(jTxtArea_Desc);

        jPnlMain.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 430, 148, 110));

        jLblPicture.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLblPicture.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Parts.png"))); // NOI18N
        jPnlMain.add(jLblPicture, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 1440, -1));

        getContentPane().add(jPnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 790));

        setSize(new java.awt.Dimension(1488, 837));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtFld_OriginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFld_OriginActionPerformed
        
    }//GEN-LAST:event_jTxtFld_OriginActionPerformed


    private void jBtn_AddNewPartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AddNewPartActionPerformed
       //Button add Data entry in SQL DB insert 

        // Input dialog for new OEM part number
        String oem = JOptionPane.showInputDialog(this, " Enter new OEM : ", "").trim();

        if ("".trim().equals(oem)) {// if OEM is empty
            JOptionPane.showMessageDialog(this, "No OEM number entered !", " No data entered ! ", 2);
            return;
        }
        if (!checkOemExists(oem)) {// if oem num exists

            try {//if fields are entered correctly

                //SQL Prepared Statement
                PreparedStatement ps = connct.prepareStatement("INSERT INTO new_parts"
                        + "(parts_OEM_Num,parts_Origin_c,parts_For_Make,"
                        + "parts_For_Model,parts_Part_Make,parts_Supplier,"
                        + "parts_Cost,parts_Count,parts_For_Weight,"
                        + "parts_For_System,parts_Description,parts_Picture,parts_VAT,parts_DateTime)"
                        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) LIMIT 1");
                ps.setString(1, oem); //oem key
                ps.setString(2, jTxtFld_Origin.getText());
                ps.setString(3, jTxtFld_Make.getText());
                ps.setString(4, jTxtFld_Model.getText());
                ps.setString(5, jTxtFld_PartMake.getText());
                ps.setString(6, jTxtFld_Suplr.getText());
                ps.setString(7, jTxtFld_Cst.getText());
                ps.setString(8, jTxtFld_Cnt.getText());
                ps.setString(9, jTxtFld_Weight.getText());
                ps.setString(10, jTxtFld_ForSys.getText());
                ps.setString(11, jTxtArea_Desc.getText());
                ps.setString(13, jTxtFld_VAT.getText());
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                LocalDateTime now = LocalDateTime.now();
                ps.setString(14, dtf.format(now)); //timestamp
                try {
                    // If  picture is selected
                    if (photopath != null) {

                        InputStream image = new FileInputStream(new File(photopath));
                        ps.setBlob(12, image);

                    } else {
                        // If no picture is selected
                        ps.setNull(12, java.sql.Types.NULL);

                    }

                } catch (FileNotFoundException ex) {//If picture is selected 
                    Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
                }

                int res = ps.executeUpdate();

                initPagination();

                if (res >= 1) {//succes
                    JOptionPane.showMessageDialog(null, res + " Number of Parts "
                            + " inserted into database ..... ");
                } else {//fail
                    JOptionPane.showMessageDialog(null, " New Part  Data entry  Failed ... ! ");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            } finally {
                //Clears all text fields and shown pics in jlabel 
                clear();
            }
        }// if oem num exists

    }//GEN-LAST:event_jBtn_AddNewPartActionPerformed

    private void jTxtFld_MakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFld_MakeActionPerformed

    }//GEN-LAST:event_jTxtFld_MakeActionPerformed

    private void jBtn_DelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_DelActionPerformed
        //Delete button
        //Checks if rows are present and if OEM number of aprt is present 
        if (jTb_Parts.getRowCount() != 0 && jLbl_Oem_Now.getText().trim() != "".trim()) {

            int result;
            //Dialog window to confirm delete operation
            result = JOptionPane.showConfirmDialog(this, "Are you sure you really want to delete part with OEM number  " + jLbl_Oem_Now.getText(),
                    " Delete operation ! ", 1);
            System.out.println(result);
            // yes -> 0
            // no ->  1
            // cancel  -> 2
            if (result == 0) {// if yes is selected

                try {

                    String dell;
                    // Delete confirm with typing DELETE !
                    dell = JOptionPane.showInputDialog(this, "Type DELETE if you want to erase record for part  : ", "");
                    //Checks if DELETE is entered and OEM number is not null
                    if ("DELETE".equals(dell) && jLbl_Oem_Now.getText().trim() != "".trim()) { // check if input iz null

                        //Deletes selected row 
                        String del = jLbl_Oem_Now.getText();
                        String query = "DELETE FROM `new_parts` WHERE `new_parts`.`parts_OEM_Num` like '%" + del + "%' LIMIT 1";
                        executeSQlQuery(query, "Deleted");//method for query
                    } else {// no input oem check if empty 
                        JOptionPane.showMessageDialog(null, " This OEM number Not deleted !   ", " Deletion  ", 2);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JFrame_Add_Product.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    //Clears all textfields
                    clear();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, " No data selected for deletion ! ", " Select data to be deleted !  ", 2);
        }
    }//GEN-LAST:event_jBtn_DelActionPerformed

    private void jTb_PartsKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTb_PartsKeyReleased
       //Key press events 
        //Table navifgation with arrow up and down keys
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
        //Get selectd row from table to text fields 
            showItemToFields();
        }
         //Delete key 
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {//Del data from table row 
         //Checks if rows are present and if OEM number of aprt is present 
        if (jTb_Parts.getRowCount() != 0 && jLbl_Oem_Now.getText().trim() != "".trim()) {

            int result;
            //Dialog window to confirm delete operation
            result = JOptionPane.showConfirmDialog(this, "Are you sure you really want to delete part with OEM number  " + jLbl_Oem_Now.getText(),
                    " Delete operation ! ", 1);
            System.out.println(result);
            // yes -> 0
            // no ->  1
            // cancel  -> 2
            if (result == 0) {// if yes is selected

                try {

                    String dell;
                    // Delete confirm with typing DELETE !
                    dell = JOptionPane.showInputDialog(this, "Type DELETE if you want to erase record for part  : ", "");
                    //Checks if DELETE is entered and OEM number is not null
                    if ("DELETE".equals(dell) && jLbl_Oem_Now.getText().trim() != "".trim()) { // check if input iz null

                        //Deletes selected row 
                        String del = jLbl_Oem_Now.getText();
                        String query = "DELETE FROM `new_parts` WHERE `new_parts`.`parts_OEM_Num` like '%" + del + "%' LIMIT 1";
                        executeSQlQuery(query, "Deleted");//method for query
                    } else {// no input oem check if empty 
                        JOptionPane.showMessageDialog(null, " This OEM number Not deleted !   ", " Deletion  ", 2);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(JFrame_Add_Product.class.getName()).log(Level.SEVERE, null, ex);
                } finally {
                    //Clears all textfields
                    clear();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, " No data selected for deletion ! ", " Select data to be deleted !  ", 2);
        }
        }
    }//GEN-LAST:event_jTb_PartsKeyReleased

    private void jTb_PartsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTb_PartsMouseClicked
      //
        showItemToFields();

    }//GEN-LAST:event_jTb_PartsMouseClicked

    private void jBtn_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_BActionPerformed
       //Back button  disposes of add pdroduct form
        this.dispose();
    }//GEN-LAST:event_jBtn_BActionPerformed

    private void jBtn_ClerarTblActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_ClerarTblActionPerformed
       //Clear textfelds
        clear();
    }//GEN-LAST:event_jBtn_ClerarTblActionPerformed

    private void jBtn_AddPicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_AddPicActionPerformed
       //Button Select photo 
        JFileChooser chooser = new JFileChooser();//File choser
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));//Opens home directory in current user 
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("*.images", "jpg", "png");//file extention filter
        chooser.addChoosableFileFilter(fnef);//Sets the filter
        int ans = chooser.showSaveDialog(null);
        if (ans == JFileChooser.APPROVE_OPTION) {//if image chosen closes with yes
            File selectedPhoto = chooser.getSelectedFile();
            String path = selectedPhoto.getAbsolutePath();// sets chosen file's path
            if (MaxSizeImage(path)) {//Limit image size to 5.5 mb
                jLbl_PicPath.setText(path);//Sets label's text to selected iamge path
                label_photo.setIcon(resetImageSize(path, null));//Resizes selected iamge to fit in jlabel
                this.photopath = path;
            } else {//if photo is larger 
                System.out.println("Photo larger than 5.5 mb");
                JOptionPane.showMessageDialog(null, "Photo larger than 5.5 mb please select different photo", "Selected photo size is too large", 2);
            }
        } else {//Image choser exited or closed
            System.out.println("Photo Not Selected ");
        }
    }//GEN-LAST:event_jBtn_AddPicActionPerformed

    private void jTxtFld_SrchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_SrchKeyReleased
       //Search from SQL with pagination
        search();
    }//GEN-LAST:event_jTxtFld_SrchKeyReleased

    private void jLabel_minimizeProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeProductMouseClicked
       //Minimize
        this.setState(JFrame_Add_Product.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeProductMouseClicked

    private void jLabel_minimizeProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeProductMouseEntered
       //Minimize mouse entered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_minimizeProduct.setBorder(label_border);
        jLabel_minimizeProduct.setForeground(Color.gray);
        jLabel_minimizeProduct.setOpaque(true);
        jLabel_closeProduct.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_jLabel_minimizeProductMouseEntered

    private void jLabel_minimizeProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeProductMouseExited
       // Minimize client management window mouse exited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimizeProduct.setBorder(label_border);
        jLabel_minimizeProduct.setForeground(Color.white);
        jLabel_minimizeProduct.setOpaque(false);
    }//GEN-LAST:event_jLabel_minimizeProductMouseExited

    private void jLabel_closeProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeProductMouseClicked
       //On exit dispose  of the form for adding products
        this.dispose();
    }//GEN-LAST:event_jLabel_closeProductMouseClicked

    private void jLabel_closeProductMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeProductMouseEntered
        //Lable close mouse mouse entered set new color
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_closeProduct.setBorder(label_border);
        jLabel_closeProduct.setForeground(Color.gray);
        jLabel_closeProduct.setOpaque(true);
        jLabel_closeProduct.setBackground(Color.RED);


    }//GEN-LAST:event_jLabel_closeProductMouseEntered

    private void jLabel_closeProductMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeProductMouseExited
      //Lable close mouse exited reset to defaut color
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_closeProduct.setBorder(label_border);
        jLabel_closeProduct.setForeground(Color.white);
        jLabel_closeProduct.setOpaque(false);
    }//GEN-LAST:event_jLabel_closeProductMouseExited

    private void jTb_PartsMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTb_PartsMouseReleased

    }//GEN-LAST:event_jTb_PartsMouseReleased

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased

    }//GEN-LAST:event_formMouseReleased

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
      //Button Update for ADD Parts 
        if (jTb_Parts.getRowCount() != 0 && jLbl_Oem_Now.getText().trim() != "".trim()) {//IF no data selected
            int result;
            result = JOptionPane.showConfirmDialog(this, "Are you sure you really want to Update part with OEM number  " + jLbl_Oem_Now.getText(),
                    " Update operation ! ", 1);
            System.out.println(result);
            // yes -> 0
            // no ->  1
            // cancel  -> 2
            if (result == 0) {//If yes is selected on dialog window

                if (photopath != null) {//Update in case no photo is selected
                    try {
                        InputStream image = new FileInputStream(new File(photopath));
                        String qry = null;
                        PreparedStatement ps = null;
                        //SQL Query
                        qry = "UPDATE new_parts SET"
                                + " parts_Picture=?,parts_Origin_c=?,parts_For_Make=?"
                                + ",parts_For_Model=?,parts_Part_Make=?,parts_Supplier=?"
                                + ",parts_Cost=?,parts_Count=?,parts_For_Weight=?"
                                + ",parts_For_System=?,parts_Description=?,parts_VAT=?"
                                + ",parts_LastMod_DateT=? "
                                + "WHERE `new_parts`.`parts_OEM_Num` like ? LIMIT 1";
                        ps = connct.prepareStatement(qry);
                        ps.setBlob(1, image);//Picture
                        ps.setString(2, jTxtFld_Origin.getText());//Part origin
                        ps.setString(3, jTxtFld_Make.getText());//For make  
                        ps.setString(4, jTxtFld_Model.getText());//For model
                        ps.setString(5, jTxtFld_PartMake.getText());//Part make
                        ps.setString(6, jTxtFld_Suplr.getText());//Supplier
                        ps.setString(7, jTxtFld_Cst.getText());//Cost
                        ps.setString(8, jTxtFld_Cnt.getText());//Count
                        ps.setString(9, jTxtFld_Weight.getText());//Weight
                        ps.setString(10, jTxtFld_ForSys.getText());//For system
                        ps.setString(11, jTxtArea_Desc.getText());//Description
                        ps.setString(12, jTxtFld_VAT.getText());//Tax
                        //Gets current local date time for tiemstamp on update
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        ps.setString(13, dtf.format(now)); //timestamp
                        ps.setString(14, jLbl_Oem_Now.getText());//OEM
                        int res = ps.executeUpdate();
                        initPagination();//Update table with paging
                        if (res >= 1) {
                            JOptionPane.showMessageDialog(null, res + " Part"
                                    + " Updated into database ..... ");
                        } else {
                            JOptionPane.showMessageDialog(null, " Parts Updae Failed .... ");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {
                        //Clears photo in the label and pgoto path to directory
                        label_photo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No Camera.png")).getImage().getScaledInstance(101, 91, Image.SCALE_SMOOTH)));
                        photopath = null;
                        jLbl_PicPath.setText(null);
                    }

                } else {//Update in case  photo is selected
                    try {
                        String qry = null;
                        PreparedStatement ps = null;
                        qry = "UPDATE new_parts SET"
                                + " parts_Origin_c=?,parts_For_Make=?"
                                + ",parts_For_Model=?,parts_Part_Make=?,parts_Supplier=?"
                                + ",parts_Cost=?,parts_Count=?,parts_For_Weight=?"
                                + ",parts_For_System=?,parts_Description=?,parts_VAT=?"
                                + ",parts_LastMod_DateT=? "
                                + "WHERE `new_parts`.`parts_OEM_Num` like ? LIMIT 1";
                        ps = connct.prepareStatement(qry);
                        ps.setString(1, jTxtFld_Origin.getText());//Part origin
                        ps.setString(2, jTxtFld_Make.getText());//For make
                        ps.setString(3, jTxtFld_Model.getText());//For model
                        ps.setString(4, jTxtFld_PartMake.getText());//Part make
                        ps.setString(5, jTxtFld_Suplr.getText());//Supplier
                        ps.setString(6, jTxtFld_Cst.getText());//Cost
                        ps.setString(7, jTxtFld_Cnt.getText());//Count
                        ps.setString(8, jTxtFld_Weight.getText());//Weight
                        ps.setString(9, jTxtFld_ForSys.getText());//For system
                        ps.setString(10, jTxtArea_Desc.getText());//Description
                        ps.setString(11, jTxtFld_VAT.getText());//Tax
                        //Gets current local date time for tiemstamp on update
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                        LocalDateTime now = LocalDateTime.now();
                        ps.setString(12, dtf.format(now)); //timestamp
                        ps.setString(13, jLbl_Oem_Now.getText());//OEM
                        int res = ps.executeUpdate();
                        initPagination();//Update table with paging
                        if (res >= 1) {
                            JOptionPane.showMessageDialog(null, res + " Part"
                                    + " Updated into database ..... ");
                        } else {
                            JOptionPane.showMessageDialog(null, " Parts Update Failed .... ");
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    } finally {
                        //Clears photo in the label and pgoto path to directory
                        label_photo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No Camera.png")).getImage().getScaledInstance(101, 91, Image.SCALE_SMOOTH)));
                        photopath = null;
                        jLbl_PicPath.setText(null);
                    }
                }
            }//If yes si selected on dialog window
        } else {//IF no data selected
            JOptionPane.showMessageDialog(null, " No data selected for update ! ", " Select data to be updated !  ", 2);
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jTxtFld_SrchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTxtFld_SrchFocusLost
        //Clears serch field on search field focus lost
        //Clears search textfield
        jTxtFld_Srch.setText("");
        //Reset table rows
        initPagination();
        //Clears textfields
        clear();
    }//GEN-LAST:event_jTxtFld_SrchFocusLost

    private void jTxtFld_OriginKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_OriginKeyTyped
       //Filter for  part origin cahrecter only letters and charecter's length 
        if (!Character.isAlphabetic(evt.getKeyChar()) && (jTxtFld_Origin.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_Origin.getText().contains("TABLE")) {
            evt.consume();
        }

    }//GEN-LAST:event_jTxtFld_OriginKeyTyped

    private void jTxtFld_MakeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_MakeKeyTyped
       // Filter for part make cahr length
        if ((jTxtFld_Make.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_Make.getText().contains("TABLE")) {
            evt.consume();
        }

    }//GEN-LAST:event_jTxtFld_MakeKeyTyped

    private void jTxtFld_ModelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ModelKeyTyped
       //Filter for part model cahr length
        if ((jTxtFld_Model.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_Model.getText().contains("TABLE")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ModelKeyTyped

    private void jTxtFld_PartMakeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_PartMakeKeyTyped
       //Filter for part make cahr length
        if ((jTxtFld_PartMake.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_PartMake.getText().contains("TABLE")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_PartMakeKeyTyped

    private void jTxtFld_SuplrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_SuplrKeyTyped
       //Filter for supplier cahr length
        if ((jTxtFld_Suplr.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_Suplr.getText().contains("TABLE")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_SuplrKeyTyped

    private void jTxtFld_CstKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_CstKeyTyped
        //Filter for cost cahr length
         if (!Character.isDigit(evt.getKeyChar()) || (jTxtFld_Cst.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_CstKeyTyped

    private void jTxtFld_CntKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_CntKeyTyped
      //Filter for part count cahr length
          if (!Character.isDigit(evt.getKeyChar()) || (jTxtFld_Cnt.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_CntKeyTyped

    private void jTxtFld_WeightKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_WeightKeyTyped
        //Filter for parts weight cahr length
        if (!Character.isDigit(evt.getKeyChar()) || (jTxtFld_Weight.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_WeightKeyTyped

    private void jTxtFld_ForSysKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ForSysKeyTyped
       //Filter for parts system cahr length
        if ((jTxtFld_ForSys.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_ForSys.getText().contains("TABLE")) {
            evt.consume();
        }

    }//GEN-LAST:event_jTxtFld_ForSysKeyTyped

    private void jTxtArea_DescKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtArea_DescKeyTyped
       //Filter for parts description cahr length
        if ((jTxtArea_Desc.getText() + evt.getKeyChar()).length() > 512 || jTxtArea_Desc.getText().contains("TABLE")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtArea_DescKeyTyped

    private void jTxtFld_VATKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_VATKeyTyped
        //Filter for tax cahr length 
    if (!Character.isDigit(evt.getKeyChar()) || (jTxtFld_VAT.getText() + evt.getKeyChar()).length() > 3) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_VATKeyTyped

    private void jTxtFld_SrchKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_SrchKeyTyped
        //Filter for search char length 
        if ((jTxtFld_Srch.getText() + evt.getKeyChar()).length() > 32 || jTxtFld_Srch.getText().contains("TABLE")) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_SrchKeyTyped

    private void jCmbBox_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmbBox_SearchActionPerformed

    }//GEN-LAST:event_jCmbBox_SearchActionPerformed

    private void jLblTopProductMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopProductMouseDragged
        //Feature for top bar form draging
        int coordX = evt.getXOnScreen();
        int coordY = evt.getYOnScreen();
        this.setLocation(coordX - xMouse, coordY - yMouse);
    }//GEN-LAST:event_jLblTopProductMouseDragged

    private void jLblTopProductMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopProductMousePressed
        //Gets mouse cursor x y coordintas
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLblTopProductMousePressed

    private void jLblTopProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopProductMouseClicked
        // 2 Clicks centr Form
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            //System.out.println("double clicked");
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jLblTopProductMouseClicked

    private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
        //Button last page
        page = totalPage;
        initPagination();//Update jtable's rows
    }//GEN-LAST:event_jButtonLastActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        // Button next page
        if (page < totalPage) {
            page++;//Increments page counter
            initPagination();//Update jtable's rows
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        //Button previous 
        if (page > 1) {
            page--;//Decrements page counter
            initPagination();//Update jtable's rows
        }
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
        //Button first
        page = 1;//Set page to first
        initPagination();//Update jtable's rows
    }//GEN-LAST:event_jButtonFirstActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //On add product form exit clsoes the connection with SQL DB
        try {
            connct.close();// Closes the connection with SQL DB
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(JFrameClientCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTxtFld_VATKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_VATKeyReleased
       //%filter
          String str = jTxtFld_VAT.getText();
        if (!"".trim().equals(str)){
        int num = Integer.parseInt(str.trim());
        if (num > 100) {
          jTxtFld_VAT.setText("100");
        } 
        }
    }//GEN-LAST:event_jTxtFld_VATKeyReleased

    public void executeSQlQuery(String query, String message) throws SQLException {
        // Execute The Insert Update And Delete Querys
        Statement st;
        try {
            st = connct.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                initPagination();//Update jtable rows with paging
                //On success
                JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
            } else {//On fail
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
        }
    }

    public ImageIcon resetImageSize(String photopath, byte[] photo) {
        //Resizes photo in jlabel
        ImageIcon myPhoto = null;
        if (photopath != null) {
            myPhoto = new ImageIcon(photopath);
        } else {
            myPhoto = new ImageIcon(photo);
        }
        Image img = myPhoto.getImage();
        Image img1 = img.getScaledInstance(label_photo.getWidth(), label_photo.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ph = new ImageIcon(img1);
        return ph;
    }

    public boolean MaxSizeImage(String imagePath) {
        //Limits iamge size
        boolean temp = false;
        File file = new File(imagePath);
        long length = file.length();

        if (length < 5500000) //limits iamge size to  5.5 mb
        {
            temp = true;
        }

        return temp;
    }

    public boolean checkOemExists(String PartOEM) {
       //Checks if OEM number alredy exists
        PreparedStatement st;
        ResultSet rs;
        boolean part_OEMnum_Exists = false;
        //SQL Query 
        String query = "SELECT * FROM `new_parts` WHERE `new_parts`.`parts_OEM_Num` = ? ";

        try {
            st = connct.prepareStatement(query);
            st.setString(1, PartOEM);
            rs = st.executeQuery();
            if (rs.next()) {
                part_OEMnum_Exists = true;
                JOptionPane.showMessageDialog(null, " This OEM number is Already registered, Choose Another One ", " OEM duplicate ", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }
        return part_OEMnum_Exists;
    }

    public void showItemToFields() {
       // Gets and displays all items from jtable to textfields also diplays picture in label
        TableModel model = jTb_Parts.getModel();
        // Gets index at selected row for jtable
        int index = jTb_Parts.getSelectedRow();
        // Display Slected Row In JTexteFields
        jLbl_Oem_Now.setText(model.getValueAt(index, 1).toString());
        jTxtFld_Origin.setText(model.getValueAt(index, 2).toString());
        jTxtFld_Make.setText(model.getValueAt(index, 3).toString());
        jTxtFld_Model.setText(model.getValueAt(index, 4).toString());
        jTxtFld_PartMake.setText(model.getValueAt(index, 5).toString());
        jTxtFld_Suplr.setText(model.getValueAt(index, 6).toString());
        jTxtFld_Cst.setText(model.getValueAt(index, 7).toString());
        jTxtFld_Cnt.setText(model.getValueAt(index, 8).toString());
        jTxtFld_Weight.setText(model.getValueAt(index, 9).toString());
        jTxtFld_ForSys.setText(model.getValueAt(index, 10).toString());
        jTxtArea_Desc.setText(model.getValueAt(index, 11).toString());
        jTxtFld_VAT.setText(model.getValueAt(index, 12).toString());

        try {
           //Gets and diplays picture if present in SQL DB   
            Statement st = connct.createStatement();
            ResultSet rs = st.executeQuery("select * from new_parts where parts_OEM_Num = '" + jLbl_Oem_Now.getText() + "'");
            if (rs.next()) {
                byte[] img = rs.getBytes("parts_Picture");
               //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(label_photo.getWidth(), label_photo.getHeight(), Image.SCALE_SMOOTH);
               //Scales image to fit in the label
                ImageIcon newImage = new ImageIcon(myImg);
               //Sets selacted scaled iamge to label
                label_photo.setIcon(newImage);
            } else {
               //if no iamge is null in SQL DB then sets  no picture image
                label_photo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No Camera.png")).getImage().getScaledInstance(101, 91, Image.SCALE_SMOOTH)));
            }
        } catch (Exception ex) {
            // ex.printStackTrace();
           //Gets defaut picture if no picture present
            label_photo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No Camera.png")).getImage().getScaledInstance(101, 91, Image.SCALE_SMOOTH)));
        } finally {

        }
    }

    public void clear() {
        // Clears all textfields , sets defaut photo in label and removes selected  iamge
        photopath = null;
        label_photo.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/No Camera.png")).getImage().getScaledInstance(101, 91, Image.SCALE_SMOOTH)));
        jLbl_PicPath.setText(null);
        jLbl_Oem_Now.setText("");
        jTxtFld_Origin.setText("");
        jTxtFld_Make.setText("");
        jTxtFld_Model.setText("");
        jTxtFld_PartMake.setText("");
        jTxtFld_Suplr.setText("");
        jTxtFld_Cst.setText("");
        jTxtFld_Cnt.setText("");
        jTxtFld_Weight.setText("");
        jTxtFld_ForSys.setText("");
        jTxtArea_Desc.setText("");
        jTxtFld_VAT.setText("");
    }

    public List<Parts_serv> findAll(int page, int pageSize) {
        //Gets all the rows in a jtable 
        List<Parts_serv> listProduct = new ArrayList<Parts_serv>();

        if (count() == 0) {
            return listProduct;
        }

        try {
            connct.setAutoCommit(false);
            //SQL DB prepared statement 
            preparedStatement = connct.prepareStatement("SELECT * FROM new_parts limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();
            Parts_serv parts_serv;
            while (rs.next()) {
                parts_serv = new Parts_serv(rs.getString("parts_OEM_Num"),
                        rs.getString("parts_Origin_c"), rs.getString("parts_For_Make"),
                        rs.getString("parts_For_Model"), rs.getString("parts_Part_Make"),
                        rs.getString("parts_Supplier"), rs.getString("parts_Cost"),
                        rs.getString("parts_Count"), rs.getString("parts_For_Weight"),
                        rs.getString("parts_For_System"), rs.getString("parts_Description"), rs.getBytes("parts_Picture"),
                        rs.getString("parts_VAT"),
                        rs.getString("parts_DateTime"));

                listProduct.add(parts_serv);

            }
            connct.commit();
            connct.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return listProduct;
        }
    }

    public int count() {
       //Counts all rows form SQL DB
        int counter = 0;

        try {
            connct.setAutoCommit(false);
            //SQL Prepared Statement
            preparedStatement = connct.prepareStatement("SELECT count(parts_OEM_Num) from new_parts");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                counter = rs.getInt("count(parts_OEM_Num)");
            }
            connct.commit();
            connct.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return counter;
        }
    }

    public List<Parts_serv> srchT(int page, int pageSize) {
        //Search with paging in SQL DB
        List<Parts_serv> listProduct = new ArrayList<Parts_serv>();

        //Combobox search order
        int b = jCmbBox_SrtOrdr.getSelectedIndex();
        String sort = "";

        switch (b) {//Swith serch oreder by position
            case 0:
                sort = "ASC";//Ascending
                break;
            case 1:
                sort = "DESC";//Descending
                break;

            default:
                sort = "ASC";//Defaut state Ascending order
                break;
        }

        //Combobox search item
        String test = "";
        int a = jCmbBox_Search.getSelectedIndex();

        switch (a) {//Switch search by item
            case 0:
                test = "parts_OEM_Num";//OEM number
                break;
            case 1:
                test = "parts_Origin_c";//Part origin 
                break;
            case 2:
                test = "parts_For_Make";//Part for car make 
                break;
            case 3:
                test = "parts_For_Model";//Part for car model
                break;
            case 4:
                test = "parts_Part_Make";//Part make
                break;
            case 5:
                test = "parts_Supplier";//Part suppllier
                break;
            case 6:
                test = "parts_Cost";//Part price
                break;
            case 7:
                test = "parts_Count";//Part count
                break;
            case 8:
                test = "parts_For_Weight";//Partv weight
                break;
            case 9:
                test = "parts_For_System";//Part for system
                break;
            case 10:
                test = "parts_DateTime";//Part TIMSTAMP
                break;
            default:
                test = "parts_OEM_Num";//Defaut state search by OEM number
                break;
        }

        if (count() == 0) {
            return listProduct;
        }

        try {
            connct.setAutoCommit(false);
            //Gets search input from textField
            String val = jTxtFld_Srch.getText();
            //SQL Query 
            preparedStatement = connct.prepareStatement("select * FROM new_parts  WHERE new_parts." + test + " like '%" + val + "%' ORDER BY " + test + " " + sort + " limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();
            Parts_serv prts_serv;
            while (rs.next()) {
                prts_serv = new Parts_serv(rs.getString("parts_OEM_Num"),
                        rs.getString("parts_Origin_c"), rs.getString("parts_For_Make"),
                        rs.getString("parts_For_Model"), rs.getString("parts_Part_Make"),
                        rs.getString("parts_Supplier"), rs.getString("parts_Cost"),
                        rs.getString("parts_Count"), rs.getString("parts_For_Weight"),
                        rs.getString("parts_For_System"), rs.getString("parts_Description"), rs.getBytes("parts_Picture"),
                        rs.getString("parts_VAT"),
                        rs.getString("parts_DateTime"));

                listProduct.add(prts_serv);

            }
            connct.commit();
            connct.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return listProduct;
        }
    }

    private void search() {//
        //Method for searching with pagination
        //Gets total number of rows in specific table in SQL database
        totalData = count();
        //For testing purposes
        // System.out.println(totalData);

        //Gets how many rows to show in jtable from combobox 
        rowCountPerPage = Integer.valueOf(jComboBoxPage.getSelectedItem().toString());
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
        totalPage = totalPageD.intValue();
        //Buttons for page navigation
        //Buttons for first and previous 
        if (page.equals(1)) {
            jButtonFirst.setEnabled(false);
            jButtonPrevious.setEnabled(false);
        } else {
            jButtonFirst.setEnabled(true);
            jButtonPrevious.setEnabled(true);
        }
        //Buttons for last and next 
        if (page.equals(totalPage)) {
            jButtonLast.setEnabled(false);
            jButtonNext.setEnabled(false);
        } else {
            jButtonLast.setEnabled(true);
            jButtonNext.setEnabled(true);
        }

        if (page > totalPage) {
            page = 1;
        }
        //Makes new instance of table for parts
        partsTableModel = new PartsTableModel();
        partsTableModel.setList(srchT(page, rowCountPerPage));//populate table with paging
        jTb_Parts.setModel(partsTableModel);//Sets table model
        //JLbls for page position and count
        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);//Page position
        jLabelTotalData.setText(("Row count " + totalData));//Total rows count
        //Autoresize table columns
        ResizeForJTables.autoResizeColumn(jTb_Parts);
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
//            java.util.logging.Logger.getLogger(JFrame_Add_Product.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrame_Add_Product.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrame_Add_Product.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrame_Add_Product.class
//                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new JFrame_Add_Product().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_AddNewPart;
    private javax.swing.JButton jBtn_AddPic;
    private javax.swing.JButton jBtn_B;
    private javax.swing.JButton jBtn_ClerarTbl;
    private javax.swing.JButton jBtn_Del;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox<String> jCmbBox_Search;
    private javax.swing.JComboBox<String> jCmbBox_SrtOrdr;
    private javax.swing.JComboBox jComboBoxPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelStatusHalaman;
    private javax.swing.JLabel jLabelTotalData;
    private javax.swing.JLabel jLabel_closeProduct;
    private javax.swing.JLabel jLabel_minimizeProduct;
    private javax.swing.JLabel jLblCostItem;
    private javax.swing.JLabel jLblKg;
    private javax.swing.JLabel jLblPicture;
    private javax.swing.JLabel jLblTaxPerc;
    private javax.swing.JLabel jLblTopProduct;
    private javax.swing.JLabel jLbl_Cost;
    private javax.swing.JLabel jLbl_Count;
    private javax.swing.JLabel jLbl_Description;
    private javax.swing.JLabel jLbl_ForMake;
    private javax.swing.JLabel jLbl_ForMod;
    private javax.swing.JLabel jLbl_ForNumM;
    private javax.swing.JLabel jLbl_For_Sys;
    private javax.swing.JLabel jLbl_Oem_Now;
    private javax.swing.JLabel jLbl_Oem_show;
    private javax.swing.JLabel jLbl_OriginC;
    private javax.swing.JLabel jLbl_PicPath;
    private javax.swing.JLabel jLbl_Splr;
    private javax.swing.JLabel jLbl_Srch;
    private javax.swing.JLabel jLbl_Tax;
    private javax.swing.JLabel jLbl_Weight;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPnlMain;
    private javax.swing.JPanel jPnlTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTb_Parts;
    private javax.swing.JTextArea jTxtArea_Desc;
    private javax.swing.JTextField jTxtFld_Cnt;
    private javax.swing.JTextField jTxtFld_Cst;
    private javax.swing.JTextField jTxtFld_ForSys;
    private javax.swing.JTextField jTxtFld_Make;
    private javax.swing.JTextField jTxtFld_Model;
    private javax.swing.JTextField jTxtFld_Origin;
    private javax.swing.JTextField jTxtFld_PartMake;
    private javax.swing.JTextField jTxtFld_Srch;
    private javax.swing.JTextField jTxtFld_Suplr;
    private javax.swing.JTextField jTxtFld_VAT;
    private javax.swing.JTextField jTxtFld_Weight;
    private javax.swing.JLabel label_photo;
    // End of variables declaration//GEN-END:variables
}
