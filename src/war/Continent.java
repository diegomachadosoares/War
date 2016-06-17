/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

import java.util.List;

/**
 *
 * @author AleGomes
 */
public class Continent {
  List<Territory> territories;
    String name;
    public Continent(String name, List<Territory> territories){
        this.name = name;
        this.territories = territories;
    }  
}
