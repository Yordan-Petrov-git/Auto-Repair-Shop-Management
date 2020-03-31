package com.model.table;

import base.Cars_Db_clients;



import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cover Star
 */
public class CarsTableModel extends AbstractTableModel {
  //Table model for cars table
    List<Cars_Db_clients> listProduct = new ArrayList<Cars_Db_clients>();
     //Header parameters
    private final String HEADER[] = {"#", "Registratin", "VIN", "Make", "Model", "Mileage", "Type", "Fueling", "Gearbox", "Manufacture date", "Drivetrain", "Engince CC", "Power", "Date added"};

    public void setList(List<Cars_Db_clients> listProduct) {
        this.listProduct = listProduct;
    }

    public void save(Cars_Db_clients product) {
        listProduct.add(product);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, Cars_Db_clients product) {
        listProduct.set(index, product);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listProduct.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Cars_Db_clients findOne(int index) {
        return listProduct.get(index);
    }

    public int getRowCount() {
        return listProduct.size();
    }

    public int getColumnCount() {
        return HEADER.length;
    }

    public String getColumnName(int column) {
        return HEADER[column];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Cars_Db_clients product = listProduct.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;//Row number counter for the table

            case 1:
                return product.getregNum();//Vehicle registration number

            case 2:
                return product.getVIN();//Vehicle VIN number

            case 3:
                return product.getMake();//Vehicle make

            case 4:
                return product.getModel();//Vehicle model

            case 5:
                return product.getMileage();//Vehicle mmileage

            case 6:
                return product.getType();//Vehicle type

            case 7:
                return product.getFueling();//Vehicle fueling 

            case 8:
                return product.getGearbox();//Vehicle gearbox

            case 9:
                return product.getManDt();//Vehicle manufacture date

            case 10:
                return product.getDrivtrn();//Vehicle drivetrain

            case 11:
                return product.getCC();//Vehicle engine diplacement

            case 12:
                return product.getKW();//Vehicle power output

            case 13:
                return product.getDateTimeCre();//Vehicle entry timestamp added
         
                

            default:
                return null;//Defaut state null
        }
    }

    public void addRow(Object[] row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
