package baseball.domain;

import baseball.domain.dto.GameResult;
import baseball.util.BallNumbersValidator;
import java.util.List;

public class Computer {
    private final List<Integer> answer;

    private Computer(List<Integer> answer) {
        BallNumbersValidator.validateInputSize(answer);
        BallNumbersValidator.validateInputRange(answer);
        BallNumbersValidator.validateInputUniqueness(answer);
        this.answer = answer;
    }

    public static Computer of(List<Integer> answer) {
        return new Computer(answer);
    }

    public GameResult calculateAndReturnGameResult(Player player) {
        List<Integer> playerNumbers = player.getNumbers();

        int strike = countStrikes(playerNumbers);
        int ball = countBalls(playerNumbers);

        return new GameResult(ball, strike);
    }

    private int countBalls(List<Integer> playerNumbers) {
        int ballCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            boolean isMatching = answer.get(i).equals(playerNumbers.get(i));
            boolean isContained = answer.contains(playerNumbers.get(i));
            if (isContained && !isMatching) {
                ballCount++;
            }
        }
        return ballCount;
    }

    private int countStrikes(List<Integer> playerNumbers) {
        int strikeCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            boolean isMatching = answer.get(i).equals(playerNumbers.get(i));
            if (isMatching) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}

