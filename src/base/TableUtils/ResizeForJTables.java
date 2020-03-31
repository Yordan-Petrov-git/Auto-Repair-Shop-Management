/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base.TableUtils;

import java.util.Enumeration;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

/**
 *Method for automatic resizing of table columns
 * @author 0896
 */
public class ResizeForJTables {
    
     public static void autoResizeColumn(JTable jTable1) {
        //Autoresizing method for tables
        JTableHeader header = jTable1.getTableHeader();//Gets table header
        int rowCount = jTable1.getRowCount();//Gets row count

        final Enumeration columns = jTable1.getColumnModel().getColumns();//Gets the model of the columns
        while (columns.hasMoreElements()) {
            TableColumn column = (TableColumn) columns.nextElement();
            int col = header.getColumnModel().getColumnIndex(column.getIdentifier());
            int width = (int) jTable1.getTableHeader().getDefaultRenderer()
                    .getTableCellRendererComponent(jTable1, column.getIdentifier(), false, false, -1, col).getPreferredSize().getWidth();

            for (int row = 0; row < rowCount; row++) {
                int preferedWidth = (int) jTable1.getCellRenderer(row, col).getTableCellRendererComponent(jTable1,
                        jTable1.getValueAt(row, col), false, false, row, col).getPreferredSize().getWidth();
                width = Math.max(width, preferedWidth);
            }
            header.setResizingColumn(column); // this line is very important
            column.setWidth(width + jTable1.getIntercellSpacing().width);
        }
    }
    
}
