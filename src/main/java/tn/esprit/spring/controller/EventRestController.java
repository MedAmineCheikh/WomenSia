package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Event;
 
import tn.esprit.spring.services.IEventService;
 
@RestController
@Api(tags = "Gestion d'events")
@RequestMapping("/Event")
public class EventRestController {

	@Autowired
	IEventService eService;

	// http://localhost:8085/app/Event/retrieve-all-events
	@ApiOperation(value = "Récupérer la liste des events")
	@GetMapping("/retrieve-all-events")
	
	public List <Event> getEvents() {
		List<Event> listEvent = eService.retrieveAllEvents();
		return listEvent;
	
	}
	

	//http://localhost:8085/app/Event/retrieve-event/12
	@ApiOperation(value = "Récupérer un event par Id")
	@GetMapping("/retrieve-event/{event-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Event retrieveEvent(@PathVariable("event-id") Integer EventId) {
		return eService.retrieveEvent(EventId);
	}
	//http://localhost:8085/app/Event/add-event
	@PostMapping("/add-event")
	public Event addEvent(@RequestBody Event c) {
		return eService.addEvent(c);
	}

	// http://localhost:8085/app/Event/remove-Event/11
	@DeleteMapping("/remove-Event/{Event-id}")
	public void removeEventt(@PathVariable("Event-id")Integer EventId) {
		eService.deleteEvent(EventId);
	}

	// http://localhost:8085/app/Event/modify-Event
	@PutMapping("/modify-Event")
	public Event modifyEvent(@RequestBody Event c) {
		return eService.updateEvent(c);
	}


}
