/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

/**
 *
 * @author AleGomes
 */
public class JokerCard {
    private String figure;
    
    public JokerCard(String figure){
        this.figure = figure;
    }

    /**
     * @return the figure
     */
    public String getFigure() {
        return figure;
    }

    /**
     * @param figure the figure to set
     */
    public void setFigure(String figure) {
        this.figure = figure;
    }
}
