package baseball.people;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PitcherTest {
    @Test
    @DisplayName("pitch 메서드 작동 확인")
    void pitchTest() {
        Pitcher pitcher = Pitcher.enter();
        String input = "425";

        int[] result = pitcher.pitch(input);

        assertArrayEquals(result, new int[]{4, 2, 5});
    }

    @Test
    @DisplayName("pitch 메서드 예외 케이스 1")
    void pitchException1() {
        Pitcher pitcher = Pitcher.enter();
        String input = "1 234";

        assertThatThrownBy(() -> pitcher.pitch(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("pitch 메서드 예외 케이스 2")
    void pitchException2() {
        Pitcher pitcher = Pitcher.enter();
        String input = "abc";

        assertThatThrownBy(() -> pitcher.pitch(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("restart 메서드에 1이 입력된 경우")
    void letUsRestart() {
        Pitcher pitcher = Pitcher.enter();
        String input = "1";

        boolean result = pitcher.restart(input);

        assertTrue(result);
    }

    @Test
    @DisplayName("restart 메서드에 2가 입력된 경우")
    void doNotRestart() {
        Pitcher pitcher = Pitcher.enter();
        String input = "2";

        boolean result = pitcher.restart(input);

        assertFalse(result);
    }

    @Test
    @DisplayName("restart 메서드 예외 케이스")
    void restartException() {
        Pitcher pitcher = Pitcher.enter();
        String input = "12";

        assertThatThrownBy(() -> pitcher.restart(input)).isInstanceOf(IllegalArgumentException.class);
    }
}