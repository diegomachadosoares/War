package war;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 *
 * @author diegomachado
 */
public class ObjectiveTest {
/*
    @Test
    public void testObjective() {
        try {
            int numPlayers = 6; //Number of players
            Player[] players = new Player[numPlayers]; //container for the player list
            for (Integer i = 0; i < numPlayers; i++) {
                //Create numPlayers players
                players[i] = new Player("joao" + i.toString(), "Azul" + i.toString(), i);
            }
            //Each player must have an objective!
            for (Player player : players) {
                player.chooseObjective();
            }
            //shows each player objective
            for (Player player : players) {
                System.out.println(player.getObjective());
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //@Test
    public void testIfAllPlayersHaveAObjective() {
        int numPlayers = 6; //Number of players
        Player[] players = new Player[numPlayers]; //container for the player list
        for (Integer i = 0; i < numPlayers; i++) {
            //Create numPlayers players
            players[i] = new Player("joao" + i.toString(), "Azul" + i.toString(), i);
        }
        //Each player must have an objective!
        for (Player player : players) {
            player.chooseObjective();
        }

        for (Player player : players) {
            if (player.getObjective() == null) {
                fail("Player "+player.getId()+" without objective.");
            }
        }
        assertEquals(true, true);
    }
    */
}
