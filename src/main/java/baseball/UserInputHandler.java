package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserInputHandler {
    private static final int EXPECTED_LENGTH = 3;

    public String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return readLine();
    }

    public boolean isValid(String userInput) {
        return isNumericOfExpectedLength(userInput) && hasDistinctChars(userInput);
    }

    private boolean isNumericOfExpectedLength(String userInput) {
        return userInput.matches("[1-9]{" + EXPECTED_LENGTH + "}");
    }

    private boolean hasDistinctChars(String userInput) {
        Set<Character> charSet = new HashSet<>();
        for (char c : userInput.toCharArray()) {
            if (!charSet.add(c)) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> convertToNumberList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (char c : userInput.toCharArray()) {
            userInputList.add(Character.getNumericValue(c));
        }
        return userInputList;
    }
}