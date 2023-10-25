package baseball;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다. ";
    public static final String GAME_CLEAR_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! ";
    private static final String GAME_END_MESSAGE = "게임 종료";
    static final String STRIKE_MESSAGE = "스트라이크";
    static final String BALL_MESSAGE = "볼 ";
    static final String NOTHING_MESSAGE = "낫싱";

    public static void printGameStart(){
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printGameEnd(){
        System.out.println(GAME_END_MESSAGE + GAME_CLEAR_MESSAGE);
    }
}
