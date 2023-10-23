package baseball.constant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("재시도 상태 열거형에")
class RetryStatusTest {

    @Nested
    @DisplayName("입력 커맨드에 맞는 값 요청시")
    class valueOfCommand {

        @Test
        @DisplayName("1인 경우 KEEP_GOING을 반환하는가")
        void oneToRetry() {
            // given
            final Integer command = 1;

            // when
            final RetryStatus retryStatus = RetryStatus.valueOfCommand(command);

            // then
            assertThat(retryStatus).isEqualTo(RetryStatus.KEEP_GOING);
        }

        @Test
        @DisplayName("2인 경우 FINISH를 반환하는가")
        void twoToFinish() {
            // given
            final Integer command = 2;

            // when
            final RetryStatus retryStatus = RetryStatus.valueOfCommand(command);

            // then
            assertThat(retryStatus).isEqualTo(RetryStatus.FINISH);
        }

        @Test
        @DisplayName("이외의 값은 예외를 던진다")
        void otherToException() {
            // given
            final Integer command = 3;

            // when
            // then
            assertThatThrownBy(() -> RetryStatus.valueOfCommand(command))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
