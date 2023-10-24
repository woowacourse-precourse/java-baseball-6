package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class ScoreServiceTest {
    private final ScoreService scoreService = new ScoreService();

    @Test
    @DisplayName("정답과 사용자입력을 비교해서 스트라이크 개수를 확인할 수 있다.")
    public void should_getStrikeNum(){
        //given
        List<Integer> answer = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> userInput = new ArrayList<>(List.of(3, 1, 5));

        //when
        Integer strikes = scoreService.getStrikes(answer, userInput);

        //then
        Assertions.assertThat(strikes).isEqualTo(1);
    }

    @Test
    @DisplayName("정답과 사용자입력을 비교해서 볼 개수를 확인할 수 있다.")
    public void should_getBallNum(){
        //given
        List<Integer> answer = new ArrayList<>(List.of(1, 3, 5));
        List<Integer> userInput = new ArrayList<>(List.of(3, 1, 5));

        //when
        Integer balls = scoreService.getBalls(answer, userInput);

        //then
        Assertions.assertThat(balls).isEqualTo(2);
    }
}