package baseball.model;

import baseball.model.baseball.BaseballGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BaseballGameTest {

    BaseballGame baseballGame = new BaseballGame();

    @Test
    @DisplayName("사용자의 예상한 숫자와 컴퓨터가 생성한 숫자를 비교해 볼을 얻는다.")
    void get_ball_count(){
        //given
        List<Integer> expectedNumbers = List.of(1,2,3);

        //when
        long ballCount = baseballGame.getBallCount(expectedNumbers);

        //then
        assertThat(ballCount).isBetween(0L,3L);
    }
}
