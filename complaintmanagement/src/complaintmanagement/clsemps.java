
package complaintmanagement;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class clsemps
{
public void insert_emps(clsempsprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call insemps(?,?,?,?)}");
    stm.setString(1,p.getEmpname());
    stm.setString(2, p.getEmppic());
    stm.setString(3, p.getEmploc());
    stm.setString(4, p.getEmpphnno());
    stm.execute();
    databaseconnection.closecon();
}

public ArrayList<clsempsprp> display_emps() throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call disemps()}");
    ResultSet rs=stm.executeQuery();
    ArrayList<clsempsprp> k=new ArrayList<clsempsprp>();
    while(rs.next())
    {
        clsempsprp p=new clsempsprp();
        p.setEmpcod(rs.getInt("empcod"));
        p.setEmpname(rs.getString("empname"));
        p.setEmppic(rs.getString("emppic"));
        p.setEmploc(rs.getString("emploc"));
        p.setEmpphnno(rs.getString("empphnno"));
        k.add(p);
    }
    databaseconnection.closecon();
    return k;
    
}

public clsempsprp find_emps(int eno) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    clsempsprp p=new clsempsprp();
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call findemps(?)}");
    stm.setInt(1,eno);
    ResultSet rs=stm.executeQuery();
    if(rs.next())
    {
        p.setEmpcod(rs.getInt("empcod"));
        p.setEmpname(rs.getString("empname"));
        p.setEmppic(rs.getString("emppic"));
        p.setEmploc(rs.getString("emploc"));
        p.setEmpphnno(rs.getString("empphnno"));
    }
    databaseconnection.closecon();
    return p;
}
public void update_emps(clsempsprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call updemps(?,?,?,?,?)}");
    stm.setInt(1, p.getEmpcod());
    stm.setString(2, p.getEmpname());
    stm.setString(3,p.getEmppic());
    stm.setString(4,p.getEmploc());
    stm.setString(5, p.getEmpphnno());
    stm.execute();
    databaseconnection.closecon();
}
     public void delete_emps(clsempsprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
     {
         databaseconnection.getcon();
         CallableStatement stm=databaseconnection.con.prepareCall("{call delemps(?)}");
         stm.setInt(1,p.getEmpcod());
         stm.execute();
         databaseconnection.closecon();
     }
        
public ArrayList<clsempsprp> dsempbyloc(String loc) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
{
    databaseconnection.getcon();
    CallableStatement stm=databaseconnection.con.prepareCall("{call dsempbyloc(?)}");
    stm.setString(1,loc);
    ResultSet rs=stm.executeQuery();
    ArrayList<clsempsprp> k=new ArrayList<clsempsprp>();
    while(rs.next())
    {
        clsempsprp p=new clsempsprp();
        p.setEmpcod(rs.getInt("empcod"));
        p.setEmpname(rs.getString("empname"));
        p.setEmppic(rs.getString("emppic"));
        p.setEmploc(rs.getString("emploc"));
        p.setEmpphnno(rs.getString("empphnno"));
        k.add(p);
    }
    databaseconnection.closecon();
    return k;
    
}        
        
        
}
