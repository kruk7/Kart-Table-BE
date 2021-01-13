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
@NamedQueries({
        @NamedQuery(name = "Event.findAll",
                    query = "SELECT e FROM Event e"
        )
})
public class Event implements Serializable {

    @Id
    @Column(name = "id_event")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Time time;

    private Date date;

    //@JsonManagedReference
    @ManyToOne(optional = false)
    @JoinColumn(name = "track_id")
    private Track track;

    //@JsonBackReference
    @ManyToMany
    @JoinTable(name = "players_in_event",
               joinColumns = {@JoinColumn(name = "event_id", referencedColumnName = "id_event")},
               inverseJoinColumns = {@JoinColumn(name = "player_id", referencedColumnName = "id_player")})
    private Set<Player> players;

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

    public void setTime(Time time)
    { this.time = time; }

    public void setDate(Date date)
    { this.date = date; }

    public void setTrack(Track track)
    { this.track = track; }

    public void setPlayers(Set<Player> players)
    { this.players = players; }
}
