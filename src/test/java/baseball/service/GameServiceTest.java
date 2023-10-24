package baseball.service;

import baseball.domain.number.AnswerNumber;
import baseball.domain.number.UserNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GameServiceTest {

    private GameService gameService;
    private AnswerNumber answerNumber;

    @BeforeEach
    void beforeEach() {
        this.gameService = GameService.startNewGame();
        this.answerNumber = new AnswerNumber(List.of(1, 2, 3));
    }

    @Test
    void compareNumberTest1() {
        //given
        UserNumber userNumber = new UserNumber(List.of(3, 2, 1));

        //when
        gameService.compareNumber(answerNumber, userNumber);

        //then
        assertThat(gameService.isNotDone()).isTrue();
    }

    @Test
    void compareNumberTest2() {
        //given
        UserNumber userNumber = new UserNumber(List.of(1, 2, 3));

        //when
        gameService.compareNumber(answerNumber, userNumber);

        //then
        assertThat(gameService.isNotDone()).isFalse();
    }

}
