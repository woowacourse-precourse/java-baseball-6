package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class NumberBaseballGameInputView {

    public final String readUserInput() {
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }
        return input;
    }

}
