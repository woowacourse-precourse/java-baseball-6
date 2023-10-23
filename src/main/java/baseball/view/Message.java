package baseball.view;

public class Message {
    /* messages for Game status */
    static public final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static public final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    static public final String GAME_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    static public final String GAME_RE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    /* messages for strike/ball count */
    static public final String STRIKE3 = "3스트라이크";
    static public final String STRIKE2 = "2스트라이크";
    static public final String STRIKE1 = "1스트라이크";
    static public final String STRIKE0 = "";

    static public final String BALL3 = "3볼 ";
    static public final String BALL2 = "2볼 ";
    static public final String BALL1 = "1볼 ";
    static public final String BALL0 = "";

    static public final String NOTHING = "낫싱";

    /* message for Exception */
    static public final String INVALID_INPUT_LENGTH = "Invald length of String is not allowed.";
    static public final String INVALID_INPUT_NUMERIC = "Invald numeric type of String is not allowed.";
    static public final String INVALID_INPUT_RESUME_QUESTION = "Invalid Game Resume Input";
    static public final String INVALID_INPUT_DUPLICATE = "Invalid duplicate number";
}
