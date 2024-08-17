package simulation.map;

/**
 * Responsible for rendering the visual representation
 * of the WorldMap in the console, displaying entities and empty cells.
 */

public class WorldMapRenderer {
    private static final String EMPTY_CELL_SYMBOL = "•";
    private static final int CELL_WIDTH = 4;

    public void renderMap(WorldMap map) {
        System.out.println("==========================================");
        for (int row = 0; row < WorldMap.ROWS; row++) {
            StringBuilder rowOutput = new StringBuilder();

            for (int col = 0; col < WorldMap.COLS; col++) {
                Cell currCell = new Cell(row, col);

                String cellContent;
                if (!map.isCellEmpty(currCell)) {
                    cellContent = map.getEntity(currCell).toString();
                } else {
                    cellContent = EMPTY_CELL_SYMBOL;
                }

                rowOutput.append(String.format(" %-" + CELL_WIDTH + "s", cellContent));
            }

            System.out.println("| " + rowOutput);
        }
        System.out.println("=========================================");
    }

}
