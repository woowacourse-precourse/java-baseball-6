package baseball.number;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class NumberMatcher {
    public static String numberMatcherResult(List<Integer> computer) {
        int inputNumber = 0;
        try {
            inputNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        if (!isValidNumber(inputNumber)) {
            throw new IllegalArgumentException();
        }
        List<Integer> userInputList = new ArrayList<>();
        while (inputNumber > 0) {
            userInputList.add(0, inputNumber % 10);
            inputNumber /= 10;
        }

        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < 3; i++) {
            if (userInputList.get(i).equals(computer.get(i))) {
                strikeCount++;
            } else if (computer.contains(userInputList.get(i))) {
                ballCount++;
            }
        }
        String result = "";
        if (ballCount != 0) {
            result += ballCount + "볼";
        }
        if (strikeCount != 0) {
            if (!result.isEmpty()) {
                result += " ";
            }
            result += strikeCount + "스트라이크";
        }
        if (ballCount == 0 && strikeCount == 0) {
            result = "낫싱";
        }
        return result;
    }

    public static boolean isValidNumber(int number) {
        return number >= 100 && number <= 999 && isAllDigitsBetween1And9(number);
    }

    public static boolean isAllDigitsBetween1And9(int number) {
        while (number > 0) {
            int digit = number % 10;
            if (digit < 1 || digit > 9) {
                return false;
            }
            number /= 10;
        }
        return true;
    }
}
