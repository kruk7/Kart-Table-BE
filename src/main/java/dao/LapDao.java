package dao;

import model.Event;
import model.Lap;
import model.Player;
import model.Track;

import java.util.List;

public interface LapDao {

    public void createLap(Lap lap, Player player, Track track);
    public void deleteLap(Long id);
    public List<Lap> getAllOnePlayerLapsInEvent(Player player, Event event);
    public List<Lap> getAllOnePlayerLapsOnTrack(Player player, Track track);
    public List<Lap> getMostFastestLapsOnTrack(Track track, int amountOfResult);

}
