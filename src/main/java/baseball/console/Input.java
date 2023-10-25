package baseball.console;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;

public class Input {

    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String get() {
        System.out.print(inputMessage);
        String number = Console.readLine();
        if (!isValidateNumber(number)) {
            throw new IllegalArgumentException();
        }
        return number;
    }

    public static String restart() {
        System.out.println(restartMessage);
        String restartNumber = Console.readLine();
        if (!isValidRestartNumber(restartNumber)) {
            throw new IllegalArgumentException();
        }

        return restartNumber;
    }

    private static boolean isValidateNumber(String number) {
        if (number.length() != 3) {
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
            if (c == '0') {
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
        if (number.equals("1") || number.equals("2")) {
            return true;
        }
        return false;
    }
}
