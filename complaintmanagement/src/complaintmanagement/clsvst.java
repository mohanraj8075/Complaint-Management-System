
package complaintmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class clsvst
{
public void insert_vst(clsvstprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call insvst(?,?,?,?)}");
    stm.setDate(1,p.getVstdat());
    stm.setInt(2, p.getVstcmpcod());
    stm.setString(3,p.getVstdsc());
    stm.setInt(4,p.getVstfed());
    stm.execute();
    databaseconnection.closecon();
}

public ArrayList<clsvstprp> display_vst() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call disvst()}");
    ResultSet rs=stm.executeQuery();
    ArrayList<clsvstprp> k=new ArrayList<clsvstprp>();
    
    while(rs.next())
    {
    clsvstprp p=new clsvstprp();
    p.setVstcod(rs.getInt("vstcod"));
    p.setVstdat(rs.getDate("vstdat"));
    p.setVstcmpcod(rs.getInt("vstcmpcod"));
    p.setVstdsc(rs.getString("vstdsc"));
    p.setVstfed(rs.getInt("vstfed"));
    k.add(p);
    }
    databaseconnection.closecon();
    return k;
    
}

public clsvstprp find_vst(int eno) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    clsvstprp p=new clsvstprp();
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call findvst(?)}");
    stm.setInt(1,eno);
    ResultSet rs=stm.executeQuery();
    if(rs.next())
    {
        p.setVstcod(rs.getInt("vstcod"));
        p.setVstdat(rs.getDate("vstdat"));
        p.setVstcmpcod(rs.getInt("vstcmpcod"));
        p.setVstdsc(rs.getString("vstdsc"));
        p.setVstfed(rs.getInt("vstfed"));
    }
    databaseconnection.closecon();
    return p;
}
public void update_vst(clsvstprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call updvst(?,?,?,?,?)}");
    stm.setInt(1, p.getVstcod());
    stm.setDate(2, p.getVstdat());
    stm.setInt(3, p.getVstcmpcod());
    stm.setString(4, p.getVstdsc());
    stm.setInt(5,p.getVstfed());
    stm.execute();
    databaseconnection.closecon();
}
public void delete_vst(clsvstprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call delvst(?)}");
    stm.setInt(1, p.getVstcod());
    stm.execute();
    databaseconnection.closecon();
    
}
}
