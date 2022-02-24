package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entities.Particip_Donation;
 import tn.esprit.spring.services.IParticipService;


 @RestController
@Api(tags = "Gestion de participation donation")
@RequestMapping("/participDon")
public class ParticipDonRestController {

	@Autowired
	IParticipService pService;

	// http://localhost:8089/app/participDon/retrieve-all-particip
	@ApiOperation(value = "Récupérer la liste des participation")
	
	@GetMapping("/retrieve-all-particip")
	
	public List <Particip_Donation> getPools() {
		List<Particip_Donation> listPart = pService.retrieveAllPart();
		return listPart;
	
	}
	

	// http://localhost:8089/app/participDon/retrieve-particip/8
	@ApiOperation(value = "Récupérer une participation par Id")
	@GetMapping("/retrieve-particip/{participation-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Particip_Donation retrievePart(@PathVariable("participation-id") Integer PlId) {
		return pService.retrievePart(PlId);
	}
	// http://localhost:8089/app/participDon/add-part/8

	@PostMapping("/add-part")
	public Particip_Donation addPart(@RequestBody Particip_Donation c) {
		return pService.addPart(c);
	}



}
