package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Retry;
import baseball.view.InputView;
import org.junit.jupiter.api.Test;

public class RetryTest extends IOTest {
    private final InputView inputView = InputView.getInstance();


    @Test
    void _1을_입력하면_retry() {
        systemIn("1");
        assertThat(inputView.scanRetry()).isEqualTo(Retry.RETRY);
    }
    @Test
    void _2를_입력하면_end() {
        systemIn("1");
        assertThat(inputView.scanRetry()).isEqualTo(Retry.END);
    }
}
