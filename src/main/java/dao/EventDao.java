package dao;

import model.Event;
import java.util.Set;

public interface EventDao {

    public void addEvent(Event event);
    public void deleteEvent(Long id);
    public Event getSingleEvent(Long id);
    public Set<Event> getAllEvents();

}
