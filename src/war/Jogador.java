package war;

import java.util.List;

/**
 *
 * @author diegomachado
 */
public class Jogador {
    
    private String name;
    private String color;
    private List<Territorio> Territorios;
    private Objetivo obj;
    private List<Carta> cartas;
    
    
    public Jogador(String name, String color){
        this.name = name;
        this.color = color;
    }
    
    
    // Gets and Sets
    public String getName() {
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getColor(){
        return this.color;
    }
    
    public void setColor(String color){
        this.color = color;
    }
}
