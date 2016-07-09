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
    List<Territory> territories;

    public Board(String continentsFile, String neighborsFile) throws FileNotFoundException, IOException {
        this.continents = generateContinents(continentsFile, neighborsFile);
        this.territories = generateTerritories();
    }

    private List<Continent> generateContinents(String continentsFile, String neighborsFile) {
        //A partir do arquivo de continentes e territorios, criar os continentes e seus territorios

        ArrayList<String> territoriesLines = new ArrayList<>();

        try {
            territoriesLines = (ArrayList<String>) Files.readAllLines(Paths.get(continentsFile), Charset.forName("Cp1252"));
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }

        
        ArrayList<Territory> territories; //Temporaria apenas para criar a lista de territorios de cada continente
        ArrayList<Territory> allTerritories = new ArrayList<>(); //Usada para associar os territorios com seus vizinhos
        //Map allTerritories = new HashMap();
        ArrayList<Continent> continents = new ArrayList<>();

        int territoryNumber = 0;
        
        //Cada linha do arquivo possui um continente e seus territorios.
        //Para cada continente (linha do arquivo)
        for (int i = 0; i < territoriesLines.size(); i++) {
            //Arquivo de continentes no formato nome-continente;nome-territorio]
            String continentName = territoriesLines.get(i).split(";")[0];
            
            territories = new ArrayList<>();
            //continete;territorio1;territorio2;territorio3;...
            //Para cada cada territorio dessa linha
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

        //Arquivo de vizinhos é no formato territorio;vizinho1;vizinho2;...
        //Para cada territorio
        for (int i = 0; i < allTerritories.size(); i++) {
            String neighborsLine = getNeighborsLine(allTerritories.get(i), neighboorsLines);

            //Para cada vizinho desse territorio obter o objeto territory
            for (int j = 1; j < neighborsLine.split(";").length; j++) {
                allTerritories.get(i).addNeighbor(obtainTerritory(neighborsLine.split(";")[j], allTerritories));
            }
        }

        //A partir da lista allTerritories, que tem os terriorios e seus vizinhos
        //atualizamos a lista de territorios de cada continente.
        
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

    //Encontrar a linha do arquivo referente ao territorio desejado.
    private String getNeighborsLine(Territory territory, ArrayList<String> neighboorsLines) {
        for (String line : neighboorsLines) {
            if (line.split(";")[0].equalsIgnoreCase(territory.getName())) {
                return line;
            }
        }
        return "";
    }

    //Obter o objeto Territory do vizinho a partir do nome dele.
    private Territory obtainTerritory(String neighbor, ArrayList<Territory> allTerritories) {
        for (Territory territory : allTerritories) {
            if (neighbor.equalsIgnoreCase(territory.getName())) {
                return territory;
            }
        }
        return null;
    }

    private List<Territory> generateTerritories() {
        ArrayList<Territory> t = new ArrayList<Territory>();
        for(Continent c : this.continents){
            for(Territory te : this.territories){
                t.add(te);
            }
        }
        return t;
    }
}
