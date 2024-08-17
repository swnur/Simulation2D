package simulation.algorithm;

import simulation.map.Cell;
import simulation.map.WorldMap;
import simulation.creatures.Entity;
import simulation.creatures.fixed.FixedItem;

import java.util.*;

/**
 * Finds the shortest path on the map using the Breadth-First Search (BFS) algorithm.
 */

public class BFSPathFinder {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public List<Cell> getShortestPath(Cell startCell, Class<?> targetType, Class<?> avoidType, WorldMap map) {
        Queue<List<Cell>> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[WorldMap.ROWS][WorldMap.COLS];

        List<Cell> startPath = new ArrayList<>();
        startPath.add(startCell);
        queue.add(startPath);
        visited[startCell.getX()][startCell.getY()] = true;

        while (!queue.isEmpty()) {
            List<Cell> currentPath = queue.poll();
            Cell currentCell = currentPath.get(currentPath.size() - 1);
            Entity entity = map.getEntity(currentCell);

            if (targetType.isInstance(entity)) {
                return currentPath;
            }

            for (int i = 0; i < 4; i++) {
                int newX = currentCell.getX() + dx[i];
                int newY = currentCell.getY() + dy[i];

                if (isWithinBounds(newX, newY) && !visited[newX][newY]) {
                    Cell neighbor = new Cell(newX, newY);
                    Entity neighborEntity = map.getEntity(neighbor);

                    if (neighborEntity instanceof FixedItem || avoidType.isInstance(neighborEntity)) {
                        continue;
                    }

                    if (neighborEntity == null || targetType.isInstance(neighborEntity)) {
                        visited[newX][newY] = true;

                        List<Cell> newPath = new ArrayList<>(currentPath);
                        newPath.add(neighbor);
                        queue.add(newPath);
                    }
                }
            }
        }

        return Collections.emptyList();
    }


    private boolean isWithinBounds(int x, int y) {
        return x >= 0 && x < WorldMap.ROWS && y >= 0 && y < WorldMap.COLS;
    }

}
