package baseball.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.BaseballGameResult;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    void 게임_결과_볼_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        List<Integer> userNumbs = List.of(2, 3, 1);

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        new OutputView(gameResult).printGameResult();
        String output = "3볼 \n";

        assertEquals(output, outputMessage.toString());
    }

    @Test
    void 게임_결과_스트라이크_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        List<Integer> userNumbs = List.of(1, 2, 3);

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        new OutputView(gameResult).printGameResult();
        String output = "3스트라이크\n";

        assertEquals(output, outputMessage.toString());
    }

    @Test
    void 게임_결과_볼_스트라이크_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        List<Integer> userNumbs = List.of(1, 3, 5);

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        new OutputView(gameResult).printGameResult();
        String output = "1볼 1스트라이크\n";

        assertEquals(output, outputMessage.toString());
    }

    @Test
    void 게임_결과_낫싱_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        List<Integer> userNumbs = List.of(9, 8, 7);

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, userNumbs);
        new OutputView(gameResult).printGameResult();
        String output = "낫싱\n";

        assertEquals(output, outputMessage.toString());
    }
}
