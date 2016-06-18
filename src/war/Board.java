/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package war;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author AleGomes
 */
public class Map {
    List<Continent> continents;

    public Map(String continentsFile, String neighborsFile) throws FileNotFoundException, IOException {
        this.continents = generateContinents(continentsFile,neighborsFile);
    }

    private List<Continent> generateContinents(String continentsFile, String neighborsFile) {
        return Collections.EMPTY_LIST;
    }
}
