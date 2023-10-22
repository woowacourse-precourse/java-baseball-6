package baseball;

import java.util.HashSet;
import java.util.Set;

public class BaseBallGameEngine {
    private static final int END_COMMAND = 2;
    private final BaseBalGameValidator baseBalGameValidator;
    private final int answer;

    public BaseBallGameEngine(int generateBaseBallValue, BaseBalGameValidator validator) {
        this.baseBalGameValidator = validator;
        baseBalGameValidator.validBaseBallValue(generateBaseBallValue);
        this.answer = generateBaseBallValue;
    }

    public BaseBallScore calculatingBaseBallScore(String baseBallValue) {
        baseBalGameValidator.validBaseBallValue(baseBallValue);
        return new BaseBallScore(getStrikeScore(Integer.parseInt(baseBallValue)), getBallScore(Integer.parseInt(baseBallValue)));
    }


    public boolean isEnd(String command) {
        baseBalGameValidator.validEndCommand(command);
        return Integer.parseInt(command) == END_COMMAND;
    }

    private int getStrikeScore(int baseBallValue) {
        int copyAnswer = answer;
        int count = 0;
        while (baseBallValue != 0) {
            if (baseBallValue % 10 == copyAnswer % 10)
                count++;
            copyAnswer /= 10;
            baseBallValue /= 10;
        }
        return count;
    }

    private int getBallScore(int baseBallValue) {
        Set<Integer> duplicateChecker = new HashSet<>();
        return getDuplicateCount(duplicateChecker, answer) + getDuplicateCount(duplicateChecker, baseBallValue) - getStrikeScore(baseBallValue);
    }

    private int getDuplicateCount(Set<Integer> duplicateChecker, int value) {
        int count = 0;
        while (value != 0) {
            if (duplicateChecker.contains(value % 10))
                count++;
            duplicateChecker.add(value % 10);
            value /= 10;
        }
        return count;
    }

}
