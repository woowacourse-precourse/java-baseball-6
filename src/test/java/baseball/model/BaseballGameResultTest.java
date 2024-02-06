package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BaseballGameResultTest {

    @Test
    @DisplayName("볼 스트라이크 카운팅 완료")
    void 볼_스트라이크_카운팅_확인() throws Exception {
        //given
        List<Integer> computerNumber = List.of(1, 2, 3);
        List<Integer> userNumber1 = List.of(3,2,1);
        List<Integer> userNumber2 = List.of(1, 3, 2);

        BaseballGameResult baseballGameResult1 = new BaseballGameResult(userNumber1, computerNumber);
        BaseballGameResult baseballGameResult2 = new BaseballGameResult(userNumber2, computerNumber);
        //when
        int ball1 = baseballGameResult1.getBall();
        int strike1 = baseballGameResult1.getStrike();
        int ball2 = baseballGameResult2.getBall();
        int strike2 = baseballGameResult2.getStrike();
        //then
        assertThat(ball1).isEqualTo(2);
        assertThat(strike1).isEqualTo(1);
        assertThat(ball2).isEqualTo(2);
        assertThat(strike2).isEqualTo(1);
    }


}