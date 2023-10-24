package baseball;

public class Output {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public void printGameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    private void printGameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public boolean printResultAndContinue(GameResult gameResult) {

        int strikes = gameResult.getStrikes();
        int balls = gameResult.getBalls();

        if (balls > 0) {
            System.out.print(balls + BALL_MESSAGE + " ");
        }

        if (strikes > 0) {
            System.out.print(strikes + STRIKE_MESSAGE);
        }

        if (gameResult.isNothing()) {
            System.out.print(NOTHING_MESSAGE);
        }

        System.out.println();

        if (strikes == GameConstants.NUMBER_LENGTH) {
            printGameEnd();
            return true;
        }

        return false;
    }

}
