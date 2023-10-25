package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputManagerTest {
    InputManager inputManager = InputManager.getInstance();

    public InputManagerTest() {
        insertStringToSystemIn("asdf\n1234\n442\n512\navs\n3\n1\n2");
    }

    @Test
    @DisplayName("readNumber()가 입력을 받아올 때 검증작업을 올바르게 처리하는지 테스트")
    void readNumber() {
        assertThatThrownBy(()-> inputManager.readNumber())
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> inputManager.readNumber())
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(()-> inputManager.readNumber())
                .isInstanceOf(IllegalArgumentException.class);

        String input = inputManager.readNumber();
        assertThat("512").isEqualTo(input);
    }

    @Test
    @DisplayName("readWeatherRestartOrEnd()가 입력을 받아올 때 검증작업을 올바르게 처리하는지 테스트")
    void readWeatherRestartOrEnd() {
        assertThatThrownBy(() -> inputManager.readWeatherRestartOrEnd())
                        .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> inputManager.readWeatherRestartOrEnd())
                .isInstanceOf(IllegalArgumentException.class);

        String input1 = inputManager.readWeatherRestartOrEnd();
        assertThat(input1).isEqualTo("1");

        String input2 = inputManager.readWeatherRestartOrEnd();
        assertThat(input2).isEqualTo("2");
    }

    void insertStringToSystemIn(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}
