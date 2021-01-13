package model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "laps")
public class Lap implements Serializable {

    @Id
    @Column(name = "id_lap")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long duration;

    //@JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;

    public Lap() {}

    public Long getId()
    { return id; }

    public Long getDuration()
    { return duration; }

    public Player getPlayer()
    { return player; }

    public Track getTrack()
    { return track; }

    public void setDuration(Long duration)
    { this.duration = duration; }

    public void setPlayer(Player player)
    { this.player = player; }

    public void setTrack(Track track)
    { this.track = track; }
}
