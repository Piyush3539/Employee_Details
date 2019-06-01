package Pdf;

import Bean.Employeedetailsbean;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Document;
import java.awt.Font;
import java.io.FileOutputStream;
import java.util.Date;

public class Pdfgeneration 
{
  public String FilePath="D:\\Employee.PDF";
   public void pdf(Employeedetailsbean b){
   try{
           Document myDocument = new Document();
            PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(FilePath));
           myDocument.open();           
           myDocument.add(new Paragraph(new Date().toString()));
           myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
            myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
           myDocument.add((new Paragraph("EMPLOYEE DETAILS",FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.BOLD))));
           myDocument.add((new Paragraph("Name of Employee: " +b.getName() + FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.PLAIN))));
           myDocument.add((new Paragraph("Email: "+b.getEmail(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.PLAIN))));
           myDocument.add((new Paragraph("Address: "+b.getAddress(),FontFactory.getFont(FontFactory.TIMES_ROMAN,15,Font.PLAIN))));
            myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
             myDocument.add(new Paragraph("-------------------------------------------------------------------------------------------"));
   myDocument.newPage();
   myDocument.close();
   b.setLoacation(FilePath);
   SendEmail.SendMail.Sendemail(b);
   }
   catch(Exception e)
   {
       System.out.println(e);
   }
         }
}
