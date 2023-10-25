package baseball.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    /**
     * System.out.println()의 출력을 재지정하여 ByteArrayOutputStream에 저장하도록 설정
     */
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream systemOut = System.out;

    // for print
    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(systemOut);
    }

    /**
     * System.in을 ByteArrayInputStream으로 변경하여 사용자 입력을 시뮬레이트
     */

    // 'userNumber'나 'gameMode' 필드에 올바른 값이 설정되었는지 확인할 수 없으므로 고도화 필요!
    private final InputStream systemIn = System.in;

    @BeforeEach
    public void setUpInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("123\n1\n".getBytes());
        System.setIn(in);
    }

    @AfterEach
    public void restoreInput() {
        System.setIn(systemIn);
    }

    @DisplayName("사용자의 3가지 숫자 입력 테스트")
    @Test
    public void inputUserNumberTest() {
        InputView inputView = new InputView();
        inputView.inputUserNumber();

        assertEquals("숫자를 입력해주세요 : \n", outContent.toString());
        outContent.reset();
    }

    @DisplayName("게임 종료 후 재시작/종료 입력 테스트")
    @Test
    public void endGameTest() {
        InputView inputViewClass = new InputView();
        inputViewClass.endOrContinuePrompt();

        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n", outContent.toString());
        outContent.reset();
    }
}