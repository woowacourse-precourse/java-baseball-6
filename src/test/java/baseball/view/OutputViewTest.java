package baseball.view;

import static baseball.view.OutputView.gameStartMessage;
import static baseball.view.OutputView.printBallStrike;
import static baseball.view.OutputView.printCelebrate;
import static baseball.view.OutputView.userInputMessage;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private static ByteArrayOutputStream outputStreamCaptor;

    @BeforeEach
    void setUp() {
        outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("gameStartMessage() 출력 값 요구사항 일치 확인")
    void testGameStartMessage() {
        gameStartMessage();
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("gameStartMessage() 출력 값 요구사항 일치 확인")
    void testUserInputMessage() {
        userInputMessage();
        assertThat(outputStreamCaptor.toString()).isEqualTo("숫자를 입력해주세요 : ");
    }

    @Test
    @DisplayName("printCelebrate() 출력 값 요구사항 일치 확인")
    void testPrintCelebrate() {
        printCelebrate();
        assertThat(outputStreamCaptor.toString().trim())
                .isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    // printBallStrike 각 조건 별 출력값 확인
    @Test
    @DisplayName("printBallStrike() 출력 검사")
    void testprintBallStrike() {
        String s = "낫싱";
        printBallStrike(s);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo(s);
    }
}