package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RetryCheckTest {
    @Test
    @DisplayName("입력 값 2 보다 큰 경우 IllegalArgumentException 확인")
    void checkInputSizeOver() {
        assertThatThrownBy(() -> new RetryCheck("4123")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 숫자 아닌 경우 IllegalArgumentException 확인")
    void checkNotNum() {
        assertThatThrownBy(() -> new RetryCheck("~")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값 1인 경우 True 리턴 확인")
    void checkReturnTrue() {
        RetryCheck retryCheck = new RetryCheck("1");
        assertThat(retryCheck.isRetry()).isTrue();
    }

    @Test
    @DisplayName("입력 값 2인 경우 False 리턴 확인")
    void checkReturnFalse() {
        RetryCheck retryCheck = new RetryCheck("2");
        assertThat(retryCheck.isRetry()).isFalse();
    }
}