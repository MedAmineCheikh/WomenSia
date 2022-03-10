package tn.esprit.spring.services;

import java.io.IOException;

import javax.mail.MessagingException;
 

import com.google.zxing.WriterException;

public interface IUserService {

	
	  void ParticipEvent(Integer id ,Integer ide ) throws WriterException, IOException, MessagingException;
	 
}
