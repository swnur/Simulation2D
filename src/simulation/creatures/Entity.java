package simulation.creatures;

/* The root abstract class for all creatures and objects existing in the simulation. */

import simulation.map.Cell;

public abstract class Entity {
    private Cell cell;

    public Entity(Cell cell) {
        this.cell = cell;
    }

    public Cell getCell() {
        return cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }
}
