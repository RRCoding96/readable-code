package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberCellTest {

    @DisplayName("숫자 셀은 지뢰가 아니다.")
    @Test
    void isLandMine() {
        // given
        final int nearbyNumber = 5;
        NumberCell numberCell = new NumberCell(nearbyNumber);
        // when
        boolean result = numberCell.isLandMine();
        // then
        assertThat(result).isFalse();
    }

}