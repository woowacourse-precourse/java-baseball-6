package baseball;

public class Output {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

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
            System.out.print(balls + "볼 ");
        }

        if (strikes > 0) {
            System.out.print(strikes + "스트라이크");
        }

        if (gameResult.isNothing()) {
            System.out.print("낫싱");
        }

        System.out.println();

        if (strikes == GameConstants.NUMBER_LENGTH) {
            printGameEnd();
            return true;
        }

        return false;
    }

}
