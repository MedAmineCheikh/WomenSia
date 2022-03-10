package tn.esprit.spring.services;
 

import java.sql.SQLException;
import java.util.List;

import tn.esprit.spring.entities.Pool;


public interface IPoolService {

	List<Pool> retrieveAllPool();

	Pool addPool(Pool c);

	void deletePool(Integer id);

	Pool updatePool(Pool c);

	Pool retrievePool(Integer id);

	void ManagePool(Integer id, boolean test);
 

	void Donate(Integer iduser, Integer idPool, Integer Montant, String AccountNumber, String ccv) throws SQLException;


}
 