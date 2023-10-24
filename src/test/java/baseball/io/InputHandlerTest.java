package baseball.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    private final InputHandler inputHandler = new InputHandler();


    @Test
    @DisplayName("문자_입력_예외_테스트")
    void scanInteger() {

        String input = "일오삼";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(IllegalArgumentException.class, inputHandler::scanInteger);

        System.setIn(System.in);
    }

    @Test
    @DisplayName("입력값_예측값_변환_테스트")
    void inputToExpectedNumber() {
        List<Integer> target = inputHandler.inputToExpectedNumber(345);
        assertThat(target).isEqualTo(new ArrayList<>(Arrays.asList(3, 4, 5)));
    }
}