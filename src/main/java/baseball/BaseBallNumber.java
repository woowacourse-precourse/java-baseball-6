package baseball;

import exceptions.InvalidNumberException;
import java.util.ArrayList;
import java.util.List;

public class BaseBallNumber {

    private List<Integer> numbers;
    private final GameRule rule;

    public BaseBallNumber(GameRule rule) {
        this.rule = rule;
    }

    public void initGoalNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void setUserInput(String input) {
        validateInput(input);
        this.numbers = parseInput(input);
    }

    public int countStrike(BaseBallNumber guess) {
        int count = 0;
        for (int i = 0; i < rule.getGoalNumberLength(); i++) {
            if (this.numbers.get(i) == guess.numbers.get(i)) {
                count++;
            }
        }
        return count;
    }

    private void validateInput(String input) throws InvalidNumberException {
        validateSize(input);
        validateRange(input);
        validateDuplication(input);
    }

    private void validateSize(String input) {
        if (input.length() != rule.getGoalNumberLength()) {
            throw new InvalidNumberException("유효하지 않은 숫자 길이");
        }
    }

    private void validateDuplication(String input) {
        int[] countOf = new int[rule.getMaxInclude() + 1];
        for (int i = 0; i < rule.getGoalNumberLength(); i++) {
            if (++countOf[charToInt(input.charAt(i))] > 1) {
                throw new InvalidNumberException("중복된 숫자 존재 " + input);
            }
        }
    }

    private void validateRange(String input) {
        for (int i = 0; i < rule.getGoalNumberLength(); i++) {
            if (outOfValidRange(charToInt(input.charAt(i)))) {
                throw new InvalidNumberException("유효하지 않은 범위의 숫자 존재");
            }
        }
    }

    private List<Integer> parseInput(String input) {
        List<Integer> numbers = new ArrayList<>(rule.getGoalNumberLength());
        for (int i = 0; i < rule.getGoalNumberLength(); i++) {
            numbers.add(charToInt(input.charAt(i)));
        }
        return numbers;
    }

    private int charToInt(char c) {
        return c - '0';
    }

    private boolean outOfValidRange(int n) {
        return rule.getMaxInclude() < n || rule.getMinInclude() > n;
    }
}
