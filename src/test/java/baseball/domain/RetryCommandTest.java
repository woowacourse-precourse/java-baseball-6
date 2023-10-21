package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RetryCommandTest {

    @Test
    void isRetryTest() {
        //given
        RetryCommand retry = RetryCommand.RETRY;
        RetryCommand quit = RetryCommand.QUIT;

        //when & then
        assertThat(retry.isRetry()).isTrue();
        assertThat(quit.isRetry()).isFalse();
    }

    @Test
    void getNumberTest() {
        //given
        RetryCommand retry = RetryCommand.RETRY;
        RetryCommand quit = RetryCommand.QUIT;

        //when & then
        assertThat(retry.getNumber()).isEqualTo("1");
        assertThat(quit.getNumber()).isEqualTo("2");
    }
}
