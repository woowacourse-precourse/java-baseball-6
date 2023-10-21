package baseball;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballGameTest {

    @Test
    void readExitNumberExceptionTest() {
        final String input = "string";
        BaseballGame baseballGame = new BaseballGame();

        assertThatThrownBy(() -> baseballGame.readExitNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void readExitNumberTest(String input) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.readExitNumber(input);

        assertEquals(Integer.parseInt(input), baseballGame.exitNumber);
    }

    @Test
    void makeAnswerNumberTest() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.makeAnswerNumber();

        assertThat(baseballGame.isDuplicated(baseballGame.answerNumber)).isFalse();
        assertThat(baseballGame.answerNumber.contains(0)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "400", "1", "13"})
    void readExpectedNumberExceptionTest(String input) {
        BaseballGame baseballGame = new BaseballGame();

        assertThatThrownBy(() -> baseballGame.readExpectedNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void readExpectedNumberTest(String input) {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.readExpectedNumber(input);

        assertThat(baseballGame.expectedNumber)
                .isEqualTo(input.chars()
                        .map(Character::getNumericValue)
                        .boxed()
                        .collect(Collectors.toList()));
    }

}
