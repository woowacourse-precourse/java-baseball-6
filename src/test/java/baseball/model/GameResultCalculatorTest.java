package baseball.model;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultCalculatorTest {
    private GameResultCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new GameResultCalculator();
    }

    @Test
    public void 랜덤숫자와_입력숫자를_주면_정확한_낫싱_결과_반환() {
        // given
        Number randomNumber = new Number(123);
        Number inputNumber = new Number(Arrays.asList(4, 5, 6));

        // when
        calculator.makeGameResult(randomNumber, inputNumber);

        // then
        assertThat(calculator.toString()).isEqualTo("낫싱");
    }

    @Test
    public void 랜덤숫자와_입력숫자를_주면_정확한_볼_결과_반환() {
        // given
        Number randomNumber = new Number(123);
        Number inputNumber = new Number(Arrays.asList(3, 1, 4));

        // when
        calculator.makeGameResult(randomNumber, inputNumber);

        // then
        assertThat(calculator.toString()).isEqualTo("2볼");
    }

    @Test
    public void 랜덤숫자와_입력숫자를_주면_정확한_스트라이트_결과_반환() {
        // given
        Number randomNumber = new Number(123);
        Number inputNumber = new Number(Arrays.asList(1, 2, 4));

        // when
        calculator.makeGameResult(randomNumber, inputNumber);

        // then
        assertThat(calculator.toString()).isEqualTo("2스트라이크");
    }

    @Test
    public void 랜덤숫자와_입력숫자를_주면_정확한_볼과_스트라이트_결과_반환() {
        // given
        Number randomNumber = new Number(123);
        Number inputNumber = new Number(Arrays.asList(1, 3, 4));

        // when
        calculator.makeGameResult(randomNumber, inputNumber);

        // then
        assertThat(calculator.toString()).isEqualTo("1볼 1스트라이크");
    }

    @Test
    public void 랜덤숫자와_입력숫자를_주면_3스트라이크인지_확인() {
        // given
        Number randomNumber = new Number(123);
        Number inputNumber = new Number(Arrays.asList(1, 2, 3));

        // when
        calculator.makeGameResult(randomNumber, inputNumber);

        // then
        assertThat(calculator.isThreeStrike()).isEqualTo(true);
    }

    @Test
    public void 랜덤숫자와_입력숫자를_주면_3스트라이크가_아닌지_확인() {
        // given
        Number randomNumber = new Number(123);
        Number inputNumber = new Number(Arrays.asList(1, 2, 4));

        // when
        calculator.makeGameResult(randomNumber, inputNumber);

        // then
        assertThat(calculator.isThreeStrike()).isEqualTo(false);
    }


}