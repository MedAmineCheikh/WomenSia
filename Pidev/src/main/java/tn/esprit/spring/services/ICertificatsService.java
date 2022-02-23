package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Certificats;

public interface ICertificatsService  {
	List<Certificats> retrieveAllCertificats();
	Certificats addCertificats(Certificats c);
	void deleteCertificats(Integer id);
	Certificats updateCertificats(Certificats c);
	Certificats retrieveCertificats(Integer id);
	void affecterCertificatToTraining(int idCer, int idTraining);

}
