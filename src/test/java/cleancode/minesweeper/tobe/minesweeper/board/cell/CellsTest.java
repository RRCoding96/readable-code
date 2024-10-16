package cleancode.minesweeper.tobe.minesweeper.board.cell;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class CellsTest {

    @DisplayName("Cells에 있는 Cell들이 모두 체크되었으면 true를 반환한다.")
    @Test
    void isAllChecked() {
        // given
        NumberCell numberCell1 = new NumberCell(1);
        NumberCell numberCell2 = new NumberCell(2);
        NumberCell numberCell3 = new NumberCell(3);
        LandMineCell landMineCell = new LandMineCell();

        Cells cells = Cells.of(List.of(numberCell1, numberCell2, numberCell3, landMineCell));

        numberCell1.open();
        numberCell2.open();
        numberCell3.open();
        landMineCell.open();
        // when
        boolean result = cells.isAllChecked();

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("Cells에 있는 Cell들이 하나라도 체크되지 않았으면 false를 반환한다.")
    @Test
    void isAllChecked2() {
        // given
        NumberCell numberCell1 = new NumberCell(1);
        NumberCell numberCell2 = new NumberCell(2);
        NumberCell numberCell3 = new NumberCell(3);
        LandMineCell landMineCell = new LandMineCell();

        Cells cells = Cells.of(List.of(numberCell1, numberCell2, numberCell3, landMineCell));

        numberCell1.open();
        numberCell2.open();
        landMineCell.open();
        // when
        boolean result = cells.isAllChecked();

        // then
        assertThat(result).isFalse();
    }
}