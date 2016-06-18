package war;

/**
 *
 * @author diegomachado
 */
public class Dice {

    public static int playDice(){
        return (int) (1 + Math.random() * 6);
    }

}
