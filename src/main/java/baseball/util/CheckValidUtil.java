package baseball.util;

import static baseball.model.Rule.END_NUM;
import static baseball.model.Rule.LENGTH;
import static baseball.model.Rule.START_NUM;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CheckValidUtil {

    public static void validateInput(String input) {
        if (!checkLengthAndDigit(input)) {
            throw new IllegalArgumentException("게임종료");
        }
        if (checkDistinctDigit(input)) {
            throw new IllegalArgumentException("게임종료");
        }
    }

    public static boolean checkLengthAndDigit(String input) {
        String regex = String.format("^[%d-%d]{%d}$", START_NUM, END_NUM, LENGTH);
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public static boolean checkContinueGameInput(String input) {
        String regex = "^[12]$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("");
        }
        return true;
    }

    public static boolean checkDistinctDigit(String input) {
        for (int i = 0; i < LENGTH; i++) {
            char currentDigit = input.charAt(i);
            for (int j = i + 1; j < LENGTH; j++) {
                if (currentDigit == input.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static List<Integer> validateAndConvertInput(String input) {
        validateInput(input);
        return input.chars().map(Character::getNumericValue).boxed().collect(Collectors.toList());
    }

}
