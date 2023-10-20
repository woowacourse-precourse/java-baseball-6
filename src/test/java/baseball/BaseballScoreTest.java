package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BaseballScoreTest {

    @Test
    @DisplayName("toString이 잘 되는지 확인")
    void 출력_테스트() {
        BaseballScore score = new BaseballScore();
        score.ball = 1; score.strike = 2;

        String s = score.toString();

        Assertions.assertThat(s).isEqualTo("1볼 2스트라이크");
    }

}
