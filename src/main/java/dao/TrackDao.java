package dao;

import model.Track;

import java.util.List;

public interface TrackDao {

    public void createTrack(Track track);
    public void deleteTrack(Long id);
    public void updateTrack(Track track);
    public Track getSingleTrack(Long id);
    public List<Track> getAllTracks();

}
