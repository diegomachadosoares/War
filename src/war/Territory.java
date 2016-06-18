package war;

import java.util.List;

/**
 *
 * @author diegomachado
 */
class Territory {
    private String name;
    private List<Territory> neighbors;
    private Player owner;
    private int numberOfTerritories;
    public Territory(String name, Player owner, int numberOfTerritories){
        this.name = name;
        //this.neighbors = neighbors;
        this.owner = owner;
        this.numberOfTerritories = numberOfTerritories;
    }

    public void addNeighbor(Territory neighbor){
        this.neighbors.add(neighbor);
    }
    
    public void setNeighbors(List<Territory> neighbors){
        this.neighbors = neighbors;
    }
    
    public List<Territory> getNeighbors(){
        return this.neighbors;
    }
    
    public String getName(){
        return this.name;
    }
    
    void addTroops(int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
