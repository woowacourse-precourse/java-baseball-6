package baseball.view;

public class OutputView {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GET_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String BALL_MESSAGE = "%d볼\n";
    private static final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String GET_RESTART_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입려하세요.";


    public static void printStartGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public static void printInputNumber() {
        System.out.print(GET_NUMBER_MESSAGE);
    }

    public static void printInputRestartGame(){
        System.out.println(GET_RESTART_GAME);
    }

    public static void printGameResult(GameResult gameResult) {
        printNoting(gameResult);
        printStrike(gameResult);
        printBall(gameResult);
        printStrikeAndBall(gameResult);
    }

    public static void printNoting(GameResult gameResult) {
        if (gameResult.isBallZero() && gameResult.isStrikeZero()){
            System.out.println(NOTING_MESSAGE);
        }
    }

    public static void printStrike(GameResult gameResult) {
        if (gameResult.isBallZero() && !gameResult.isStrikeZero()){
            System.out.printf(STRIKE_MESSAGE, gameResult.getStrike());
        }
    }

    public static void printBall(GameResult gameResult) {
        if (!gameResult.isBallZero() && gameResult.isStrikeZero()){
            System.out.printf(BALL_MESSAGE, gameResult.getBall());
        }

    }

    public static void printStrikeAndBall(GameResult gameResult) {
        if (!gameResult.isBallZero() && !gameResult.isStrikeZero()){
            System.out.printf(BALL_STRIKE_MESSAGE, gameResult.getBall(), gameResult.getStrike());
        }
    }
}
