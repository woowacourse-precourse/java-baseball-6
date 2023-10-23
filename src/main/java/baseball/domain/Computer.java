package baseball.domain;

import baseball.controller.dto.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class Computer {

    protected final List<Integer> numbers = new ArrayList<>();

    public List<Integer> generateNumbers(Rule rule, int numberCount) {
        while (numbers.size() < numberCount) {
            generateEachNumber(rule);
        }
        return numbers;
    }

    private void generateEachNumber(Rule rule) {
        int number = rule.generateNumber();
        if (rule.canNotBeDuplicated() && numbers.contains(number)) {
            return;
        }
        numbers.add(number);
    }

    public abstract Result calculateResult(User user);

}
