package baseball;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    @DisplayName("answerNumber: 123, expectedNumber: 123 => 3스트라이크")
    void computeAnswerTest1() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.answerNumber = List.of(1, 2, 3);
        baseballGame.expectedNumber = List.of(1, 2, 3);

        baseballGame.computeAnswer();

        assertThat(baseballGame.strikeNumber).isEqualTo(3);
        assertThat(baseballGame.ballNumber).isEqualTo(0);
    }

    @Test
    @DisplayName("answerNumber: 123, expectedNumber: 321 => 2볼 1스트라이크")
    void computeAnswerTest2() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.answerNumber = List.of(1, 2, 3);
        baseballGame.expectedNumber = List.of(3, 2, 1);

        baseballGame.computeAnswer();

        assertThat(baseballGame.strikeNumber).isEqualTo(1);
        assertThat(baseballGame.ballNumber).isEqualTo(2);
    }

    @Test
    @DisplayName("answerNumber: 123, expectedNumber: 345 => 1볼")
    void computeAnswerTest3() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.answerNumber = List.of(1, 2, 3);
        baseballGame.expectedNumber = List.of(3, 4, 5);

        baseballGame.computeAnswer();

        assertThat(baseballGame.strikeNumber).isEqualTo(0);
        assertThat(baseballGame.ballNumber).isEqualTo(1);
    }

    @Test
    @DisplayName("answerNumber: 123, expectedNumber: 987 => 낫싱")
    void computeAnswerTest4() {
        BaseballGame baseballGame = new BaseballGame();
        baseballGame.answerNumber = List.of(1, 2, 3);
        baseballGame.expectedNumber = List.of(9, 8, 7);

        baseballGame.computeAnswer();

        assertThat(baseballGame.strikeNumber).isEqualTo(0);
        assertThat(baseballGame.ballNumber).isEqualTo(0);
    }

}
