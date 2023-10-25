package baseball.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.model.ball.Ball;
import baseball.model.ball.Balls;
import baseball.model.player.Computer;
import baseball.ui.ConsoleOutput;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class BallCounterTest {

    private final Computer computer = new Computer(new ConsoleOutput());

    @RepeatedTest(value = 5, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void 볼_카운터는_유저와_컴퓨터의_숫자_결과를_게임_규칙에_맞게_생성함(RepetitionInfo repetitionInfo) {
        // given
        computer.generatePlayerNumber(3);
        List<Ball> guessNumber = List.of(new Ball(1), new Ball(2), new Ball(3));

        // when
        BallCounter ballCounter = new BallCounter(computer.getNumbers(), new Balls(guessNumber));
        System.out.println(ballCounter.toString());

        String[] results = getResults();
        // then
        boolean isContained = Arrays.stream(results)
            .anyMatch(result -> result.trim().equals(ballCounter.toString().trim()));

        assertTrue(isContained);
    }

    private static void announceRepetitionInfo(String repetitionInfo) {
        System.out.println(repetitionInfo);
    }

    public static String[] getResults() {
        return new String[] {
            "낫싱",
            "1볼",
            "2볼",
            "3볼",
            "1스트라이크",
            "2스트라이크",
            "3스트라이크",
            "1볼 1스트라이크",
            "1볼 2스트라이크",
            "2볼 1스트라이크",
            "2볼 2스트라이크",
            "3볼 1스트라이크",
            "3볼 2스트라이크"
        };
    }

}