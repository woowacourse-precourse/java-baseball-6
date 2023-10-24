package baseball.service;

import camp.nextstep.edu.missionutils.Console;

public class InputService {
    public static String getNumber(int size, int start, int end) {
        String input=Console.readLine();
        if (!isValidNumberInput(input, start, end, size)) {
            throw new IllegalArgumentException("입력값이 유효하지 않습니다.");
        }
        return input;
    }

    public static boolean restart(String input, int restart, int exit) {
        if (!isValidRestartOrExit(input, restart, exit)) {
            throw new IllegalArgumentException("일력값이 유효하지 않습니다.");
        }
        int isRestart=Integer.parseInt(input);
        return isRestart == restart;
    }

    private static boolean isValidNumberInput(String input, int start, int end, int size) {
        String pattern = "[" + start + "-" + end + "]{" + size + "}";
        return input.matches(pattern);
    }

    private static boolean isValidRestartOrExit(String input, int restart, int exit) {
        try {
            int inputValue = Integer.parseInt(input);
            return inputValue == restart || inputValue == exit;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
