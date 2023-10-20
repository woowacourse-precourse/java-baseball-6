package baseball.view.input;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String NUMBER_INPUT_REQUEST = "숫자를 입력해주세요 : ";

    public int readNumber() {
        print(NUMBER_INPUT_REQUEST);
        return readInt();
    }

    private int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다");
        }
    }

    private String readLine() {
        return Console.readLine();
    }
    private void print(String message) {
        System.out.print(message);
    }
}
