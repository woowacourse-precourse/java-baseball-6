package baseball;

import baseball.model.GameStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameStatusTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void 게임_상태_반환_테스트(String input) {
        Assertions.assertEquals(GameStatus.GAME_OVER, GameStatus.fromIsThreeStrike(true));
    }
}
