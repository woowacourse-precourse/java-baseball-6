package baseball.service;

import static baseball.properties.Properties.*;

import static org.assertj.core.api.Assertions.*;

import baseball.model.Balls;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    GameService gameService;

    @BeforeEach
    void setGameService() {
        this.gameService = new GameService(Balls.createRandomBalls(GAME_SIZE,DIGIT_START,DIGIT_END));
    }

    @Test
    void 사용자_문자열_파싱테스트_길이오류() {
        String input = "1234";
        assertThatThrownBy(() -> gameService.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("제한길이");
    }

    @Test
    void 사용자_문자열_파싱테스트_숫자가_아닌_문자입력() {
        String input = "1a4";
        assertThatThrownBy(() -> gameService.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자형식이 아닙니다.");
    }

    @Test
    void 사용자_문자열_파싱테스트_중복숫자입력() {
        String input = "113";
        assertThatThrownBy(() -> gameService.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복");
    }


    @Test
    void 사용자_문자열_파싱테스트_파싱_성공() {
        String input = "123";
        List<Integer> parsedInput = gameService.parseInput(input);
        assertThat(parsedInput).containsExactly(1,2,3);
    }

}