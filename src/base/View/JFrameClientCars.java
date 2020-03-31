package base.View;

import base.Validators.CarNumberVerifi;
import base.Cars_Db_clients;
import base.Connection.MyCNX;
import base.TableUtils.ResizeForJTables;
import static base.Validators.VIN.isVinValid;
import com.model.table.CarsTableModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;

/**
 * Form for car management and car ownership
 *
 * @author 0896
 */
public class JFrameClientCars extends javax.swing.JFrame {
    //Coordinats for jform mouse draging

    int xMouse;
    int yMouse;
    //Connection to SQL DB
    Connection connct = MyCNX.getConnection();
    //SQL Prepared Statement
    private PreparedStatement preparedStatement;
    //Table model for cars
    CarsTableModel carsTableModel;
    //Page navigation
    Integer page = 1;//
    Integer rowCountPerPage = 5;//
    Integer totalPage = 1;//
    Integer totalData = 0;//

    /**
     * Creates new form JFrameClientCars
     */
    public JFrameClientCars() {
        initComponents();

        seticon();//Sets icon
        
        //Disables copy pasete functionality 
        jTxtFld_ClCars_REG.setTransferHandler(null);//Vehicle registration number
       // jTxtFld_ClCars_VIN.setTransferHandler(null);//Vehicle VIN number
        jTxtFld_ClCars_Make.setTransferHandler(null);//Vehicle make
        jTxtFld_ClCars_Model.setTransferHandler(null);//Vehicle model
        jTxtFld_ClCars_Mileage.setTransferHandler(null);//Vehicle mileage
        jTxtFld_ClCars_Type.setTransferHandler(null);//Vehicle type
        jTxtFld_ClCars_Fueling.setTransferHandler(null);//Vehicle fueling
        jTxtFld_ClCars_Gearbox.setTransferHandler(null);//Vehicle gearbox
        jDateChooser1_dob1.setTransferHandler(null);//Vehicle manufacture date
        jTxtFld_ClCars_DRTrain.setTransferHandler(null);//Vehicle drivetrain
        jTxtFld_ClCars_EngineCC.setTransferHandler(null);//Vehicle engine dispalacemnt
        jTxtFld_ClCars_KW.setTransferHandler(null);//Vehicle power

        //Sets bacground to transparent
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
        //Gets  new instance of table model for cars model
        carsTableModel = new CarsTableModel();
        carsTableModel.setList(findAll(page, rowCountPerPage));//Populate jtable
        jTbl_Car_INF.setModel(carsTableModel);//Set table model
        //Page number
        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);
        jLabelTotalData.setText(("Row count " + totalData));//Table rows count 
        //Auto resizes table columns
        ResizeForJTables.autoResizeColumn(jTbl_Car_INF);
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
        jLabel_closeCarAdd = new javax.swing.JLabel();
        jLabel_minimizeCarAdd = new javax.swing.JLabel();
        jLblTopBarCarAdd = new javax.swing.JLabel();
        jPnl_Client_Cars = new javax.swing.JPanel();
        jTxtFld_ClCars_REG = new javax.swing.JTextField();
        jTxtFld_ClCars_VIN = new javax.swing.JTextField();
        jTxtFld_ClCars_Make = new javax.swing.JTextField();
        jTxtFld_ClCars_Model = new javax.swing.JTextField();
        jTxtFld_ClCars_Mileage = new javax.swing.JTextField();
        jTxtFld_ClCars_Type = new javax.swing.JTextField();
        jTxtFld_ClCars_Fueling = new javax.swing.JTextField();
        jTxtFld_ClCars_Gearbox = new javax.swing.JTextField();
        jDateChooser1_dob1 = new com.toedter.calendar.JDateChooser();
        jTxtFld_ClCars_DRTrain = new javax.swing.JTextField();
        jTxtFld_ClCars_EngineCC = new javax.swing.JTextField();
        jTxtFld_ClCars_KW = new javax.swing.JTextField();
        jLbl_RegNum = new javax.swing.JLabel();
        jLbl_VIN = new javax.swing.JLabel();
        jLbl_CarNum = new javax.swing.JLabel();
        jLbl_CarMod = new javax.swing.JLabel();
        jLbl_CarMileage = new javax.swing.JLabel();
        jLbl_CarType = new javax.swing.JLabel();
        jLbl_CarFueling = new javax.swing.JLabel();
        jLbl_CarGearbox = new javax.swing.JLabel();
        jLbl_CarMnufDt = new javax.swing.JLabel();
        jLbl_CarDrTr = new javax.swing.JLabel();
        jLbl_CarCC = new javax.swing.JLabel();
        jLbl_CarKW = new javax.swing.JLabel();
        jLblOwner = new javax.swing.JLabel();
        jLblCarOwnedBy = new javax.swing.JLabel();
        jLbl_SrchBy = new javax.swing.JLabel();
        jCmBoxOrder = new javax.swing.JComboBox<>();
        jCmBx_Srch = new javax.swing.JComboBox<>();
        jTxtFld_ClCars_Srch = new javax.swing.JTextField();
        jBtn_Tbl_Add = new javax.swing.JButton();
        jBtn_Tbl_Update = new javax.swing.JButton();
        jBtn_Tbl_DEL = new javax.swing.JButton();
        jBtn_Tbl_Cln = new javax.swing.JButton();
        jBtn_Bck = new javax.swing.JButton();
        jPnlPaging = new javax.swing.JPanel();
        jButtonLast = new javax.swing.JButton();
        jButtonNext = new javax.swing.JButton();
        jComboBoxPage = new javax.swing.JComboBox();
        jButtonPrevious = new javax.swing.JButton();
        jButtonFirst = new javax.swing.JButton();
        jLabelStatusHalaman = new javax.swing.JLabel();
        jLabelTotalData = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTbl_Car_INF = new javax.swing.JTable();
        jLblPic = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cars  management");
        setBackground(new java.awt.Color(231, 76, 60));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPnlTop.setBackground(new java.awt.Color(51, 51, 51));
        jPnlTop.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel_closeCarAdd.setBackground(new java.awt.Color(255, 0, 51));
        jLabel_closeCarAdd.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_closeCarAdd.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_closeCarAdd.setText("  X");
        jLabel_closeCarAdd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_closeCarAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_closeCarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_closeCarAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_closeCarAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_closeCarAddMouseExited(evt);
            }
        });
        jPnlTop.add(jLabel_closeCarAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1470, 0, 30, 30));

        jLabel_minimizeCarAdd.setBackground(new java.awt.Color(153, 153, 153));
        jLabel_minimizeCarAdd.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel_minimizeCarAdd.setForeground(new java.awt.Color(255, 255, 255));
        jLabel_minimizeCarAdd.setText("  -");
        jLabel_minimizeCarAdd.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        jLabel_minimizeCarAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel_minimizeCarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel_minimizeCarAddMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel_minimizeCarAddMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel_minimizeCarAddMouseExited(evt);
            }
        });
        jPnlTop.add(jLabel_minimizeCarAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(1440, 0, 30, 30));

        jLblTopBarCarAdd.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jLblTopBarCarAddMouseDragged(evt);
            }
        });
        jLblTopBarCarAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLblTopBarCarAddMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLblTopBarCarAddMousePressed(evt);
            }
        });
        jPnlTop.add(jLblTopBarCarAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 30));

        getContentPane().add(jPnlTop, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1500, 30));

        jPnl_Client_Cars.setBackground(new java.awt.Color(0, 84, 140));
        jPnl_Client_Cars.setForeground(new java.awt.Color(52, 152, 219));
        jPnl_Client_Cars.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTxtFld_ClCars_REG.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_REG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_REG.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_REG.setToolTipText("Enter 8 charecter car number.");
        jTxtFld_ClCars_REG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFld_ClCars_REGActionPerformed(evt);
            }
        });
        jTxtFld_ClCars_REG.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_REGKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_REGKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_REG, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 120, -1));

        jTxtFld_ClCars_VIN.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_VIN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_VIN.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_VIN.setToolTipText("Enter 17 character VIN number.");
        jTxtFld_ClCars_VIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_VINKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_VIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 160, -1));

        jTxtFld_ClCars_Make.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Make.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Make.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Make.setToolTipText("Enter car make.");
        jTxtFld_ClCars_Make.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_MakeKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Make, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 160, -1));

        jTxtFld_ClCars_Model.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Model.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Model.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Model.setToolTipText("Enter car model.");
        jTxtFld_ClCars_Model.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_ModelKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Model, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));

        jTxtFld_ClCars_Mileage.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Mileage.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Mileage.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Mileage.setToolTipText("Enter vehicle mileage.");
        jTxtFld_ClCars_Mileage.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_MileageKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Mileage, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 160, -1));

        jTxtFld_ClCars_Type.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Type.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Type.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Type.setToolTipText("Enter vehicle  type.");
        jTxtFld_ClCars_Type.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_TypeKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Type, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 190, 160, -1));

        jTxtFld_ClCars_Fueling.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Fueling.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Fueling.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Fueling.setToolTipText("Enter vehicle fuel type.");
        jTxtFld_ClCars_Fueling.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_FuelingKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Fueling, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 160, -1));

        jTxtFld_ClCars_Gearbox.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Gearbox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Gearbox.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Gearbox.setToolTipText("Enter vehicle gerbox type.");
        jTxtFld_ClCars_Gearbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_GearboxKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Gearbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 160, -1));

        jDateChooser1_dob1.setBackground(new java.awt.Color(0, 84, 140));
        jDateChooser1_dob1.setForeground(new java.awt.Color(255, 255, 255));
        jDateChooser1_dob1.setToolTipText("Enter vehicle manufacture date .");
        jDateChooser1_dob1.setDateFormatString("dd-MM-yyyy");
        jPnl_Client_Cars.add(jDateChooser1_dob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 140, 26));

        jTxtFld_ClCars_DRTrain.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_DRTrain.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_DRTrain.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_DRTrain.setToolTipText("Enter vehicle  Drivetrain type .");
        jTxtFld_ClCars_DRTrain.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_DRTrainKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_DRTrain, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 160, -1));

        jTxtFld_ClCars_EngineCC.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_EngineCC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_EngineCC.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_EngineCC.setToolTipText("Enter vehicle   Engine capacity .");
        jTxtFld_ClCars_EngineCC.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_EngineCCKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_EngineCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 160, -1));

        jTxtFld_ClCars_KW.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_KW.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_KW.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_KW.setToolTipText("Enter vehicle    power figure .");
        jTxtFld_ClCars_KW.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTxtFld_ClCars_KWMouseClicked(evt);
            }
        });
        jTxtFld_ClCars_KW.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_KWKeyTyped(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_KW, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 160, -1));

        jLbl_RegNum.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_RegNum.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_RegNum.setText("Registration Number :  ");
        jPnl_Client_Cars.add(jLbl_RegNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLbl_VIN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_VIN.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_VIN.setText("VIN number:  ");
        jPnl_Client_Cars.add(jLbl_VIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, -1));

        jLbl_CarNum.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarNum.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarNum.setText("Make :  ");
        jPnl_Client_Cars.add(jLbl_CarNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 138, -1));

        jLbl_CarMod.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarMod.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarMod.setText("Model :  ");
        jPnl_Client_Cars.add(jLbl_CarMod, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 138, -1));

        jLbl_CarMileage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarMileage.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarMileage.setText("Mileage :");
        jPnl_Client_Cars.add(jLbl_CarMileage, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 138, -1));

        jLbl_CarType.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarType.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarType.setText("Type:");
        jPnl_Client_Cars.add(jLbl_CarType, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 138, -1));

        jLbl_CarFueling.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarFueling.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarFueling.setText("Fueling :");
        jPnl_Client_Cars.add(jLbl_CarFueling, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 138, -1));

        jLbl_CarGearbox.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarGearbox.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarGearbox.setText("Gearbox :");
        jPnl_Client_Cars.add(jLbl_CarGearbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 138, -1));

        jLbl_CarMnufDt.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarMnufDt.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarMnufDt.setText("Manufacture date :");
        jPnl_Client_Cars.add(jLbl_CarMnufDt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 138, -1));

        jLbl_CarDrTr.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarDrTr.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarDrTr.setText("Drivetrain :");
        jPnl_Client_Cars.add(jLbl_CarDrTr, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 138, -1));

        jLbl_CarCC.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarCC.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarCC.setText("Engine cc :");
        jPnl_Client_Cars.add(jLbl_CarCC, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 138, -1));

        jLbl_CarKW.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_CarKW.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_CarKW.setText("Power :");
        jPnl_Client_Cars.add(jLbl_CarKW, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 138, -1));

        jLblOwner.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLblOwner.setForeground(new java.awt.Color(255, 255, 255));
        jLblOwner.setText("Owner :");
        jPnl_Client_Cars.add(jLblOwner, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jLblCarOwnedBy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLblCarOwnedBy.setForeground(new java.awt.Color(255, 255, 255));
        jLblCarOwnedBy.setText("None");
        jPnl_Client_Cars.add(jLblCarOwnedBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 410, -1, -1));

        jLbl_SrchBy.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLbl_SrchBy.setForeground(new java.awt.Color(255, 255, 255));
        jLbl_SrchBy.setText("Search by :");
        jPnl_Client_Cars.add(jLbl_SrchBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, -1, -1));

        jCmBoxOrder.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCmBoxOrder.setForeground(new java.awt.Color(255, 255, 255));
        jCmBoxOrder.setMaximumRowCount(2);
        jCmBoxOrder.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        jPnl_Client_Cars.add(jCmBoxOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 470, 90, -1));

        jCmBx_Srch.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jCmBx_Srch.setForeground(new java.awt.Color(255, 255, 255));
        jCmBx_Srch.setMaximumRowCount(9);
        jCmBx_Srch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VIN", "Reg Number", "Make", "Model", "Type", "Fueling", "Gearbox", "Engine cc", "Power", "" }));
        jCmBx_Srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCmBx_SrchActionPerformed(evt);
            }
        });
        jPnl_Client_Cars.add(jCmBx_Srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        jTxtFld_ClCars_Srch.setBackground(new java.awt.Color(62, 62, 62));
        jTxtFld_ClCars_Srch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTxtFld_ClCars_Srch.setForeground(new java.awt.Color(255, 255, 255));
        jTxtFld_ClCars_Srch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtFld_ClCars_SrchActionPerformed(evt);
            }
        });
        jTxtFld_ClCars_Srch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTxtFld_ClCars_SrchKeyReleased(evt);
            }
        });
        jPnl_Client_Cars.add(jTxtFld_ClCars_Srch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 505, 270, -1));

        jBtn_Tbl_Add.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_Tbl_Add.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Tbl_Add.setText("Add");
        jBtn_Tbl_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Tbl_AddActionPerformed(evt);
            }
        });
        jPnl_Client_Cars.add(jBtn_Tbl_Add, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 80, -1));

        jBtn_Tbl_Update.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_Tbl_Update.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Tbl_Update.setText("Update");
        jBtn_Tbl_Update.setToolTipText("");
        jBtn_Tbl_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Tbl_UpdateActionPerformed(evt);
            }
        });
        jPnl_Client_Cars.add(jBtn_Tbl_Update, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, 80, -1));

        jBtn_Tbl_DEL.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_Tbl_DEL.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Tbl_DEL.setText("Delete");
        jBtn_Tbl_DEL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Tbl_DELActionPerformed(evt);
            }
        });
        jPnl_Client_Cars.add(jBtn_Tbl_DEL, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 540, 80, -1));

        jBtn_Tbl_Cln.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_Tbl_Cln.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Tbl_Cln.setText("Clean");
        jBtn_Tbl_Cln.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_Tbl_ClnActionPerformed(evt);
            }
        });
        jPnl_Client_Cars.add(jBtn_Tbl_Cln, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, 80, -1));

        jBtn_Bck.setBackground(new java.awt.Color(0, 84, 140));
        jBtn_Bck.setForeground(new java.awt.Color(255, 255, 255));
        jBtn_Bck.setText("Back");
        jBtn_Bck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtn_BckActionPerformed(evt);
            }
        });
        jPnl_Client_Cars.add(jBtn_Bck, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 630, 90, -1));

        jPnlPaging.setBackground(new java.awt.Color(62, 62, 62));
        jPnlPaging.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonLast.setBackground(new java.awt.Color(0, 84, 140));
        jButtonLast.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonLast.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLast.setText("Last");
        jButtonLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLastActionPerformed(evt);
            }
        });
        jPnlPaging.add(jButtonLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 90, -1));

        jButtonNext.setBackground(new java.awt.Color(0, 84, 140));
        jButtonNext.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonNext.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNext.setText("Next");
        jButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextActionPerformed(evt);
            }
        });
        jPnlPaging.add(jButtonNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 70, -1));

        jComboBoxPage.setBackground(new java.awt.Color(62, 62, 62));
        jComboBoxPage.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jComboBoxPage.setForeground(new java.awt.Color(255, 255, 255));
        jPnlPaging.add(jComboBoxPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 80, 30));

        jButtonPrevious.setBackground(new java.awt.Color(0, 84, 140));
        jButtonPrevious.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonPrevious.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPrevious.setText("Previous");
        jButtonPrevious.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPreviousActionPerformed(evt);
            }
        });
        jPnlPaging.add(jButtonPrevious, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 0, -1, -1));

        jButtonFirst.setBackground(new java.awt.Color(0, 84, 140));
        jButtonFirst.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButtonFirst.setForeground(new java.awt.Color(255, 255, 255));
        jButtonFirst.setText("First");
        jButtonFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFirstActionPerformed(evt);
            }
        });
        jPnlPaging.add(jButtonFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 90, -1));

        jLabelStatusHalaman.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelStatusHalaman.setForeground(new java.awt.Color(255, 255, 255));
        jPnlPaging.add(jLabelStatusHalaman, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 240, 40));

        jLabelTotalData.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabelTotalData.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTotalData.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPnlPaging.add(jLabelTotalData, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 0, 200, 40));

        jPnl_Client_Cars.add(jPnlPaging, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 610, 1150, 40));

        jTbl_Car_INF.setAutoCreateRowSorter(true);
        jTbl_Car_INF.setBackground(new java.awt.Color(62, 62, 62));
        jTbl_Car_INF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTbl_Car_INF.setForeground(new java.awt.Color(255, 255, 255));
        jTbl_Car_INF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "REG", "VIN", "Make", "Model", "Mileage", "Type", "Fueling", "Gear box", "Manufacture date", "Drivetrain", "Engine cc", "Power", "Date added"
            }
        ));
        jTbl_Car_INF.getTableHeader().setReorderingAllowed(false);
        jTbl_Car_INF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTbl_Car_INFFocusGained(evt);
            }
        });
        jTbl_Car_INF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTbl_Car_INFMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTbl_Car_INFMouseEntered(evt);
            }
        });
        jTbl_Car_INF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTbl_Car_INFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTbl_Car_INFKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTbl_Car_INF);

        jPnl_Client_Cars.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 1150, 570));

        jLblPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/car_reg.png"))); // NOI18N
        jPnl_Client_Cars.add(jLblPic, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1480, 670));

        getContentPane().add(jPnl_Client_Cars, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1500, 700));

        setSize(new java.awt.Dimension(1503, 749));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBtn_BckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_BckActionPerformed
       //Backs to main menu by disposing of the form 
        this.dispose();
    }//GEN-LAST:event_jBtn_BckActionPerformed

    private void jCmBx_SrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCmBx_SrchActionPerformed

    }//GEN-LAST:event_jCmBx_SrchActionPerformed

    private void jTxtFld_ClCars_VINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_VINKeyTyped
       //Filters vin number entry 17 or les char
        if ((jTxtFld_ClCars_VIN.getText() + evt.getKeyChar()).length() > 17) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_VINKeyTyped

    private void jBtn_Tbl_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Tbl_AddActionPerformed
       //Button Add  new vehicle
        String carNum = jTxtFld_ClCars_REG.getText();
        String carVIN = jTxtFld_ClCars_VIN.getText();

        if (!checkCarNum(carNum) && CarNumberVerifi.getCarNumberVer(carNum)) {// if car num is not taken alredy and is valid
            if (!checkCarVIN(carVIN)) {// if vin is  not taken 
                if (isVinValid(carVIN)) {//if vin is valid 
                    if (verifyEptyFieldsCar()) {//if fiealds are not empty

                        try {
                            PreparedStatement ps = connct.prepareStatement("insert into clients_cars_record"
                                    + "(Car_Reg_Num_cl,Car_Vin_Num_cl,Car_Make_cl,Car_Model_cl,"
                                    + "Car_Mileage_cl,Car_VehicleType_cl,Car_FuelSys_cl,"
                                    + "Car_Gearbox_cl,Car_ManufactureDate_cl,Car_Drivetrain_cl,"
                                    + "Car_EngineDisplacementl_cl,Car_Power_cl,Car_DateTime_Created_cl) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                            ps.setString(1, jTxtFld_ClCars_REG.getText());//vehicle registation number
                            ps.setString(2, jTxtFld_ClCars_VIN.getText());//vehicle VIN number
                            ps.setString(3, jTxtFld_ClCars_Make.getText());//vehicle make
                            ps.setString(4, jTxtFld_ClCars_Model.getText());//vehicle model
                            ps.setString(5, jTxtFld_ClCars_Mileage.getText());//vehicle mileage
                            ps.setString(6, jTxtFld_ClCars_Type.getText());//vehicle type
                            ps.setString(7, jTxtFld_ClCars_Fueling.getText());//vehicle fueling
                            ps.setString(8, jTxtFld_ClCars_Gearbox.getText());//vehicle gearbox
                            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                            String dob1 = sdf.format(jDateChooser1_dob1.getDate());
                            ps.setString(9, dob1);//Manufacture date of vehicle
                            ps.setString(10, jTxtFld_ClCars_DRTrain.getText());//vehicle drivetrain
                            ps.setString(11, jTxtFld_ClCars_EngineCC.getText());//vehicle engine displacement
                            ps.setString(12, jTxtFld_ClCars_KW.getText());//vehicle power
                            //Gets local date time from machine
                            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                            LocalDateTime now = LocalDateTime.now();
                            ps.setString(13, dtf.format(now));//timestamp
                            int res = ps.executeUpdate();//Ececute update
                            initPagination();//Update jtable rows
                            if (res >= 1) {
                                JOptionPane.showMessageDialog(null, res + " Number of Cars"
                                        + " inserted into database .....");
                            } else {
                                JOptionPane.showMessageDialog(null, "New Car Insertion Failed ....");
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, e);
                        } finally {
                            //Clean textfields
                            clean();
                        }
                    }//if fiealds are not empty
                }//if vin is valid 
            }// if vin is  not taken 
        } else {// if car num is not taken alredy and is valid
            JOptionPane.showMessageDialog(null, " Car number is invalid ", "Registration number !", 2);
        }
    }//GEN-LAST:event_jBtn_Tbl_AddActionPerformed

    private void jBtn_Tbl_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Tbl_UpdateActionPerformed
        //Button update vehicle
        if (verifyEptyFieldsCar() && CarNumberVerifi.getCarNumberVer(jTxtFld_ClCars_REG.getText())) {//Verifies if fields are not empty and car number is valid
            if (isVinValid(jTxtFld_ClCars_VIN.getText())) {//Vin number verification
                int result;
                result = JOptionPane.showConfirmDialog(this, "Are you sure you really want to Update Vehicle  registration  number  " + jTxtFld_ClCars_REG.getText(),
                        " Update operation ! ", 1);
                System.out.println(result);
                // yes -> 0
                // no ->  1
                // cancel  -> 2
                if (result == 0) {//Update dalog window prompt yes option

                    try {
                        PreparedStatement ps = null;
                        ps = connct.prepareStatement("UPDATE clients_cars_record SET "
                                + "Car_Reg_Num_cl=?,Car_Vin_Num_cl=?,Car_Make_cl=? ,Car_Model_cl=?,"
                                + "Car_Mileage_cl=?,Car_VehicleType_cl=?,Car_FuelSys_cl=?,"
                                + "Car_Gearbox_cl=?,Car_ManufactureDate_cl=?,Car_Drivetrain_cl=?,"
                                + "Car_EngineDisplacementl_cl=?,Car_Power_cl=?"
                                + " WHERE Car_Reg_Num_cl=? ");
                        ps.setString(1, jTxtFld_ClCars_REG.getText());//Vehicle Registration number
                        ps.setString(2, jTxtFld_ClCars_VIN.getText());//Vehicle VIN number
                        ps.setString(3, jTxtFld_ClCars_Make.getText());//Vehicle make
                        ps.setString(4, jTxtFld_ClCars_Model.getText());//Vehicle model
                        ps.setString(5, jTxtFld_ClCars_Mileage.getText());//Vehicle mileage
                        ps.setString(6, jTxtFld_ClCars_Type.getText());//Vehicle type
                        ps.setString(7, jTxtFld_ClCars_Fueling.getText());//Vehicle fueling
                        ps.setString(8, jTxtFld_ClCars_Gearbox.getText());//Vehicle gerbox
                        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                        String dob1 = sdf.format(jDateChooser1_dob1.getDate());
                        ps.setString(9, dob1);//Vehicle mnufacture date
                        ps.setString(10, jTxtFld_ClCars_DRTrain.getText());//Vehicle drivetrain
                        ps.setString(11, jTxtFld_ClCars_EngineCC.getText());//Vehicle engine displacement
                        ps.setString(12, jTxtFld_ClCars_KW.getText());//Vehicle power
                        ps.setString(13, jTxtFld_ClCars_REG.getText()); //Vehicle Registration number
                       // int res = ps.executeUpdate();//Executes update
                        initPagination();//Update table rows
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrameClientCars.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        clean();//Clens textfields
                    }
                }//Update dalog window prompt yes option
            }//Vin number verification
        }//Verifies if fields are not empty and car number is valid
    }//GEN-LAST:event_jBtn_Tbl_UpdateActionPerformed

    private void jTbl_Car_INFMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbl_Car_INFMouseClicked
      //Fills textfields on row form table mouse clicked
        fillFldsTbl();
    }//GEN-LAST:event_jTbl_Car_INFMouseClicked

    private void jTxtFld_ClCars_REGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_REGActionPerformed

    }//GEN-LAST:event_jTxtFld_ClCars_REGActionPerformed

    private void jBtn_Tbl_DELActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Tbl_DELActionPerformed
    //Button Delete 
        if (jTbl_Car_INF.getRowCount() != 0 && verifyEptyFieldsCar()) {//Checks if teble is empty and textfields not empty
            int result;
            result = JOptionPane.showConfirmDialog(this, "Are you sure you really want to delete the record for car with registration number "
                    + jTxtFld_ClCars_REG.getText(),
                    "Delete entry!", 2);
            System.out.println(result);
            // yes -> 0
            // no ->  1
            // cancel  -> 2
            if (result == 0) {//Dialog window yes option

                String dell;
           //
                dell = JOptionPane.showInputDialog(this, "Type DELETE if you want to erase record for part  : ", "");
                if ("DELETE".equals(dell) && jTxtFld_ClCars_REG.getText().trim() != "".trim()) {//If DELETE is typed in input dialog form

                   try {
                        String del = jTxtFld_ClCars_REG.getText().toString();
                        String query = "DELETE FROM `clients_cars_record` WHERE `clients_cars_record`.`Car_Reg_Num_cl` like '%" + del + "%' limit 1 ";
                        executeSQlQuery(query, "Deleted");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    clean();//Cleans textfileds on succesful delete
                } //If DELETE is typed in input dialog form            
            }//Dialog window yes option
        }//Checks if teble is empty and textfields not empty
    }//GEN-LAST:event_jBtn_Tbl_DELActionPerformed

    private void jBtn_Tbl_ClnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtn_Tbl_ClnActionPerformed
