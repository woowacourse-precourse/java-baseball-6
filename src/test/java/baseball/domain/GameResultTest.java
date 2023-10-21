package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {

    private GameResult gameResult;

    @BeforeEach
    void beforeEach() {
        gameResult = new GameResult();
    }

    @Test
    void settingTest() {
        assertThat(gameResult.getBallCount()).isEqualTo(0);
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void updateCountTest() {
        //given
        Judgement strike = Judgement.STRIKE;
        Judgement ball = Judgement.BALL;

        //when
        gameResult.updateCount(strike);
        gameResult.updateCount(ball);

        //then
        assertThat(gameResult.getStrikeCount()).isEqualTo(1);
        assertThat(gameResult.getBallCount()).isEqualTo(1);
    }

    @Test
    void isThreeStrikeTest() {
        //given
        Judgement strike = Judgement.STRIKE;
        int threeTimes = 3;

        //when
        for (int i = 0; i < threeTimes; i++) {
            gameResult.updateCount(strike);
        }

        //then
        assertThat(gameResult.isThreeStrike()).isTrue();
    }

    @Test
    void isNotThreeStrikeTest() {
        //given
        Judgement strike = Judgement.STRIKE;
        int twoTimes = 2;

        //when
        for (int i = 0; i < twoTimes; i++) {
            gameResult.updateCount(strike);
        }

        //then
        assertThat(gameResult.isNotThreeStrike()).isTrue();
    }

    @Test
    void resetTest() {
        //given
        Judgement strike = Judgement.STRIKE;
        Judgement ball = Judgement.BALL;

        //when
        gameResult.updateCount(strike);
        gameResult.updateCount(ball);

        gameResult.reset();

        //then
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
        assertThat(gameResult.getBallCount()).isEqualTo(0);
    }
}
