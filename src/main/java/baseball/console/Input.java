package baseball.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

import static baseball.constants.Constants.VALID_NUMBER_LENGTH;
import static baseball.constants.Messages.INPUT_MESSAGE;
import static baseball.constants.Messages.RESTART_MESSAGE;

public class Input {

    private static final char ZERO = '0';
    private static final String RESTART_CHOICE_ONE = "1";
    private static final String RESTART_CHOICE_TWO = "2";

    public static String get() {
        System.out.print(INPUT_MESSAGE.getMessage());
        String number = Console.readLine();
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static String restart() {
        System.out.println(RESTART_MESSAGE.getMessage());
        String restartNumber = Console.readLine();
        if (!isValidRestartNumber(restartNumber)) {
            throw new IllegalArgumentException();
        }

        return restartNumber;
    }

    static boolean isValidNumber(String number) {
        if (number.length() != VALID_NUMBER_LENGTH.getValue()) {
            return false;
        }
        if (!isDigits(number)) {
            return false;
        }
        if (containZero(number)) {
            return false;
        }
        if (isDuplicate(number)) {
            return false;
        }
        return true;
    }

    public static boolean isDigits(String number) {
        for (char c : number.toCharArray()) {
            if(!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean containZero(String number) {
        for (char c: number.toCharArray()) {
            if (c == ZERO) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDuplicate(String number) {
        HashSet<Character> set = new HashSet<Character>();
        for (char c : number.toCharArray()) {
            if(!set.isEmpty() && set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }

    public static boolean isValidRestartNumber(String number) {
        return RESTART_CHOICE_ONE.equals(number) || RESTART_CHOICE_TWO.equals(number);
    }
}
