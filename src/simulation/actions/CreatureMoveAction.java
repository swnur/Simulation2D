package simulation.actions;


import simulation.algorithm.BFSPathFinder;
import simulation.creatures.Creature;
import simulation.creatures.Herbivore;
import simulation.creatures.Predator;
import simulation.creatures.fixed.Grass;
import simulation.map.Cell;
import simulation.map.WorldMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Handles the movement actions of creatures on the map during a turn.
 */

public class CreatureMoveAction  {

    public void turnAction(WorldMap map) {
        moveCreature(map, getCreatureToMove(map));
    }

    public void moveCreature(WorldMap map, Creature creature) {
        BFSPathFinder pathFinder = new BFSPathFinder();
        List<Cell> pathToTarget = new ArrayList<>();

        if (creature instanceof Predator) {
            pathToTarget = pathFinder.getShortestPath(creature.getCell(), Herbivore.class, Grass.class, map);
        } else if (creature instanceof Herbivore) {
            pathToTarget = pathFinder.getShortestPath(creature.getCell(), Grass.class, Predator.class, map);
        }

        if (pathToTarget.isEmpty()) {
            System.out.println("Path not found");
            return;
        }

        for (int i = 1; i < pathToTarget.size(); i++) {
            creature.makeMove(map, pathToTarget.get(i));
            map.render();
        }
    }

    public Creature getCreatureToMove(WorldMap map) {
        return map.getEntitiesOfType(Creature.class).values()
                .stream()
                .findFirst()
                .orElse(null);
    }
}
