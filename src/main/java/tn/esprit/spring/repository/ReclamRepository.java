package tn.esprit.spring.repository;
 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reclamation;

@Repository
public interface ReclamRepository extends CrudRepository<Reclamation,Integer> {


}
