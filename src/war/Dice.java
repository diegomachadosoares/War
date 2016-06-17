package war;

/**
 *
 * @author diegomachado
 */
public class Dice {

    public int playDice(){
        return (int) (1 + Math.random() * 6);
    }

}
