package baseball.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestartOptionTest {

    @Test
    void retry() {
        assertAll(
                () -> assertEquals(RestartOption.from("1"), RestartOption.RESTART),
                () -> assertEquals(RestartOption.from("2"), RestartOption.QUIT),
                () -> assertThatThrownBy(() -> RestartOption.from("3")).isInstanceOf(IllegalArgumentException.class)
        );
    }
}