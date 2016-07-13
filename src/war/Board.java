package war;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author AleGomes
 */
public class Board {

    private final Map<Integer, Continent> continents;
    private final Map<Integer, Territory> territories;

    public Board(String continentsFile, String territoriesFile, String neighborhoodFile) throws FileNotFoundException, IOException {
        this.continents = new HashMap<>();
        this.territories = new HashMap<>();
        readTerritories(territoriesFile);
        readContinents(continentsFile);
        //readNeighborhood(neighborhoodFile);
    }

    private void readTerritories(String territoriesFile) throws FileNotFoundException {
        try {
            Scanner sc = new Scanner(new FileInputStream(new File(territoriesFile)));
            String currline;
            String[] split;
            while(sc.hasNextLine()){
                currline = sc.nextLine();
                split = currline.split(":");
                this.territories.put(Integer.parseInt(split[0]),new Territory(split[1], null, Integer.parseInt(split[0])));
            }
        } catch (FileNotFoundException e){
        }
    }

    private void readContinents(String continentsFile) throws FileNotFoundException {
        try{
            Scanner sc = new Scanner(new FileInputStream(new File(continentsFile)));            
            String currline;
            String[] split, t;
            List<Territory> tlist = new LinkedList();
            while(sc.hasNextLine()){
                currline = sc.nextLine();
                split = currline.split(":");
                t = split[2].split(";");
                for (String t1 : t) {
                    tlist.add(getTerritory(Integer.parseInt(t1)));
                }
                Continent c = new Continent(split[1], Integer.parseInt(split[0]), tlist);
                this.continents.put(Integer.parseInt(split[0]), c);
            }
        } catch (FileNotFoundException e){
        }
    }

    public Map getTerritories(){
        return this.territories;
    }
    
    public Map getContinents() {
        return this.continents;
    }
    
    public Territory getTerritory(Integer i){
        return this.territories.get(i);
    }
}
