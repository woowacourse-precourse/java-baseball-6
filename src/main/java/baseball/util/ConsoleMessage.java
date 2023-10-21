package baseball.util;

public class ConsoleMessage {
    public static final String DISPLAY_GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String DISPLAY_GAME_SUCCESS = String.format("%d개의 숫자를 모두 맞히셨습니다! 게임 종료", Constants.BALL_LENGTH);
    public static final String READ_PLAYER_NUMBER = "숫자를 입력해주세요 : ";
    public static final String READ_RETRY_COMMAND = String.format("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.",
            Constants.RETRY_COMMAND, Constants.EXIT_COMMAND);
}
