package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RetryTest extends IOTest {

    @Test
    void _1을_입력하면_retry() {
        systemIn("1");
        assertThat(InputView.scanRetry()).isEqualTo(Retry.RETRY);
    }
    @Test
    void _2를_입력하면_end() {
        systemIn("1");
        assertThat(InputView.scanRetry()).isEqualTo(Retry.END);
    }
}
