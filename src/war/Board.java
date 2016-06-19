/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package war;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author AleGomes
 */
public class Board {

    List<Continent> continents;

    public Board(String continentsFile, String neighborsFile) throws FileNotFoundException, IOException {
        this.continents = generateContinents(continentsFile, neighborsFile);
    }

    private List<Continent> generateContinents(String continentsFile, String neighborsFile) {
        //A partir do arquivo de continentes e territorios, criar os continentes e seus territorios

        ArrayList<String> territoriesLines = new ArrayList<>();

        try {
            territoriesLines = (ArrayList<String>) Files.readAllLines(Paths.get(continentsFile), Charset.forName("Cp1252"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        ArrayList<Territory> territories;
        ArrayList<Territory> allTerritories = new ArrayList<>();
        //Map allTerritories = new HashMap();
        ArrayList<Continent> continents = new ArrayList<>();

        int territoryNumber = 0;
        for (int i = 0; i < territoriesLines.size(); i++) {
            String continentName = territoriesLines.get(i).split(";")[0];
            
            territories = new ArrayList<>();
            for (int j = 1; j < territoriesLines.get(i).split(";").length; j++) {
                String territoryName = territoriesLines.get(i).split(";")[j];
                territories.add(new Territory(territoryName, null, territoryNumber));
                allTerritories.add(new Territory(territoryName, null, territoryNumber));
                territoryNumber++;
            }
            Continent c = new Continent(continentName, territories);
            continents.add(c);
            //allTerritories.put(c, territories);
        }


        //A partir dos terrorios e da lista de vizinhos, atribuir os vizinhos de cada territorio
        ArrayList<String> neighboorsLines = new ArrayList<>();
        try {
            neighboorsLines = (ArrayList<String>) Files.readAllLines(Paths.get(neighborsFile), Charset.forName("Cp1252"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        for (int i = 0; i < allTerritories.size(); i++) {
            String neighborsLine = getNeighborsLine(allTerritories.get(i), neighboorsLines);

            for (int j = 1; j < neighborsLine.split(";").length; j++) {
                allTerritories.get(i).addNeighbor(getTerritory(neighborsLine.split(";")[j], allTerritories));
            }
        }

        for (int i = 0; i < continents.size(); i++) {
            for (int j = 0; j < continents.get(i).getTerritories().size(); j++) {
                for (int k = 0; k < allTerritories.size(); k++) {
                    if (allTerritories.get(k).getName().equalsIgnoreCase(continents.get(i).getTerritories().get(j).getName())) {
                        continents.get(i).getTerritories().get(j).setNeighbors(allTerritories.get(k).getNeighbors());
                    }
                }
            }
        }
        return continents;
    }

    private String getNeighborsLine(Territory territory, ArrayList<String> neighboorsLines) {
        for (String line : neighboorsLines) {
            if (line.split(";")[0].equalsIgnoreCase(territory.getName())) {
                return line;
            }
        }
        return "";
    }

    private Territory getTerritory(String neighbor, ArrayList<Territory> allTerritories) {
        for (Territory territory : allTerritories) {
            if (neighbor.equalsIgnoreCase(territory.getName())) {
                return territory;
            }
        }
        return null;
    }
}
