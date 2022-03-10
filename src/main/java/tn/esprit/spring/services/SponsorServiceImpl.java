package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.services.ISponsorService;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Sponsors;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.SponsorRepository;
@Service
 public class SponsorServiceImpl implements ISponsorService {
	
	@Autowired
	SponsorRepository sRepository;
	@Autowired
	EventRepository eRepository; 

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
	
	@Override
	public void affectSponsEvent(int idSponsor,int idEvent ) {
		Sponsors s= sRepository.findById(idSponsor).get();
		Event event = eRepository.findById(idEvent).get();
		event.getSponsors().add(s);
		eRepository.save(event);
	}

}
