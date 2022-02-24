package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.repository.ReclamRepository;
@Service
@Slf4j
public class ReclamServiceImpl implements IReclamService {
	
	@Autowired
	ReclamRepository rRepository;

	@Override
	public List<Reclamation> retrieveAllReclamation() {
		List<Reclamation> listReclamation= (List<Reclamation>) rRepository.findAll();
		for(Reclamation c:listReclamation)
		{
			log.info("Reclamation:" + c.getNomReclamation()+ c.getTypeReclamation());
		}
		return listReclamation;
	}

	@Override
	public Reclamation addReclamation(Reclamation c) {
		rRepository.save(c);
		return c;
	}

	@Override
	public void deleteReclamation(Integer id) {
		rRepository.deleteById(id);

	}

	@Override
	public Reclamation updateReclamation(Reclamation c) {
		rRepository.save(c);
		return c;
	}

	@Override
	public Reclamation retrieveReclamation(Integer id) {
		Reclamation c= rRepository.findById(id).get();
		return c;
	}

}
 