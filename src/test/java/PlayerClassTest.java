import model.Player;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class PlayerClassTest {

    Player player1;

    public PlayerClassTest() {
        player1 = new Player();
        player1.setFirstName("Jan");
        player1.setLastName("Kowalski");
    }

    @Test
    void getNullAliasPlayer() {
        assertNull(player1.getAlias());
    }

    @Test
    void getAliasWithManualAssign() {
        player1.setAlias("Stanisław");
        assertEquals("STA", player1.getAlias());
    }

    @Test
    void generateAliasPlayer() {
        Player.generateAlias(player1);
        assertEquals("JKO", player1.getAlias());
    }

    @Test
    void generateAliasPlayerAfterManualAssignAlias() {
        player1.setAlias("Zenon");
        Player.generateAlias(player1);
        assertEquals("ZEN", player1.getAlias());
    }
}
