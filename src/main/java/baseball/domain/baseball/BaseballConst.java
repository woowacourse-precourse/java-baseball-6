package baseball.domain.baseball;

public class BaseballConst {
    private BaseballConst() { }

    public static final int NUMBER_SIZE = 3;
    public static final int FINISH_STRIKE_COUNT = 3;

    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 9;

    public static final int RESTART_COMMAND = 1;
    public static final int FINISH_COMMAND = 2;

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요: ";
    public static final String STRIKE_GAME_FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼 ";
    public static final String NOTHING_MESSAGE = "낫싱";

    public static final String ILLEGAL_INPUT_DIGIT_MESSAGE = "1~9 이외의 문자가 입력되었습니다.";
    public static final String ILLEGAL_FINISH_COMMAND_MESSAGE = "게임 완료 명령은 1또는 2만 입력될 수 있습니다. ";
    public static final String ILLEGAL_NUMBER_SIZE_MESSAGE = NUMBER_SIZE + "개의 숫자가 입력되어야 합니다.";
    public static final String ILLEGAL_DUPLICATE_NUMBER_MESSAGE = "중복된 숫자는 입력될 수 없습니다.";
    public static final String ILLEGAL_INPUT_INCLUDE_ZERO_MESSAGE = "입력에는 0이 포함될 수 없습니다.";

}
