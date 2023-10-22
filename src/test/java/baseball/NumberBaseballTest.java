package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
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
    }

    @DisplayName("게임을 정확히 실행하는지 확인합니다.")
    @Test
    void startGame() {
        String input = "123\n345\n678\n789\n359\n2";
        in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        NumberBaseball numberBaseball = new NumberBaseball() {
            @Override
            protected List<Integer> getComNumber() {
                return List.of(3, 5, 9);
            }
        };

        numberBaseball.startGame();
        String printedMessage = out.toString();

        assertThat(printedMessage).contains(
                "숫자 야구 게임을 시작합니다.",
                "1볼",
                "1볼 1스트라이크",
                "낫싱",
                "1스트라이크",
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료",
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
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
        NumberBaseball numberBaseball = new NumberBaseball() {
            @Override
            protected BallContainer createUserBalls() {
                Scanner scanner = new Scanner(System.in);
                UserNumberGenerator numberGenerator = new UserNumberGenerator();
                System.out.println("숫자를 입력해주세요 : ");
                String input = scanner.nextLine();

                List<Integer> userNumber = numberGenerator.generate(input);
                return BallContainer.getFromNumbers(userNumber);
            }
        };

        System.setIn(new ByteArrayInputStream(input.getBytes()));

        assertThatThrownBy(numberBaseball::startGame)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(errorMessage);
    }
}