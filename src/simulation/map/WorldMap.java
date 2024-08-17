package simulation.map;

import simulation.creatures.Entity;

import java.util.*;

/**
 * The map contains a collection for storing creatures and their locations.
 */

public class WorldMap {
    public static final int ROWS = 8;
    public static final int COLS = 8;
    private final WorldMapRenderer renderer = new WorldMapRenderer();
    private Map<Cell, Entity> cells = new HashMap<>();

    public void placeEntity(Entity entity, Cell cell) {
        entity.setCell(cell);
        cells.put(cell, entity);
    }

    public Entity getEntity(Cell cell) {
        return cells.getOrDefault(cell, null);
    }

    public void removeEntity(Cell cell) {
        cells.remove(cell);
    }

    public boolean isCellEmpty(Cell cell) {
        return cells.get(cell) == null;
    }

    public void moveEntity(Cell from, Cell to) {
        Entity entity = getEntity(from);
        removeEntity(from);

        placeEntity(entity, to);
    }

    public <T> Map<Cell, T> getEntitiesOfType(Class<T> typeEntity) {
        Map<Cell, T> result = new HashMap<>();

        for (Map.Entry<Cell, Entity> entry : cells.entrySet()) {
            if (typeEntity.isInstance(entry.getValue())) {
                result.put(entry.getKey(), (T) entry.getValue());
            }
        }

        return result;
    }

    public void render() {
        renderer.renderMap(this);
    }

}
