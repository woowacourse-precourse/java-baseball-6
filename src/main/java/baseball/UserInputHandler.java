package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class UserInputHandler {
    private boolean isCorrectDigit(String input) {
        for (char c : input.toCharArray()) {
            if (isZero(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private boolean isZero(char c) {
        return c == '0';
    }

    private boolean isCorrectLengthFromInput(String input) throws IllegalArgumentException {
        return input.length() == 3;
    }

    private boolean isCorrectInput(String input) throws IllegalArgumentException {
        return isCorrectDigit(input) && isCorrectLengthFromInput(input);
    }

    private List<Integer> makeUserCountList(String input) {
        List<Integer> userCountList = new ArrayList<>();
        for (char c : input.toCharArray()) {
            userCountList.add(Character.getNumericValue(c));
        }
        return userCountList;
    }

    public List<Integer> takeInput() {
        System.out.println("숫자를 입력해주세요 : ");
        String userInput = Console.readLine();
        if (!isCorrectInput(userInput)) {
            throw new IllegalArgumentException("입력 오류");
        }
        return makeUserCountList(userInput);
    }
}