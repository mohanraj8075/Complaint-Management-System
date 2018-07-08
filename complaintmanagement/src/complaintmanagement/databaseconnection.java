package complaintmanagement;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class databaseconnection 
{
    static Connection con;
    public static void getcon() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
        if(con==null)
        {
            FileInputStream fis;
            fis=new FileInputStream("configure.properties");
            Properties prp=new Properties();
            prp.load(fis);
            fis.close();
            Class.forName(prp.getProperty("driver"));
            con=(Connection) DriverManager.getConnection(prp.getProperty("url"),prp.getProperty("username"),"");
            if(con!=null)
            System.out.println("Connection to database established");
            
    }
}
    public static void closecon() throws SQLException
    {
        if(con==null)
            return;
        
        else
            con.close();
        con=null;
    }
}