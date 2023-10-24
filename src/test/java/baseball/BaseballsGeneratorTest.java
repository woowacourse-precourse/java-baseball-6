package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballsGeneratorTest {

    @Test
    @DisplayName("BaseballsGenerator 는 랜덤값으로 Baseballs 를 생성할 수 있다")
    public void createBaseballsByRandomNumberTest() {
        // given, when, then
        Baseballs baseballs = BaseballsGenerator.createBaseballsByRandomNumber();
    }

    @ParameterizedTest
    @DisplayName("BaseballsGenerator 는 입력한 값으로 Baseballs 를 생성할 수 있다")
    @ValueSource(strings = {"123", "456", "789"})
    public void createBaseballsByUserInput(String input) {
        // given, when, then
        Baseballs baseballs = BaseballsGenerator.createBaseballsByUserInput(input);
    }

    @ParameterizedTest
    @DisplayName("입력값이 올바르지 않으면 IllegalArgumentException 를 발생시킨다")
    @ValueSource(strings = {"1", "11", "111", "112", "1234"})
    public void badInputForCreateBaseballsByUserInputTest(String input) {
        // given, when, then
        Assertions.assertThatThrownBy(() -> BaseballsGenerator.createBaseballsByUserInput(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}