package com.model.table;

import base.Parts_serv;


import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cover Star
 */
public class PartsTableModel extends AbstractTableModel {
//Table model for parts table
    List<Parts_serv> listProduct = new ArrayList<Parts_serv>();
     //Header parameters
    private final String HEADER[] = {"#", "OEM", "Origin", "For Make", "For Model", "Part Make", "Supplier", "Cost", "Count", "Weight", "For System", "Description", "TAX", "Date added"};

    public void setList(List<Parts_serv> listProduct) {
        this.listProduct = listProduct;
    }

    public void save(Parts_serv product) {
        listProduct.add(product);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, Parts_serv product) {
        listProduct.set(index, product);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listProduct.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public Parts_serv findOne(int index) {
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
        Parts_serv product = listProduct.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;//Row number counter for the table

            case 1:
                return product.getOEMNum();//Part OEM Number

            case 2:
                return product.getOriginC();//Part origin 

            case 3:
                return product.getFMake();//Part for make 

            case 4:
                return product.getFModel();//Part for model

            case 5:
                return product.getPartMake();//Part make

            case 6:
                return product.getSupp();//Part supplier

            case 7:
                return product.getCst();//Part cost

            case 8:
                return product.getGCnt();//Part count

            case 9:
                return product.getWeight();//Part weight

            case 10:
                return product.getForSys();//Part for system

            case 11:
                return product.getDesc();//Part description

            case 12:
                return product.getVAT_T();//Part tax

            case 13:
                return product.getDateTimeSt();//Part timestamp added

           

            default:
                return null;//Defaut state null
        }
    }

    public void addRow(Object[] row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
