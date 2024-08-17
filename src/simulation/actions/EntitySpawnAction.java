package simulation.actions;

import simulation.map.Cell;
import simulation.map.WorldMap;

import java.util.Random;

/**
 * Abstract class for actions that spawn entities on the map.
 * Manages the spawn rate and provides utility methods for generating entities.
 */

public abstract class EntitySpawnAction extends Action {
    protected final Random random = new Random();
    protected double spawnRate;

    public EntitySpawnAction(double spawnRate) {
        this.spawnRate = spawnRate;
    }

    @Override
    public void initActions(WorldMap map) {
        generateEntities(map);
    }

    public abstract void generateEntities(WorldMap map);

    public abstract void ensureEntities(WorldMap map);

    protected Cell getRandomEmptyCoordinate(WorldMap map) {
        int x;
        int y;

        do {
            x = random.nextInt(WorldMap.ROWS);
            y = random.nextInt(WorldMap.COLS);
        } while (!map.isCellEmpty(new Cell(x, y)));

        return new Cell(x, y);
    }
}