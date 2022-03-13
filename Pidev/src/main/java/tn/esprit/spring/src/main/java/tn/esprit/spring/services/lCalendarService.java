package tn.esprit.spring.services;

import tn.esprit.spring.entities.Calendar;


import java.util.List;

public interface lCalendarService {
    List<Calendar> retrieveAllCalendars();

    Calendar addCalendar(Calendar calendar);

    void deleteCalendar(Integer IdInterview);

    Calendar updateCalendar(Calendar calendar);

    Calendar retrieveCalendar(Integer IdInterview);
}
