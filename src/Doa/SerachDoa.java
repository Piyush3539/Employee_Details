package Doa;

import Bean.Employeedetailsbean;
import Search.Searchempl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import util.Sqlconnection;


public class SerachDoa {
    
   public static Employeedetailsbean Sreach(String name)
    {
        Bean.Employeedetailsbean b=new Employeedetailsbean();
         Connection con=Sqlconnection.sqlGetConnection();
        try {
            PreparedStatement ps= con.prepareStatement("select*from employeedetails where name =(?)");
            ps.setString(1,name);
            ResultSet rs = ps.executeQuery();//----------contains rows of table (metedata)... 
            while(rs.next())//moving from metedata to table data.
            {
             b.setName(rs.getString("name")); 
             b.setEmail(rs.getString("email"));
             b.setAddress(rs.getString("address"));
             }
   
        } catch (SQLException ex) {
            Logger.getLogger(Searchempl.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return b;
    }
    
}
