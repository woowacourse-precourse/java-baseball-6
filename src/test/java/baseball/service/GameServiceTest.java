package baseball.service;

import baseball.domain.GameNumberSet;
import baseball.domain.GameStatus;
import baseball.domain.InputNumber;
import baseball.domain.RandomNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameServiceTest {

    @Test
    @DisplayName("randomNumber와 inputNumber를 비교한 후 gameStatus를 업데이트한다.")
    void compareNumberTest() {
        GameNumberSet gameNumberSet = new GameNumberSet(
                RandomNumber.create(List.of(1, 4, 3)),
                InputNumber.create(List.of(1, 2, 4))
        );
        GameStatus gameStatus = new GameStatus();

        GameService gameService = new GameService();

        gameService.compareNumber(gameNumberSet, gameStatus);
        int strikeCnt = gameStatus.getStrikeCnt();
        int ballCnt = gameStatus.getBallCnt();

        Assertions.assertThat(strikeCnt).isEqualTo(1);
        Assertions.assertThat(ballCnt).isEqualTo(1);
    }
}