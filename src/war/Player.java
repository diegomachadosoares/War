package war;

import java.util.List;

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
}
