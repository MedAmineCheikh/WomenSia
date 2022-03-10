package tn.esprit.spring.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
public class PDFGeneratorService {
	 
    public  void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        document.add(Image.getInstance("PI-DOUBLEU/273676056_105321595411989_8296886164647848980_n.png"));
        Paragraph p = new Paragraph();
        p.add("INVITATION CONFIRMEE");
        p.setAlignment(Element.ALIGN_CENTER);
        document.add(p);
        Paragraph p2 = new Paragraph();
        p2.add("Bonjour MOHAMED RAHMOUNI ,c'est avec un grand plaisir que nous vous confirmons la tenue de votre évènement SOLIDARITY qui aura lieu à l'Ariana  le 2022-03-30 à 13:00 . "); 
        document.add(p2);
        Font f = new Font();
        f.setStyle(Font.BOLD);
        f.setSize(8);
        document.add(new Paragraph("This is my paragraph 3", f));
        
        document.close();
       
        
 
}}