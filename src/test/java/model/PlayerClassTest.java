package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class PlayerClassTest {

    Player player;

    @BeforeEach
    void setUp() {
        player = new Player();
        player.setFirstName("Jan");
        player.setLastName("Kowalski");
    }

    @Test
    void getNullAliasPlayer() {
        //Then
        assertNull(player.getAlias());
    }

    @Test
    void getAliasWithManualAssign() {
        //When
        player.setAlias("Stanisław");

        //Then
        assertEquals("STA", player.getAlias());
    }

    @Test
    void generateAliasPlayer() {
        //When
        Player.generateAlias(player);

        //Then
        assertEquals("JKO", player.getAlias());
    }

    @Test
    void generateAliasPlayerAfterManualAssignAlias() {
        //Given
        player.setAlias("Zenon");

        //When
        Player.generateAlias(player);

        //Then
        assertEquals("ZEN", player.getAlias());
    }

    @Test
    void generateIncompliteAlias() {
        //Given
        player.setFirstName("J");
        player.setLastName("K");

        //When
        Player.generateAlias(player);

        //Then
        assertEquals("JK0", player.getAlias());
    }


}
