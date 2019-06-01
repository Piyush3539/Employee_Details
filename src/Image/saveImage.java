package Image;
import java.sql.*;
import java.io.*;
import util.Sqlconnection;
public class saveImage 
{
        public static void main(String[] args) 
        {
                DB db = new DB();
              
                Connection conn=Sqlconnection.sqlGetConnection();
                db.insertImage(conn,"C://Users//P Verma//Desktop//IMG_20170124_123317_696.JPG");
                db.getImageData(conn);
        }
 
}
 
class DB
{
        public DB() {}
 
        public Connection dbConnect(String db_connect_string,
           String db_userid, String db_password)
        {
                try
                {
                        Class.forName("net.sourceforge.jtds.jdbc.Driver");
                        Connection conn = DriverManager.getConnection(
                          db_connect_string, db_userid, db_password);
 
                        System.out.println("connected");
                        return conn;
                         
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                        return null;
                }
        }
 
        public void insertImage(Connection conn,String img)
        {
                int len;
                String query;
                PreparedStatement pstmt;
                 
                try
                {
                        File file = new File(img);
                        FileInputStream fis = new FileInputStream(file);
                        len = (int)file.length();
 
                        query = ("insert into TableImage VALUES(?,?,?)");
                        pstmt = conn.prepareStatement(query);
                        pstmt.setString(1,file.getName());
                        pstmt.setInt(2, len);
   
                        // Method used to insert a stream of bytes
                        pstmt.setBinaryStream(3, fis, len); 
                        pstmt.executeUpdate();
 
                }
                catch (Exception e)
                {
                        e.printStackTrace();
                }
        }
 
        public void getImageData(Connection conn)
        {
                 
                 byte[] fileBytes;
                 String query;
                 try
                 {
                         query = "select data from tableimage";
                         Statement state = conn.createStatement();
                         ResultSet rs = state.executeQuery(query);
                         if (rs.next())
                        {
                                  fileBytes = rs.getBytes(1);
                                  OutputStream targetFile=  
                                  new FileOutputStream(
                                       "d://filepath//new.JPG");
 
                                  targetFile.write(fileBytes);
                                  targetFile.close();
                        }        
                         
                 }
                 catch (Exception e)
                 {
                         e.printStackTrace();
                 }
        }
};