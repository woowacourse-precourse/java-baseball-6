package baseball.service;

import static baseball.properties.Properties.*;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.utils.RandomUtils;

class GameServiceTest {
    GameService gameService;

    @BeforeEach
    void setGameService() {
        this.gameService = new GameService(RandomUtils.getRandomNumbers(GAME_SIZE,DIGIT_START,DIGIT_END));
    }

    @Test
    void 사용자_문자열_파싱테스트_길이오류() {
        //given
        String input = "1234";
        //when

        //then
        assertThatThrownBy(() -> gameService.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("제한길이");
    }

    @Test
    void 사용자_문자열_파싱테스트_숫자가_아닌_문자입력() {
        //given
        String input = "1a4";
        //when
        //then
        assertThatThrownBy(() -> gameService.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("숫자형식이 아닙니다.");
    }

    @Test
    void 사용자_문자열_파싱테스트_중복숫자입력() {
        //given
        String input = "113";
        //when
        //then
        assertThatThrownBy(() -> gameService.parseInput(input))
                .isInstanceOf(IllegalArgumentException.class).hasMessageContaining("중복");
    }


    @Test
    void 사용자_문자열_파싱테스트_파싱_성공() {
        //given
        String input = "123";
        //when
        List<Integer> parsedInput = gameService.parseInput(input);
        //then
        assertThat(parsedInput).containsExactly(1,2,3);
    }

}