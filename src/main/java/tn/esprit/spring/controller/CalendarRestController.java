package tn.esprit.spring.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.Calendar;
import tn.esprit.spring.services.lCalendarService;

import javax.persistence.Id;
import java.util.List;

@RestController
@RequestMapping("/calendar")
@RequiredArgsConstructor
public class CalendarRestController {

    @Autowired
    lCalendarService calendarService;

    @GetMapping("/allcalendars")
    public ResponseEntity<List<Calendar>> getCalendars(){
        List<Calendar> calendarList = calendarService.retrieveAllCalendars();
        return new ResponseEntity<>(calendarList, HttpStatus.OK);
    }

    @GetMapping("/retrivecalendars/{interview-id}")
    public ResponseEntity<Calendar> retrieveCalendar(@PathVariable("interview-id") Integer IdInterview){
        Calendar calendar=calendarService.retrieveCalendar(IdInterview);
        return new ResponseEntity<>(calendar, HttpStatus.OK);
    }

    @PostMapping("/add-calendar")
    public ResponseEntity<Calendar> addCalendar(@RequestBody Calendar calendar){
        Calendar newCalendar=calendarService.addCalendar(calendar);
        return new ResponseEntity<>(newCalendar, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete-calendar/{interview-id}")
    public ResponseEntity<?> deleteCalendar(@PathVariable("interview-id") Integer IdInterview) {
        calendarService.deleteCalendar(IdInterview);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update-calendar")
    public ResponseEntity<Calendar> updateCalendar(@RequestBody Calendar calendar) {
           Calendar updatedCalendar=calendarService.updateCalendar(calendar);
        return new ResponseEntity<>(updatedCalendar, HttpStatus.OK);

    }

}
