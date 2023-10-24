package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BaseballTest {

    @Test
    void randomConstructorTest() {
        Baseball baseball = new Baseball();

        assertThat(baseball.isDuplicated(baseball.toString())).isFalse();
        assertThat(baseball.balls.contains(0)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {"asd", "406", "558", "1", "13", "0123", "%45", "s23", "7df"})
    void inputConstructorExceptionTest(String input) {
        assertThatThrownBy(() -> new Baseball(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void inputConstructorTest(String input) {
        Baseball baseball = new Baseball(input);

        assertThat(baseball.balls)
                .isEqualTo(input.chars()
                        .map(Character::getNumericValue)
                        .boxed()
                        .collect(Collectors.toList()));
    }

    @Test
    @DisplayName("answer balls: 123, expected balls: 123 => 3스트라이크")
    void checkResultTest1() {
        Baseball answer = new Baseball("123");
        Baseball expected = new Baseball("123");

        Score result = expected.checkResult(answer);

        assertThat(result.getStrikeCount()).isEqualTo(3);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("answer balls: 123, expected balls: 321 => 2볼 1스트라이크")
    void checkResultTest2() {
        Baseball answer = new Baseball("123");
        Baseball expected = new Baseball("321");

        Score result = expected.checkResult(answer);

        assertThat(result.getStrikeCount()).isEqualTo(1);
        assertThat(result.getBallCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("answer balls: 123, expected balls: 345 => 1볼")
    void checkResultTest3() {
        Baseball answer = new Baseball("123");
        Baseball expected = new Baseball("345");

        Score result = expected.checkResult(answer);

        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(1);
    }

    @Test
    @DisplayName("answer balls: 123, expected balls: 987 => 낫싱")
    void checkResultTest4() {
        Baseball answer = new Baseball("123");
        Baseball expected = new Baseball("987");

        Score result = expected.checkResult(answer);

        assertThat(result.getStrikeCount()).isEqualTo(0);
        assertThat(result.getBallCount()).isEqualTo(0);
    }

}
