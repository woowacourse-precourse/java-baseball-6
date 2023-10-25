package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.domain.BaseballFlag.*;
import static org.assertj.core.api.Assertions.*;

class ComputerNumbersTest {

    @Test
    @DisplayName("숫자를 비교하면 BALL, STRIKE, BALL이 나와야 한다.")
    void compareToNumbers() {
        ComputerNumbers computerNumbers = new ComputerNumbers(List.of(1,5,4));
        assertThat(computerNumbers.match(List.of(4,5,1))).isEqualTo(List.of(BALL, STRIKE, BALL));
    }
}