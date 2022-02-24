package tn.esprit.spring.repository;
 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Pool;

@Repository
public interface PoolRepository extends CrudRepository<Pool,Integer> {


}
