package tn.esprit.spring.controller;

import java.sql.SQLException;
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
 
import tn.esprit.spring.entities.Pool;
import tn.esprit.spring.services.IPoolService;
@RestController
@Api(tags = "Gestion de cagnotte")
@RequestMapping("/Cagnotte")
public class PoolRestController {

	@Autowired
	IPoolService poolService;

	// http://localhost:8085/app/Cagnotte/retrieve-all-cagnotte
	@ApiOperation(value = "Récupérer la liste des cagnotte")
	@GetMapping("/retrieve-all-cagnotte")
	
	public List <Pool> getPools() {
		List<Pool> listPool = poolService.retrieveAllPool();
		return listPool;
	
	}
	

	//  http://localhost:8085/app/Cagnotte/retrieve-pool/1
	@ApiOperation(value = "Récupérer une cagnotte par Id")
	@GetMapping("/retrieve-pool/{pool-id}")
//	@ApiResponses(value = {
//			@ApiResponse(code = 200, message = "Success|OK"),
//			@ApiResponse(code = 401, message = "Not Authorized!"),
//			@ApiResponse(code = 403, message = "Forbidden!"),
//			@ApiResponse(code = 404, message = "Not Found!") })
	public Pool retrievePool(@PathVariable("pool-id") Integer PoolId) {
		return poolService.retrievePool(PoolId);
	}

	// http://localhost:8085/app/Cagnotte/add-pool

	@PostMapping("/add-pool")
	public Pool addPool(@RequestBody Pool c) {
		return poolService.addPool(c);
	}
	// http://localhost:8085/app/Cagnotte/donate/{account-id}/{pool-id}/{mont}/{CN}/{Ccv}

		@PostMapping("/donate/{account-id}/{pool-id}/{mont}/{CN}/{Ccv}")
		public void donation(@PathVariable("account-id") Integer  idAccount,@PathVariable("pool-id") Integer idPool,@PathVariable("mont") Integer Montant,@PathVariable("CN")  String CardNumber,@PathVariable("Ccv")String ccv) throws SQLException {
			poolService.Donate(idAccount,idPool,Montant,CardNumber,ccv);
		}
		
	

	// http://localhost:8085/app/Cagnotte/remove-pool/{pool-id}
	@DeleteMapping("/remove-pool/{pool-id}")
	public void removePool(@PathVariable("pool-id")Integer PoolId) {
		poolService.deletePool(PoolId);
	}

	// http://localhost:8085/app/Cagnotte/modify-pool
	@PutMapping("/modify-pool")
	public Pool modifyPool(@RequestBody Pool c) {
		return poolService.updatePool(c);
	}

	// http://localhost:8085/app/Cagnotte/manage-pool
	@PutMapping("/manage-pool/{pool-id}/{test}")
	public void managePool(@PathVariable("pool-id")Integer PoolId, @PathVariable boolean test) {
		 poolService.ManagePool(PoolId,test);
		  
	}
	

}
