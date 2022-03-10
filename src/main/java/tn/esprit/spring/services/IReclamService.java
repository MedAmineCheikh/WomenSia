package tn.esprit.spring.services;
 

import java.sql.Date;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;

 
public interface IReclamService {

	List<Reclamation> retrieveAllReclamation();

	Reclamation addReclamation(Reclamation c);

	 void deleteReclamation(Integer id);
	
	 Reclamation updateReclamation(Reclamation c) ;
	 
	 Reclamation retrieveReclamation(Integer id);

	 void traiterReclam (Boolean bool ,Integer idrec) throws MessagingException ;

	void retrieveByDate(String datedeb,String datefin);

	void StatComplainer();


}