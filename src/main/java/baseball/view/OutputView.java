package baseball.view;

public class OutputView {
    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printMainMessage() {
        System.out.println(Message.OUTPUT_MAIN_MESSAGE.message);
    }

    private enum Message {
        OUTPUT_MAIN_MESSAGE("숫자 야구 게임을 시작합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
