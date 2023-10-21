package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class GameRoundTest {

    private MockedStatic<RandomNumberGenerator> mocked;
    private GameRule rule;
    private PrintStream stdout;

    @BeforeEach
    void init() {
        stdout = System.out;
        rule = new GameRule(3, 1, 9);
        mocked = Mockito.mockStatic(RandomNumberGenerator.class);
        mocked.when(() -> RandomNumberGenerator.getNonDuplicateNumbers(rule)).thenReturn(List.of(1, 9, 4));
    }

    @AfterEach
    void closeMock() {
        mocked.close();
        System.setOut(stdout);
        Console.close();
    }

    @Test
    void 잘못된_입력으로_인한_게임_종료() {
        // given
        String[] inputs = {"abcd", "112", "012", "230"};
        stdinWillRead(String.join("\n", inputs));
        // when
        GameRound round = new GameRound(rule);
        for (int i = 0; i < inputs.length; i++) {
            // then
            Assertions.assertThrowsExactly(IllegalArgumentException.class,
                    () -> round.playUntilCorrect());
        }
    }

    @Test
    void 한_번의_시도에_대해_적절한_판정_결과_반환() {
        // given
        ComputerPlayer computerPlayer = new ComputerPlayer(rule);
        computerPlayer.decideGoalNumber();
        BaseBallNumber guess = new BaseBallNumber(rule);
        String[] guesses = {"236", "123", "193", "194", "491", "923"};
        List<ResultOfGuess> results = new ArrayList<>();
        results.add(new ResultOfGuess(0, 0));
        results.add(new ResultOfGuess(0, 1));
        results.add(new ResultOfGuess(0, 2));
        results.add(new ResultOfGuess(0, 3));
        results.add(new ResultOfGuess(2, 1));
        results.add(new ResultOfGuess(1, 0));
        for (int i = 0; i < guesses.length; i++) {
            guess.setUserInput(guesses[i]);
            // when
            ResultOfGuess actualResult = computerPlayer.evaluateGuess(guess);
            // then
            Assertions.assertTrue(isSameResult(actualResult, results.get(i)));
        }
    }

    @Test
    void 맞출때까지_적절한_판정_결과_출력() {
        // given
        GameRound round = new GameRound(rule);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        redirectStdOutTo(outputStream);
        // when
        String[] inputs = {"235", "193", "941", "149", "194"};
        stdinWillRead(String.join("\n", inputs));
        round.playUntilCorrect();
        //then
        String output = read(outputStream);
        Assertions.assertTrue(output.contains("낫싱") &&
                output.contains("2스트라이크") &&
                output.contains("3볼") &&
                output.contains("2볼 1스트라이크") &&
                output.contains("3스트라이크"));
    }

    @Test
    void retrieveFromConsole() {
        // given
        PrintStream stdOut = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        redirectStdOutTo(outputStream);
        // when
        System.out.println("낫싱");
        System.out.println("2스트라이크");
        System.out.println("3볼");
        System.out.println("3볼 2스트라이크");
        System.out.println("3스트라이크");
        //then
        String output = read(outputStream);
        System.setOut(stdOut);
        System.out.println(output);
    }

    boolean isSameResult(ResultOfGuess g1, ResultOfGuess g2) {
        return (g1.getBall() == g2.getBall() &&
                g1.getStrike() == g2.getStrike());
    }

    void stdinWillRead(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    void redirectStdOutTo(ByteArrayOutputStream out) {
        System.setOut(new PrintStream(out));
    }

    String read(ByteArrayOutputStream out) {
        return new String(out.toByteArray());
    }

}
