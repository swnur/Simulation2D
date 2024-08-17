package simulation.actions;

import simulation.creatures.Predator;
import simulation.map.Cell;
import simulation.map.WorldMap;

public class PredatorSpawnAction extends EntitySpawnAction {
    private int numberOfPredators;

    public PredatorSpawnAction(double spawnRate) {
        super(spawnRate);
        this.numberOfPredators = (int)(WorldMap.COLS * WorldMap.ROWS * spawnRate);
    }

    @Override
    public void generateEntities(WorldMap map) {
        for (int i = 0; i < numberOfPredators; i++) {
            Cell randomCell = getRandomEmptyCoordinate(map);
            map.placeEntity(new Predator(randomCell, 1, 1, 1), randomCell);
        }
    }

    @Override
    public void ensureEntities(WorldMap map) {
        int currentCount = map.getEntitiesOfType(Predator.class).size();
        if (currentCount < numberOfPredators) {
            for (int i = 0; i < numberOfPredators - currentCount; i++) {
                Cell randomCell = getRandomEmptyCoordinate(map);
                map.placeEntity(new Predator(randomCell, 1, 1, 1), randomCell);
            }
        }
    }
}
