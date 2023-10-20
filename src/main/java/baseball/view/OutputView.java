package baseball.view;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "%d스트라이크";
    private static final String BALL_MESSAGE = "%d볼";
    private static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크";


    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.println(GET_NUMBER_MESSAGE);
    }

    public static void printNoting(GameResult gameResult){
        System.out.println(NOTING_MESSAGE);
    }

    public static void printStrike(GameResult gameResult){
        System.out.printf(STRIKE_MESSAGE, gameResult.getStrike());
    }

    public static void printBall(GameResult gameResult){
        System.out.printf(BALL_MESSAGE, gameResult.getBall());

    }

    public static void printStrikeAndBall(GameResult gameResult){
        System.out.printf(BALL_STRIKE_MESSAGE, gameResult.getBall(), gameResult.getStrike());
    }
}
