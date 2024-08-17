package simulation.actions;

import simulation.creatures.fixed.FixedItem;
import simulation.map.Cell;
import simulation.map.WorldMap;
import simulation.creatures.fixed.Rock;
import simulation.creatures.fixed.Tree;

public class ObstacleSpawnAction extends EntitySpawnAction {
    private int numberOfObstacles;

    public ObstacleSpawnAction(double spawnRate) {
        super(spawnRate);
        this.numberOfObstacles = (int)(WorldMap.COLS * WorldMap.ROWS * spawnRate);
    }

    @Override
    public void generateEntities(WorldMap map) {
        for (int i = 0; i < numberOfObstacles; i++) {
            Cell randomCell = getRandomEmptyCoordinate(map);
            if (i < numberOfObstacles / 2) {
                map.placeEntity(new Rock(randomCell), randomCell);
            } else {
                map.placeEntity(new Tree(randomCell), randomCell);
            }
        }
    }

    @Override
    public void ensureEntities(WorldMap map) {
        int currentCount = map.getEntitiesOfType(FixedItem.class).size();
        if (currentCount < numberOfObstacles) {
            for (int i = 0; i < numberOfObstacles - currentCount; i++) {
                Cell randomCell = getRandomEmptyCoordinate(map);
                int randomValue = random.nextInt(1, 3);
                switch (randomValue) {
                    case 1 -> map.placeEntity(new Rock(randomCell), randomCell);
                    case 2 -> map.placeEntity(new Tree(randomCell), randomCell);
                }
            }
        }
    }


}
