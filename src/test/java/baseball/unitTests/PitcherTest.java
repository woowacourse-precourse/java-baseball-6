package baseball.unitTests;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import baseball.people.Pitcher;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PitcherTest {

    @Test
    @DisplayName("pitch 메서드 작동 확인")
    void pitchTest() {
        Pitcher pitcher = Pitcher.enter();
        String input = "425";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] result = pitcher.pitch();

        assertArrayEquals(result, new int[]{4, 2, 5});
    }

    @Test
    @DisplayName("pitch 메서드 예외 케이스 1")
    void pitchException1() {
        Pitcher pitcher = Pitcher.enter();
        String input = "1 234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(pitcher::pitch).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("pitch 메서드 예외 케이스 2")
    void pitchException2() {
        Pitcher pitcher = Pitcher.enter();
        String input = "abc";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(pitcher::pitch).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("restart 메서드에 1이 입력된 경우")
    void letUsRestart() {
        Pitcher pitcher = Pitcher.enter();
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = pitcher.restart();

        assertTrue(result);
    }

    @Test
    @DisplayName("restart 메서드에 2가 입력된 경우")
    void doNotRestart() {
        Pitcher pitcher = Pitcher.enter();
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean result = pitcher.restart();

        assertFalse(result);
    }

    @Test
    @DisplayName("restart 메서드 예외 케이스")
    void restartException() {
        Pitcher pitcher = Pitcher.enter();
        String input = "12";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(pitcher::restart).isInstanceOf(IllegalArgumentException.class);
    }
}