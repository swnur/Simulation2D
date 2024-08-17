package simulation.creatures.fixed;

import simulation.map.Cell;
import simulation.creatures.Entity;

public class Grass extends Entity {
    private static final String SYMBOL = "\uD83C\uDF31";

    public Grass(Cell cell) {
        super(cell);
    }

    @Override
    public String toString() {
        return SYMBOL;
    }
}
