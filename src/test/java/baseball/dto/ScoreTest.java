package baseball.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ScoreTest {
    @Test
    @DisplayName("객체 생성 확인")
    void getInstance() {
        //when
        Score instance = Score.getInstance(1, 2);

        //then
        assertThat(instance.getBall()).isEqualTo(1);
        assertThat(instance.getStrike()).isEqualTo(2);
        assertThat(instance.getStatus()).isEqualTo(GameStatus.PLAY);
    }

    @ParameterizedTest
    @DisplayName("점수 출력 확인")
    @CsvSource({"0,3,3스트라이크", "1,2,1볼 2스트라이크", "3,0,3볼", "0,0,낫싱"})
    public void test(int ball, int strike, String expected) {
        //when
        String actual = Score.getInstance(ball, strike).getScoreToString().trim();

        //then
        assertThat(actual).isEqualTo(expected);
    }


}