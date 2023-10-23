package baseball.common;

public class Message {

    private Message() {
    }

    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String START_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INVALID_START_INPUT_LENGTH_MESSAGE = "3개의 숫자만 입력이 가능합니다.";
    public static final String INVALID_START_INPUT_NUMBER_MESSAGE = "1~9까지의 숫자만 입력이 가능 합니다.";
    public static final String DUPLICATION_START_INPUT_NUMBER_MESSAGE = "서로 다른 숫자만 입력이 가능 합니다.";
    public static final String INVALID_END_INPUT_NUMBER_MESSAGE = "1 또는 2만 입력이 가능 합니다.";

    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼";
    public static final String EMPTY_MESSAGE = "낫싱";

}
