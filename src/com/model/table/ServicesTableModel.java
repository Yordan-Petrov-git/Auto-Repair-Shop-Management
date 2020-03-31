package com.model.table;


import base.RepairsService;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cover Star
 */
public class ServicesTableModel extends AbstractTableModel {
//Table model for services table
    List<RepairsService> listProduct = new ArrayList<RepairsService>();
    //Header parameters
    private final String HEADER[] = {"#", "ID", "Employee", "Type", "Descrioption", "Vehicle Id", "ClientI d", "OEM number", "Data created", "Price", "TAX", "Discount", "Time"};

    public void setList(List<RepairsService> listProduct) {
        this.listProduct = listProduct;
    }

    public void save(RepairsService product) {
        listProduct.add(product);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, RepairsService product) {
        listProduct.set(index, product);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listProduct.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public RepairsService findOne(int index) {
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
        RepairsService product = listProduct.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;//Row number counter for the table

            case 1:
                return product.getIdSrvc();//Service ID number

            case 2:
                return product.getWorkerSrvc();//Worker names and id

            case 3:
                return product.getTypeSrvc();//Service type

            case 4:
                return product.getdescSrvc();//Service description

            case 5:
                return product.getCarIdSrvc();//Vehicle Registration number

            case 6:
                return product.getClientIdSrvc();//Client ID and name

            case 7:
                return product.getPartOEMSrvc();//Part used in service OEM number

            case 8:
                return product.getTimeStmpSrvc();//Date time entry created

            case 9:
                return product.getPriveSrvc();//Service price

            case 10:
                return product.getVatSrvc();//Service tax

            case 11:
                return product.getDiscountSrvc();//Service discount
                
            case 12:
                return product.gettimeSrvc();//Service Duration

                
                
            default:
                return null;//Defaut state null
        }
    }

    public void addRow(Object[] row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
