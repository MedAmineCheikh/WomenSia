package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Job_Offer;
import tn.esprit.spring.repository.JobOfferRepository;

import java.util.List;

@Service
@Slf4j
public class JobOfferServicelmpl implements lJobOfferService{
    @Autowired
    JobOfferRepository jobOfferRepository;

    @Override
    public List<Job_Offer> retrieveAllJobOffers() {
        List<Job_Offer> listJobOffer= jobOfferRepository.findAll();
        return listJobOffer;
    }

    @Override
    public Job_Offer addJobOffer(Job_Offer jobOffer) {
        jobOfferRepository.save(jobOffer);
        return jobOffer;
    }

    @Override
    public void deleteJobOffer(Integer IdOffer) {
        jobOfferRepository.deleteById(IdOffer);

    }

    @Override
    public Job_Offer updateJobOffer(Job_Offer jobOffer) {
        jobOfferRepository.save(jobOffer);
        return jobOffer;
    }

    @Override
    public Job_Offer retrieveJobOffer(Integer IdOffer) {
        Job_Offer jobOffer=jobOfferRepository.findById(IdOffer).get();
        return jobOffer;
    }
}
