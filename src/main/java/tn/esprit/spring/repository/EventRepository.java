package tn.esprit.spring.repository;
 

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Event;

@Repository
public interface EventRepository extends CrudRepository<Event,Integer>,JpaRepository<Event,Integer> {
	
	//@Query(value="SELECT (e.eventname) FROM event e, event_users ev WHERE e.id_event=ev.event_id_event  GROUP BY ev.event.id_event ORDER BY COUNT(ev.event.id_event) DESC LIMIT 1", nativeQuery= true)
	//public Integer getMostVisited();
 //SELECT event_users.event_id_event FROM event_users GROUP BY event_users.event_id_event ORDER BY COUNT(event_users.users_id_account) DESC LIMIT 

	@Query(value="SELECT event_users.event_id_event FROM event_users GROUP BY event_users.event_id_event ORDER BY COUNT(event_users.users_id_account) DESC LIMIT 1 ", nativeQuery= true)
	public Integer getMostVisited();
	
	@Query(value="SELECT event_users.event_id_event FROM event_users GROUP BY event_users.event_id_event ORDER BY COUNT(event_users.users_id_account) ASC LIMIT 1 ", nativeQuery= true)
	public Integer getLessVisited();
}
