package war;

import java.util.Arrays;
import java.util.LinkedList;

/**
 *
 * @author diegomachado
 */
public class Player {

    private final String name;
    private final String color;
    private String objective;
    private final int id;
    private LinkedList<Territory> territories;
    private LinkedList<Card> cards;
   
    public Player(String name, String color, int id) {
        this.name = name;
        this.color = color;
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public String getObjective() {
        return this.objective;
    }

    public void chooseObjective() {
        Objective obj = Objective.getInstance();
        this.objective = obj.getObjective();
    }

    public boolean distributeTroops(Territory t, int n){
        if (getTerritories().contains(t)){
            t.addTroops(n);
            return true;
        }
        return false;
    }

    public void attack(Territory my, Territory enemy){
        int enemy_troops = enemy.getTroops();
        int my_troops = my.getTroops();
        int[] enemy_dices = null;
        int[] my_dices = null;

        for (int i = 0; i < enemy_troops; i++) {
            enemy_dices[i] = Dice.playDice();
        }
	Arrays.sort(enemy_dices);

	for (int i = 0; i < my_troops; i++){
		my_dices[i] = Dice.playDice();
	}
	Arrays.sort(my_dices);

	int[] winner = winnerCheck(my_dices, enemy_dices);
    }

    private int[] winnerCheck(int[] my, int[] enemy){
	int[] ret = null;
	for (int i=0; i < my.length; i++){
		if (my[i] > enemy[i]){
			ret[i] = 0;
		} else {
			ret[i] = 1;
		}
	}
	return ret;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the territories
     */
    public LinkedList<Territory> getTerritories() {
        return territories;
    }

    /**
     * @param territories the territories to set
     */
    public void setTerritories(LinkedList<Territory> territories) {
        this.territories = territories;
    }
    
    public void addTerritory(Territory territory){
        if(this.territories == null){
            this.territories = new LinkedList<>();
        }
        this.territories.add(territory);
    }
}
