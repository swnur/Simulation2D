package simulation.creatures.fixed;

import simulation.map.Cell;

public class Tree extends FixedItem {
    private static final String SYMBOL = "\uD83C\uDF33";

    public Tree(Cell cell) {
        super(cell);
    }

    @Override
    public String toString() {
        return SYMBOL;
    }
}
