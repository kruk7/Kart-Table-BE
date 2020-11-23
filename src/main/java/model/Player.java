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
    @Column(nullable = false, length = 3, unique = true)
    private String alias;
    @OneToMany(mappedBy = "player")
    private Set<Lap> laps;

    public Player() {}

    public Long getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getAlias() { return alias; }
    public Set<Lap> getLaps() { return laps; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAlias(String alias) { this.alias = alias; }
    public void setLaps(Set<Lap> laps) { this.laps = laps; }

    private String generateAlias() {
       // alias += this.firstName.charAt(0);
        return null;
    }

}
