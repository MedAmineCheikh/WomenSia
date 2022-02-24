package tn.esprit.spring.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Sponsors;
import tn.esprit.spring.repository.SponsorRepository;
@Service
@Slf4j
public class SponsorServiceImpl implements ISponsorService {
	
	@Autowired
	SponsorRepository sRepository;

	@Override
	public List<Sponsors> retrieveAllSponsors() {
		List<Sponsors> listSponsors= (List<Sponsors>) sRepository.findAll();
		/*for(Sponsors c:listSponsors)
		{
			log.info("Sponsors:" + c.getIdSponsor()+ c.getName_Spons());
		}*/
		return listSponsors;
	}

	@Override
	public Sponsors addSponsors(Sponsors c) {
		sRepository.save(c);
		return c;
	}

	@Override
	public void deleteSponsors(Integer id) {
		sRepository.deleteById(id);

	}

	@Override
	public Sponsors updateSponsors(Sponsors c) {
		sRepository.save(c);
		return c;
	}

	@Override
	public Sponsors retrieveSponsors(Integer id) {
		Sponsors c= sRepository.findById(id).get();
		return c;
	}

}
