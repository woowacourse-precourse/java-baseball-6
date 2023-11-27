package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.GameResult;
import baseball.domain.Judgement;
import org.junit.jupiter.api.Test;

public class GameResultTest {

    @Test
    void 점수계산_3스트라이크() {
        GameResult gameResult = new GameResult();

        gameResult.updateScore(Judgement.STRIKE);
        gameResult.updateScore(Judgement.STRIKE);
        gameResult.updateScore(Judgement.STRIKE);

        boolean result = gameResult.isThreeStrike();

        assertThat(result).isTrue();
    }

    @Test
    void 점수계산_3스트라이크_아닌경우() {
        GameResult gameResult = new GameResult();

        gameResult.updateScore(Judgement.STRIKE);
        gameResult.updateScore(Judgement.STRIKE);

        boolean result = gameResult.isThreeStrike();

        assertThat(result).isFalse();
    }
}
