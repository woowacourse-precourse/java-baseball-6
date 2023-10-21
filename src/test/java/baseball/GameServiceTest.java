package baseball;

import baseball.domain.BaseballNumbers;
import baseball.domain.GameResult;
import baseball.domain.InputValidator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private GameResult gameResult = new GameResult();
    private BaseballNumbers baseballNumbers = new BaseballNumbers();

    private GameService gameService = new GameService(new InputValidator(), gameResult);

    @Test
    @DisplayName("문자 포함 input 검증")
    void getGameResult_invalid_input_char() {
        gameService.generateNumber();

        String input = "12x";

        Assertions.assertThatThrownBy(() -> gameService.getGameResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 범위 검증")
    void getGameResult_invalid_input_range() {
        gameService.generateNumber();

        String input = "120";

        Assertions.assertThatThrownBy(() -> gameService.getGameResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복 숫자 검증")
    void getGameResult_invalid_input_duplicate() {
        gameService.generateNumber();

        String input = "121";

        Assertions.assertThatThrownBy(() -> gameService.getGameResult(input))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void endOrRestartGame() {
        String input = "1";
        Assertions.assertThat(gameService.endOrRestartGame(input)).isFalse();
        input = "2";
        Assertions.assertThat(gameService.endOrRestartGame(input)).isTrue();
    }

    @Test
    @DisplayName("끝나는 숫자 범위 검증 - 0")
    void endOrRestartGame_invalid() {
        String input = "0";
        Assertions.assertThatThrownBy(() -> gameService.endOrRestartGame(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("끝나는 숫자 범위 검증- 문자")
    void endOrRestartGame_invalid_char() {
        String input = "h";
        Assertions.assertThatThrownBy(() -> gameService.endOrRestartGame(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}