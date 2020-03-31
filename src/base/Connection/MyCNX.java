package base.Connection;


import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class MyCNX {
//Conenction class login
    private static final String servername = "localhost";//SQL DB name of the server
    private static final String username = "root";//SQL DB  username
    private static final String dbname = "service";//SQL Database name
    private static final Integer portnumber = 3306;//SQL DB server port number //Defaut port number XAMPP APACHE SERVER
    //private static final String password = "9B4P3bFEg6UW5erc";//SQL DB server user login password
 
    

    public static Connection getConnection() {
      //SQL DB connection method
        Connection cnx = null;

        MysqlDataSource datasource = new MysqlDataSource();

        datasource.setServerName(servername);
        datasource.setUser(username);
        datasource.setDatabaseName(dbname);
        datasource.setPortNumber(portnumber);
        //datasource.setPassword(password);


        try {
            cnx = datasource.getConnection();
           
            System.out.println(cnx);//for testing
            
        } catch (SQLException ex) {//if connection fails 
            Logger.getLogger(" Get Connection -> " + MyCNX.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error : " + ex);
        } finally {

        }

        return cnx;

    }

}
