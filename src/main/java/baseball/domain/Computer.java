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

}
