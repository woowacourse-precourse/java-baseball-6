package baseball;

public class Constants {
    /** 숫자 야구에 사용되는 숫자 목록 */
    static final Integer GAME_NUM_LENGTH = 3;
    static final String CONTINUE_INPUT = "1";
    static final String STOP_INPUT = "2";

    /** 숫자 야구에 사용되는 멘트 */
    static final String START_COMMENT = "숫자 야구 게임을 시작합니다.";
    static final String RECEIVE_USER_INPUT_COMMENT = "숫자를 입력해주세요 : ";
    static final String END_COMMENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static final String ASK_CONTINUE_COMMENT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /** 사용자 입력 힌트 멘트 */
    static final String NOT_MATCH_COMMENT= "낫싱";
    static final String BALL_COMMENT = "%d볼";
    static final String STRIKE_COMMENT = "%d스트라이크";
    static final String BALL_AND_STRIKE_COMMENT = BALL_COMMENT + " " + STRIKE_COMMENT;
}
