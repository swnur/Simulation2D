package simulation.creatures.fixed;

import simulation.map.Cell;
import simulation.creatures.Entity;

/**
 * Represents an immovable entity fixed to a specific cell on the map.
 */

public abstract class FixedItem extends Entity  {

    public FixedItem(Cell cell) {
        super(cell);
    }
}
