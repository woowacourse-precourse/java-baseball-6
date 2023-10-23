package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final int NUMBER_COUNT = 3;
    private static final int RESTART_ANSWER = 1;
    private static final int SHUTDOWN_ANSWER = 2;
    public static List<Integer> inputNumbers() {
        List<Integer> convertedNumber = new ArrayList<>();
        String input = Console.readLine();
        if (input.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            if (convertedNumber.contains(digit)) {
                throw new IllegalArgumentException();
            }
            convertedNumber.add(digit);
        }
        return convertedNumber;
    }

    public static boolean restartGame() {
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (input == RESTART_ANSWER) {
            return true;
        }
        if (input == SHUTDOWN_ANSWER) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
