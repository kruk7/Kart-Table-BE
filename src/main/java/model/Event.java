package model;

import javax.persistence.*;
import javax.xml.namespace.QName;
import java.sql.Date;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @Column(name = "events_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Time time;
    private Date date;
    @ManyToOne
    @JoinColumn(name = "id_track")
    private Track track;
    @OneToMany(mappedBy = "event")
    private Set<Lap> laps;

    public Event() {}


}
