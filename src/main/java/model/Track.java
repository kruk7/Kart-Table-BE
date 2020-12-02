package model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tracks")
public class Track implements Serializable {

    @Id
    @Column(name = "track_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String location;

    @OneToMany(mappedBy = "track")
    @JsonBackReference
    private Set<Event> events;

    @OneToMany(mappedBy = "track")
    private Set<Lap> laps;

    public Track() {}

    public Long getId()
    { return id; }

    public String getName()
    { return name; }

    public String getLocation()
    { return location; }

    public Set<Event> getEvents()
    { return events; }

    public void setName(String name)
    { this.name = name; }

    public void setLocation(String location)
    { this.location = location; }

    public void setEvents(Set<Event> events)
    { this.events = events; }

}
