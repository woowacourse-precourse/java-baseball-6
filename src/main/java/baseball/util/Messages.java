package baseball.util;

public class Messages {
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    public static final String STRIKE_MESSAGE = GameConfig.GAME_NUM_SIZE.getValue()
            + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REPLAY_PROMPT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static final String LENGTH_ERROR_MESSAGE = "숫자는 "
            + GameConfig.GAME_NUM_SIZE.getValue() + "자리여야 합니다.";
    public static final String RANGE_ERROR_MESSAGE = "각 자리의 숫자는 "
            + GameConfig.GAME_NUM_SIZE.getValue() + "에서 "
            + GameConfig.RANDOM_MAX_VALUE.getValue() + " 사이여야 합니다.";
    public static final String DUPLICATE_ERROR_MESSAGE = "각 자리의 숫자는 서로 중복되지 않아야 합니다.";
}
