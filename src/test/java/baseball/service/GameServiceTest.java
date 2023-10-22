package baseball.service;


import baseball.Util.Validator;
import baseball.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private final GameService gameService = new GameService(new Validator());

    @Test
    @DisplayName("생성한 정답은 1부터 9까지 중복되지 않는 수로 이루어져 있다.")
    public void createAnswer() {
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

    @Test
    @DisplayName("정답과 입력을 비교해서 스트라이크, 볼 정보를 담은 Result 객체를 반환할 수 있다.")
    public void compare_InputAndAnswer() {
        //given
        List<Integer> answer = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> userInput = new ArrayList<>(List.of(3, 1, 5));

        //when
        Result result = gameService.compare(answer, userInput);

        //then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }
}