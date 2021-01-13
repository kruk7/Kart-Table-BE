package model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Track.findAll",
                query = "SELECT t FROM Track t")
})
@Table(name = "tracks")
public class Track implements Serializable {

    @Id
    @Column(name = "id_track")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String location;

    @OneToMany(mappedBy = "track",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Lap> laps;

    public Track() {}

    public Long getId()
    { return id; }

    public String getName()
    { return name; }

    public String getLocation()
    { return location; }

    public void setName(String name)
    { this.name = name; }

    public void setLocation(String location)
    { this.location = location; }
}
