package baseball.service;

import baseball.constants.Baseball;
import baseball.dto.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private final GameService gameService = new GameService(new ScoreService());

    @Test
    @DisplayName("생성한 정답은 1부터 9까지 중복되지 않는 수로 이루어져 있다.")
    public void createAnswer() {
        //given
        List<Integer> answer = gameService.createAnswer();

        //when
        List<Integer> filtered = answer.stream()
                .filter(a -> Baseball.MIN_NUMBER.getValue() <= a &&
                        a <= Baseball.MAX_NUMBER.getValue())
                .distinct()
                .toList();

        //then
        assertThat(answer).isEqualTo(filtered);
    }

    @Test
    @DisplayName("사용자 입력을 전달했을 때 스트라이크와 볼 결과를 받을 수 있다.")
    public void should_getResult_when_passUserInput(){
        //given
        List<Integer> answer = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> userInput = new ArrayList<>(List.of(3, 1, 5));

        //when
        Result result = gameService.playRound(answer, userInput);

        //then
        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(2);
    }
}