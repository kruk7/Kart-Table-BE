package model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "players")
public class Player {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(nullable = false, length = 3)
    private String alias;
    @OneToMany(mappedBy = "player")
    private Set<Lap> laps;

    public Player() {};

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAlias() { return alias; }
    public Set<Lap> getLaps() { return laps; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAlias(String alias) { this.alias = alias.substring(0,3).toUpperCase(); }
    public void setLaps(Set<Lap> laps) { this.laps = laps; }

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
