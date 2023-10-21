package View;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final InputView INSTANCE = new InputView();

    public static InputView getInstance() {
        return INSTANCE;
    }

    private InputView() {
    }

    public String printUserInput() {
        System.out.print(Message.USER_INPUT.getMessage());
        return Console.readLine();
    }

    private enum Message {
        USER_INPUT("숫자를 입력해주세요 : ");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
