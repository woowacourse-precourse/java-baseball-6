package baseball.domain;

import baseball.controller.dto.Result;

import java.util.ArrayList;
import java.util.List;

public abstract class Computer {

    protected final List<Integer> numbers = new ArrayList<>();

    protected Computer(Rule rule) {
        generateNumbers(rule);
    }

    private void generateNumbers(Rule rule) {
        while (numbers.size() < rule.digits()) {
            generateEachNumber(rule);
        }
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
