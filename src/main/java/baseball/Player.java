package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.HashSet;
import java.util.Set;

public class Player {
    private static final int NUMBER_LENGTH = 3;
    private static final String INVALID_NUMBER = "0";
    private static final String RESTART_FLAG = "1";
    private static final String EXIT_FLAG = "2";

    public String inputNumbers() {
        String numbers = getPlayerInput();
        isInputNull(numbers);
        checkBallValidation(numbers);
        return numbers;
    }

    public boolean conformGameRestart() {
        String flag = getPlayerInput();
        isInputNull(flag);
        checkFlagValidation(flag);
        return isRestartFlag(flag);
    }

    private String getPlayerInput() {
        String playerInput = readLine();
        return playerInput;
    }

    private void isInputNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBallValidation(String numbers) {
        if (numbers.length() != NUMBER_LENGTH || numbers.contains(INVALID_NUMBER) || hasDuplicateNumber(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateNumber(String numbers) {
        Set<Character> numberSet = new HashSet<>();
        for (char number : numbers.toCharArray()) {
            numberSet.add(number);
        }
        return numbers.length() != numberSet.size();
    }

    private void checkFlagValidation(String flag) {
        if (!flag.equals(RESTART_FLAG) && !flag.equals(EXIT_FLAG)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isRestartFlag(String flag) {
        if (flag.equals(RESTART_FLAG)) {
            return true;
        }
        return false;
    }
}
