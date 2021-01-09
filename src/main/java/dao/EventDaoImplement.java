package dao;

import model.Event;
import model.Player;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
public class EventDaoImplement implements EventDao {

    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public void createEvent(Event event) {
        em.persist(event);
    }

    @Override
    @Transactional
    public void deleteEvent(Long id) {
        em.remove(getSingleEvent(id));
    }

    @Override
    public Event getSingleEvent(Long id) {
        Event event = em.find(Event.class, id);
        return event;
    }

    @Override
    public List<Event> getAllEvents() {
        TypedQuery<Event> query = em.createNamedQuery("Event.findAll", Event.class);
        return query.getResultList();
    }

    @Override
    public void addPlayerToEvent(Player player) {

    }
}
