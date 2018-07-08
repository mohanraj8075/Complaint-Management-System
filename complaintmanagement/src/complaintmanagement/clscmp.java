

package complaintmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;



public class clscmp
{
    public void insert_cmp(clscmpprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call inscmp(?,?,?,?,?)}");
        stm.setInt(1,p.getCmpaccno());
        stm.setDate(2, p.getCmpdat());
        stm.setString(3, p.getCmpdsc());
        stm.setInt(4, p.getCmpasgempcod());
        stm.setString(5,p.getCmpsts());
        
        
        
    stm.execute();
    databaseconnection.closecon();
    
    }
    
    public ArrayList<clscmpprp> display_cmp() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call discmp()}");
    ResultSet rs=stm.executeQuery();
    ArrayList<clscmpprp> k=new ArrayList<clscmpprp>();
    while(rs.next())
    {
  clscmpprp p=new clscmpprp();
  p.setCmpcod(rs.getInt("cmpcod"));
  p.setCmpaccno(rs.getInt("cmpaccno"));
  p.setCmpdat(rs.getDate("cmpdat"));
  p.setCmpdsc(rs.getString("Mpdsc"));
  p.setCmpasgempcod(rs.getInt("cmpasgempcod"));
  p.setCmpsts(rs.getString("cmpsts"));
  k.add(p);
  
    }
    databaseconnection.closecon();
    return k;
    }
    
    public clscmpprp find_cmp(int eno) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        clscmpprp p=new clscmpprp();
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call findcmp(?)}");
        stm.setInt(1,eno);
        ResultSet rs=stm.executeQuery();
        if(rs.next())
        {
            p.setCmpcod(rs.getInt("cmpcod"));
            p.setCmpaccno(rs.getInt("cmpaccno"));
            p.setCmpdat(rs.getDate("cmpdat"));
            p.setCmpdsc(rs.getString("cmpdsc"));
            p.setCmpasgempcod(rs.getInt("cmpasgempcod"));
            p.setCmpsts(rs.getString("cmpsts"));
            
        }
        databaseconnection.closecon();
        return p;
    }
    public void update_cmp(clscmpprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call updcmp(?,?)}");
        stm.setInt(1,p.getCmpcod());
        stm.setString(2, p.getCmpsts());
        stm.execute();
        databaseconnection.closecon();
    }
    public void delete_cmp(clscmpprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
    {
        databaseconnection.getcon();
        CallableStatement stm=databaseconnection.con.prepareCall("{call delcmp(?)}");
        stm.setInt(1,p.getCmpcod());
        stm.execute();
        databaseconnection.closecon();
    }
    
}
