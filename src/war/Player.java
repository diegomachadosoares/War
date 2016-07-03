package war;

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
        if (territories.contains(t)){
            t.addTroops(n);
            return true;
        }
        return false;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
}
