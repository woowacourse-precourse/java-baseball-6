package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.printer.BaseballPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BaseballPrinterTest {
    private BaseballPrinter baseballPrinter;

    @BeforeEach
    public void setUp() {
        baseballPrinter = new BaseballPrinter();
    }

    @Test
    void 볼과_스트라이크가_0이면_낫싱이다() {
        //given
        int ball = 0;
        int strike = 0;

        //when
        String result = baseballPrinter.printResult(ball, strike);

        //then
        String expectedResult = "낫싱";
        assertEquals(expectedResult, result);
    }

    @Test
    void 볼과_스트라이크가_둘다_존재한다() {
        //given
        int ball = 1;
        int strike = 2;

        //when
        String result = baseballPrinter.printResult(ball, strike);

        //then
        String expectedResult = "1볼 2스트라이크";
        assertEquals(expectedResult, result);
    }

    @Test
    void 볼과_스트라이크_중_하나만_존재한다() {
        //given
        int ball = 1;
        int strike = 0;

        //when
        String result = baseballPrinter.printResult(ball, strike);

        //then
        String expectedResult = "1볼";
        assertEquals(expectedResult, result);
    }
}