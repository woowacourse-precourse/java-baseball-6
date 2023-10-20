package baseball.constant;

public class GameConstant {

    //난수 설정
    public static final int START_RANGE = 1;
    public static final int LAST_RANGE = 9;
    public static final int RANDOM_NUMBER_SIZE = 3;

    public static final String REGULAR_EXPRESSION_INPUT_NUMBER = "^(?!.*(\\d).*\\1)[1-9]{3}$";
    public static final String REGULAR_EXPRESSION_RESTART_OR_END_NUMBER = "^[1-2]{1}";


    //게임 뷰
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public static final String RESTART_OR_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    //Check Value
    public static final int INPUT_NUMBER_SIZE = 3;
    public static final int COMPLETE_CHECK_NUM = 0;
    public static final int THREE_STRIKE = 3;
    public static final int NOTHING_CHECK_NUM = 0;
    public static final String END_VALUE = "2";
    public static final String RESTART_VALUE = "1";

}
