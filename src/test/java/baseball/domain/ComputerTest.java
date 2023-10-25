package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.ui.ConsoleInput;
import baseball.ui.ConsoleOutput;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ComputerTest {

    private static ConsoleInput CONSOLE_INPUT;
    private static ConsoleOutput CONSOLE_OUTPUT;
    private static User user;
    private static Computer computer;
    private static InputStream originalSystemIn;
    private static PrintStream originalSystemOut;
    private static final int NUMBER_BALLS = 3;
    private String[] expectedOutputs = getExpectedOutputs();

    @BeforeAll
    public static void setupAll() {
        user = new User(new ConsoleInput());
        computer = new Computer(new ConsoleOutput());
        originalSystemIn = System.in;
        originalSystemOut = new PrintStream(System.out);
    }

    @AfterAll
    public static void cleanupAll() {
        System.setIn(originalSystemIn);
        System.setOut(originalSystemOut);
    }

    @AfterEach
    public void tearDown() {
        camp.nextstep.edu.missionutils.Console.close();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void 컴퓨터는_게임_볼_개수_규칙만큼_볼을_생성함(int numberBalls) {
        // given

        // when
        computer.generatePlayerNumber(numberBalls);

        // then
        assertEquals(numberBalls, computer.countNumberBalls());
    }

    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void 컴퓨터는_유저의_입력값에_맞는_응답을_함(RepetitionInfo repetitionInfo) {
        announceRepetitionInfo(
                "test" + repetitionInfo.getCurrentRepetition() + "/" + repetitionInfo.getTotalRepetitions());

        // given
        computer.generatePlayerNumber(NUMBER_BALLS);
        String input = "123";
        ByteArrayInputStream mockInput = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setIn(mockInput);
        System.setOut(new PrintStream(outContent));

        // when
        user.generatePlayerNumber(NUMBER_BALLS);
        computer.respondsTo(user);

        // then
        String consoleOutput = outContent.toString().trim();
        assertTrue(Arrays.asList(expectedOutputs).contains(consoleOutput));
    }

    private static void announceRepetitionInfo(String repetitionInfo) {
        System.out.println(repetitionInfo);
    }

    private String[] getExpectedOutputs() {
        return new String[]{
                "낫싱", "1볼", "2볼", "3볼",
                "1스트라이크", "2스트라이크", "3스트라이크",
                "1볼 1스트라이크", "1볼 2스트라이크",
                "2볼 1스트라이크", "2볼 2스트라이크",
                "3볼 1스트라이크", "3볼 2스트라이크",
        };
    }
}