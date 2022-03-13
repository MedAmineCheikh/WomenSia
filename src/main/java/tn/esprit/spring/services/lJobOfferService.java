package tn.esprit.spring.services;

import tn.esprit.spring.entities.Job_Offer;

import java.util.List;

public interface lJobOfferService {
    List<Job_Offer> retrieveAllJobOffers();

    Job_Offer addJobOffer(Job_Offer jobOffer);

    void deleteJobOffer(Integer IdOffer);

    Job_Offer updateJobOffer(Job_Offer jobOffer);

    Job_Offer retrieveJobOffer(Integer IdOffer);
}
