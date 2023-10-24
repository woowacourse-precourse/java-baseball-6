package baseball.application.process;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[ApplicationEndProcessTest]")
class ApplicationEndProcessTest extends BaseballProcessTest {

    @Test
    @DisplayName("execute시 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenExecute() {
        // given
        ApplicationEndProcess applicationEndProcess = new ApplicationEndProcess();

        // when, then
        assertThrows(IllegalArgumentException.class,
            () -> applicationEndProcess.execute(baseballContext, ioContext));
    }

    @Test
    @DisplayName("hasNext가 false를 반환한다.")
    void hasNextReturnFalse() {
        // given
        ApplicationEndProcess applicationEndProcess = new ApplicationEndProcess();

        // when
        boolean result = applicationEndProcess.hasNext();

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("next시 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenNext() {
        // given
        ApplicationEndProcess applicationEndProcess = new ApplicationEndProcess();

        // when, then
        assertThrows(IllegalArgumentException.class,
            () -> applicationEndProcess.next());
    }
}