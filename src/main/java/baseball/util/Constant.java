package baseball.util;

public class Constant {
    /* 랜덤 및 입력으로 받는 숫자의 길이 */
    public static final int LENGTH_OF_NUMBERS = 3;
    /* 각 자리의 숫자의 최솟값 및 최댓값 */
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 9;

    /* 볼, 스트라이크, 낫싱 */
    public static final String BALL = "볼";
    public static final String STRIKE = "스트라이크";
    public static final String NOTHING = "낫싱";

    /* 게임 진행에 필요한 출력 메시지 */
    public static final String INPUT_MSG = "숫자를 입력해주세요 : ";
    public static final String NUM_ERR_MSG = "세 자리의 숫자를 입력해야합니다. 게임을 종료합니다.";
    public static final String DUP_NUM_ERR = "서로 다른 1~9 사이의 수를 입력해야 합니다. 게임을 종료합니다.";
    public static final String START_GAME_MSG = "숫자 야구 게임을 시작합니다.";
    public static final String CORRECT_MSG = "번 만에 3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String CHECK_END_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String END_MSG = "게임을 종료합니다.";
    public static final String CHOICE_ERR_MSG = "올바른 선택이 아닙니다. 다시 입력하세요.";
}