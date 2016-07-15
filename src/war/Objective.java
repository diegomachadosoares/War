package war;

import java.util.List;

/**
 *
 * @author diegomachado
 */
public class Objective {

    private int type;
    private String msg;
    private List<Integer> target;
    private String color;
    private int nTerritories;
    
    private Objective(int type, String msg){
        this.type = type;
        this.msg = msg;
    }
    
    public Objective(int type, String msg, List<Integer> continents){
        this(type, msg);
        this.target = continents;
    }

    public Objective(int type, String msg, String color){
        this(type, msg);
        this.color = color;
    }
    
    public Objective(int type, String msg, int nterritories){
        this(type, msg);
        this.nTerritories = nterritories;
    }
}
