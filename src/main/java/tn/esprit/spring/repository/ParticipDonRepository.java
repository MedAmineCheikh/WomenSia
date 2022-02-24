package tn.esprit.spring.repository;
 

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Particip_Donation;

@Repository
public interface ParticipDonRepository extends CrudRepository<Particip_Donation,Integer> {


}
