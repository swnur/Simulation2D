package simulation.creatures;

import simulation.map.Cell;
import simulation.map.WorldMap;


public class Predator extends Creature {
    private static final String SYMBOL = "\uD83D\uDC05";
    private final double attackPower;

    public Predator(Cell cell, int speed, double hp, double attackPower) {
        super(cell, speed, hp);
        this.attackPower = attackPower;
    }

    public double getAttackPower() {
        return attackPower;
    }

    @Override
    public void makeMove(WorldMap map, Cell toCell) {
        System.out.println(this + " moved from " + this.getCell() + " to " + toCell);

        Entity entity = map.getEntity(toCell);
        if (entity instanceof Herbivore herbivore) {
            herbivore.setHP(herbivore.getHP() - this.attackPower);
            if (herbivore.getHP() <= 0) {
                System.out.println(this + " killed " + herbivore + " at " + toCell);
                map.removeEntity(toCell);
            } else {
                System.out.println(this + " attacked " + herbivore + ". Remaining HP: " + herbivore.getHP());
            }
        }
        map.moveEntity(this.getCell(), toCell);
    }


    @Override
    public String toString() {
        return SYMBOL;
    }
}
