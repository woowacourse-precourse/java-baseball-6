package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    public void restore() {
        Console.close();
    }

    public static InputStream generateUserInput(String input) {
        return new ByteArrayInputStream(input.getBytes());
    }

    @DisplayName("숫자를 입력해주세요 : 문구를 출력하고 사용자의 입력을 받는다.")
    @ParameterizedTest
    @ValueSource(strings = {"123", "456"})
    void baseballNumberTest(String input) {
        System.setIn(generateUserInput(input));
        String baseBallNumber = InputView.baseBallNumber();
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : ");
        assertThat(baseBallNumber).isEqualTo(input);
    }
}
