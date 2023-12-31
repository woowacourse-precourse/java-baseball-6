package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ResultTest {

    @Test
    void 결과_테스트() {
        Ball answer = new Ball(List.of(1, 2, 3));
        Ball player = new Ball(List.of(1, 3, 4));

        Result result = new Result(answer, player);
        Assertions.assertThat(result.toString())
                .isEqualTo("1볼 1스트라이크");
    }
}
