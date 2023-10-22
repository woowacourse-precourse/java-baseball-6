package baseball.constant;

public class Constants {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int NUMBERS_SIZE = 3;

    public static final int GAME_WIN = 3;
    public static final String GAME_RESTART = "1";
    public static final String GAME_QUIT = "2";

    public static final String BALL_MESSAGE = "볼 ";
    public static final String STRIKE_MESSAGE = "스트라이크";
    public static final String NOTHING_MESSAGE = "낫싱";

    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String GAME_WIN_MESSAGE = Constants.GAME_WIN + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String GAME_RESTART_OR_QUIT_MESSAGE = "게임을 새로 시작하려면 " + GAME_RESTART
            + ", 종료하려면 " + GAME_QUIT + "를 입력하세요.";
}
