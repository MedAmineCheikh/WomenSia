 package tn.esprit.spring.services;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
 
import tn.esprit.spring.repository.EventRepository;
 
import tn.esprit.spring.repository.UserRepository;
 
@Service
@Slf4j
public class EventServiceImpl implements IEventService {
	
	@Autowired
	EventRepository eventRepository;

	@Autowired
	UserRepository uRepository ;

	@Override
	public List<Event> retrieveAllEvents() {
		List<Event> listEvent= (List<Event>) eventRepository.findAll();
		/*for(Event c:listEvent)
		{
			log.info("Event:" + c.getEventname()+ c.getDateEvent());
		}*/
		return listEvent;
	}

	@Override
	public Event addEvent(Event c) {
		eventRepository.save(c);
		return c;
	}

	@Override
	public void deleteEvent(Integer id) {
		eventRepository.deleteById(id);

	}

	@Override
	public Event updateEvent(Event c) {
		eventRepository.save(c);
		return c;
	}

	@Override
	public Event retrieveEvent(Integer id) {
		Event c= eventRepository.findById(id).get();
		return c;
	}
	
	/*@Override 
	public Event getMostVisitedEvent() {
		int event_id = eventRepository.getMostVisited();
		Event event = eventRepository.findById(event_id).get();
		log.info("the most visited event is : "+event.getEventname()+" "+event.getDescription()+".");
		return event;
	};*/
	
	@Override 
	public void getMostVisitedEvent() {
		int event_id = eventRepository.getMostVisited();
		Event event = eventRepository.findById(event_id).get();
		log.info("the most visited event is : "+event.getEventname()+" "+event.getDescription()+".");
		
	};
	
	@Override 
	public void getMinVisitedEvent() {
		int event_id = eventRepository.getLessVisited();
		Event event = eventRepository.findById(event_id).get();
		log.info("the most visited event is : "+event.getEventname()+" "+event.getDescription()+".");
		
	};
	
}
 