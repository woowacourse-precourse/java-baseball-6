package baseball.view;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BaseballGameResult;
import baseball.domain.UserNumber;
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
        String input = "231";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        new OutputView(gameResult).printGameResult();
        String output = "3볼 \n";

        assertThat(outputMessage.toString()).hasToString(output);
    }

    @Test
    void 게임_결과_스트라이크_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        String input = "123";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        new OutputView(gameResult).printGameResult();
        String output = "3스트라이크\n";

        assertThat(outputMessage.toString()).hasToString(output);
    }

    @Test
    void 게임_결과_볼_스트라이크_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        String input = "135";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        new OutputView(gameResult).printGameResult();
        String output = "1볼 1스트라이크\n";

        assertThat(outputMessage.toString()).hasToString(output);
    }

    @Test
    void 게임_결과_낫싱_출력_확인() {
        List<Integer> computerNumbs = List.of(1, 2, 3);
        String input = "987";

        BaseballGameResult gameResult = new BaseballGameResult(computerNumbs, new UserNumber(input));
        new OutputView(gameResult).printGameResult();
        String output = "낫싱\n";

        assertThat(outputMessage.toString()).hasToString(output);
    }
}
