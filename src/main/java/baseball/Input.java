package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Input {
    private static final int SIZE = 3;

    public List<Integer> getUserGuess() {
        List<Integer> userGuess = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputUserGuess = Console.readLine();
        validateGuess(inputUserGuess);
        for (int i = 0; i < SIZE; i++) {
            userGuess.add(Integer.parseInt(String.valueOf(inputUserGuess.charAt(i))));
        }
        return userGuess;
    }

    private void validateGuess(String inputUserGuess) throws IllegalArgumentException {
        if (!inputUserGuess.matches("^[1-9]{3}")) {
            throw new IllegalArgumentException();
        }
        if (hasDuplicateNumber(inputUserGuess)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateNumber(String inputUserGuess) {
        Set<Character> check = new HashSet<>();
        for (char ch : inputUserGuess.toCharArray()) {
            if (!check.add(ch)) {
                return true;
            }
        }
        return false;
    }
}
