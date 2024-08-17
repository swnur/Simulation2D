package simulation.actions;

import simulation.creatures.Herbivore;
import simulation.map.Cell;
import simulation.map.WorldMap;

public class HerbivoreSpawnAction extends EntitySpawnAction {
    private int numberOfHerbivores;

    public HerbivoreSpawnAction(double spawnRate) {
        super(spawnRate);
        this.numberOfHerbivores = (int)(WorldMap.COLS * WorldMap.ROWS * spawnRate);
    }

    @Override
    public void generateEntities(WorldMap map) {
        for (int i = 0; i < numberOfHerbivores; i++) {
            Cell randomCell = getRandomEmptyCoordinate(map);
            map.placeEntity(new Herbivore(randomCell, 1, 1), randomCell);
        }
    }

    @Override
    public void ensureEntities(WorldMap map) {
        int currentCount = map.getEntitiesOfType(Herbivore.class).size();
        if (currentCount < numberOfHerbivores) {
            for (int i = 0; i < numberOfHerbivores - currentCount; i++) {
                Cell randomCell = getRandomEmptyCoordinate(map);
                map.placeEntity(new Herbivore(randomCell, 1, 1), randomCell);
            }
        }
    }

}
