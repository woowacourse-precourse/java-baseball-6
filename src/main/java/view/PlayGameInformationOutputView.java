package view;

public class PlayGameInformationOutputView {
    private enum Message {
        OUTPUT_GAME_START("게임을 시작합니다.");

        private final String message;

        private Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public void printGameStart() {
        System.out.println(Message.OUTPUT_GAME_START.message);
    }
}
