package baseball.ui;

public class PrintManager {

    private final String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_VALUE = "숫자를 입력해주세요 : ";
    private final String NOTHING = "낫싱";
    private final String STRIKE = "스트라이크";
    private final String BALL = "볼";
    private final String GAME_OVER =  "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String RESTART= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final String ERROR= "적절하지 않은 값을 입력했습니다. 게임을 종료합니다.";

    public void printGameStart() {
        System.out.println(GAME_START);
    }

    public void printInputValue() {
        System.out.printf(INPUT_VALUE);
    }

    public void printResult(int strike, int ball) {
        if (ball == 0 && strike ==0) {
            System.out.println(NOTHING);
        }

        if (ball == 0 && strike != 0) {
            System.out.println(strike + STRIKE);
        }

        if (ball != 0 && strike == 0) {
            System.out.println(ball + BALL);
        }

        if (ball != 0 && strike != 0) {
            System.out.println(ball + BALL + strike + STRIKE);
        }
    }

    public void printGameOver() {
        System.out.println(GAME_OVER);
    }

    public void printRestart() {
        System.out.println(RESTART);
    }

    public void printError() {
        System.out.println(ERROR);
    }
}
