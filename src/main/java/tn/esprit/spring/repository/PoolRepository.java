package tn.esprit.spring.repository;
 

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Pool;

@Repository
public interface PoolRepository extends CrudRepository<Pool,Integer> {
	@Query(value="SELECT sum FROM pool ", nativeQuery= true)
	public Integer getsumpool();
	
	@Query(value="SELECT nb_donateur FROM pool ", nativeQuery= true)
	public Integer getnbdon();
	@Query(value=" UPDATE pool SET nb_donateur=2,sum=21 WHERE id_pool=1 ", nativeQuery= true)
	public void update();
	 

}
