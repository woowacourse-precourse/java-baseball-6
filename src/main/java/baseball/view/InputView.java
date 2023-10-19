package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INVALID_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public int readPlayerNumber() {
        print(INPUT_NUMBER_MESSAGE);
        return readInt();
    }

    private int readInt() {
        return parseInt(readLine());
    }

    private String readLine() {
        return Console.readLine();
    }

    private int parseInt(String number) {
        int parsedNumber;
        try {
            parsedNumber = Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_MESSAGE);
        }
        return parsedNumber;
    }

    private void print(String message) {
        System.out.print(message);
    }
}
