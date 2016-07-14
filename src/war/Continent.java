package war;

import java.util.List;

/**
 *
 * @author AleGomes
 */
public class Continent {

    private final List<Territory> territories;
    private final String name;
    private final int id;

    public Continent(String name, int id, List<Territory> territories) {
        this.name = name;
        this.territories = territories;
        this.id = id;
    }

    public List<Territory> getTerritories() {
        return this.territories;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Continent continent = (Continent) obj;

        return this.getName().equalsIgnoreCase(continent.getName())
                && this.territories.equals(continent.getTerritories());
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }
}
