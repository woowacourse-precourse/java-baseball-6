package baseball.controller;

public final class BaseBallConstants {
    public static final int BASEBALL_GAME_NUMBER_LENGTH = 3;
    public static final char MIN_DIGIT = '1';
    public static final char MAX_DIGIT = '9';
    public static final String WRONG_LENGTH_THROW_MESSAGE = "세 자리 숫자를 입력하세요.";
    public static final String WRONG_RANGE_THROW_MESSAGE = "1-9 사이의 정수를 입력하세요.";
    public static final String DUPLICATE_INPUT_MESSAGE = "중복되지 않는 서로 다른 숫자를 입력해주세요.";
    public static final String SIGNAL_CONTINUE = "1";
    public static final String SIGNAL_TERMINATE = "2";
    public static final String WRONG_INPUT_GAME_CONTINUE_CHOICE_MESSAGE = "재시작/종료 여부는 1 또는 2를 입력해주세요.";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    private BaseBallConstants() {

    }
}
