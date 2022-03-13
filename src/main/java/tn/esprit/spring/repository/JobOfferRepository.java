package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.Job_Offer;

@Repository
public interface JobOfferRepository extends JpaRepository<Job_Offer,Integer> {
}
