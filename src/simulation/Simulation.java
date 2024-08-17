package simulation;

import simulation.actions.*;
import simulation.map.WorldMap;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Manages the progression of the simulation,
 * including initializing the world map, spawning entities, and
 * executing actions for each turn in the simulation.
 */

public class Simulation {
    private static final WorldMap map = new WorldMap();
    private final List<EntitySpawnAction> entitySpawners;
    private final CreatureMoveAction action = new CreatureMoveAction();
    private int counterOfMoves;

    public Simulation(double predatorSpawnRate, double herbivoreSpawnRate, double obstacleSpawnRate, double grassSpawnRate) {
        this.entitySpawners = List.of(
                new PredatorSpawnAction(predatorSpawnRate),
                new HerbivoreSpawnAction(herbivoreSpawnRate),
                new ObstacleSpawnAction(obstacleSpawnRate),
                new GrassSpawnAction(grassSpawnRate)
        );
    }


    public void nextTurn() {
        counterOfMoves++;
        action.turnAction(map);
        map.render();

        ensureEntitiesCount();
    }

    public void startSimulation() {
        createMap();  // Initialize the map
        map.render();

        while (counterOfMoves < 100) {
            nextTurn();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void createMap() {
        for (EntitySpawnAction spawner : entitySpawners) {
            spawner.initActions(map);
        }
    }

    private void ensureEntitiesCount() {
        for (EntitySpawnAction spawner : entitySpawners) {
            spawner.ensureEntities(map);
        }
    }
}
