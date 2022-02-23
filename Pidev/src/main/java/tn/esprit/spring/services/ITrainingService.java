package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Training;



public interface ITrainingService {

	List<Training> retrieveAllTraining();
	Training addTraining(Training c);
	void deleteTraining(Integer id);
	Training updateTraining(Training c);
	Training retrieveTraining(Integer id);
}
