package baseball;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.*;

public class UserTest {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void userInput() {
        String input = "123";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        String answer = user.answer();
        assertThat(answer).isEqualTo(input);
    }

    @Test
    void collectInput() {
        String input = "123";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        assertThatNoException().isThrownBy(() -> user.answer());
    }

    @Test
    void zeroInput() {
        String input = "012";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        assertThatThrownBy(() -> user.answer())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void sameInput() {
        String input = "111";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        assertThatThrownBy(() -> user.answer())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void overLengthInput() {
        String input = "1234";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        assertThatThrownBy(() -> user.answer())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void stringInput() {
        String input = "abc";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        assertThatThrownBy(() -> user.answer())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void restart() {
        String input = "1";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        boolean restart = user.restartGame();
        assertThat(restart).isTrue();
    }

    @Test
    void end() {
        String input = "2";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        boolean restart = user.restartGame();
        assertThat(restart).isFalse();
    }

    @Test
    void wrongRestartInput() {
        String input = "3";
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        User user = new User();
        assertThatThrownBy(() -> user.restartGame())
                .isInstanceOf(IllegalArgumentException.class);
    }
}
