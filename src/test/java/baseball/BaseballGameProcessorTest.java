package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballGameProcessorTest {

    private static final String COMPUTER_NUMBER = "123";
    private static final String TWO_STRIKE_NUMBER = "124";
    private static final String ONE_STRIKE_NUMBER = "154";
    private static final String THREE_BALL_NUMBER = "312";
    private static final String TWO_BALL_NUMBER = "315";
    private static final String ONE_BALL_NUMBER = "367";
    private static final String TWO_BALL_ONE_STRIKE_NUMBER = "321";
    private static final String ONE_BALL_ONE_STRIKE_NUMBER = "134";
    private static final String NOTHING_NUMBER = "456";


    BaseballGameProcessor processor = new BaseballGameProcessorImpl();



    @Test
    @DisplayName("3스트라이크 테스트")
    void threeStrikeTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, COMPUTER_NUMBER)).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("2스트라이크 테스트")
    void twoStrikeTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, TWO_STRIKE_NUMBER)).isEqualTo("2스트라이크");
    }

    @Test
    @DisplayName("1스트라이크 테스트")
    void oneStrikeTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, ONE_STRIKE_NUMBER)).isEqualTo("1스트라이크");
    }

    @Test
    @DisplayName("3볼 테스트")
    void threeBallTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, THREE_BALL_NUMBER)).isEqualTo("3볼");

    }

    @Test
    @DisplayName("2볼 테스트")
    void twoBallTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, TWO_BALL_NUMBER)).isEqualTo("2볼");

    }

    @Test
    @DisplayName("1볼 테스트")
    void oneBallTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, ONE_BALL_NUMBER)).isEqualTo("1볼");

    }


    @Test
    @DisplayName("2볼 1스트라이크 테스트")
    void twoBallOneStrikeTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, TWO_BALL_ONE_STRIKE_NUMBER)).isEqualTo("2볼 1스트라이크");

    }

    @Test
    @DisplayName("1볼 1스트라이크 테스트")
    void oneBallOneStrikeTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, ONE_BALL_ONE_STRIKE_NUMBER)).isEqualTo("1볼 1스트라이크");

    }

    @Test
    @DisplayName("낫싱 테스트")
    void nothingTest() {
        Assertions.assertThat(processor.process(COMPUTER_NUMBER, NOTHING_NUMBER)).isEqualTo("낫싱");

    }



}
