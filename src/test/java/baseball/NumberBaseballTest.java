package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class NumberBaseballTest {
    InputStream in;
    OutputStream out;

    @BeforeEach
    void setUp() {
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Console.close();
    }

    @DisplayName("게임을 반복 실행하여, 모든 가능한 결과에 대해 정상적으로 실행되는지 확인합니다.")
    @Test
    void startGame_CorrectExecution() {
        String input = """
                123
                345
                678
                789
                359
                1
                416
                418
                148
                1
                245
                265
                267
                2
                """;
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ComNumberGenerator comNumberGenerator = mock(ComNumberGenerator.class);
        when(comNumberGenerator.generate())
                .thenReturn(List.of(3, 5, 9))
                .thenReturn(List.of(1, 4, 8))
                .thenReturn(List.of(2, 6, 7));

        NumberBaseball numberBaseball = new NumberBaseball(comNumberGenerator, new UserNumberGenerator());

        numberBaseball.startGame();

        String printedMessage = out.toString();
        assertThat(printedMessage).contains(
                "숫자 야구 게임을 시작합니다.",
                "1볼",
                "1볼 1스트라이크",
                "낫싱",
                "3스트라이크",
                "2볼",
                "2볼 1스트라이크",
                "1스트라이크",
                "2스트라이크",
                "게임 종료",
                "새로 시작"
        );
    }

    @DisplayName("잘못된 숫자를 입력하였을 때, 알맞는 예외메시지를 출력하는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {
            "109/0은 입력할 수 없습니다.",
            "-123/음수값은 입력할 수 없습니다.",
            "5/입력되는 숫자는 3자리여야 합니다.",
            "37/입력되는 숫자는 3자리여야 합니다.",
            "5829/입력되는 숫자는 3자리여야 합니다.",
            "121/중복된 숫자는 입력할 수 없습니다."}, delimiter = '/')
    void startGame_WithInvalidInput_ThrowsException(String input, String errorMessage) {
        NumberBaseball numberBaseball = new NumberBaseball();

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(numberBaseball::startGame)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}