//Cleans textfields
        clean();
    }//GEN-LAST:event_jBtn_Tbl_ClnActionPerformed

    private void jTxtFld_ClCars_SrchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_SrchKeyReleased
        //Search on key typed
        srch();
    }//GEN-LAST:event_jTxtFld_ClCars_SrchKeyReleased

    private void jTxtFld_ClCars_SrchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_SrchActionPerformed

    }//GEN-LAST:event_jTxtFld_ClCars_SrchActionPerformed

    private void jTbl_Car_INFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTbl_Car_INFKeyPressed

    }//GEN-LAST:event_jTbl_Car_INFKeyPressed

    private void jTxtFld_ClCars_REGKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_REGKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_REG.getText() + evt.getKeyChar()).length() > 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_REGKeyTyped

    private void jTxtFld_ClCars_REGKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_REGKeyReleased

    }//GEN-LAST:event_jTxtFld_ClCars_REGKeyReleased

    private void jTxtFld_ClCars_MakeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_MakeKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_Make.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_MakeKeyTyped

    private void jTxtFld_ClCars_ModelKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_ModelKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_Model.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_ModelKeyTyped

    private void jTxtFld_ClCars_MileageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_MileageKeyTyped
     //Filter cahrecter length
        if ((jTxtFld_ClCars_Mileage.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_MileageKeyTyped

    private void jTxtFld_ClCars_TypeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_TypeKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_Type.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_TypeKeyTyped

    private void jTxtFld_ClCars_FuelingKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_FuelingKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_Fueling.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_FuelingKeyTyped

    private void jTxtFld_ClCars_GearboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_GearboxKeyTyped
       //Filter cahrecter length
        if ((jTxtFld_ClCars_Gearbox.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }

    }//GEN-LAST:event_jTxtFld_ClCars_GearboxKeyTyped

    private void jTxtFld_ClCars_DRTrainKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_DRTrainKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_DRTrain.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_DRTrainKeyTyped

    private void jTxtFld_ClCars_EngineCCKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_EngineCCKeyTyped
      //Filter cahrecter length
        if ((jTxtFld_ClCars_EngineCC.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_EngineCCKeyTyped

    private void jTxtFld_ClCars_KWKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_KWKeyTyped
       //Filter cahrecter length
        if ((jTxtFld_ClCars_KW.getText() + evt.getKeyChar()).length() > 32) {
            evt.consume();
        }
    }//GEN-LAST:event_jTxtFld_ClCars_KWKeyTyped

    private void jTxtFld_ClCars_KWMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTxtFld_ClCars_KWMouseClicked

    }//GEN-LAST:event_jTxtFld_ClCars_KWMouseClicked

    private void jTbl_Car_INFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTbl_Car_INFKeyReleased
      //Key events
        //Navigation with arrow keys up adn down ibn jtable
        if (evt.getKeyCode() == KeyEvent.VK_UP || evt.getKeyCode() == KeyEvent.VK_DOWN) {
           //Fills textfields with inf oabout the cars
            fillFldsTbl();
        }
       //Deelte with del key pressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
       //Deletes car entry
       if (jTbl_Car_INF.getRowCount() != 0 && verifyEptyFieldsCar()) {//Checks if teble is empty and textfields not empty
            int result;
            result = JOptionPane.showConfirmDialog(this, "Are you sure you really want to delete the record for car with registration number "
                    + jTxtFld_ClCars_REG.getText(),
                    "Delete entry!", 2);
            System.out.println(result);
            // yes -> 0
            // no ->  1
            // cancel  -> 2
            if (result == 0) {//Dialog window yes option

                String dell;
           //
                dell = JOptionPane.showInputDialog(this, "Type DELETE if you want to erase record for part  : ", "");
                if ("DELETE".equals(dell) && jTxtFld_ClCars_REG.getText().trim() != "".trim()) {//If DELETE is typed in input dialog form

                   try {
                        String del = jTxtFld_ClCars_REG.getText().toString();
                        String query = "DELETE FROM `clients_cars_record` WHERE `clients_cars_record`.`Car_Reg_Num_cl` like '%" + del + "%' limit 1 ";
                        executeSQlQuery(query, "Deleted");
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    clean();//Cleans textfileds on succesful delete
                } //If DELETE is typed in input dialog form            
            }//Dialog window yes option
        }//Checks if teble is empty and textfields not empty
        }
    }//GEN-LAST:event_jTbl_Car_INFKeyReleased

    private void jLabel_closeCarAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeCarAddMouseClicked
//On exit
        this.dispose();
    }//GEN-LAST:event_jLabel_closeCarAddMouseClicked

    private void jLabel_closeCarAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeCarAddMouseEntered
        //Label clese mosue exited reset to defaut color
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_closeCarAdd.setBorder(label_border);
        jLabel_closeCarAdd.setForeground(Color.gray);
        jLabel_closeCarAdd.setOpaque(true);
        jLabel_closeCarAdd.setBackground(Color.RED);
    }//GEN-LAST:event_jLabel_closeCarAddMouseEntered

    private void jLabel_closeCarAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_closeCarAddMouseExited
        //Label close mosue entered color change
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_closeCarAdd.setBorder(label_border);
        jLabel_closeCarAdd.setForeground(Color.white);
        jLabel_closeCarAdd.setOpaque(false);
    }//GEN-LAST:event_jLabel_closeCarAddMouseExited

    private void jLabel_minimizeCarAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeCarAddMouseClicked
        //Minimize form for cars
        this.setState(JFrameClientCars.ICONIFIED);
    }//GEN-LAST:event_jLabel_minimizeCarAddMouseClicked

    private void jLabel_minimizeCarAddMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeCarAddMouseEntered
        // Minimize client management window mouse entered
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray);
        jLabel_minimizeCarAdd.setBorder(label_border);
        jLabel_minimizeCarAdd.setForeground(Color.gray);
        jLabel_minimizeCarAdd.setOpaque(true);
        jLabel_closeCarAdd.setBackground(new Color(153, 153, 153));
    }//GEN-LAST:event_jLabel_minimizeCarAddMouseEntered

    private void jLabel_minimizeCarAddMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel_minimizeCarAddMouseExited
        // Minimize client management window mouse exited
        Border label_border = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.white);
        jLabel_minimizeCarAdd.setBorder(label_border);
        jLabel_minimizeCarAdd.setForeground(Color.white);
        jLabel_minimizeCarAdd.setOpaque(false);
    }//GEN-LAST:event_jLabel_minimizeCarAddMouseExited

    private void jTbl_Car_INFMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTbl_Car_INFMouseEntered

    }//GEN-LAST:event_jTbl_Car_INFMouseEntered

    private void jTbl_Car_INFFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTbl_Car_INFFocusGained

    }//GEN-LAST:event_jTbl_Car_INFFocusGained

    private void jLblTopBarCarAddMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopBarCarAddMouseDragged
        //Feature to drag jframe
        int coordX = evt.getXOnScreen();
        int coordY = evt.getYOnScreen();
        this.setLocation(coordX - xMouse, coordY - yMouse);
    }//GEN-LAST:event_jLblTopBarCarAddMouseDragged

    private void jLblTopBarCarAddMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopBarCarAddMousePressed
        //Mouse cursor x y coordinates
        xMouse = evt.getX();
        yMouse = evt.getY();
    }//GEN-LAST:event_jLblTopBarCarAddMousePressed

    private void jLblTopBarCarAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLblTopBarCarAddMouseClicked
        // 2 Clicks centr Form
        if (evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            //System.out.println("double clicked");
            this.setLocationRelativeTo(null);
        }
    }//GEN-LAST:event_jLblTopBarCarAddMouseClicked

    private void jButtonLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLastActionPerformed
        //Button last apge
        page = totalPage;
        initPagination();//Update jtable rows with paging
    }//GEN-LAST:event_jButtonLastActionPerformed

    private void jButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextActionPerformed
        //Button next page
        if (page < totalPage) {
            page++;//Incremetn page counter
            initPagination();//Update jtable rows with paging
        }
    }//GEN-LAST:event_jButtonNextActionPerformed

    private void jButtonPreviousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPreviousActionPerformed
        //Button previous page
        if (page > 1) {
            page--;//Decrement page counter
            initPagination();//Update jtable rows with paging
        }
    }//GEN-LAST:event_jButtonPreviousActionPerformed

    private void jButtonFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFirstActionPerformed
        //Button forst page
        page = 1;
        initPagination();//Update jtable rows with paging
    }//GEN-LAST:event_jButtonFirstActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //On exit of the form close connection to SQL DB
        try {
            connct.close();//Close connection with SQL DB
            this.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(JFrameClientCars.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowClosing

    public boolean checkCarVIN(String ClCarVIN) {
        //Check if the entred vin nbr alredy exists 
        PreparedStatement st;
        ResultSet rs;
        boolean ClCarVIN_exist = false;

        String query = "SELECT * FROM `clients_cars_record` WHERE `Car_Vin_Num_cl` = ?";
        try {
            st = connct.prepareStatement(query);
            st.setString(1, ClCarVIN);
            rs = st.executeQuery();
            if (rs.next()) {
                ClCarVIN_exist = true;
                JOptionPane.showMessageDialog(null, "This Car VIN Number is Already registered, Choose Another VIN",
                        "Car VIN number Failed", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ClCarVIN_exist;
    }

    public boolean checkCarNum(String ClCarNum) {
        //Check if the entred reg & vin nbr alredy exists 
        PreparedStatement st;
        ResultSet rs;
        boolean ClCarNum_exist = false;
        String query = "SELECT * FROM `clients_cars_record` WHERE `Car_Reg_Num_cl` = ?";

        try {
            st = connct.prepareStatement(query);
            st.setString(1, ClCarNum);
            rs = st.executeQuery();
            if (rs.next()) {
                ClCarNum_exist = true;
                JOptionPane.showMessageDialog(null, "This Car Number  is Already registered, Choose Another One",
                        "Car Number  Failed", 2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Register_Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ClCarNum_exist;
    }

    public void executeSQlQuery(String query, String message) {
        // Execute The Insert Update And Delete Querys
        Statement st;
        try {
            st = connct.createStatement();
            if ((st.executeUpdate(query)) == 1) {
                initPagination();//Updete table rows
                JOptionPane.showMessageDialog(null, "Data " + message + " Succefully");
            } else {
                JOptionPane.showMessageDialog(null, "Data Not " + message);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean verifyEptyFieldsCar() {
        //Validates if the textfilds are no empty
        String ClCars_VIN = jTxtFld_ClCars_VIN.getText();
        String ClCars_REG = jTxtFld_ClCars_REG.getText();
        String ClCars_Make = jTxtFld_ClCars_Make.getText();
        String ClCars_Model = jTxtFld_ClCars_Model.getText();
        // check empty fields
        if (ClCars_VIN.trim().equals("") && ClCars_REG.trim().equals("") && ClCars_Make.trim().equals("") && ClCars_Model.trim().equals("")) {
            JOptionPane.showMessageDialog(null, "Mandatory fields Are Empty", "Fiels Empty ", 2);
            return false;
        } // if everything is ok
        else {
            return true;
        }
    }

    public void fillFldsTbl() {
        //Fills textfields 
        //Gets index of selected row for jtable
        int i = jTbl_Car_INF.getSelectedRow();
        // Display Slected Row In JTexteFields
        jTxtFld_ClCars_REG.setText(jTbl_Car_INF.getValueAt(i, 1).toString());//Vehicle reg number
        jTxtFld_ClCars_VIN.setText(jTbl_Car_INF.getValueAt(i, 2).toString());//Vehicle VIN number
        jTxtFld_ClCars_Make.setText(jTbl_Car_INF.getValueAt(i, 3).toString());//Vehicle make
        jTxtFld_ClCars_Model.setText(jTbl_Car_INF.getValueAt(i, 4).toString());//Vehicle model
        jTxtFld_ClCars_Mileage.setText(jTbl_Car_INF.getValueAt(i, 5).toString());//Vehicle mileage
        jTxtFld_ClCars_Type.setText(jTbl_Car_INF.getValueAt(i, 6).toString());//Vehicle type
        jTxtFld_ClCars_Fueling.setText(jTbl_Car_INF.getValueAt(i, 7).toString());//Vehicle fueling
        jTxtFld_ClCars_Gearbox.setText(jTbl_Car_INF.getValueAt(i, 8).toString());//Vehicle gearbox

        try {
            //Vehicle date manufactured
            java.util.Date dob = new SimpleDateFormat("dd-MM-yyyy").parse((String) jTbl_Car_INF.getValueAt(i, 9).toString());
            jDateChooser1_dob1.setDate(dob);
        } catch (Exception e) {
            System.out.println("Error at showItemToFields method " + e);
        }
        jTxtFld_ClCars_DRTrain.setText(jTbl_Car_INF.getValueAt(i, 10).toString());//Vehicle drivetrain
        jTxtFld_ClCars_EngineCC.setText(jTbl_Car_INF.getValueAt(i, 11).toString());//Vehicle engine displacement
        jTxtFld_ClCars_KW.setText(jTbl_Car_INF.getValueAt(i, 12).toString());//Vehicle power

        jLblCarOwnedBy.setText("None");//Sets defaut state for ownership label

        try {
            //Gets car owner id name and family name
            Statement st = connct.createStatement();
            //SQL Query to get client id 
            ResultSet rs = st.executeQuery("SELECT * FROM `clients_cars_record` WHERE `Car_Reg_Num_cl` LIKE '" + jTxtFld_ClCars_REG.getText() + "' ORDER BY `Car_Reg_Num_cl` ASC");
            if (rs.next()) {
                String id = rs.getString("cl_Owner_car");//Gets clent
                //SQL Query to get cleitn name adn family name based on his id
                ResultSet rs1 = st.executeQuery("SELECT * FROM `clientdetails` WHERE `id` = " + id + " ORDER BY `id` ASC");
                if (rs1.next()) {
                    String name = rs1.getString("fname");//Gets cliet name
                    String fname = rs1.getString("lname");//Gets clietn family name
                    //sets label with Vehicle owner id name and family name
                    jLblCarOwnedBy.setText(id + " " + name + " " + fname);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
        }
    }

    public void clean() {
        //Clean textfields
        jTxtFld_ClCars_REG.setText("");
        jTxtFld_ClCars_VIN.setText("");
        jTxtFld_ClCars_Make.setText("");
        jTxtFld_ClCars_Model.setText("");
        jTxtFld_ClCars_Mileage.setText("");
        jTxtFld_ClCars_Type.setText("");
        jTxtFld_ClCars_Fueling.setText("");
        jTxtFld_ClCars_Gearbox.setText("");
        jTxtFld_ClCars_DRTrain.setText("");
        jTxtFld_ClCars_EngineCC.setText("");
        jTxtFld_ClCars_KW.setText("");
        jDateChooser1_dob1.setDate(null);
        jLblCarOwnedBy.setText("None");
    }

    public List<Cars_Db_clients> findAll(int page, int pageSize) {
        //Fill jtable paged
        List<Cars_Db_clients> listProduct = new ArrayList<Cars_Db_clients>();
        if (count() == 0) {
            return listProduct;
        }

        try {
            connct.setAutoCommit(false);
            preparedStatement = connct.prepareStatement("SELECT * FROM clients_cars_record limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();
            Cars_Db_clients cars_Db_clients;
            while (rs.next()) {

                cars_Db_clients = new Cars_Db_clients(rs.getString("Car_Reg_Num_cl"), rs.getString("Car_Vin_Num_cl"),
                        rs.getString("Car_Make_cl"), rs.getString("Car_Model_cl"), rs.getString("Car_Mileage_cl"),
                        rs.getString("Car_VehicleType_cl"), rs.getString("Car_FuelSys_cl"), rs.getString("Car_Gearbox_cl"),
                        rs.getString("Car_ManufactureDate_cl"), rs.getString("Car_Drivetrain_cl"), rs.getString("Car_EngineDisplacementl_cl"),
                        rs.getString("Car_Power_cl"), rs.getString("Car_DateTime_Created_cl"));
                listProduct.add(cars_Db_clients);

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
            preparedStatement = connct.prepareStatement("SELECT count(Car_Reg_Num_cl) from clients_cars_record");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                counter = rs.getInt("count(Car_Reg_Num_cl)");
            }
            connct.commit();
            connct.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return counter;
        }
    }

    public List<Cars_Db_clients> srchT(int page, int pageSize) {
        //Search with paging in SQL DB
        List<Cars_Db_clients> listProduct = new ArrayList<Cars_Db_clients>();

        //Combobox search order
        int b = jCmBoxOrder.getSelectedIndex();
        String sort = "";
        switch (b) {//Swithch for search by order
            case 0:
                sort = "ASC";//Ascending order
                break;
            case 1:
                sort = "DESC";//Descendin order
                break;

            default:
                sort = "ASC";//Defaut state for search order Ascending
                break;
        }

        //Combobox search item
        String test = "";
        int a = jCmBx_Srch.getSelectedIndex();
        switch (a) {//Switch for search item combobox states
            case 0:
                test = "Car_Vin_Num_cl";// VIN
                break;
            case 1:
                test = "Car_Reg_Num_cl";//Reg Number
                break;
            case 2:
                test = "Car_Make_cl";//Make
                break;
            case 3:
                test = "Car_Model_cl";//Model
                break;
            case 4:
                test = "Car_VehicleType_cl";//Type
                break;
            case 5:
                test = "Car_FuelSys_cl";//Fueling
                break;
            case 6:
                test = "Car_Gearbox_cl";//Gearbox
                break;
            case 7:
                test = "Car_EngineDisplacementl_cl";//Engine cc
                break;
            case 8:
                test = "Car_Power_cl";//Power
                break;
            default:
                test = "Car_Vin_Num_cl";//Defaut state
                break;
        }
        if (count() == 0) {
            return listProduct;
        }

        try {
            connct.setAutoCommit(false);
            String val = jTxtFld_ClCars_Srch.getText();
            //SQL Query DB
            preparedStatement = connct.prepareStatement("SELECT * FROM `clients_cars_record` WHERE " + test + " LIKE '%" + val + "%'  ORDER BY " + test + " " + sort + " limit ?,?");
            preparedStatement.setInt(1, pageSize * (page - 1));
            preparedStatement.setInt(2, pageSize);
            ResultSet rs = preparedStatement.executeQuery();
            Cars_Db_clients cars_Db_clients;
            while (rs.next()) {

                cars_Db_clients = new Cars_Db_clients(rs.getString("Car_Reg_Num_cl"), rs.getString("Car_Vin_Num_cl"),
                        rs.getString("Car_Make_cl"), rs.getString("Car_Model_cl"), rs.getString("Car_Mileage_cl"),
                        rs.getString("Car_VehicleType_cl"), rs.getString("Car_FuelSys_cl"), rs.getString("Car_Gearbox_cl"),
                        rs.getString("Car_ManufactureDate_cl"), rs.getString("Car_Drivetrain_cl"),
                        rs.getString("Car_EngineDisplacementl_cl"), rs.getString("Car_Power_cl"), rs.getString("Car_DateTime_Created_cl"));
                listProduct.add(cars_Db_clients);

            }
            connct.commit();
            connct.setAutoCommit(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            return listProduct;
        }
    }

    private void srch() {
        //page srch
        //Get all rows count for table in SQL for paging
        totalData = count();
        System.out.println(totalData);
        rowCountPerPage = Integer.valueOf(jComboBoxPage.getSelectedItem().toString());//Sets rows per page from combobox
        Double totalPageD = Math.ceil(totalData.doubleValue() / rowCountPerPage.doubleValue());
        totalPage = totalPageD.intValue();
        //Buttons for page navigation
        //Buttons  for firs next page 
        if (page.equals(1)) {
            jButtonFirst.setEnabled(false);
            jButtonPrevious.setEnabled(false);
        } else {
            jButtonFirst.setEnabled(true);
            jButtonPrevious.setEnabled(true);
        }
        // Buttons for Last Next Page
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
        //New instance for cars table model
        carsTableModel = new CarsTableModel();
        //
        carsTableModel.setList(srchT(page, rowCountPerPage));//Populates table
        //Set tabler model for cars 
        jTbl_Car_INF.setModel(carsTableModel);

        jLabelStatusHalaman.setText("Page " + page + " for " + totalPage);//Table page psoition
        jLabelTotalData.setText(("Row count " + totalData));//Table rows count
        //Resize table columns
        ResizeForJTables.autoResizeColumn(jTbl_Car_INF);
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
//        <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
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
//            java.util.logging.Logger.getLogger(JFrameClientCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameClientCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameClientCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameClientCars.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        </editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(() -> {
//            new JFrameClientCars().setVisible(true);
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtn_Bck;
    private javax.swing.JButton jBtn_Tbl_Add;
    private javax.swing.JButton jBtn_Tbl_Cln;
    private javax.swing.JButton jBtn_Tbl_DEL;
    private javax.swing.JButton jBtn_Tbl_Update;
    private javax.swing.JButton jButtonFirst;
    private javax.swing.JButton jButtonLast;
    private javax.swing.JButton jButtonNext;
    private javax.swing.JButton jButtonPrevious;
    private javax.swing.JComboBox<String> jCmBoxOrder;
    private javax.swing.JComboBox<String> jCmBx_Srch;
    private javax.swing.JComboBox jComboBoxPage;
    private com.toedter.calendar.JDateChooser jDateChooser1_dob1;
    private javax.swing.JLabel jLabelStatusHalaman;
    private javax.swing.JLabel jLabelTotalData;
    private javax.swing.JLabel jLabel_closeCarAdd;
    private javax.swing.JLabel jLabel_minimizeCarAdd;
    private javax.swing.JLabel jLblCarOwnedBy;
    private javax.swing.JLabel jLblOwner;
    private javax.swing.JLabel jLblPic;
    private javax.swing.JLabel jLblTopBarCarAdd;
    private javax.swing.JLabel jLbl_CarCC;
    private javax.swing.JLabel jLbl_CarDrTr;
    private javax.swing.JLabel jLbl_CarFueling;
    private javax.swing.JLabel jLbl_CarGearbox;
    private javax.swing.JLabel jLbl_CarKW;
    private javax.swing.JLabel jLbl_CarMileage;
    private javax.swing.JLabel jLbl_CarMnufDt;
    private javax.swing.JLabel jLbl_CarMod;
    private javax.swing.JLabel jLbl_CarNum;
    private javax.swing.JLabel jLbl_CarType;
    private javax.swing.JLabel jLbl_RegNum;
    private javax.swing.JLabel jLbl_SrchBy;
    private javax.swing.JLabel jLbl_VIN;
    private javax.swing.JPanel jPnlPaging;
    private javax.swing.JPanel jPnlTop;
    private javax.swing.JPanel jPnl_Client_Cars;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTbl_Car_INF;
    private javax.swing.JTextField jTxtFld_ClCars_DRTrain;
    private javax.swing.JTextField jTxtFld_ClCars_EngineCC;
    private javax.swing.JTextField jTxtFld_ClCars_Fueling;
    private javax.swing.JTextField jTxtFld_ClCars_Gearbox;
    private javax.swing.JTextField jTxtFld_ClCars_KW;
    private javax.swing.JTextField jTxtFld_ClCars_Make;
    private javax.swing.JTextField jTxtFld_ClCars_Mileage;
    private javax.swing.JTextField jTxtFld_ClCars_Model;
    private javax.swing.JTextField jTxtFld_ClCars_REG;
    private javax.swing.JTextField jTxtFld_ClCars_Srch;
    private javax.swing.JTextField jTxtFld_ClCars_Type;
    private javax.swing.JTextField jTxtFld_ClCars_VIN;
    // End of variables declaration//GEN-END:variables
}
