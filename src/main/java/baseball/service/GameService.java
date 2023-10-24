package baseball.service;

import baseball.domain.Ball;
import baseball.domain.GameResult;
import baseball.domain.MatchResult;
import baseball.view.OutputView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {

    public boolean isGameOver(GameResult gameResult) {
        if (gameResult.getStrike() == 3) {
            OutputView.printGameEnd();
            return true;
        }
        return false;
    }

    public GameResult checkResult(List<Integer> numbers, List<Integer> computerNumbers) {
        validate(numbers);

        int strike = 0;
        int ball = 0;

        List<Ball> player = convertToBall(numbers);
        List<Ball> computer = convertToBall(computerNumbers);

        for (Ball playerBall : player) {
            MatchResult result = playerBall.match(computer);
            if (result.isStrike()) {
                strike++;
            }
            if (result.isBall()) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }

    private List<Ball> convertToBall(List<Integer> numbers) {
        return IntStream.range(0, numbers.size()).mapToObj(i -> new Ball(i, numbers.get(i)))
                .collect(Collectors.toList());
    }

    private static void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicateNumbers(numbers);
    }

    private static void validateDuplicateNumbers(List<Integer> numbers) {
        Set<Integer> checkDuplicateNumbers = new HashSet<>(numbers);
        if (checkDuplicateNumbers.size() != 3) {
            throw new IllegalArgumentException("중복된 수가 있습니다.");
        }
    }

    private static void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자의 사이즈가 맞지 않습니다.");
        }
    }
}