package baseball.message;

public abstract class Message {

    // 게임 설정 메시지
    public static final String BEGIN_RANGE = "beginRange";
    public static final String END_RANGE = "engRange";
    public static final String CAPACITY_STR = "capacity";
    public static final String GAME_STATUS_STR = "status";

    // 게임 진행 메시지
    public static final String START_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String END_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REGAME_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String INPUT_MSG = "숫자를 입력해주세요 : ";
    public static final String BALL_MSG = "볼";
    public static final String STRIKE_MSG = "스트라이크";
    public static final String NON_MSG = "낫싱";

    // 게임 용어
    public static final String STRIKE = "STRIKE";
    public static final String BALL = "BALL";
    public static final String COMPUTER = "COMPUTER";
    public static final String PLAYER = "PLAYER";
    public static final String SUCCESS = "SUCCESS";

}
