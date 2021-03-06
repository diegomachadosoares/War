package war;

import java.util.LinkedList;

/**
 *
 * @author diegomachado
 */
public class Player {

    private final String name;
    private final String color;
    private Objective objective;
    private final int id;
    private LinkedList<Territory> territories;
    private LinkedList<Continent> continents;
    private LinkedList<Card> cards;
    private int nTroops;
   
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

    public Objective getObjective() {
        return this.objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public boolean distributeTroops(Territory t, int n){
        if (getTerritories().contains(t)){
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

    /**
     * @return the territories
     */
    public LinkedList<Territory> getTerritories() {
        return territories;
    }
    
    public void addTerritory(Territory territory){
        if(this.territories == null){
            this.territories = new LinkedList<>();
        }
        this.territories.add(territory);
    }
    
    public boolean removeTerritory(Territory t){
        if (this.territories.contains(t)){
            this.territories.remove(t);
            return true;
        }
        return false;
    }
    
    public void addContinent(Continent c){
        this.continents.push(c);
    }
    
    public boolean removeContinent(Continent c){
        if (this.continents.contains(c)){
            this.continents.remove(c);
            return true;
        }
        return false;
    }
    
    public void setNTroops(int n){
        this.nTroops = n;
    }
    
    public int getNTroops(){
        return this.nTroops;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        
        Player player = (Player) obj;

        return this.name.equalsIgnoreCase(player.getName())
                && this.id == player.id
                && this.color.equalsIgnoreCase(player.color);
    }
    
    public LinkedList<Card> getCards(){
        return cards;
    }
}
