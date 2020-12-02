package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "laps")
public class Lap implements Serializable {

    @Id
    @Column(name = "lap_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long duration;

    @ManyToOne
    @JoinColumn(name = "id_player")
    @JsonManagedReference
    private Player player;

    @ManyToOne
    @JoinColumn(name = "id_event")
    @JsonManagedReference
    private Event event;

    @ManyToOne
    @JoinColumn(name = "id_track")
    private Track track;

    public Lap() {}

    public Long getId()
    { return id; }

    public Long getDuration()
    { return duration; }

    public Player getPlayer()
    { return player; }

    public Event getEvent()
    { return event; }

    public Track getTrack()
    { return track; }

    public void setDuration(Long duration)
    { this.duration = duration; }

    public void setPlayer(Player player)
    { this.player = player; }

    public void setEvent(Event event)
    { this.event = event; }

    public void setTrack(Track track)
    { this.track = track; }
}
