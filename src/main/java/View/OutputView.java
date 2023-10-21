package View;

public class OutputView {

    private static final OutputView INSTANCE = new OutputView();

    public static OutputView getInstance() {
        return INSTANCE;
    }

    private OutputView() {
    }

    public void printGameStart() {
        System.out.println(Message.GAME_START.getMessage());
    }

    private enum Message {
        GAME_START("숫자 야구 게임을 시작합니다");

        private String message;

        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
