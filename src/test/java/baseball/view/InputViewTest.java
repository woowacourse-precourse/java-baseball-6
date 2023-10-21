package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
    void baseballNumberWithInputValidatorSuccessTest(String input) {
        System.setIn(generateUserInput(input));
        String baseBallNumber = InputView.baseBallNumber();
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : ");
        assertThat(baseBallNumber).isEqualTo(input);
    }

    @DisplayName("숫자를 입력해주세요 : 문구를 출력하고 사용자의 입력을 받는다.")
    @ParameterizedTest
    @MethodSource("provideValidateBaseBallNumberFailTestArgument")
    void baseballNumberWithInputValidatorFailTest(String input, String message) {
        System.setIn(generateUserInput(input));
        assertThatCode(InputView::baseBallNumber)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(message);
        assertThat(output.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    static Stream<Arguments> provideValidateBaseBallNumberFailTestArgument() {
        return Stream.of(
                arguments("1", "입력값은 3자리 수만 가능합니다."),
                arguments("1234", "입력값은 3자리 수만 가능합니다."),
                arguments("112", "입력값은 중복되지 않는 서로 다른 숫자만 가능합니다."),
                arguments("가나다", "입력값은 1~9 범위의 숫자만 가능합니다."),
                arguments("abc", "입력값은 1~9 범위의 숫자만 가능합니다.")
        );
    }
}
