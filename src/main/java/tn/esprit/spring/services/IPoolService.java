package tn.esprit.spring.services;
 

import java.util.List;

import tn.esprit.spring.entities.Pool;


public interface IPoolService {

	List<Pool> retrieveAllPool();

	Pool addPool(Pool c);

	void deletePool(Integer id);

	Pool updatePool(Pool c);

	Pool retrievePool(Integer id);

}
 