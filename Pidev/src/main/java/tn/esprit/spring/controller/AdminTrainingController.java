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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.services.ITrainingService;


@RestController
@RequestMapping("/adminTraining")
public class AdminTrainingController {

	@Autowired
	ITrainingService trainingService;
	// http://localhost:8089/SpringMVC/adminTraining/retrieve-all-trainings
		@GetMapping("/retrieve-all-trainings")
		public List<Training> getTrainings() {
		List<Training> listTrainings = trainingService.retrieveAllTraining();
		return listTrainings;
		}
		// http://localhost:8089/SpringMVC/adminTraining/retrieve-training/8
		@GetMapping("/retrieve-training/{training-id}")
		public Training retrieveTraining(@PathVariable("training-id") Integer trainingId) {
		return trainingService.retrieveTraining(trainingId);
		}
		@PostMapping("/add-training")
		public Training addTraining(@RequestBody Training c) {
		return trainingService.addTraining(c);
		}
		// http://localhost:8089/SpringMVC/adminTraining/remove-training/{training-id}
		@DeleteMapping("/remove-training/{training-id}")
		@ResponseBody
		public void removeTraining1(@PathVariable("training-id") Integer trainingId) {
		trainingService.deleteTraining(trainingId);
		}
		// http://localhost:8089/SpringMVC/adminTraining/modify-training/1
		@PutMapping("/modify-training/{id}")
		@ResponseBody
		public Training updateTraining(@PathVariable("id") int IdTraining,@RequestBody Training training) {
		return trainingService.updateTraining(training);
		}
}
