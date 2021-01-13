package dao;

import model.Track;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class TrackDaoImplement implements TrackDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public boolean ifExist(String name) {
        TypedQuery<Long> query = em.createNamedQuery("Track.ifExist", Long.class);
        query.setParameter("name", name);
        System.out.println(query.getSingleResult());
        return query.getSingleResult() > 0L;
    }

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
    public void updateTrack(Track track, Long id) {
        Track persistTrack = em.find(Track.class, id);
        persistTrack.setName(track.getName());
        persistTrack.setLocation(track.getLocation());

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
