package tn.esprit.spring.services;
 

import java.util.List;

import tn.esprit.spring.entities.Sponsors;


public interface ISponsorService {

	List<Sponsors> retrieveAllSponsors();

	Sponsors addSponsors(Sponsors c);

	void deleteSponsors(Integer id);

	Sponsors updateSponsors(Sponsors c);

	Sponsors retrieveSponsors(Integer id);

}