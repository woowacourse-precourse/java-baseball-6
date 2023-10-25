package baseball.games.numberbaseball.core;

import baseball.games.numberbaseball.domain.BallCount;
import baseball.games.numberbaseball.util.BaseballPrinter;
import baseball.games.numberbaseball.util.NumberGenerator;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Baseball {
    private static final int NUMBER_OF_BALLS = 3;
    private final NumberGenerator numberGenerator;
    private final List<Integer> computerNumbers;
    private List<Integer> playerNumbers;

    Baseball() {
        numberGenerator = new NumberGenerator();
        computerNumbers = numberGenerator.generateRandomNumbers();
    }


    public void playGame() {
        BaseballPrinter.printRequestingNumberMessage();
        playerNumbers = numberGenerator.createValidatedNumbers(readLine());
        BallCount ballCount = createBallCount();
        String ballCountMessage = ballCount.createBallCountMessage();
        System.out.println(ballCountMessage);
        if (ballCount.isThreeStrike()) {
            BaseballPrinter.printCorrectMessage();
            return;
        }
        playGame();
    }

    private BallCount createBallCount() {
        int ballCount = (int) IntStream.range(0, NUMBER_OF_BALLS)
                .filter(index -> !Objects.equals(playerNumbers.get(index), computerNumbers.get(index)))
                .filter(index -> computerNumbers.contains(playerNumbers.get(index)))
                .count();
        int strikeCount = (int) IntStream.range(0, NUMBER_OF_BALLS)
                .filter(index -> Objects.equals(playerNumbers.get(index), computerNumbers.get(index)))
                .count();
        return new BallCount(ballCount, strikeCount);
    }

    private String readLine() {
        return Console.readLine();
    }
}
