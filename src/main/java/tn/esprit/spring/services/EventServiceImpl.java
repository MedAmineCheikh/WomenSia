 package tn.esprit.spring.services;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repository.EventRepository;
 
@Service
@Slf4j
public class EventServiceImpl implements IEventService {
	
	@Autowired
	EventRepository eventRepository;

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

}
 