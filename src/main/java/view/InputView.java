package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<Integer> inputNumbers() {
        List<Integer> convertedNumber = new ArrayList<>();
        String input = Console.readLine();
        if (input.length() != 3) {
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
        if (input == 1) {
            return true;
        }
        if (input == 2) {
            return false;
        }
        throw new IllegalArgumentException();
    }
}
