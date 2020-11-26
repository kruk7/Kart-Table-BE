package model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "tracks")
public class Track implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String location;

    @OneToMany(mappedBy = "track")
    private Set<Event> events;

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
