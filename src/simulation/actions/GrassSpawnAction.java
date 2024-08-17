package simulation.actions;

import simulation.map.Cell;
import simulation.map.WorldMap;
import simulation.creatures.fixed.Grass;

public class GrassSpawnAction extends EntitySpawnAction {
    private int numberOfGrass;

    public GrassSpawnAction(double spawnRate) {
        super(spawnRate);
        this.numberOfGrass = (int)(WorldMap.COLS * WorldMap.ROWS * spawnRate);
    }

    @Override
    public void generateEntities(WorldMap map) {
        for (int i = 0; i < numberOfGrass; i++) {
            Cell randomCell = getRandomEmptyCoordinate(map);
            map.placeEntity(new Grass(randomCell), randomCell);
        }
    }

    @Override
    public void ensureEntities(WorldMap map) {
        int currentCount = map.getEntitiesOfType(Grass.class).size();
        if (currentCount < numberOfGrass) {
            for (int i = 0; i < numberOfGrass - currentCount; i++) {
                Cell randomCell = getRandomEmptyCoordinate(map);
                map.placeEntity(new Grass(randomCell), randomCell);
            }
        }
    }

}
