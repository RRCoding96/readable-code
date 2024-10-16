package cleancode.minesweeper.tobe.minesweeper.board.position;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CellPositionTest {

    @DisplayName("CellPosition의 row 값이 파라미터의 값보다 크거나 같으면 true 반환")
    @Test
    void isRowIndexMoreThanOrEqual() {
        // given
        final int parameterRow = 5;
        CellPosition cellPosition = CellPosition.of(10, 10);

        // when
        boolean result = cellPosition.isRowIndexMoreThanOrEqual(parameterRow);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("셀 기준으로 떨어진 셀의 row와 col이 모두 0 이상이면 탐색할 수 있다.")
    @Test
    void canCalculatePositionBy() {
        // given
        RelativePosition relativePosition = RelativePosition.of(5, 5);
        CellPosition cellPosition = CellPosition.of(10, 10);

        // when
        boolean result = cellPosition.canCalculatePositionBy(relativePosition);

        // then
        assertThat(result).isTrue();
    }


    @DisplayName("셀의 row 값이 입력받은 rowIndex 값보다 더 작으면 true를 반환한다.")
    @Test
    void isRowIndexLessThan() {
        // given
        CellPosition cellPosition = CellPosition.of(10, 10);

        // when
        boolean result = cellPosition.isRowIndexLessThan(20);

        // then
        assertThat(result).isTrue();
    }

}