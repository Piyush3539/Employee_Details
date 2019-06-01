package SendEmail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import Bean.Employeedetailsbean;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

public class SendMail {

    public static void Sendemail(Employeedetailsbean b) {
        String FilePath="F:\\Employee.PDF";
        
        
        final String username = "pverma3539@gmail.com";
        final String password = "march1996";
        
        Properties props = new Properties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
          });
        
try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("pverma3539@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("pverma3539@gmail.com"));
            message.setSubject("Employee Details");
            message.setText("Dear Employee,"
               + "\n\n you have successfully login into your account");
//               +"\n\n your details are as follows--------,"
//               + " \n\n Name : " +b.getName()
//               + " \n\n Email : "+b.getEmail()
//                + " \n\n Address : "+b.getAddress()
//                + "\n\n Gender : "+b.getGender()
//                + "\n\n Salary : "+b.getSalary());



        //Program to send email with pdf attached in it.......
            DataSource source=new FileDataSource(FilePath);
            message.setDataHandler(new DataHandler(source));
            message.setFileName(b.getName()+".pdf");//name of pdf with the name of employee....
            
            
            



            Transport.send(message);
            JOptionPane.showMessageDialog(null, "Details Submitted Successful");
            

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
  
}