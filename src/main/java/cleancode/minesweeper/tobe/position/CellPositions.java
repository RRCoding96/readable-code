package cleancode.minesweeper.tobe.position;

import cleancode.minesweeper.tobe.cell.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CellPositions {

    private final List<CellPosition> cellPositions;

    private CellPositions(List<CellPosition> cellPositions) {
        this.cellPositions = cellPositions;
    }

    public static CellPositions of(List<CellPosition> cellPositions) {
        return new CellPositions(cellPositions);
    }

    public static CellPositions from(Cell[][] board) {
        List<CellPosition> cellPositions = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                CellPosition cellPosition = CellPosition.of(row, col);
                cellPositions.add(cellPosition);
            }
        }

        return of(cellPositions);
    }

    public List<CellPosition> extractRandomPositions(int count) {
        List<CellPosition> cellPositions = new ArrayList<>(this.cellPositions);
        Collections.shuffle(cellPositions);
        return cellPositions.subList(0, count);
    }


    public List<CellPosition> subtract(List<CellPosition> positionListToSubtract) {
        List<CellPosition> cellPositions = new ArrayList<>(this.cellPositions);

        CellPositions positionsToSubtract = CellPositions.of(positionListToSubtract);

        return cellPositions.stream()
            .filter(positionsToSubtract::doesNotContain)
            .toList();
    }

    private boolean doesNotContain( CellPosition position) {
        return !cellPositions.contains(position);
    }

    public List<CellPosition> getCellPositions() {
        return new ArrayList<>(cellPositions);
    }
}
