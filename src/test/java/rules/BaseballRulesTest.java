package rules;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BaseballRulesTest {

    @Test
    public void 스트라이크_볼_모두_존재_테스트() {
        //given
        int strike = 1;
        int ball = 1;

        //when
        boolean result = BaseballRules.hasStrikeAndBall(strike, ball);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void 스트라이크만_존재_테스트() {
        //given
        int strike = 1;
        int ball = 0;

        //when
        boolean result = BaseballRules.hasStrikeButNoBall(strike, ball);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void 볼만_존재_테스트() {
        //given
        int strike = 0;
        int ball = 1;

        //when
        boolean result = BaseballRules.hasBallButNoStrike(strike, ball);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void 스트라이크_볼_둘_다_존재하지않음_테스트() {
        //given
        int strike = 0;
        int ball = 0;

        //when
        boolean result = BaseballRules.noStrikeAndBall(strike, ball);

        //then
        assertThat(result).isTrue();
    }

    @Test
    public void 삼진아웃_테스트() {
        //given
        int strike = 3;

        //when
        boolean result = BaseballRules.isThreeStrike(strike);

        //then
        assertThat(result).isTrue();
    }
}
