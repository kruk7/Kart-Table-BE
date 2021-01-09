package dao;

import model.Event;
import model.Player;

import java.util.List;

public interface EventDao {

    void createEvent(Event event);
    void deleteEvent(Long id);
    Event getSingleEvent(Long id);
    List<Event> getAllEvents();

    void addPlayerToEvent(Player player);

}
