package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GameNumberSetTest {

    private InputNumber inputNumber;
    private RandomNumber randomNumber;

    private GameNumberSet gameNumberSet;

    @Test
    @DisplayName("스트라이크면 true 반환")
    void isStrikeTrueTest() {
        inputNumber = InputNumber.create(List.of(1, 2, 3));
        randomNumber = RandomNumber.create(List.of(1, 2, 3));
        gameNumberSet = new GameNumberSet(randomNumber, inputNumber);
        int index = 2;

        Assertions.assertThat(gameNumberSet.isStrike(index)).isEqualTo(true);
    }

    @Test
    @DisplayName("스트라이크가 아니면 false 반환")
    void isStrikeFalseTest() {
        inputNumber = InputNumber.create(List.of(1, 2, 3));
        randomNumber = RandomNumber.create(List.of(1, 2, 4));
        gameNumberSet = new GameNumberSet(randomNumber, inputNumber);
        int index = 2;

        Assertions.assertThat(gameNumberSet.isStrike(index)).isEqualTo(false);
    }

    @Test
    @DisplayName("볼이면 true 반환")
    void isBallTrueTest() {
        inputNumber = InputNumber.create(List.of(2, 1, 3));
        randomNumber = RandomNumber.create(List.of(4, 3, 2));
        gameNumberSet = new GameNumberSet(randomNumber, inputNumber);
        int index = 2;

        Assertions.assertThat(gameNumberSet.isBall(index)).isEqualTo(true);
    }

    @Test
    @DisplayName("볼이 아니면 false 반환")
    void isBallFalseTest() {
        inputNumber = InputNumber.create(List.of(2, 1, 3));
        randomNumber = RandomNumber.create(List.of(4, 6, 5));
        gameNumberSet = new GameNumberSet(randomNumber, inputNumber);
        int index = 2;

        Assertions.assertThat(gameNumberSet.isBall(index)).isEqualTo(false);
    }
}
