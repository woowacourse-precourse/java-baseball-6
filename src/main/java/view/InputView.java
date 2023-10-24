package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import vo.UserNumbers;

public class InputView {

    public static UserNumbers getUserNumbersInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return checkInputValue(Console.readLine());
    }

    private static UserNumbers checkInputValue(String userInput) {
        checkInputLength(userInput);
        checkInputOnlyNumber(userInput);
        checkInputDuplicate(userInput);

        return getUserNumbersInput(userInput);
    }

    private static void checkInputLength(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkInputOnlyNumber(String userInput) {
        if (!userInput.matches("^[1-9]{3}$")) {
            throw new IllegalArgumentException();
        }

    }

    private static void checkInputDuplicate(String userInput) {
        Set<Character> duplicateChecker = new HashSet<>();
        for (char number : userInput.toCharArray()) {
            duplicateChecker.add(number);
        }
        if (duplicateChecker.size() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private static UserNumbers getUserNumbersInput(String userInput) {
        List<Integer> userNumberList = new ArrayList<>();
        for (char number : userInput.toCharArray()) {
            userNumberList.add(Integer.parseInt(String.valueOf(number)));
        }
        return new UserNumbers(userNumberList);
    }
}
