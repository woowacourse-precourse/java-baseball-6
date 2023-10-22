package baseball.service;


import baseball.Util.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private final GameService gameService = new GameService(new Validator());

    @Test
    @DisplayName("생성한 정답은 1부터 9까지 중복되지 않는 수로 이루어져 있다.")
    public void createAnswer(){
        //given
        List<Integer> answer = gameService.createAnswer();

        //when
        List<Integer> filtered = answer.stream()
                .filter(a -> 1 <= a && a <= 9)
                .distinct()
                .toList();

        //then
        assertThat(answer).isEqualTo(filtered);
    }
}