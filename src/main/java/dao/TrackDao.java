package dao;

import model.Track;
import java.util.Set;

public interface TrackDao {

    public void addTrack(Track track);
    public void deleteTrack(Long id);
    public Track getSingleTrack(Long id);
    public Set<Track> getAllTracks();

}
