package Doa;
import  Bean.Employeedetailsbean;
import util.Sqlconnection;
import java.sql.*;
import Pdf.Pdfgeneration;
public class Addemployee 
{
    public static void addEmp(Employeedetailsbean b) throws SQLException
    {
     try
     {
      Connection con=Sqlconnection.sqlGetConnection();
      PreparedStatement ps= con.prepareStatement("insert into employeedetails values(?,?,?,?,?)");
      ps.setString(1,b.getName());
      ps.setString(2,b.getEmail());
      ps.setString(3,b.getAddress());
      ps.setString(4,b.getGender());
      ps.setInt(5,b.getSalary());
      ps.execute();
     }
      catch(Exception e)
      {
      System.out.println(e);
      }
     Pdfgeneration p=new Pdfgeneration();
     p.pdf(b);
     
    }
    
    
}
