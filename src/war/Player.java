package war;

import java.util.List;
import java.util.Arrays;

/**
 *
 * @author diegomachado
 */
public class Player {

    private String name;
    private String color;
    private List<Territory> Territories;
    private String objective;
    private List<Card> cards;

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Gets and Sets
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObjective() {
        return this.objective;
    }

    public void chooseObjective() {
        Objective obj = Objective.getInstance();
        this.objective = obj.getObjective();
    }

    public void distributeTroops(Territory t, int n){
        t.addTroops(n);
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
}
