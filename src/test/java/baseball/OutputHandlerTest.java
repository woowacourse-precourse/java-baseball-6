package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * OutputHandler.class 테스트 코드 이다.
 */
class OutputHandlerTest {
    private final PrintStream basicStream = System.out;
    private OutputStream streamCaptor;

    @BeforeEach
    void testInit() {
        streamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(streamCaptor));
    }

    @AfterEach
    void cleanUp() {
        System.setOut(basicStream);
    }

    private String getPrintString() {
        return streamCaptor.toString();
    }

    @Test
    void 게임_시작_메시지가_정상_출력_되는지_확인한다() {
        String expected = "숫자 야구 게임을 시작합니다.\n";

        OutputHandler.showGameStartMessage();

        assertThat(getPrintString()).isEqualTo(expected);
    }

    @Test
    void 게임에_사용되는_숫자_입력_요청_메시지가_정상_출력_되는지_확인한다() {
        String expected = "숫자를 입력해주세요 : \n";

        OutputHandler.showGamePromptNumbersMessage();

        assertThat(getPrintString()).isEqualTo(expected);
    }

    @Test
    void 숫자_비교_결과가_정상_출력_되는지_확인한다() {
        String[] expectMessages = {"1볼 2스트라이크", "1볼", "1스트라이크", "낫싱", "3스트라이크"};
        int[][] ballAndStrikeCnts = {{1,2}, {1,0}, {0,1}, {0,0}, {0,3}};

        for(int i = 0; i < ballAndStrikeCnts.length; i++) {
            String expected = expectMessages[i] + "\n";
            int ballCnt = ballAndStrikeCnts[i][0];
            int strikeCnt = ballAndStrikeCnts[i][1];

            OutputHandler.showNumberCheckResultMessage(ballCnt, strikeCnt);

            assertThat(getPrintString()).isEqualTo(expected);
            testInit();
        }
    }

    @Test
    void 숫자_세개를_모두_맞혔을때_표시되는_게임종료_메시지가_정상_출력_되는지_확인한다() {
        String expected = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";

        OutputHandler.showGameEndMessage();

        assertThat(getPrintString()).isEqualTo(expected);
    }

    @Test
    void 재시작을_확인하는_메시지가_정상_출력_되는지_확인한다() {
        String expected = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

        OutputHandler.showRestartPrompt();

        assertThat(getPrintString()).isEqualTo(expected);
    }
}