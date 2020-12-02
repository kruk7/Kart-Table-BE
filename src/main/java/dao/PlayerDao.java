package dao;

import model.Event;
import model.Player;

import java.util.List;
import java.util.Set;

public interface PlayerDao {

    public void createPlayer(Player player);
    public void deletePlayer(Long id);
    public Player getSinglePlayer(Long id);
    public List<Player> getAllPlayers();
    public List<Player> getPlayersInEvent(Event event);

}
