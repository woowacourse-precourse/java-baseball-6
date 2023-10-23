package baseball.view;


import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class InputView {
    private static final int INPUT_NUMBER_SIZE = 3;

    public static String readUserNumber() {
        OutputView.printInputNumberMessage();
        String inputNumber = Console.readLine();

        checkIsNumber(inputNumber);
        checkNumberSize(inputNumber);
        checkNumberRange(inputNumber);
        checkDuplicatedNumber(inputNumber);

        return inputNumber;
    }

    private static void checkIsNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력이 가능합니다.");
        }
    }

    private static void checkNumberSize(String inputNumber) {
        if (inputNumber.length() != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("반드시 3개의 숫자여야 합니다.");
        }
    }

    private static void checkNumberRange(String inputNumber) {
        if (inputNumber.contains("0")) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력이 가능합니다.");
        }
    }

    private static void checkDuplicatedNumber(String inputNumber) {
        String[] numbers = inputNumber.split("");
        long count = Arrays.stream(numbers).distinct().count();

        if (count != INPUT_NUMBER_SIZE) {
            throw new IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.");
        }
    }

    public static int readGameEndCommand() {
        OutputView.printGameEndMessage();
        String inputCommand = Console.readLine();


        return Integer.parseInt(inputCommand);
    }
}
