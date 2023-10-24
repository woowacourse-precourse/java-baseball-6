package baseball.constants;

public class MessageConstants {
    public static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    public static final String REQUEST_NUMBERS_INPUT = "숫자를 입력해주세요 : ";
    public static final String RESULT_DEFAULT = "낫싱";
    public static final String END_GAME = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료".formatted(NumberConstants.SIZE);
    public static final String REQUEST_RESTART_INPUT = "게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.".formatted(
            NumberConstants.START_NUM, NumberConstants.END_NUM);
}
