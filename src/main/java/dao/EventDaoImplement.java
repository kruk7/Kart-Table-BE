package dao;

import model.Event;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Set;

public class EventDaoImplement implements EventDao {

    @PersistenceContext
    EntityManager em;


    @Override
    public void addEvent(Event event) {

    }

    @Override
    public void deleteEvent(Long id) {

    }

    @Override
    public Event getSingleEvent(Long id) {

        return null;
    }

    @Override
    public Set<Event> getAllEvents() {
        return null;
    }
}
