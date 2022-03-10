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
 
import tn.esprit.spring.entities.Sponsors;
import tn.esprit.spring.services.IEventService;
import tn.esprit.spring.services.ISponsorService;
@RestController
@Api(tags = "Gestion des Sponsors")
@RequestMapping("/Sponsors")
public class SponsorRestController {
 
	
	@Autowired
	IEventService EService;
	@Autowired
	ISponsorService sService;

	// http://localhost:8089/app/Sponsors/retrieve-all-Sponsors
	@ApiOperation(value = "Récupérer la liste des sponsors")
	@GetMapping("/retrieve-all-Sponsors")
	
	public List <Sponsors> getSponsors() {
		List<Sponsors> listSponsors = sService.retrieveAllSponsors();
		return listSponsors;
	
	}
	
	

	// http://localhost:8085/app/Sponsors/retrieve-sponsor/8
	@ApiOperation(value = "Récupérer un sponsor par Id")
	@GetMapping("/retrieve-sponsor/{sponsors-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Sponsors retrieveSponsors(@PathVariable("sponsors-id") Integer SponsorsId) {
		return sService.retrieveSponsors(SponsorsId);
	}
	// http://localhost:8085/app/Sponsors/add-sponsors
	@PostMapping("/add-sponsors")
	public Sponsors addSponsors(@RequestBody Sponsors c) {
		return sService.addSponsors(c);
	}

	// http://localhost:8085/app/Sponsors/remove-sponsor/{sponsor-id}
	@DeleteMapping("/remove-sponsor/{Sponsors-id}")
	public void removeSponsors(@PathVariable("Sponsors-id")Integer SponsorsId) {
		sService.deleteSponsors(SponsorsId);
	}

	// http://localhost:8085/app/Sponsors/modify-sponsor
	@PutMapping("/modify-sponsor")
	public Sponsors modifySponsors(@RequestBody Sponsors c) {
		return sService.updateSponsors(c);
	}
	
	// http://localhost:8085/app/Sponsors/affect-sponsor
		@PutMapping("/affect-sponsor/{Id-Sponsor}/{Id-Event}")
		public void affecterSponsEvent(@PathVariable("Id-Sponsor") int idSponsor,@PathVariable("Id-Event") int idEvent ){
			sService.affectSponsEvent(idSponsor,idEvent );
		}


}
