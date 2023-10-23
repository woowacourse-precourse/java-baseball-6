package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class ApplicationCalculateResultTest {

    @Test
    void calculateResult_볼_스트라이크_테스트() {

        int strike = 1;
        int ball = 1;

        assertThat(Application.calculateResult(strike, ball)).isEqualTo(ball + "볼 " + strike + "스트라이크");

    }

    @Test
    void calculateResult_볼_테스트() {

        int strike = 0;
        int ball = 1;

        assertThat(Application.calculateResult(strike, ball)).isEqualTo(ball + "볼");
    }

    @Test
    void calculateResult_스트라이크_테스트() {

        int strike = 2;
        int ball = 0;

        assertThat(Application.calculateResult(strike, ball)).isEqualTo(strike + "스트라이크");
    }

    @Test
    void calculateResult_3스트라이크_테스트() {

        int strike = 3;
        int ball = 0;

        assertThat(Application.calculateResult(strike, ball)).isEqualTo("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    void calculateResult_낫싱_테스트() {

        int strike = 0;
        int ball = 0;

        assertThat(Application.calculateResult(strike, ball)).isEqualTo("낫싱");
    }

}
