package baseball;

public class Constant {

    public enum UserRequestMessage {
        GUESS_NUMBER_REQUEST_MESSAGE("숫자를 입력해주세요 : "),
        REPEAT_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        private final String message;

        UserRequestMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }

    public enum UserResponseMessage {
        GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
        BALL_MESSAGE("볼 "),
        STRIKE_MESSAGE("스트라이크"),
        NOTHING_MESSAGE("낫싱"),
        ALL_CORRECT_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private final String message;

        UserResponseMessage(String message) {
            this.message = message;
        }

        @Override
        public String toString() {
            return message;
        }
    }
}