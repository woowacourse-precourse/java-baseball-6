package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {
    @DisplayName("스트라이크의 개수 올리는 테스트")
    @Test
    void increaseCntStrikeTest(){
        //given
        Score score = new Score();
        //when
        score.increaseStrike();
        //then
        Assertions.assertThat(score.getStrike()).isEqualTo(1);
        Assertions.assertThat(score.getBall()).isEqualTo(0);
    }
    @DisplayName("볼의 개수 올리는 테스트")
    @Test
    void increaseCntBallTest(){
        //given
        Score score = new Score();
        //when
        score.increaseBall();
        //then
        Assertions.assertThat(score.getBall()).isEqualTo(1);
        Assertions.assertThat(score.getStrike()).isEqualTo(0);
    }
}