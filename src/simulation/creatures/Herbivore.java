package simulation.creatures;

import simulation.map.Cell;
import simulation.map.WorldMap;
import simulation.creatures.fixed.Grass;


public class Herbivore extends Creature {
    private static final String SYMBOL = "\uD83D\uDC07";

    public Herbivore(Cell cell, int speed, double hp) {
        super(cell, speed, hp);
    }

    @Override
    public void makeMove(WorldMap map, Cell toCell) {
        System.out.println(this + " moved from " + this.getCell() + " to " + toCell);

        Entity entity = map.getEntity(toCell);
        if (entity instanceof Grass) {
            System.out.println(this + " ate grass at " + toCell);
            map.removeEntity(toCell);
        }

        map.moveEntity(this.getCell(), toCell);
    }

    @Override
    public String toString() {
        return SYMBOL;
    }
}
