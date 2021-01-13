package dao;

import model.Player;
import model.Track;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Set;

@Stateless
public class TrackDaoImplement implements TrackDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createTrack(Track track) {
        em.persist(track);
    }

    @Override
    public void deleteTrack(Long id) {
        Track track = em.find(Track.class, id);
        em.remove(track);
    }

    @Override
    public void updateTrack(Track editedTrack) {
        Track track = em.find(Track.class, editedTrack.getId());
        track.setName(editedTrack.getName());
        track.setLocation(editedTrack.getLocation());

    }

    @Override
    public Track getSingleTrack(Long id) {
        return em.find(Track.class, id);
    }

    @Override
    public List<Track> getAllTracks() {
        TypedQuery<Track> query = em.createNamedQuery("Track.findAll", Track.class);
        return query.getResultList();
    }
}
