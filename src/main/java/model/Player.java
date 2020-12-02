package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Player.findAll",
                    query = "SELECT p FROM Player p"),
        @NamedQuery(name = "Player.findInEnent",
                    query = "SELECT p FROM Player p where p.event = :event")
})

@Table(name = "players")
public class Player implements Serializable {

    @Id
    @Column(name = "player_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 3)
    private String alias;


    @ManyToOne
    @JoinColumn(name = "id_event")
    @JsonManagedReference
    private Event event;

    //@JsonbTransient
    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Lap> laps;

    public Player() {};

    public Long getId()
    { return id; }

    public String getFirstName()
    { return firstName; }

    public String getLastName()
    { return lastName; }

    public String getAlias()
    { return alias; }

    public List<Lap> getLaps()
    { return laps; }

    public Event getEvent()
    { return event; }

    public void setFirstName(String firstName)
    { this.firstName = firstName; }

    public void setLastName(String lastName)
    { this.lastName = lastName; }

    public void setAlias(String alias)
    { this.alias = alias.substring(0,3).toUpperCase(); }

    public void setLaps(List<Lap> laps)
    { this.laps = laps; }

    public void setEvent(Event event)
    { this.event = event; }

    public static Player generateAlias(Player player) {
        if (player.alias == null) {
            char[] newAlias = {'0','0','0'};
            newAlias[0] = player.firstName.charAt(0);
            newAlias[1] = player.lastName.charAt(0);
            newAlias[2] = player.lastName.charAt(1);
            player.alias = String.valueOf(newAlias).toUpperCase();
        }
        return player;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", alias='" + alias + '\'' +
                ", laps=" + laps +
                '}';
    }
}
