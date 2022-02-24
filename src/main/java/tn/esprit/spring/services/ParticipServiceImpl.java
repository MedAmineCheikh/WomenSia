package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Particip_Donation;
import tn.esprit.spring.repository.ParticipDonRepository;
@Service
@Slf4j
public class ParticipServiceImpl implements IParticipService {
	
	@Autowired
	ParticipDonRepository pRepository;

	@Override
	public List<Particip_Donation> retrieveAllPart() {
		List<Particip_Donation> listpart= (List<Particip_Donation>) pRepository.findAll();
		for(Particip_Donation c:listpart)
		{
			log.info("Particip_Donation:" + c.getIdPoolPartDon()+ c.getAmount());
		}
		return listpart;
	}

	@Override
	public Particip_Donation addPart(Particip_Donation c) {
		pRepository.save(c);
		return c;
	}


	@Override
	public Particip_Donation retrievePart(Integer id) {
		Particip_Donation c= pRepository.findById(id).get();
		return c;
	}

}
