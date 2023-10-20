package baseball.domain;

import baseball.util.Sentence;
import java.util.List;

public class Player {
    private final List<Integer> numbers;

    private Player(List<Integer> numbers) {
        validateThreeSize(numbers);
        validateDuplicationNumbers(numbers);
        this.numbers = numbers;
    }

    public static Player of(List<Integer> numbers) {
        return new Player(numbers);
    }

    private void validateThreeSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(Sentence.ERROR_NOT_THREE_SIZE_MESSAGE.getMessage());
        }
    }

    private void validateDuplicationNumbers(List<Integer> numbers) {
        long duplicationCount = numbers.stream()
                .distinct()
                .count();

        if (duplicationCount != numbers.size()) {
            throw new IllegalArgumentException(Sentence.ERROR_NUMBERS_DUPLICATION_MESSAGE.getMessage());
        }
    }

    // 컴퓨터의 서로 다른 3자리 숫자와 비교 후, 게임 결과를 생성 및 반환
    public GameResult gameStartAndReturnResult(List<Integer> computer) {
        int ball = 0;
        int strike = 0;
        GameStatus gameStatus = GameStatus.ONGOING;

        for (int i = 0; i < computer.size(); i++) {
            if (isSame(computer, i)) {
                strike += 1;
                continue;
            }
            if (isContained(computer, i)) {
                ball += 1;
            }
        }

        if (strike == 3) {
            gameStatus = GameStatus.SUCCESS;
        }

        return new GameResult(ball, strike, gameStatus);
    }

    private boolean isSame(List<Integer> computer, int index) {
        return numbers.get(index).equals(computer.get(index));
    }

    private boolean isContained(List<Integer> computer, int index) {
        return computer.contains(numbers.get(index));
    }
}
