package dao;

import model.Event;
import model.Lap;
import model.Player;
import model.Track;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LapDaoImplement implements LapDao {

    @PersistenceContext
    EntityManager em;

    @Override
    public void createLap(Lap lap, Player player, Track track) {
        lap.setPlayer(player);
        lap.setTrack(track);
        em.persist(lap);
    }

    @Override
    public void deleteLap(Long id) {
        Lap lap = em.getReference(Lap.class, id);
        em.remove(lap);
    }

    @Override
    public List<Lap> getAllOnePlayerLapsInEvent(Player player, Event event) {
        return null;
    }

    @Override
    public List<Lap> getAllOnePlayerLapsOnTrack(Player player, Track track) {
        TypedQuery<Lap> query = em.createNamedQuery("findAllOnePlayerLapsOnTrack", Lap.class);
        query.setParameter("playerId", player.getId());
        query.setParameter("trackId", track.getId());
        return query.getResultList();
    }

    @Override
    public List<Lap> getMostFastestLapsOnTrack(Track track, int amountOfResult) {
        TypedQuery<Lap> query = em.createNamedQuery("findMostFastestLapsOnTrack", Lap.class);
        query.setParameter("trackID", track.getId());
        if (amountOfResult > 0)
            query.setMaxResults(amountOfResult);
        return query.getResultList();
    }
}
