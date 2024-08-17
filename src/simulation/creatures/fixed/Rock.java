package simulation.creatures.fixed;

import simulation.map.Cell;

public class Rock extends FixedItem {
    private static final String SYMBOL = "\uD83E\uDEA8";

    public Rock(Cell cell) {
        super(cell);
    }

    @Override
    public String toString() {
        return SYMBOL;
    }
}
