package tn.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Pool;
import tn.esprit.spring.repository.PoolRepository;
@Service
@Slf4j
public class PoolServiceImpl implements IPoolService {
	
	@Autowired
	PoolRepository pRepository;

	@Override
	public List<Pool> retrieveAllPool() {
		List<Pool> listPool= (List<Pool>) pRepository.findAll();
		for(Pool c:listPool)
		{
			log.info("Pool:" + c.getNamePool()+ c.getNbDonateur());
		}
		return listPool;
	}

	@Override
	public Pool addPool(Pool c) {
		pRepository.save(c);
		return c;
	}

	@Override
	public void deletePool(Integer id) {
		pRepository.deleteById(id);

	}

	@Override
	public Pool updatePool(Pool c) {
		pRepository.save(c);
		return c;
	}

	@Override
	public Pool retrievePool(Integer id) {
		Pool c= pRepository.findById(id).get();
		return c;
	}

}
