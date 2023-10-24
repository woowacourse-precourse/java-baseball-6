package baseball;

import java.util.List;

public class BaseballGameRules {

    private final int minNumber;
    private final int maxNumber;
    private final int numberCount;

    public BaseballGameRules(int minNumber, int maxNumber, int numberCount) {
        this.minNumber = minNumber;
        this.maxNumber = maxNumber;
        this.numberCount = numberCount;
    }

    public void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != numberCount) {
            throw new IllegalArgumentException("숫자의 개수가 게임 규칙과 일치하지 않습니다.");
        }

        for (int number : numbers) {
            if (number < minNumber || number > maxNumber) {
                throw new IllegalArgumentException("하나 이상의 숫자가 허용된 범위를 벗어났습니다.");
            }
        }

        long uniqueNumberCount = numbers.stream().distinct().count();
        if (uniqueNumberCount != numbers.size()) {
            throw new IllegalArgumentException("숫자들 중 중복된 숫자가 있습니다.");
        }
    }

    public int getMinNumber() {
        return minNumber;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getNumberCount() {
        return numberCount;
    }
}
