package baseball.domain.result;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ResultTest {

    @Test
    void isClear() {
        Result result = new Result(0, 3);

        assertThat(result.isGameClear()).isTrue();
    }
}
