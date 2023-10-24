package baseball.service;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.NumberBaseball;
import baseball.domain.hint.item.Ball;
import baseball.domain.hint.Hint;
import baseball.domain.hint.item.Nothing;
import baseball.domain.hint.item.Strike;
import baseball.service.hint.item.BallServiceImpl;
import baseball.service.hint.item.NothingServiceImpl;
import baseball.service.hint.item.StrikeServiceImpl;
import org.junit.jupiter.api.Test;

public class GameServiceImplTest {

    private final GameService gameService = new GameServiceImpl(
            BallServiceImpl.getInstance(),
            StrikeServiceImpl.getInstance(),
            NothingServiceImpl.getInstance()
    );

    @Test
    void createHint_ball() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("416");

        Hint hint = gameService.createHint(computerBaseball, inputBaseball);

        assertTrue(hint.getHintItems().stream()
                .anyMatch(hintItem -> hintItem instanceof Ball));
    }

    @Test
    void createHint_strike() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("426");

        Hint hint = gameService.createHint(computerBaseball, inputBaseball);

        assertTrue(hint.getHintItems().stream()
                .anyMatch(hintItem -> hintItem instanceof Strike));
    }

    @Test
    void createHint_ballAndStrike() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("326");

        Hint hint = gameService.createHint(computerBaseball, inputBaseball);

        assertAll(
                () -> assertTrue(hint.getHintItems().stream()
                        .anyMatch(hintItem -> hintItem instanceof Ball)),
                () -> assertTrue(hint.getHintItems().stream()
                        .anyMatch(hintItem -> hintItem instanceof Strike))
        );
    }

    @Test
    void createHint_nothing() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("456");

        Hint hint = gameService.createHint(computerBaseball, inputBaseball);

        assertTrue(hint.getHintItems().stream()
                .anyMatch(hintItem -> hintItem instanceof Nothing));
    }

    @Test
    void createHint_NonNothing() {
        NumberBaseball computerBaseball = NumberBaseball.createBaseball("123");
        NumberBaseball inputBaseball = NumberBaseball.createBaseball("156");

        Hint hint = gameService.createHint(computerBaseball, inputBaseball);

        assertFalse(hint.getHintItems().stream()
                .anyMatch(hintItem -> hintItem instanceof Nothing));
    }

}
