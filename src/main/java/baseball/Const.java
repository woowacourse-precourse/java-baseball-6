package baseball;

public class Const {
    private Const() { }

    public static final int NUMBER_LENGTH = 3;
    public static final int FINISH_STRIKE_COUNT = 3;

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    public static final int RESTART_COMMAND = 1;
    public static final int FINISH_COMMAND = 2;

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    public static final String GAME_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    public static final String STRIKE_GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼 ";
    public static final String NOTHING_MESSAGE = "낫싱";

}
