package tn.esprit.spring.repository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Reclamation;
import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>,JpaRepository<User,Integer>  {
	
	 @Query(value="SELECT COUNT(user.id_acccount) FROM user ", nativeQuery= true )
		public Integer getNbUser();

}
