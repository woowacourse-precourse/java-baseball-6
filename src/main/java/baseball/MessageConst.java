package baseball;

public abstract class MessageConst {
    public final static String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public final static String INPUT_GUESS_NUMBER = "숫자를 입력해 주세요 : ";
    public final static String STRIKE_BALL_COUNT = "%d볼 %d스트라이크";
    public final static String ONLY_STRIKE_COUNT = "%d스트라이크";
    public final static String ONLY_BALL_COUNT = "%d볼";
    public final static String NOTHING = "낫싱";
    public final static String GAME_CLEAR_MESSAGE =
            String.format("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                          "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.",
                    CommandConst.GAME_RESTART_COMMAND, CommandConst.GAME_END_COMMAND);
}
