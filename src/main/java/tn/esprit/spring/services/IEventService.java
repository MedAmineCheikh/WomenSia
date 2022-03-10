package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Event;


public interface IEventService {

	List<Event> retrieveAllEvents();

	Event addEvent(Event c);

	void deleteEvent(Integer id);

	Event updateEvent(Event c);

	Event retrieveEvent(Integer id);

	

	//Event getMostVisitedEvent();
	
	void getMostVisitedEvent();

	void getMinVisitedEvent();



}