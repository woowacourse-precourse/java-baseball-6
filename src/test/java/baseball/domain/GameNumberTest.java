package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class GameNumberTest {
    @Test
    @DisplayName("올바른 입력으로 생성")
    void createdByValidInput() {
        String input = "123";

        GameNumber gameNumber = new GameNumber(input);

        assertThat(gameNumber).isNotNull();
    }

    @Nested
    @DisplayName("길이가")
    class createdByInvalidSizeInput {
        @Test
        @DisplayName("3보다 큰 입력으로 생성 시 예외")
        void createdByOverSizeLengthInput() {
            String input = "123456";

            assertThrows(IllegalArgumentException.class, () -> new GameNumber(input));
        }

        @Test
        @DisplayName("3보다 작은 입력으로 생성 시 예외")
        void createdByUnderSizeLengthInput() {
            String input = "12";

            assertThrows(IllegalArgumentException.class, () -> new GameNumber(input));
        }
    }

    @Test
    @DisplayName("숫자가 아닌 입력으로 생성 시 예외")
    void createdByNotNumberInput() {
        String input = "1ab";

        assertThrows(IllegalArgumentException.class, () -> new GameNumber(input));
    }

    @Test
    @DisplayName("0을 포함한 입력으로 생성 시 예외")
    void createdByZeroInput() {
        String input = "1ab";

        assertThrows(IllegalArgumentException.class, () -> new GameNumber(input));
    }

    @Test
    @DisplayName("중복이 있는 입력으로 생성 시 예외")
    void createdByDuplicatedInput() {
        String input = "112";

        assertThrows(IllegalArgumentException.class, () -> new GameNumber(input));
    }
}