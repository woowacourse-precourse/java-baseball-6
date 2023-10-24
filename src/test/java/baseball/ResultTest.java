package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static baseball.BaseballsGenerator.createBaseballsByUserInput;

class ResultTest {

    @ParameterizedTest
    @DisplayName("Result 는 결과 값을 출력 형식에 맞는 String 으로 반환할 수 있다")
    @CsvSource(value = {"123:132:2볼 1스트라이크", "123:123:3스트라이크", "123:456:낫싱", "359:935:3볼"}, delimiterString = ":")
    public void getResultTest(String num1, String num2, String expected) {
        // given
        Baseballs baseballs = createBaseballsByUserInput(num1);
        Baseballs compareBaseballs = createBaseballsByUserInput(num2);
        Result result = new Result(baseballs, compareBaseballs);

        // when
        String actual = result.getResult();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("Result 는 클리어 유무를 반환할 수 있다")
    @CsvSource(value = {"123:123:true", "123:124:false"}, delimiterString = ":")
    public void getResultTest(String num1, String num2, boolean expected) {
        // given
        Baseballs baseballs = createBaseballsByUserInput(num1);
        Baseballs compareBaseballs = createBaseballsByUserInput(num2);
        Result result = new Result(baseballs, compareBaseballs);

        // when
        boolean actual = result.isClear();

        // then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

}