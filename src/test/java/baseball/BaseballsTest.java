package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static baseball.BaseballsGenerator.createBaseballsByUserInput;
import static org.assertj.core.api.Assertions.*;

class BaseballsTest {

    @ParameterizedTest
    @DisplayName("Baseballs 는 중복되는 숫자(Baseball)가 존재할 수 없다")
    @CsvSource(value = {"1, 1, 2", "2, 3, 3", "7, 7, 7", "5, 5, 5"})
    public void validateDuplicateTest(int num1, int num2, int num3) {
        // given
        List<Baseball> baseballs = new ArrayList<>();
        baseballs.add(new Baseball(num1));
        baseballs.add(new Baseball(num2));
        baseballs.add(new Baseball(num3));

        // when, then
        assertThatThrownBy(() -> new Baseballs(baseballs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("Baseballs 는 정확히 3개의 숫자(Baseball)만 존재할 수 있다")
    @ValueSource(strings = {"1", "12", "1234", "12345"})
    public void validateSizeTest(String input) {
        // given, when, then
        assertThatThrownBy(() -> createBaseballsByUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("스트라이크의 개수를 구할 수 있다")
    @CsvSource(value = {"312:412:2", "135:246:0", "987:953:1", "543:543:3"}, delimiterString = ":")
    public void countStrikeTest(String num1, String num2, int expected) {
        // given
        Baseballs computerBaseballs = createBaseballsByUserInput(num1);
        Baseballs userBaseballs = createBaseballsByUserInput(num2);

        // when
        int actual = computerBaseballs.countStrike(userBaseballs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("볼의 개수를 구할 수 있다")
    @CsvSource(value = {"123:456:0", "135:254:1", "246:461:2", "321:132:3"}, delimiterString = ":")
    public void countBallTest(String num1, String num2, int expected) {
        // given
        Baseballs computerBaseballs = createBaseballsByUserInput(num1);
        Baseballs userBaseballs = createBaseballsByUserInput(num2);

        // when
        int actual = computerBaseballs.countBall(userBaseballs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}