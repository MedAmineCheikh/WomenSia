package tn.esprit.spring.repository;
 

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;

@Repository
public interface ReclamRepository extends CrudRepository<Reclamation,Integer>,JpaRepository<Reclamation,Integer> {


	
	
	 @Query(value="SELECT COUNT( DISTINCT reclamation.email) FROM reclamation ", nativeQuery= true )
	public Integer getNbComplainer();	
	 
	 @Query(value="SELECT reclamation.type_reclamation , COUNT(reclamation.type_reclamation) FROM reclamation GROUP BY reclamation.type_reclamation ORDER BY COUNT(reclamation.type_reclamation) DESC LIMIT 1",nativeQuery= true)
	 public String getTypeReclamation();
	 @Query(value="SELECT reclamation.type_reclamation , COUNT(reclamation.type_reclamation) FROM reclamation GROUP BY reclamation.type_reclamation ORDER BY COUNT(reclamation.type_reclamation) ASC LIMIT 1",nativeQuery= true)
	 public String getTypeReclamation2();
	 
	 
	 @Query(value="SELECT  COUNT(reclamation.id_reclamation) FROM reclamation",nativeQuery= true)
	 public int getNbReclam();
	 
	 @Query(value="SELECT  COUNT(reclamation.id_reclamation) FROM reclamation WHERE reclamation.traité='Oui' ",nativeQuery= true)
	 public int getNbReclamtraited();
	
	 
	 
}


