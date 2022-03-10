package tn.esprit.spring.services;
 


import java.io.IOException;
 

import javax.mail.MessagingException;
 
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
 
import org.springframework.stereotype.Service;

import com.google.zxing.WriterException;
 
import tn.esprit.spring.entities.Event;
 
 
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.services.QRCodeGenerator;
import tn.esprit.spring.services.JavaMailSenderImpl;

@Service
 
public class UserServiceImpl implements IUserService {
	
 
	@Autowired
	JavaMailSenderImpl e;
	@Autowired
	EventRepository eventRepository;
 
	@Autowired
	UserRepository uRepository ;
	


public void ParticipEvent(Integer IdAccount ,Integer IdEvent) throws WriterException, IOException, MessagingException  
{
	
	User u= uRepository.findById(IdAccount).get();
	Event event = eventRepository.findById(IdEvent).get();
	HttpServletResponse response;
	
	{
		String Msg=" Nous vous confirmons à travers ce message votre presence à l'event";
		String Msg1 ="qui aura lieu ";
		
		String Data=u.getNom()+" " +u.getPrenom()+" "+Msg+" "+event.getEventname()+" "+"Msg1"+" "+event.getDateEvent();
		
		final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCd.png";
	 
	    QRCodeGenerator.generateQRCodeImage(Data, 350, 350, QR_CODE_IMAGE_PATH);
		
	event.getUsers().add(u);
	eventRepository.save(event);
String to="mohamed.s.rahmouni@gmail.com";
String sub="This is Email Body with Attachment...";
String att="This email has attachment";
String chem="C:\\\\Users\\\\moham\\\\Desktop\\\\PI-DOUBLEU\\\\src\\\\main\\\\resources\\\\QRCd.png";
  
	//JavaMailSenderImpl sender =new JavaMailSenderImpl();
	//   sender.sendSimpleEmail(to,sub,att);
	   //sendEmailWithAttachment(to,sub,att,chem);
	e.sendEmailWithAttachment(to, sub, att, chem);

	}
	}
}
	






