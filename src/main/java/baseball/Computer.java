package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;

public class Computer {

    private final int digitNumber;
    private String targetNumber;

    public Computer(int digitNumber) {
        this.digitNumber = digitNumber;
        this.targetNumber = String.valueOf(randomize());
    }

    public int randomize() {
        if (digitNumber < 1 || digitNumber > 8) {
            throw new IllegalArgumentException();
        }
        ArrayList<Integer> selectedNumbers = new ArrayList<>();

        while (selectedNumbers.size() < digitNumber) {
            int n = Randoms.pickNumberInRange(1, 9);

            if (!selectedNumbers.contains(n)) {
                selectedNumbers.add(n);
            }
        }
        return selectedNumbers.stream().mapToInt(Integer::intValue).reduce(0, (a, b) -> a * 10 + b);
    }

    public String evaluate(String sourceNumber, String targetNumber) {
        if (isNotValid(sourceNumber)) {
            throw new IllegalArgumentException();
        }
        int[] candidates = candidateNumbers(sourceNumber, targetNumber);
        int numberOfStrikes = numberOfStrikes(sourceNumber, targetNumber, candidates);
        int numberOfBalls = candidates.length - numberOfStrikes;
        return Prompt.printResult(numberOfBalls, numberOfStrikes);
    }

    public String evaluate(String input) {
        return evaluate(input, this.targetNumber);
    }

    public boolean restartOrTerminate(String option) {
        switch (option) {
            case "1" -> {
                reset();
                return true;
            }
            case "2" -> {
                Console.close();
                return false;
            }
            default -> throw new IllegalArgumentException();
        }
    }

    private void reset() {
        this.targetNumber = String.valueOf(randomize());
    }

    private int[] candidateNumbers(String sourceNumber, String targetNumber) {
        return sourceNumber.chars().filter(digit -> containsDigit(targetNumber, digit)).toArray();
    }

    private int numberOfStrikes(String sourceNumber, String targetNumber, int[] numbers) {
        return (int) Arrays.stream(numbers)
                .filter(digit -> isOnSamePosition(sourceNumber, targetNumber, digit))
                .count();
    }

    private boolean isOnSamePosition(String sourceNumber, String targetNumber, int digit) {
        return sourceNumber.indexOf(digit) == targetNumber.indexOf(digit);
    }

    private boolean containsDigit(String sourceNumber, int digit) {
        return sourceNumber.indexOf(digit) != -1;
    }

    private boolean isNotValid(String sourceNumber) {
        return isNaN(sourceNumber) || isNotUnique(sourceNumber) || isNotNaturalNumber(sourceNumber)
                || sourceNumber.length() != digitNumber;
    }

    private boolean isNaN(String sourceNumber) {
        if (sourceNumber == null) {
            return true;
        }
        return !sourceNumber.chars().allMatch(Character::isDigit);
    }

    private boolean isNotUnique(String sourceNumber) {
        if (sourceNumber == null) {
            throw new IllegalArgumentException();
        }
        return sourceNumber.chars().distinct().count() != sourceNumber.length();
    }

    private boolean isNotNaturalNumber(String sourceNumber) {
        if (sourceNumber == null) {
            throw new IllegalArgumentException();
        }
        return sourceNumber.chars().anyMatch(c -> c == '0');
    }
}
