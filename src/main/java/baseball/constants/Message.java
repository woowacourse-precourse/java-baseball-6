package baseball.constants;

public class Message {
    public static class InputMessage {
        public static final String INPUT_PLAYER_NUMBERS = "숫자를 입력해주세요 : ";
        public static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }

    public static class OutputMessage {
        public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
        public static final String GAME_EXIT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
        public static final String NOTHING = "낫싱";
        public static final String BALL = "볼";
        public static final String STRIKE = "스트라이크";
    }

    public static class ErrorMessage {
        public static final String INVALID_INPUT = "유효하지 않은 입력입니다.";
        public static final String INVALID_RESTART_OR_EXIT = "입력 값은 1 (재시작) 또는 2 (종료) 여야 합니다.";
    }
}
