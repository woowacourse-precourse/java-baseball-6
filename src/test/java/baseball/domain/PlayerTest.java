package baseball.domain;

import static baseball.utils.ErrorMessages.NOT_INTEGER;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_DUPLICATE;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_INVALID_SIZE;
import static baseball.utils.ErrorMessages.PLAYER_NUMBERS_ZERO_CONTAIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Player 클래스")
public class PlayerTest {

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class 생성자는 {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 입력값의_길이가_3이_아니라면 {
            @ParameterizedTest
            @ValueSource(strings = {"1", "12", "123456789"})
            void IllegalArgumentException_예외를_던진다(String input) {
                Assertions.assertThatThrownBy(() -> new Player(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(PLAYER_NUMBERS_INVALID_SIZE);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 입력값에_중복된_값이_존재하면 {
            @ParameterizedTest
            @ValueSource(strings = {"112", "755", "939"})
            void IllegalArgumentException_예외를_던진다(String input) {
                Assertions.assertThatThrownBy(() -> new Player(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(PLAYER_NUMBERS_DUPLICATE);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 입력값에_0이_존재하면 {
            @ParameterizedTest
            @ValueSource(strings = {"102", "470", "039"})
            void IllegalArgumentException_예외를_던진다(String input) {
                Assertions.assertThatThrownBy(() -> new Player(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(PLAYER_NUMBERS_ZERO_CONTAIN);
            }
        }

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 입력값에_문자가_포함된다면 {
            @ParameterizedTest
            @ValueSource(strings = {"19a", "!47", "38;"})
            void IllegalArgumentException_예외를_던진다(String input) {
                Assertions.assertThatThrownBy(() -> new Player(input))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(NOT_INTEGER);
            }
        }
    }

    @Nested
    @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
    class getNumber_메소드는 {

        @Nested
        @DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
        class 인덱스가_주어진다면 {
            private static Stream<Arguments> providePlayerNumberAndIdx() {
                return Stream.of(
                        Arguments.of("123", 0, 1),
                        Arguments.of("895", 1, 9),
                        Arguments.of("473", 2, 3)
                );
            }

            @ParameterizedTest
            @MethodSource("providePlayerNumberAndIdx")
            void 해당_인덱스의_숫자값을_반환한다(String numbers, int idx, int expect) {
                Player player = new Player(numbers);
                assertEquals(player.getNumber(idx), expect);
            }
        }
    }
}
