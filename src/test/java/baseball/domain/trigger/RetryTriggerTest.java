package baseball.domain.trigger;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RetryTriggerTest {

    @Test
    @DisplayName("RetryTrigger 에 1을 넣어 만들면 retryOrNot 에서 True 를 반환한다.")
    void retryTriggerTest_1() {
        RetryTrigger retryTrigger = new RetryTrigger(1);
        Assertions.assertThat(retryTrigger.retryOrNot()).isTrue();
    }

    @Test
    @DisplayName("RetryTrigger 에 2을 넣어 만들면 retryOrNot 에서 False 를 반환한다.")
    void retryTriggerTest_2() {
        RetryTrigger retryTrigger = new RetryTrigger(2);
        Assertions.assertThat(retryTrigger.retryOrNot()).isFalse();
    }
}