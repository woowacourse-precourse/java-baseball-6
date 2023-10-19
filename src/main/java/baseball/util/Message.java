package baseball.util;

public class Message {
    /**
     * GameManager Message
     */
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_OPTION = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_EXIT = "게임을 종료합니다.";
    public static final String GAME_RESTART = "게임을 새로 시작합니다.";
    public static final String INVALID_INPUT = "잘못된 입력입니다. 1 또는 2를 입력하세요.";

    /**
     * BaseballService Message
     */
    public static final String USER_START = "숫자를 입력해주세요(현재 게임을 종료하고싶다면 'q'를 입력하세요.) : ";
    public static final String QUIT = "q";
    public static final String CURRENT_GAME_CLOSE = "현재 게임을 종료합니다.";
    public static final String THREE_STRIKE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크";
    public static final String STRIKE_MESSAGE = "%d스트라이크";
    public static final String BALL_MESSAGE = "%d볼";
    public static final String NOTHING_MESSAGE = "낫싱";

    public static String formatBallStrikeMessage(int ball, int strike) {
        return String.format(BALL_STRIKE_MESSAGE, ball, strike);
    }

    public static String formatStrikeMessage(int strike) {
        return String.format(STRIKE_MESSAGE, strike);
    }

    public static String formatBallMessage(int ball) {
        return String.format(BALL_MESSAGE, ball);
    }

}
