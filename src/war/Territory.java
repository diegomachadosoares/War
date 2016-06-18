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

    public Territory(String name, Player owner, int troops) {
        this.name = name;
        this.neighbors = new ArrayList<>();
        this.owner = owner;
        this.troops = troops;
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

    int getTroops() {
        return this.troops;
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
