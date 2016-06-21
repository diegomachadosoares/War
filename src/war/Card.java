package war;

/**
 *
 * @author diegomachado
 */
class Card {
    private Territory territory;
    private String figure;

    public Card(Territory territory, String figure){
        this.territory = territory;
        this.figure = figure;
    }
    
    /**
     * @return the territory
     */
    public Territory getTerritory() {
        return territory;
    }

    /**
     * @return the figure
     */
    public String getFigure() {
        return figure;
    }
}
