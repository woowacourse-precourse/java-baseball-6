package racingcar.view;
import java.util.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputViewTest {
    OutputView view;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUp() {
        view = new OutputView();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    void 자동차이름_입력_안내메세지_테스트() {
        view.printCarNamesInputMessage();

        String expectedOutput = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)" + System.lineSeparator();
        assertThat(expectedOutput).isEqualTo(outContent.toString());
    }

    @Test
    void 횟수_입력_안내메세지_테스트() {
        view.printAttemptsInputMessage();
        String expectedOutput = "시도할 회수는 몇회인가요?" + System.lineSeparator();
        assertThat(expectedOutput).isEqualTo(outContent.toString());
    }

    @Test
    void 차수_결과_출력_테스트() {
        Map<String, Integer> attemptResultSample = new LinkedHashMap<>();
        attemptResultSample.put("dave", 3);
        attemptResultSample.put("app", 7);
        attemptResultSample.put("show", 6);
        attemptResultSample.put("mon", 5);
        String attemptResultString = "dave : ---\n"
                + "app : -------\n"
                + "show : ------\n"
                + "mon : -----\n";

        view.printAttemptResult(attemptResultSample);

        assertThat(outContent.toString()).contains(attemptResultString);
    }

    @Test
    void 게임_결과_출력_테스트() {
        List<String> winnersSample = new ArrayList<>();
        winnersSample.add("pobi");
        winnersSample.add("jun");

        String gameResultString = "최종 우승자 : pobi, jun\n";

        view.printGameResult(winnersSample);
        assertThat(gameResultString).isEqualTo(outContent.toString());
    }
}
