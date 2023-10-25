package baseball.domain;

final class MessageConstants {
    public static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String END_MESSAGE = """
        3개의 숫자를 모두 맞히셨습니다!
        게임 종료 게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.""";
    public static final String NOTHING_MESSAGE = "낫싱";
    public static final String ERROR_MESSAGE = "잘못된 입력입니다";
    public static final String ONLY_STRIKE_MESSAGE_FORMAT = "%d스트라이크";
    public static final String ONLY_BALL_MESSAGE_FORMAT = "%d볼";
    public static final String STRIKE_BALL_MESSAGE_FORMAT = "%d볼 %d스트라이크";

    private MessageConstants() {
    }
}
