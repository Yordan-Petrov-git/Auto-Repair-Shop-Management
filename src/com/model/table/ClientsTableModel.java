
package com.model.table;


import base.User;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Cover Star
 */
public class ClientsTableModel extends AbstractTableModel {
//Table model for clients table
    List<User> listProduct = new ArrayList<User>();
     //Header parameters
    private final String HEADER[] = {"#", "ID", "Name", "Family Name", "Phone", "Phone 2","Email","Email 2"};

    public void setList(List<User> listProduct) {
        this.listProduct = listProduct;
    }

    public void save(User product) {
        listProduct.add(product);
        fireTableRowsInserted(getRowCount() - 1, getRowCount() - 1);
    }

    public void edit(int index, User product) {
        listProduct.set(index, product);
        fireTableRowsUpdated(index, index);
    }

    public void delete(int index) {
        listProduct.remove(index);
        fireTableRowsDeleted(index, index);
    }

    public User findOne(int index) {
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
        User product = listProduct.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return rowIndex + 1;//Row number counter for the table

            case 1:
                return product.getId();//Client ID

            case 2:
                return product.getFirstName();//Client first name           

            case 3:
                return product.getLastNAme();//Client last name

            case 4:
                return product.getAge();//Client primary phone number

            case 5:
                return product.getPhNumAlt();//Client secondary phone number

            case 6:
                return product.getMail();//Client primary email

            case 7:
                return product.getMailAlt();//Client secondary email

                
            
            default:
                return null;//Defaut state null
        }
    }

    public void addRow(Object[] row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
