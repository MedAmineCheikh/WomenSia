package tn.esprit.spring.services;
 

import java.util.List;

import tn.esprit.spring.entities.Particip_Donation;
 


public interface IParticipService {

	List <Particip_Donation> retrieveAllPart();

	Particip_Donation addPart(Particip_Donation c);

	Particip_Donation retrievePart(Integer id);
}