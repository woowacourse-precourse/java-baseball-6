package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String NUMBER_FORMAT_EXCEPTION = "숫자만 입력 가능합니다.";

    public String readNumber() {
        String number = read();
        validateNumberFormat(number);
        return number;
    }

    private void validateNumberFormat(String number) {
        try {
            Integer.valueOf(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION);
        }
    }

    private String read() {
        return Console.readLine();
    }
}
