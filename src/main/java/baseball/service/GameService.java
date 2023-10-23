package baseball.service;

import baseball.domain.GameResult;
import baseball.view.OutputView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameService {

    public GameService() {

    }

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

        for (int i = 0; i < numbers.size(); i++) {
            Integer player = numbers.get(i);
            for (int j = 0; j < computerNumbers.size(); j++) {
                Integer computer = computerNumbers.get(j);
                if (i == j && player.equals(computer)) {
                    strike++;
                }
                if (i != j && player.equals(computer)) {
                    ball++;
                }
            }
        }

        return new GameResult(strike, ball);
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