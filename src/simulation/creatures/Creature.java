package simulation.creatures;

import simulation.map.Cell;
import simulation.map.WorldMap;

/**
 * It strives to find a resource (grass) and can spend its turn moving towards the grass or consuming it.
 */

public abstract class Creature extends Entity {
    private final int speed;
    private double hp;

    public Creature(Cell cell, int speed, double hp) {
        super(cell);
        this.speed = speed;
        this.hp = hp;
    }

    public int getSpeed() {
        return speed;
    }

    public double getHP() {
        return hp;
    }

    public void setHP(double hp) {
        this.hp = hp;
    }

    public abstract void makeMove(WorldMap map, Cell toCell);
}
