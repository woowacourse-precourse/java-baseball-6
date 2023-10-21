package baseball.service;

import baseball.domain.GameNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;
    private GameNumber answerNumber;

    @BeforeEach
    void beforeEach() {
        this.gameService = GameService.startNewGame();
        this.answerNumber = new GameNumber(List.of(1, 2, 3));
    }

    @Test
    void compareNumberTest1() {
        //given
        GameNumber userNumber = new GameNumber(List.of(3, 2, 1));

        //when
        gameService.compareNumber(answerNumber, userNumber);

        //then
        assertThat(gameService.isNotDone()).isTrue();
    }

    @Test
    void compareNumberTest2() {
        //given
        GameNumber userNumber = new GameNumber(List.of(1, 2, 3));

        //when
        gameService.compareNumber(answerNumber, userNumber);

        //then
        assertThat(gameService.isNotDone()).isFalse();
    }

}
