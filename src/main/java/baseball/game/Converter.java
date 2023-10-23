package baseball.game;

import java.util.ArrayList;
import java.util.List;

import static constant.Constant.NUMBER_OF_DIGITS;

public class Converter {
    public List<Integer> convertToInputNumbers(String userInputString) {
        List<Integer> userInputNumbers = new ArrayList<>();
        for (int index = 0; index < NUMBER_OF_DIGITS; index++) {
            char character = userInputString.charAt(index);
            validate(character);
            int digit = Character.getNumericValue(character);
            userInputNumbers.add(digit);
        }
        return userInputNumbers;
    }

    private static void validate(char character) {
        if (!Character.isDigit(character)) {
            throw new NumberFormatException("[ERROR] 숫자가 아닌 값으로 인해 변환에 실패하였습니다.");
        }
    }
}