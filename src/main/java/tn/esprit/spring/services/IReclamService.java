package tn.esprit.spring.services;
 

import java.util.List;

import tn.esprit.spring.entities.Reclamation;


public interface IReclamService {

	List<Reclamation> retrieveAllReclamation();

	Reclamation addReclamation(Reclamation c);

	 void deleteReclamation(Integer id);
	
	 Reclamation updateReclamation(Reclamation c) ;
	 
	 Reclamation retrieveReclamation(Integer id);

}