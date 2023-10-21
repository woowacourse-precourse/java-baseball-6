package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static int[] generateRandomAnswer() {
        int[] answer;

        answer = new int[3];
        do {
            for (int i = 0; i < 2; i++) {
                answer[i] = Randoms.pickNumberInRange(1, 9);
            }
        } while(!duplicateNumber(answer));
        return answer;
    }

    private static boolean duplicateNumber(int[] number) {
        return ((number[0] == number[1])
                || (number[1] == number[2])
                || (number[2] == number[0]));
    }

    private static int[] getInputNumber() {
        String input;

        input = Console.readLine();
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        };
        return (stringToIntArray(input));
    }

    private static boolean isValidInput(String input) {
        return (isLengthThree(input)
                && isInRange(input)
                && !duplicateInput(input));
    }

    private static boolean isLengthThree(String input) {
        return (input.length() == 3);
    }

    private static boolean isInRange(String input) {
        for (char ch : input.toCharArray()) {
            if (!('1' <= ch && ch <= '9')) {
                return false;
            }
        }
        return true;
    }

    private static boolean duplicateInput(String input) {
        return ((input.charAt(0) == input.charAt(1))
                || (input.charAt(1) == input.charAt(2))
                || (input.charAt(2) == input.charAt(0)));
    }

    private static int[] stringToIntArray(String input) {
        int[] inputNumber;

        inputNumber = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            inputNumber[i] = (int) input.charAt(i);
        }
        return inputNumber;
    }
}
