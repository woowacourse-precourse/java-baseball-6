package baseball;

import java.text.Collator;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidation {
    public List<Integer> validateUserInput(String input) throws IllegalArgumentException{
        if (input.contains(" ")) {
            throw new IllegalArgumentException("공백 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.contains(",")) {
            throw new IllegalArgumentException("콤마 없이 오직 숫자만 입력해주시기 바랍니다.");
        }
        if (input.length() != 3) {
            throw new IllegalArgumentException("3개의 숫자만을 입력해주시기 바랍니다.");
        }
        validateInputNumber(input);
        final List<Integer> parseIntList = userInputToList(input);
        return parseIntList;
    }

    private void validateInputNumber(String input) throws IllegalArgumentException{
        Set<Character> charSet = new HashSet<Character>();
        charSet.add(input.charAt(0));
        charSet.add(input.charAt(1));
        charSet.add(input.charAt(2));

        if (charSet.size() != 3) {
            throw new IllegalArgumentException("숫자를 중복하지 않고 입력해주시기 바랍니다.");
        }

        for (Character c : charSet) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("숫자만을 입력해주시기 바랍니다.");
            }
            if (c.equals('0')) {
                throw new IllegalArgumentException("1 ~ 9 사이의 숫자만을 입력해주시기 바랍니다.");
            }
        }
    }

    private List<Integer> userInputToList(String userInput) {
        List<Integer> userInputList = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            userInputList.add(Character.getNumericValue(c));
        }
        return userInputList;
    }

    public int validateNewGameRequest(String input) throws IllegalArgumentException{
        if (input.length() != 1) {
            throw new IllegalArgumentException("한자리 숫자를 입력해주세요.");
        }
        if (!Character.isDigit(input.charAt(0))) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
        int inputValue = Character.getNumericValue(input.charAt(0));
        if (inputValue < 0 || inputValue > 2) {
            throw new IllegalArgumentException("1 혹은 2를 입력해주세요.");
        }
        return inputValue;
    }
}
