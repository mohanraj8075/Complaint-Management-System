
package complaintmanagement;

import static complaintmanagement.databaseconnection.con;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class clsacc
{
    public void insert_acc(clsaccprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call insacc(?,?,?,?,?,?)}");
        stm.setString(1,p.getAccnam());
        stm.setDate(2, p.getAccrtdat());
        stm.setString(3, p.getAccadd());
        stm.setString(4,p.getAccloc());
        stm.setString(5,p.getAccphnno());
        stm.setString(6, p.getAcctyp());
       stm.execute();
       databaseconnection.closecon();
    }
    
    public ArrayList<clsaccprp> display_acc() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call disacc()}");
        ResultSet rs=stm.executeQuery();
        ArrayList<clsaccprp> k=new ArrayList<clsaccprp>();
        while(rs.next())
        {
            clsaccprp p=new clsaccprp();
            p.setAccno(rs.getInt("accno"));
            p.setAccnam(rs.getString("accnam"));
            p.setAccrtdat(rs.getDate("accrtdat"));
            p.setAccadd(rs.getString("accadd"));
            p.setAccloc(rs.getString("accloc"));
            p.setAccphnno(rs.getString("accphnno"));
            p.setAcctyp(rs.getString("acctyp"));
            k.add(p);
            
        }
        databaseconnection.closecon();
        return k;
        
    }
    public clsaccprp find_acc(int ano) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        clsaccprp p=new clsaccprp();
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call findacc(?)}");
        stm.setInt(1,ano);
        ResultSet rs=stm.executeQuery();
        if(rs.next())
        {
            p.setAccno(rs.getInt("accno"));
            p.setAccnam(rs.getString("accnam"));
            p.setAccrtdat(rs.getDate("accrtdat"));
            p.setAccadd(rs.getString("accadd"));
            p.setAccloc(rs.getString("accloc"));
            p.setAccphnno(rs.getString("accphnno"));
            p.setAcctyp(rs.getString("acctyp"));
        }
        databaseconnection.closecon();
        return p;
    }
    
    public void update_acc(clsaccprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call updacc(?,?,?,?,?,?,?)}");
        stm.setInt(1,p.getAccno());
        stm.setString(2, p.getAccnam());
        stm.setDate(3, p.getAccrtdat());
        stm.setString(4, p.getAccadd());
        stm.setString(5, p.getAccloc());
        stm.setString(6, p.getAccphnno());
        stm.setString(7, p.getAcctyp());
        stm.execute();
        databaseconnection.closecon();
    }
    
    public void delete_acc(clsaccprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call delacc(?)}");
        stm.setInt(1, p.getAccno());
        stm.execute();
        databaseconnection.closecon();
        
    }    
    
}

