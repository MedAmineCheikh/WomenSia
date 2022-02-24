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
 import tn.esprit.spring.entities.Reclamation;
 import tn.esprit.spring.services.IReclamService;
 
@RestController
@Api(tags = "Gestion de reclamation")
@RequestMapping("/Reclamation")
public class ReclamRestController {

	@Autowired
	IReclamService rService;

	// http://localhost:8085/app/Reclamation/retrieve-all-reclamation
	@ApiOperation(value = "Récupérer la liste des reclamations")
	@GetMapping("/retrieve-all-reclamation")
	
	public List <Reclamation> getReclamation() {
		List<Reclamation> listReclamation = rService.retrieveAllReclamation();
		return listReclamation;
	
	}
	

	//// http://localhost:8085/app/Reclamation/retrieve-reclamation/8
	@ApiOperation(value = "Récupérer une reclamation par Id")
	@GetMapping("/retrieve-reclamation/{Reclamation-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Reclamation retrieveReclamation(@PathVariable("Reclamation-id") Integer ReclamationId) {
		return rService.retrieveReclamation(ReclamationId);
	}
	// http://localhost:8089/app/Reclamation/add-reclam
	@PostMapping("/add-reclam")
	public Reclamation addReclam(@RequestBody Reclamation c) {
		return rService.addReclamation(c);
	}

	// http://localhost:8085/app/Reclamation/remove-Reclam/{Reclamation-id}
	@DeleteMapping("/remove-Reclam/{Reclam-id}")
	public void removeReclamation(@PathVariable("Reclam-id")Integer ReclamationId) {
		rService.deleteReclamation(ReclamationId);
	}

	// http://localhost:8085/app/Reclamation/modify-Reclamation
	@PutMapping("/modify-Reclamation")
	public Reclamation modifyEvent(@RequestBody Reclamation c) {
		return rService.updateReclamation(c);
	}


}
