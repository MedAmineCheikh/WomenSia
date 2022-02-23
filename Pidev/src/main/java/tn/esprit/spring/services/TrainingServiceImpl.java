package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.TrainingRepository;

@Service
public class TrainingServiceImpl implements ITrainingService {

	@Autowired
	TrainingRepository trainingRepository;
	@Override
	public List<Training> retrieveAllTraining() {
		// TODO Auto-generated method stub
		return (List<Training>)trainingRepository.findAll();
	}

	@Override
	public Training addTraining(Training c) {
		// TODO Auto-generated method stub
		return trainingRepository.save(c);
	}

	@Override
	public void deleteTraining(Integer id) {
		// TODO Auto-generated method stub
		trainingRepository.deleteById(id);
	}

	@Override
	public Training updateTraining(Training c) {
		// TODO Auto-generated method stub
		return trainingRepository.save(c);
	}

	@Override
	public Training retrieveTraining(Integer id) {
		// TODO Auto-generated method stub
		Training c=trainingRepository.findById(id).get();
		return c;
	}

}
