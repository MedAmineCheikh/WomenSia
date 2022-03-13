package tn.esprit.spring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Calendar;
import tn.esprit.spring.entities.Job_Offer;
import tn.esprit.spring.services.lJobOfferService;

import java.util.List;

@RestController
@RequestMapping("/joboffer")
@RequiredArgsConstructor
public class JobOfferRestController {


    @Autowired
    lJobOfferService jobOfferService;


    @GetMapping("/alljoboffers")
    public ResponseEntity<List<Job_Offer>> getJoboffers(){
        List<Job_Offer> jobOfferList = jobOfferService.retrieveAllJobOffers();
        return new ResponseEntity<>(jobOfferList, HttpStatus.OK);
    }

    @GetMapping("/retrivejoboffers/{offer-id}")
    public ResponseEntity<Job_Offer> retrieveJobOffer(@PathVariable("offer-id") Integer IdOffer){
        Job_Offer jobOffer=jobOfferService.retrieveJobOffer(IdOffer);
        return new ResponseEntity<>(jobOffer, HttpStatus.OK);
    }

    @PostMapping("/add-Job")
    public ResponseEntity<Job_Offer> addJobOffer(@RequestBody Job_Offer jobOffer) {
        Job_Offer newJobOffer=jobOfferService.addJobOffer(jobOffer);
        return new ResponseEntity<>(newJobOffer, HttpStatus.CREATED);

    }

    @DeleteMapping("/delete-joboffer/{offer-id}")
    public ResponseEntity<?> deleteJobOffer(@PathVariable("offer-id") Integer IdOffer) {
        jobOfferService.deleteJobOffer(IdOffer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-job")
    public ResponseEntity<Job_Offer> updateJobOffer(@RequestBody Job_Offer jobOffer) {
        Job_Offer updatedJob=jobOfferService.updateJobOffer(jobOffer);
        return new ResponseEntity<>(updatedJob, HttpStatus.OK);
    }

}
