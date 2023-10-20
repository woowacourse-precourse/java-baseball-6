package baseball.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameNumberTest {

    private static final String END_NUMBER = "2";

    @Test
    @DisplayName("게임 넘버가 1일 때 게임을 지속할 수 있다고 알려준다")
    void when_game_number_1_can_continue_game() {
        // given
        GameContinueNumber gameNumber = GameContinueNumber.createDefault();

        // when
        boolean canContinueGame = gameNumber.canContinueGame();

        // then
        assertTrue(canContinueGame);
    }

    @Test
    @DisplayName("게임 넘버가 2일 때 게임을 지속할 수 없다고 알려준다.")
    void when_game_number_2_can_not_continue_game() {
        // given
        GameContinueNumber gameNumber = GameContinueNumber.createDefault();

        // when
        gameNumber.changeNumber(END_NUMBER);
        boolean canContinueGame = gameNumber.canContinueGame();
        // then
        assertFalse(canContinueGame);
    }

    @Test
    @DisplayName("지정된 입력 외 다른 입력이 들어오면 예외가 발생한다.")
    void when_() {
        // given
        GameContinueNumber gameNumber = GameContinueNumber.createDefault();

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
            gameNumber.changeNumber("12")
        );
    }
}
