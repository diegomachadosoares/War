package war;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diegomachado
 */
class Territory {

    private String name;
    private List<Territory> neighbors;
    private Player owner;
    private int troops;
    private final int id;

    public Territory(String name, Player owner, int id) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.owner = owner;
        this.troops = 1;
        this.id = id;
    }

    public void addNeighbor(Territory neighbor) {
        this.neighbors.add(neighbor);
    }

    public void setNeighbors(List<Territory> neighbors) {
        this.neighbors = neighbors;
    }

    public List<Territory> getNeighbors() {
        return this.neighbors;
    }

    public String getName() {
        return this.name;
    }

    void addTroops(int n) {
        this.troops += n;
    }
    
    // If troops == 1 return else subtract 1  troop
    int subTroop(){
        if (this.troops == 1) {
            return 1;
        }
        this.troops--;
        return 0;
    }

    int getTroops() {
        return this.troops;
    }
    
    int getID(){
        return this.id;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Territory territory = (Territory) obj;

        return this.name.equalsIgnoreCase(territory.getName())
                && this.neighbors.equals(territory.getNeighbors())
                && this.troops == territory.getTroops();
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the owner
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
