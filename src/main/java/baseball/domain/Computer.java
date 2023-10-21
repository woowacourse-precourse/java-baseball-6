package baseball.domain;

import baseball.strategy.DuplicateAllowancePolicy;
import baseball.strategy.NumberGeneratePolicy;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> numbers = new ArrayList<>();

    public List<Integer> generateNumbers(NumberGeneratePolicy numberGeneratePolicy, DuplicateAllowancePolicy duplicateAllowancePolicy, int numberCount) {
        while (numbers.size() < numberCount) {
            generateEachNumber(numberGeneratePolicy, duplicateAllowancePolicy);
        }
        return numbers;
    }

    private void generateEachNumber(NumberGeneratePolicy numberGeneratePolicy, DuplicateAllowancePolicy duplicateAllowancePolicy) {
        int number = numberGeneratePolicy.generate();
        if (!duplicateAllowancePolicy.canBeDuplicated() && numbers.contains(number)) { // 중복 불가이고 이미 존재하는 숫자이면
            return;
        }
        numbers.add(number);
    }

    public Result calculateResult(User user) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int index = 0; index < numbers.size(); index++) {
            int number = numbers.get(index);
            if (user.contains(number) && user.isSamePosition(number, index)) {
                strikeCount++;
            }
            if (user.contains(number) && !user.isSamePosition(number, index)) {
                ballCount++;
            }
        }

        return new Result(strikeCount, ballCount);
    }

}
