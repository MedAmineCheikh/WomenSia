package tn.esprit.spring.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.spring.entities.Calendar;
import tn.esprit.spring.repository.CalendarRepository;

import java.util.List;
@Service
@Slf4j
public class CalendarServicelmpl implements lCalendarService{
    @Autowired
    CalendarRepository calendarRepository;

    @Override
    public List<Calendar> retrieveAllCalendars() {
        List<Calendar> listCalendar=calendarRepository.findAll();
        return listCalendar;
    }

    @Override
    public Calendar addCalendar(Calendar calendar) {
        calendarRepository.save(calendar);
        return calendar;
    }

    @Override
    public void deleteCalendar(Integer IdInterview) {
        calendarRepository.deleteById(IdInterview);

    }

    @Override
    public Calendar updateCalendar(Calendar calendar) {
        calendarRepository.save(calendar);
        return calendar;
    }

    @Override
    public Calendar retrieveCalendar(Integer IdInterview) {
        Calendar calendar=calendarRepository.findById(IdInterview).get();
        return calendar;
    }
}
