package dao;

import model.Event;
import model.Lap;
import model.Player;
import model.Track;

import java.util.List;

public interface LapDao {

    public void addLap(Lap lap);
    public void deleteLap(Long id);
    public List<Lap> getAllPlayerLapsInEvent(Player player, Event event);
    public List<Lap> getMostFasterLapsOnTrack(Track track, int countOfResult);

}
