package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Certificats;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.Certificats;
import tn.esprit.spring.repository.CertificatsRepository;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.entities.Certificats;
@Service
public class CertificatsServiceImpl implements ICertificatsService {

	@Autowired
	CertificatsRepository certificatsRepository;
	@Autowired
	TrainingRepository trainingRepository;
	@Override
	public List<Certificats> retrieveAllCertificats() {
		// TODO Auto-generated method stub
		return (List<Certificats>)certificatsRepository.findAll();
	}

	@Override
	public Certificats addCertificats(Certificats c) {
		// TODO Auto-generated method stub
		return certificatsRepository.save(c);
	}

	@Override
	public void deleteCertificats(Integer id) {
		// TODO Auto-generated method stub
		certificatsRepository.deleteById(id);;
		
	}

	@Override
	public Certificats updateCertificats(Certificats c) {
		// TODO Auto-generated method stub
		return certificatsRepository.save(c);
	}

	@Override
	public Certificats retrieveCertificats(Integer id) {
		// TODO Auto-generated method stub
		Certificats c=certificatsRepository.findById(id).get();
		return c;
	}
	public void affecterCertificatToTraining(int idCer, int idTraining) {
		Certificats certificat = certificatsRepository.findById(idCer).orElse(null);
		Training training = trainingRepository.findById(idTraining).orElse(null);
		training.setCertificats(certificat);
		trainingRepository.save(training);
		

	}

}
	