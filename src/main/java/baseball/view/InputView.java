package baseball.view;

import baseball.util.ValidationUtils;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView instance = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return instance;
    }

    public String readUserNumber() {
        System.out.print(Message.INPUT_USER_NUMBER.message);
        String input = ValidationUtils.validUserNumber(Console.readLine());

        return input;
    }


    private enum Message {
        INPUT_USER_NUMBER("숫자를 입력해주세요 : ");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }

}
