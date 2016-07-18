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
        this.att_dices = new int[]{0, 0, 0};
        this.def_dices = new int[]{0, 0, 0};
    }

    public Territory[] attack(int nTroops) {
        for (int i = 0; i < nTroops; i++) {
            this.att_dices[i] = Dice.playDice();
        }
        int lim;
        if (this.def.getTroops() > 3){
            lim = 3;
        } else {
            lim = this.def.getTroops() ;
        }
        for (int i = 0; i < lim; i++) {
            this.def_dices[i] = Dice.playDice();
        }
        Arrays.sort(this.att_dices);
        Arrays.sort(this.def_dices);

        Territory[] winners = checkWinner(this.att_dices, this.def_dices);
        return winners;
    }
    
    private int[] getDices(Territory t){
        if (t.equals(this.att)){
            return this.att_dices;
        }
        return this.def_dices;
    }

    private Territory[] checkWinner(int[] att, int[] def) {
        Territory[] ret = new Territory[3];
        int defTroops =0;
        for (int i = 2; i >= 0; i--) {
            if(att[i] == 0 && def[i] == 0){
                ret[i] = null;
            }
            if (att[i] > def[i]) {
                defTroops = this.def.subTroop();
                if (defTroops==1){
                    this.def.setOwner(this.att.getOwner());
                    return ret;
                }
                ret[i] = this.att;
            } else {
                ret[i] = this.def;
                this.att.subTroop();
            }
        }
        return ret;
    }
}
