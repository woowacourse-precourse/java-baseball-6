package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BaseBalls {
    private List<BaseBall> numbers;
    public static final int SIZE = 3;

    public BaseBalls(List<BaseBall> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = numbers;
    }

    public static BaseBalls getAnswerBaseBallNumbers() {
        List<BaseBall> randomBaseBallNumbers = new ArrayList<>();
        while (randomBaseBallNumbers.size() < BaseBalls.SIZE) {
            int number = Randoms.pickNumberInRange(BaseBall.MIN_NUMBER, BaseBall.MAX_NUMBER);
            BaseBall answerNumber = BaseBall.toAnswerBaseBall(number);
            if (!randomBaseBallNumbers.contains(answerNumber)) {
                randomBaseBallNumbers.add(answerNumber);
            }
        }
        return new BaseBalls(randomBaseBallNumbers);
    }

    public static BaseBalls getUserBaseBallNumbers(String input) {
        List<BaseBall> userBaseBallNumbers = Arrays.stream(input.split(""))
                .map(digit -> BaseBall.toUserBaseBall(digit))
                .collect(Collectors.toList());

        return new BaseBalls(userBaseBallNumbers);
    }

    private void validateSize(List<BaseBall> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException("숫자의 길이는 3이여야합니다.");
        }
    }

    private void validateDuplication(List<BaseBall> numbers) {
        if (numbers.stream().distinct().count() != SIZE) {
            throw new IllegalArgumentException("중복되는 숫자없이, 서로 다른 3개의 숫자를 입력해야합니다.");
        }
    }

    public int getStrikeCounts(BaseBalls otherBaseBalls) {
        return (int) IntStream.range(0, SIZE)
                .filter(index -> numbers.get(index).equals(otherBaseBalls.numbers.get(index)))
                .count();
    }

    public int getBallCounts(BaseBalls otherBaseBalls) {
        return (int) IntStream.range(0, SIZE)
                .filter(index -> numbers.contains(otherBaseBalls.numbers.get(index)))
                .filter(index -> !numbers.get(index).equals(otherBaseBalls.numbers.get(index)))
                .count();
    }
}
