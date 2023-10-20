package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.GameResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class GameServiceTest {

    GameService gameService;
    @BeforeEach
    void beforeEach() {
        BaseballGame baseballGame = new BaseballGame(new ArrayList<>(Arrays.asList(1, 3, 6)));
        gameService = new GameService(baseballGame);
    }
    @Test
    void 입력받은_값과_컴퓨터_숫자_비교() {
        GameResult result = gameService.getResult("123");
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(1);

        GameResult result2 = gameService.getResult("136");
        assertThat(result2.getStrike()).isEqualTo(3);
        assertThat(result2.getBall()).isEqualTo(0);
    }

    @Test
    void 컴퓨터의_숫자_새로_초기화() {
        gameService.restart();
        gameService.numbersInit();
        GameResult result = gameService.getResult("136");
        assertThat(result.getStrike()).isNotEqualTo(3);
    }

}