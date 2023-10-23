package constant;

public class MessageList {
    /**
     * 게임 진행을 위한 상수
     */
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String NULL_STRING = "";
    public static final String RESTART = "1";
    public static final String END = "2";
    /**
     * 힌트 출력을 위한 상수
     */
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String BALL_MESSAGE = "볼 ";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    /**
     * 범위 체크를 위한 상수
     */
    public static final int MIN_RANGE_NUM = 1;
    public static final int MAX_RANGE_NUM = 9;
    public static final int THREE_STRIKE = 3;
    public static final int NONE = 0;
    private MessageList(){
    }
}
