package baseball.Message;

public class Constant {
    public enum RequestMessage {
        REQUEST_INPUT_DATA("숫자를 입력해 주세요 : "),
        REQUEST_RETRY_MESSAGE("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String message;

        RequestMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}
