package war;

import java.util.Arrays;

/**
 *
 * @author diegomachado
 */
public class Battle {

    private int[] att_dices;
    private int[] def_dices;
    private Territory att;
    private Territory def;

    public Battle(Territory att, Territory def) {
        if (att.getOwner() == def.getOwner()){
            throw new IllegalArgumentException("Player owns both territories!");
        }
        this.att = att;
        this.def = def;
        this.att_dices = new int[3];
        this.def_dices = new int[3];
    }

    public Territory[] attack(int nTroops) {
        for (int i = 0; i <= nTroops; i++) {
            this.att_dices[i] = Dice.playDice();
        }
        for (int i = 0; i < this.def.getTroops(); i++) {
            this.def_dices[i] = Dice.playDice();
        }
        Arrays.sort(this.att_dices);
        Arrays.sort(this.def_dices);

        Territory[] winners = checkWinner(this.att_dices, this.def_dices);
        return winners;
    }

    private Territory[] checkWinner(int[] att, int[] def) {
        Territory[] ret = null;
        for (int i = 0; i < att.length; i++) {
            if (att[i] > def[i]) {
                ret[i] = this.att;
                int a = this.def.subTroop();
                if (a==1){
                    this.def.setOwner(this.att.getOwner());
                    return ret;
                }
            } else {
                ret[i] = this.def;
                this.def.subTroop();
            }
        }
        return ret;
    }
}
