package baseball.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void isClear() {
        Result result = new Result(0, 3);

        Assertions.assertThat(result.isGameClear()).isTrue();
    }
}
