package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event implements Serializable {

    @Id
    @Column(name = "event_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Time time;

    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_track")
    @JsonManagedReference
    private Track track;

    @JsonBackReference
    @OneToMany(mappedBy = "event")
    private Set<Player> players;

    @JsonBackReference
    @OneToMany(mappedBy = "event")
    private Set<Lap> laps;

    public Event() {}

    public Long getId()
    { return id; }

    public Time getTime()
    { return time; }

    public Date getDate()
    { return date; }

    public Track getTrack()
    { return track; }

    public Set<Player> getPlayers()
    { return players; }

    public Set<Lap> getLaps()
    { return laps; }

    public void setTime(Time time)
    { this.time = time; }

    public void setDate(Date date)
    { this.date = date; }

    public void setTrack(Track track)
    { this.track = track; }

    public void setPlayers(Set<Player> players)
    { this.players = players; }

    public void setLaps(Set<Lap> laps)
    { this.laps = laps; }
}
