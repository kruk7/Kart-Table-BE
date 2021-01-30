package model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@NamedQueries({
        @NamedQuery(name = "Player.findAll", query = "SELECT p FROM Player p"),
        @NamedQuery(name = "Player.findInEvent", query = "SELECT p FROM Player p where p.event = :event")
})

@Table(name = "players")
public class Player implements Serializable {

    @Id
    @Column(name = "id_player")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(nullable = false, length = 3)
    private String alias;

    //@JsonManagedReference
    @ManyToMany(mappedBy = "players")
    private Set<Event> event;

    //@JsonbTransient
    //@JsonBackReference
    @OneToMany(mappedBy = "player", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Lap> laps;

    public Player() {};

    public Long getId()
    { return id; }

    public String getFirstName()
    { return firstName; }

    public String getLastName()
    { return lastName; }

    public String getAlias()
    { return alias; }

    public Set<Lap> getLaps()
    { return laps; }

    public Set<Event> getEvent()
    { return event; }

    public void setFirstName(String firstName)
    { this.firstName = firstName; }

    public void setLastName(String lastName)
    { this.lastName = lastName; }

    public void setAlias(String alias)
    { this.alias = alias.substring(0,3).toUpperCase(); }

    public void setLaps(Set<Lap> laps)
    { this.laps = laps; }

    public void setEvent(Set<Event> event)
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
