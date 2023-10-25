package baseball.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Input {

    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private static final int VALID_NUMBER_LENGTH = 3;
    private static final char ZERO = '0';
    private static final String RESTART_CHOICE_ONE = "1";
    private static final String RESTART_CHOICE_TWO = "2";


    public static String get() {
        System.out.print(INPUT_MESSAGE);
        String number = Console.readLine();
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static String restart() {
        System.out.println(RESTART_MESSAGE);
        String restartNumber = Console.readLine();
        if (!isValidRestartNumber(restartNumber)) {
            throw new IllegalArgumentException();
        }

        return restartNumber;
    }

    static boolean isValidNumber(String number) {
        if (number.length() != VALID_NUMBER_LENGTH) {
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
