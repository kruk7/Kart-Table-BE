package dao;

import model.Track;
import java.util.Set;

public interface TrackDao {

    public void createTrack(Track track);
    public void deleteTrack(Long id);
    public Track getSingleTrack(Long id);
    public Set<Track> getAllTracks();

}
