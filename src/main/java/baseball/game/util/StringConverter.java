package baseball.game.util;

import baseball.game.model.Numbers;

import java.util.List;

public class StringConverter {

    public static Numbers convertToNumbers(String inputNumber) {
        inputNumber = removeWhiteSpace(inputNumber);

        List<Integer> list = inputNumber
                .chars()
                .mapToObj(Character::getNumericValue)
                .toList();
        return new Numbers(list);
    }

    private static String removeWhiteSpace(String number) {
        return number.replaceAll("\\s+", "");
    }
}
