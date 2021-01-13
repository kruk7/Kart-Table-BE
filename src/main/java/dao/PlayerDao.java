package dao;

import model.Event;
import model.Lap;
import model.Player;
import java.util.List;

public interface PlayerDao {

    void createPlayer(Player player);
    void deletePlayer(Long id);
    void updatePlayer(Player player);
    void addLapToPlayer(Lap lap, Long idPlayer);
    Player getSinglePlayer(Long id);
    List<Player> getAllPlayers();
    List<Player> getPlayersInEvent(Event event);
}
