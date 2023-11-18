package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerNumberTest {
    @DisplayName("1 이상 9 이하의 숫자 3개가 생성된다.")
    @Test
    void create() {
        // given
        ComputerNumber computerNumber = ComputerNumber.create();

        // when, then
        assertThat(computerNumber.findNumberByPosition(0)).isBetween(1, 9);
        assertThat(computerNumber.findNumberByPosition(1)).isBetween(1, 9);
        assertThat(computerNumber.findNumberByPosition(2)).isBetween(1, 9);
    }

}